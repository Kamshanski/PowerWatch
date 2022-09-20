package dev.itssho.powerwatch.lib.power.java.power.entity

// https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-system_power_status
/**
 * The number of seconds of battery life remaining,
 *  or –1 if remaining seconds are unknown or if the device is connected to AC power.
 */
sealed interface BatteryLifeTime {

    data class Seconds(val value: Long) : BatteryLifeTime

    object Undefined : BatteryLifeTime { // -1
        override fun toString(): String = this::class.simpleName!!
    }
}