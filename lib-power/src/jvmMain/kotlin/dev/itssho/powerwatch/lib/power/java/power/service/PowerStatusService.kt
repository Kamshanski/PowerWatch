package dev.itssho.powerwatch.lib.power.java.power.service

import dev.itssho.powerwatch.lib.power.java.power.entity.BatteryCharge
import dev.itssho.powerwatch.lib.power.java.power.entity.BatteryLifeTime
import dev.itssho.powerwatch.lib.power.java.power.entity.NSystemPowerStatus
import dev.itssho.powerwatch.lib.power.java.power.entity.PowerStatus
import dev.itssho.powerwatch.lib.power.java.power.service.anative.NativePowerStatusService
import java.io.File




object PowerStatusService {

	init {
//		val path = this.javaClass.classLoader.getResource("lib/lib_power.dll")!!
//		val p = path.file
//
//		System.load(p
//			.removePrefix("file:/")
////			.removeSuffix(".dll")
//		)
		NativeUtils.loadLibraryFromJar("/lib/lib_power.dll")
//		Runtime.getRuntime().load("lib/lib_power")
//		val classpath = System.getProperty("java.class.path")
//		val classpathEntries = classpath.split(File.pathSeparator).map { it. }
//
//		var success = false
//		for (entry in classpathEntries) {
//			try {
//				System.setProperty("java.library.path", this::class.java.)
//
//				success = true
//			} catch (ule: UnsatisfiedLinkError) {
//
//			}
//		}
//
//
//		System.setProperty("java.library.path", oldProperty)
	}

	private val native = NativePowerStatusService()

	fun getStatus(): PowerStatus =
		try {
			val nativeData = native.getPower()
			convert(nativeData)
		} catch (ex: Throwable) {
			ex.printStackTrace()
			println(ex)
			PowerStatus.Undefined
		}

	private fun convert(powerStatus: NSystemPowerStatus): PowerStatus {
		when {
			powerStatus.BatteryFlag.toInt() == 128 -> {
				return PowerStatus.WireDependent
			}
			powerStatus.BatteryFlag.toInt() == 255 -> {
				return PowerStatus.Undefined
			}
		}

		when (powerStatus.ACLineStatus.toInt()) {
			0    -> {
				return PowerStatus.Autonomous.InUse(
					charge = convertPercent(powerStatus.BatteryLifePercent),
					lifeTime = convertBatteryLifeTime(powerStatus.BatteryLifeTime)
				)
			}
			1    -> {
				return PowerStatus.Autonomous.Charging(convertPercent(powerStatus.BatteryLifePercent))
			}
			else -> {
				return PowerStatus.Undefined
			}
		}
	}

	private fun convertPercent(percent: Byte): BatteryCharge =
		if (percent in 0..100) {
			BatteryCharge.Percent(percent.toInt())
		} else {
			BatteryCharge.Unknown
		}

	private fun convertBatteryLifeTime(seconds: Int) =
		if (seconds != -1) {
			BatteryLifeTime.Seconds(seconds.toLong())
		} else {
			BatteryLifeTime.Undefined
		}
}