package dev.itssho.powerwatch.java

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.ComposeDialog
import androidx.compose.ui.awt.ComposeWindow
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.key.key
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import dev.itssho.powerwatch.lib.power.java.power.entity.BatteryCharge
import dev.itssho.powerwatch.lib.power.java.power.entity.BatteryLifeTime
import dev.itssho.powerwatch.lib.power.java.power.entity.PowerStatus
import dev.itssho.powerwatch.lib.power.java.power.service.PowerStatusService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.awt.Dimension
import java.awt.Robot
import java.awt.Toolkit
import java.awt.event.KeyEvent
import java.awt.event.KeyEvent.VK_WINDOWS
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.time.Duration.Companion.seconds


@Composable
private fun LoadingScreen() {
	CircularProgressIndicator(Modifier.aspectRatio(1f).fillMaxSize())
}

@Composable
private fun AutonomousBatteryScreen(percent: BatteryCharge, lifeTime: BatteryLifeTime, charging: Boolean) {
	val percentText = when (percent) {
		is BatteryCharge.Percent -> "${percent.value}%"
		BatteryCharge.Unknown    -> "Не известно"
	}
	val lifetimeText = when (lifeTime) {
		is BatteryLifeTime.Seconds ->
			lifeTime.value.seconds.toComponents { hours, minutes, seconds, _ -> "$hours ч $minutes мин $seconds с" }
		BatteryLifeTime.Undefined  -> "∞"
	}
	val chargingColor = if (charging) Color.Green else Color.Red

	Row(Modifier.fillMaxSize()) {
		Column(Modifier.fillMaxHeight()) {
			Text("Текущие показания:")
			Text("Осталось жить:")
			Text("Провод:")
		}
		Spacer(Modifier.size(15.dp))
		Column(Modifier.fillMaxHeight()) {
			Text(percentText)
			Text(lifetimeText)
			Box(
				modifier = Modifier
					.size(LocalTextStyle.current.fontSize.value.dp)
					.clip(CircleShape)
					.background(chargingColor)
			)
		}
	}
}

@Composable
private fun NoBatteryScreen(msg: String) {
	Text(msg)
}

@Composable
private fun ApplicationScope.SystemTrayIsNotSupportedDialog(window: ComposeWindow) {
	Dialog(create = { ComposeDialog(owner = window) }, dispose = { exitApplication() }) {
		Text("App cannot be placed in system tray as it's not supported on this device")
		Button(onClick = { this.window.dispose() }) {
			Text("Close")
		}
	}
}

// Тут надо преобрадовывать float в dp, но пофиг
val SCREEN_SIZE: DpSize by lazy {
	val screenSize: Dimension = Toolkit.getDefaultToolkit().screenSize
	val width = screenSize.getWidth()
	val height = screenSize.getHeight()

	DpSize(width = width.dp, height = height.dp)
}

fun main() {
	SCREEN_SIZE

	application {
		MaterialTheme {
			var state by remember { mutableStateOf<PowerState>(PowerState.Initial) }
			var time by remember { mutableStateOf(LocalDateTime.now()) }
			var windowShown by remember { mutableStateOf(false) }
			var forceShow by remember { mutableStateOf(false) }
			val windowOpenCloseText = if (windowShown) "Hide" else "Show"

			val trayState = rememberTrayState()
			Tray(
				state = trayState,
				icon = rememberVectorPainter(Icons.Default.ThumbUp),
				menu = {
					Item(windowOpenCloseText, onClick = { windowShown = !windowShown })
					Item("Exit", onClick = { exitApplication() })
				}
			)

			if (forceShow) {
				Window(
					onCloseRequest = { },
					title = "Compose for Desktop",
					state = rememberWindowState(size = SCREEN_SIZE, placement = WindowPlacement.Fullscreen),
					alwaysOnTop = true,
					undecorated = true,
					resizable = false,
				) {
					Column(modifier = Modifier.fillMaxSize()) {
						Text(time.format(DateTimeFormatter.ISO_DATE_TIME))
						Spacer(Modifier.size(10.dp))
						Text(modifier = Modifier.weight(1f), text = "Подключи провод или я убью комп")
					}
				}
			}

			if (windowShown) {
				Window(
					onCloseRequest = ::exitApplication,
					title = "Compose for Desktop",
					state = rememberWindowState(size = DpSize(width = 350.dp, height = 200.dp)),
				) {
					Column(Modifier.fillMaxSize()) {
						Text(time.format(DateTimeFormatter.ISO_DATE_TIME))
						Spacer(Modifier.size(10.dp))
						Box(Modifier.weight(1f)) {
							when (val ps = state) {
								is PowerState.Initial -> {
									LoadingScreen()
								}
								is PowerState.Content -> {
									when (val status = ps.powerStatus) {
										is PowerStatus.Autonomous.Charging ->
											AutonomousBatteryScreen(
												percent = status.charge,
												lifeTime = BatteryLifeTime.Undefined,
												charging = true
											)
										is PowerStatus.Autonomous.InUse    ->
											AutonomousBatteryScreen(
												percent = status.charge,
												lifeTime = status.lifeTime,
												charging = false
											)
										is PowerStatus.Undefined           -> NoBatteryScreen("Battery power measurement failed")
										is PowerStatus.WireDependent       -> NoBatteryScreen("Device has no battery")
									}

								}
							}
						}
						Button(onClick = { this@application.exitApplication() }, modifier = Modifier.fillMaxWidth()) {
							Text("Close")
						}
					}
				}
			}

			LaunchedEffect(0) {
				launch {
					while (true) {
						val powerStatus = PowerStatusService.getStatus()
						state = PowerState.Content(powerStatus)
						time = LocalDateTime.now()

						if (powerStatus is PowerStatus.Autonomous.InUse) {
							val charge = powerStatus.charge
							forceShow = charge is BatteryCharge.Percent && charge.value < 20
						} else {
							forceShow = false
						}

						println(powerStatus)
						if (forceShow) {
							delay(1_000)
						} else {
							delay(15_000)
						}
					}
				}
			}
		}
	}
}