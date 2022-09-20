package dev.itssho.powerwatch.lib.power.windows.power.service

import dev.itssho.powerwatch.lib.power.windows.power.entity.NSystemPowerStatus
import dev.itssho.powerwatch.lib.power.windows.tools.NativeException
import generated.jni.JNIEnvVar
import generated.jni.jclass
import generated.jni.jobject
import kotlinx.cinterop.*
import platform.windows.GetSystemPowerStatus
import platform.windows.SYSTEM_POWER_STATUS

/** @see [dev.itssho.powerwatch.lib.power.java.power.service.anative.NativePowerStatusService] */
@Suppress("UNUSED_PARAMETER")
@CName("Java_dev_itssho_powerwatch_lib_power_java_power_service_anative_NativePowerStatusService_getPower")
fun getPower(env: CPointer<JNIEnvVar>, clazz: jclass): jobject {
	initRuntimeIfNeeded()
	Platform.isMemoryLeakCheckerActive = false

	val status = readPowerStatus(env)

	return status
}

private fun readPowerStatus(env: CPointer<JNIEnvVar>): jobject = memScoped {
	val powerStatus = alloc<SYSTEM_POWER_STATUS>().ptr
	// Проверять return value не надо, т.к. функция может возвращать не 0 при несовершившейся ошибке
	GetSystemPowerStatus(powerStatus)

	val nativeStatus = convert(powerStatus.pointed)

	try {
		return@memScoped nativeStatus.toJni(env)
	} catch (npse: NativeException) {
		println(npse.stackTraceToString())
		throw npse
	}
}

private fun convert(powerStatus: SYSTEM_POWER_STATUS): NSystemPowerStatus = with(powerStatus) { //@formatter:off
    NSystemPowerStatus(
        ACLineStatus =          ACLineStatus.toByte(),
        BatteryFlag =           BatteryFlag.toByte(),
        BatteryFullLifeTime =   BatteryFullLifeTime.toInt(),
        BatteryLifePercent =    BatteryLifePercent.toByte(),
        BatteryLifeTime =       BatteryLifeTime.toInt(),
        Reserved1 =             Reserved1.toByte(),
    )
}//@formatter:on