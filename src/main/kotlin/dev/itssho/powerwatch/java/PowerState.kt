package dev.itssho.powerwatch.java

import dev.itssho.powerwatch.lib.power.java.power.entity.PowerStatus

sealed interface PowerState {

	data class Content(val powerStatus: PowerStatus) : PowerState

	object Initial : PowerState
}
