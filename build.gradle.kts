import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
	kotlin("jvm") version "1.6.10"
	id("org.jetbrains.compose") version "1.1.0"
}

group = "self.itssho"
version = "1.0.0"

dependencies {
	implementation(compose.desktop.currentOs)
	implementation(project(":lib-power"))
}

repositories {
	mavenCentral()
	maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
	google()
}

compose.desktop {
	application {
		mainClass = "dev.itssho.powerwatch.java.MainKt"
		group = "application"

		nativeDistributions {
			targetFormats(TargetFormat.Exe, TargetFormat.Msi)
		}
	}
}

fun kotlinx(simpleModuleName: String, version: String?): ExternalModuleDependency {
	val dependency = project.dependencies.create(
		"org.jetbrains.kotlinx:kotlinx-$simpleModuleName" + version?.let { ":$it" }.orEmpty()
	)

	return dependency as ExternalModuleDependency
}
//tasks.withType<KotlinCompile>().configureEach {
//	kotlinOptions {
////		jvmTarget = "1.8"
//		freeCompilerArgs = freeCompilerArgs.toMutableList().apply {
////			this += "-Xallow-jvm-ir-dependencies"
//			this += "-P"
//			this += "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=true"
//		}
//	}
//}
