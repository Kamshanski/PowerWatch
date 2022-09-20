package dev.itssho.powerwatch.lib.power.windows.tools

data class NativeException(override val message: String? = null, override val cause: Throwable? = null) : Throwable()