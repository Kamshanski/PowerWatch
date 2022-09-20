#ifndef KONAN_LIB_POWER_H
#define KONAN_LIB_POWER_H
#ifdef __cplusplus
extern "C" {
#endif
#ifdef __cplusplus
typedef bool            lib_power_KBoolean;
#else
typedef _Bool           lib_power_KBoolean;
#endif
typedef unsigned short     lib_power_KChar;
typedef signed char        lib_power_KByte;
typedef short              lib_power_KShort;
typedef int                lib_power_KInt;
typedef long long          lib_power_KLong;
typedef unsigned char      lib_power_KUByte;
typedef unsigned short     lib_power_KUShort;
typedef unsigned int       lib_power_KUInt;
typedef unsigned long long lib_power_KULong;
typedef float              lib_power_KFloat;
typedef double             lib_power_KDouble;
#ifndef _MSC_VER
typedef float __attribute__ ((__vector_size__ (16))) lib_power_KVector128;
#else
#include <xmmintrin.h>
typedef __m128 lib_power_KVector128;
#endif
typedef void*              lib_power_KNativePtr;
struct lib_power_KType;
typedef struct lib_power_KType lib_power_KType;

typedef struct {
  lib_power_KNativePtr pinned;
} lib_power_kref_kotlin_Byte;
typedef struct {
  lib_power_KNativePtr pinned;
} lib_power_kref_kotlin_Short;
typedef struct {
  lib_power_KNativePtr pinned;
} lib_power_kref_kotlin_Int;
typedef struct {
  lib_power_KNativePtr pinned;
} lib_power_kref_kotlin_Long;
typedef struct {
  lib_power_KNativePtr pinned;
} lib_power_kref_kotlin_Float;
typedef struct {
  lib_power_KNativePtr pinned;
} lib_power_kref_kotlin_Double;
typedef struct {
  lib_power_KNativePtr pinned;
} lib_power_kref_kotlin_Char;
typedef struct {
  lib_power_KNativePtr pinned;
} lib_power_kref_kotlin_Boolean;
typedef struct {
  lib_power_KNativePtr pinned;
} lib_power_kref_kotlin_Unit;
typedef struct {
  lib_power_KNativePtr pinned;
} lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus;
typedef struct {
  lib_power_KNativePtr pinned;
} lib_power_kref_kotlin_Any;
typedef struct {
  lib_power_KNativePtr pinned;
} lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus_Companion;
typedef struct {
  lib_power_KNativePtr pinned;
} lib_power_kref_kotlin_Array;
typedef struct {
  lib_power_KNativePtr pinned;
} lib_power_kref_kotlin_Throwable;
typedef struct {
  lib_power_KNativePtr pinned;
} lib_power_kref_kotlinx_cinterop_CValue;
typedef struct {
  lib_power_KNativePtr pinned;
} lib_power_kref_dev_itssho_powerwatch_lib_power_windows_tools_NativeException;

extern void* Java_dev_itssho_powerwatch_lib_power_java_power_service_anative_NativePowerStatusService_getPower(void* env, void* clazz);

typedef struct {
  /* Service functions. */
  void (*DisposeStablePointer)(lib_power_KNativePtr ptr);
  void (*DisposeString)(const char* string);
  lib_power_KBoolean (*IsInstance)(lib_power_KNativePtr ref, const lib_power_KType* type);
  lib_power_kref_kotlin_Byte (*createNullableByte)(lib_power_KByte);
  lib_power_kref_kotlin_Short (*createNullableShort)(lib_power_KShort);
  lib_power_kref_kotlin_Int (*createNullableInt)(lib_power_KInt);
  lib_power_kref_kotlin_Long (*createNullableLong)(lib_power_KLong);
  lib_power_kref_kotlin_Float (*createNullableFloat)(lib_power_KFloat);
  lib_power_kref_kotlin_Double (*createNullableDouble)(lib_power_KDouble);
  lib_power_kref_kotlin_Char (*createNullableChar)(lib_power_KChar);
  lib_power_kref_kotlin_Boolean (*createNullableBoolean)(lib_power_KBoolean);
  lib_power_kref_kotlin_Unit (*createNullableUnit)(void);

  /* User functions. */
  struct {
    struct {
      struct {
        struct {
          struct {
            struct {
              struct {
                struct {
                  struct {
                    struct {
                      struct {
                        lib_power_KType* (*_type)(void);
                        lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus (*NSystemPowerStatus)(lib_power_KByte ACLineStatus, lib_power_KByte BatteryFlag, lib_power_KInt BatteryFullLifeTime, lib_power_KByte BatteryLifePercent, lib_power_KInt BatteryLifeTime, lib_power_KByte Reserved1);
                        lib_power_KByte (*get_ACLineStatus)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus thiz);
                        lib_power_KByte (*get_BatteryFlag)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus thiz);
                        lib_power_KInt (*get_BatteryFullLifeTime)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus thiz);
                        lib_power_KByte (*get_BatteryLifePercent)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus thiz);
                        lib_power_KInt (*get_BatteryLifeTime)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus thiz);
                        lib_power_KByte (*get_Reserved1)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus thiz);
                        lib_power_KByte (*component1)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus thiz);
                        lib_power_KByte (*component2)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus thiz);
                        lib_power_KInt (*component3)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus thiz);
                        lib_power_KByte (*component4)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus thiz);
                        lib_power_KInt (*component5)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus thiz);
                        lib_power_KByte (*component6)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus thiz);
                        lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus (*copy)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus thiz, lib_power_KByte ACLineStatus, lib_power_KByte BatteryFlag, lib_power_KInt BatteryFullLifeTime, lib_power_KByte BatteryLifePercent, lib_power_KInt BatteryLifeTime, lib_power_KByte Reserved1);
                        lib_power_KBoolean (*equals)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus thiz, lib_power_kref_kotlin_Any other);
                        lib_power_KInt (*hashCode)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus thiz);
                        void* (*toJni)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus thiz, void* jniEnvPtr);
                        const char* (*toString)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus thiz);
                        struct {
                          lib_power_KType* (*_type)(void);
                          lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus_Companion (*_instance)();
                          const char* (*get_N_SYSTEM_POWER_STATUS_CONSTRUCTOR_SIGNATURE)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus_Companion thiz);
                          const char* (*get_N_SYSTEM_POWER_STATUS_FQ_NAME)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_power_entity_NSystemPowerStatus_Companion thiz);
                        } Companion;
                      } NSystemPowerStatus;
                    } entity;
                    struct {
                      void* (*getPower)(void* env, void* clazz);
                    } service;
                  } power;
                  struct {
                    lib_power_kref_kotlin_Throwable (*NewObjectException)(void* clazz, void* methodId, lib_power_kref_kotlin_Array args);
                    lib_power_kref_kotlin_Throwable (*NoClassException)(const char* clazzName);
                    lib_power_kref_kotlin_Throwable (*NoConstructorException)(const char* constructorParams);
                    lib_power_kref_kotlinx_cinterop_CValue (*asJValue)(void* thiz);
                    lib_power_kref_kotlinx_cinterop_CValue (*asJValue_)(lib_power_KBoolean thiz);
                    lib_power_kref_kotlinx_cinterop_CValue (*asJValue__)(lib_power_KByte thiz);
                    lib_power_kref_kotlinx_cinterop_CValue (*asJValue___)(lib_power_KChar thiz);
                    lib_power_kref_kotlinx_cinterop_CValue (*asJValue____)(lib_power_KDouble thiz);
                    lib_power_kref_kotlinx_cinterop_CValue (*asJValue_____)(lib_power_KFloat thiz);
                    lib_power_kref_kotlinx_cinterop_CValue (*asJValue______)(lib_power_KInt thiz);
                    lib_power_kref_kotlinx_cinterop_CValue (*asJValue_______)(lib_power_KLong thiz);
                    lib_power_kref_kotlinx_cinterop_CValue (*asJValue________)(lib_power_KShort thiz);
                    lib_power_kref_kotlinx_cinterop_CValue (*asJValue_________)(lib_power_KUShort thiz);
                    void* (*findClass)(void* thiz, const char* clazzName);
                    void* (*getConstructorMethodId)(void* thiz, void* clazz, const char* constructorParams);
                    void* (*newObject)(void* thiz, void* clazz, void* methodId, lib_power_kref_kotlin_Array args);
                    void* (*newObject_)(void* thiz, const char* clazzName, const char* constructorParams, lib_power_kref_kotlin_Array args);
                    struct {
                      lib_power_KType* (*_type)(void);
                      lib_power_kref_dev_itssho_powerwatch_lib_power_windows_tools_NativeException (*NativeException)(const char* message, lib_power_kref_kotlin_Throwable cause);
                      lib_power_kref_kotlin_Throwable (*get_cause)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_tools_NativeException thiz);
                      const char* (*get_message)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_tools_NativeException thiz);
                      const char* (*component1)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_tools_NativeException thiz);
                      lib_power_kref_kotlin_Throwable (*component2)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_tools_NativeException thiz);
                      lib_power_kref_dev_itssho_powerwatch_lib_power_windows_tools_NativeException (*copy)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_tools_NativeException thiz, const char* message, lib_power_kref_kotlin_Throwable cause);
                      lib_power_KBoolean (*equals)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_tools_NativeException thiz, lib_power_kref_kotlin_Any other);
                      lib_power_KInt (*hashCode)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_tools_NativeException thiz);
                      const char* (*toString)(lib_power_kref_dev_itssho_powerwatch_lib_power_windows_tools_NativeException thiz);
                    } NativeException;
                  } tools;
                } windows;
              } power;
            } lib;
          } powerwatch;
        } itssho;
      } dev;
    } root;
  } kotlin;
} lib_power_ExportedSymbols;
extern lib_power_ExportedSymbols* lib_power_symbols(void);
#ifdef __cplusplus
}  /* extern "C" */
#endif
#endif  /* KONAN_LIB_POWER_H */
