package dev.itssho.powerwatch.lib.power.java.power.entity

// https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-system_power_status
/**
 * The percentage of full battery charge remaining.
 * This member can be a value in the range 0 to 100, or 255 if status is unknown.
 */
sealed interface BatteryCharge {

    data class Percent(val value: Int) : BatteryCharge {

        init { require(value in 0..100) }

        override fun toString(): String = "$value%"
    }

    object Unknown : BatteryCharge { // 255
        override fun toString(): String = this::class.simpleName!!
    }
}