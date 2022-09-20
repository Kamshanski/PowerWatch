package dev.itssho.powerwatch.lib.power.windows.tools

import generated.jni.*
import kotlinx.cinterop.*

/**
 * Примеры jni на котлине:
 * https://github.com/LandryNorris/JniUtils
 * https://github.com/Windmill-City/KNI
 */
fun CPointer<JNIEnvVar>.findClass(clazzName: String): jclass? = memScoped {
	val env = this@findClass.pointed.pointed!!

	val formattedClazzName = when {
		clazzName.contains(".") -> clazzName.replace('.', '/')
		else -> clazzName
	}
	val clazzNameCStr = formattedClazzName.cstr.ptr

	env.FindClass!!.invoke(this@findClass, clazzNameCStr)
}

fun CPointer<JNIEnvVar>.getConstructorMethodId(clazz: jclass, constructorParams: String): jmethodID? = memScoped {
	val env = this@getConstructorMethodId.pointed.pointed!!

	val constructorName = "<init>".cstr.ptr
	val constructorParams = constructorParams.cstr.ptr

	env.GetMethodID!!.invoke(this@getConstructorMethodId, clazz, constructorName, constructorParams)
}

fun CPointer<JNIEnvVar>.newObject(clazz: jclass, methodId: jmethodID, vararg args: CValue<jvalue>?): jobject = memScoped {
	val env = this@newObject.pointed.pointed!!

	val arguments = allocArray<jvalue>(args.size)
	args.asSequence()
		.filterNotNull()
		.forEachIndexed { index, cValue -> cValue.place(arguments[index].ptr) }

	val obj = env.NewObjectA!!.invoke(
		p1 = this@newObject,
		p2 = clazz,
		p3 = methodId,
		p4 = arguments,
	) ?: throw NewObjectException(clazz, methodId, args)

	return obj
}

fun CPointer<JNIEnvVar>.newObject(clazzName: String, constructorParams: String, vararg args: CValue<jvalue>?): jobject {
	val clazz = findClass(clazzName) ?: throw NoClassException(clazzName)
	val methodId = getConstructorMethodId(clazz, constructorParams) ?: throw NoConstructorException(constructorParams)
	val obj = newObject(clazz, methodId, *args)
	return obj
}

// Exceptions throw
inline fun NoClassException(clazzName: String): Throwable =
	NativeException("Class not found: $clazzName")

inline fun NoConstructorException(constructorParams: String): Throwable =
	NativeException("Constructor with params '$constructorParams' not found")

inline fun NewObjectException(clazz: jclass, methodId: jmethodID, args: Array<out CValue<jvalue>?>): Throwable =
	NativeException("New object creation: jclass='${clazz}', jmethodID='$methodId', args='${args.joinToString()}'")
