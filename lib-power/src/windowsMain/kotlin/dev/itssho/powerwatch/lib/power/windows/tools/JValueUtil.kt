package dev.itssho.powerwatch.lib.power.windows.tools

import kotlinx.cinterop.CValue
import kotlinx.cinterop.cValue
import generated.jni.JNI_FALSE
import generated.jni.JNI_TRUE
import generated.jni.jobject
import generated.jni.jvalue

inline fun Boolean.asJValue(): CValue<jvalue> = cValue {
	z = when (this@asJValue) {
		true  -> JNI_TRUE.toUByte()
		false -> JNI_FALSE.toUByte()
	}
}

inline fun Byte.asJValue(): CValue<jvalue> = cValue { b = this@asJValue }
inline fun Char.asJValue(): CValue<jvalue> = cValue { c = this@asJValue.code.toUShort() }
inline fun UShort.asJValue(): CValue<jvalue> = cValue { c = this@asJValue }
inline fun Short.asJValue(): CValue<jvalue> = cValue { s = this@asJValue }
inline fun Int.asJValue(): CValue<jvalue> = cValue { i = this@asJValue }
inline fun Long.asJValue(): CValue<jvalue> = cValue { j = this@asJValue }
inline fun Float.asJValue(): CValue<jvalue> = cValue { f = this@asJValue }
inline fun Double.asJValue(): CValue<jvalue> = cValue { d = this@asJValue }
inline fun jobject.asJValue(): CValue<jvalue> = cValue { l = this@asJValue }