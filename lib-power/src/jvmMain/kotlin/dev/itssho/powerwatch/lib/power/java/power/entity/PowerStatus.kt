package dev.itssho.powerwatch.lib.power.java.power.entity

sealed interface PowerStatus {

    sealed interface Autonomous : PowerStatus {
        val charge: BatteryCharge

        data class Charging(override val charge: BatteryCharge) : Autonomous

        data class InUse(override val charge: BatteryCharge, val lifeTime: BatteryLifeTime) : Autonomous
    }

    object WireDependent : PowerStatus

    object Undefined : PowerStatus
}
