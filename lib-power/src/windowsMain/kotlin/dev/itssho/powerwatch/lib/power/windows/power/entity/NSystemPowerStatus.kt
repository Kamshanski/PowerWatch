package dev.itssho.powerwatch.lib.power.windows.power.entity

import dev.itssho.powerwatch.lib.power.windows.tools.asJValue
import dev.itssho.powerwatch.lib.power.windows.tools.newObject
import generated.jni.JNIEnvVar
import generated.jni.jobject
import kotlinx.cinterop.CPointer

/** @see [N_SYSTEM_POWER_STATUS_FQ_NAME] */
data class NSystemPowerStatus(
	val ACLineStatus: Byte,
	val BatteryFlag: Byte,
	val BatteryFullLifeTime: Int,
	val BatteryLifePercent: Byte,
	val BatteryLifeTime: Int,
	val Reserved1: Byte,
) {

	companion object {

		const val N_SYSTEM_POWER_STATUS_FQ_NAME = "dev.itssho.powerwatch.lib.power.java.power.entity.NSystemPowerStatus"

		const val N_SYSTEM_POWER_STATUS_CONSTRUCTOR_SIGNATURE = "(BBIBIB)V"
	}

	fun toJni(jniEnvPtr: CPointer<JNIEnvVar>): jobject =
		jniEnvPtr.newObject(
			clazzName = N_SYSTEM_POWER_STATUS_FQ_NAME,
			constructorParams = N_SYSTEM_POWER_STATUS_CONSTRUCTOR_SIGNATURE,
			ACLineStatus.asJValue(),
			BatteryFlag.asJValue(),
			BatteryFullLifeTime.asJValue(),
			BatteryLifePercent.asJValue(),
			BatteryLifeTime.asJValue(),
			Reserved1.asJValue(),
		)
}

/*
@CStruct class _SYSTEM_POWER_STATUS public constructor(rawPtr: NativePtr /* = NativePtr */) : CStructVar {
    @CStruct.VarType @Deprecated public companion object : CStructVar.Type {
    }

    public final var ACLineStatus: BYTE /* = UByte */ /* compiled code */

    public final var BatteryFlag: BYTE /* = UByte */ /* compiled code */

    public final var BatteryFullLifeTime: DWORD /* = UInt */ /* compiled code */

    public final var BatteryLifePercent: BYTE /* = UByte */ /* compiled code */

    public final var BatteryLifeTime: DWORD /* = UInt */ /* compiled code */

    public final var Reserved1: BYTE /* = UByte */ /* compiled code */
}
 */