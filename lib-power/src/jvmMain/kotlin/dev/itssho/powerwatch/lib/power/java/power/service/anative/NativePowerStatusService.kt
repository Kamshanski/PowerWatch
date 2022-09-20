package dev.itssho.powerwatch.lib.power.java.power.service.anative

import dev.itssho.powerwatch.lib.power.java.power.entity.NSystemPowerStatus

/** @see [dev.itssho.powerwatch.lib.power.windows.power.service.getPower] */
internal class NativePowerStatusService {

    external fun getPower(): NSystemPowerStatus
}