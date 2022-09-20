package dev.itssho.powerwatch.lib.power.java.power.entity

/** @see [dev.itssho.powerwatch.lib.power.windows.power.entity.NSystemPowerStatus] */
data class NSystemPowerStatus(
    val ACLineStatus: Byte,
    val BatteryFlag: Byte,
    val BatteryFullLifeTime: Int,
    val BatteryLifePercent: Byte,
    val BatteryLifeTime: Int,
    val Reserved1: Byte,
)