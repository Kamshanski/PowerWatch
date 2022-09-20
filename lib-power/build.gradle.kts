import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("multiplatform")
}

repositories {
	mavenCentral()
}

kotlin {
	val jvm = jvm {
		compilations["main"].dependencies {
			implementation(kotlin("stdlib"))
			implementation(kotlinx("coroutines-core", "1.6.4"))
		}
	}

	val native = mingwX64("windows") {
		binaries {
			sharedLib {
				val libsOutputPath = File(project.buildFile.parentFile.path + "\\src\\jvmMain\\resources\\lib")
				if (!libsOutputPath.exists()) {
					libsOutputPath.mkdirs()
				}
				this.outputDirectory = libsOutputPath
				println("outputDirectory set")
				println("outputDirectory set: '$outputDirectory'")
			}
		}

		compilations["main"].cinterops.create("jni") {
			// JDK is required here, JRE is not enough
			val javaHome = File(System.getenv("JAVA_HOME") ?: System.getProperty("java.home"))
			packageName = "generated.jni"
			includeDirs(
				Callable { File(javaHome, "include") },
				Callable { File(javaHome, "include/win32") }
			)
		}
	}

	tasks.withType<KotlinCompile> {
//		dependsOn(jvm.compilations.map { it.compileAllTaskName }.also(::println))
		dependsOn(native.compilations.map { it.compileAllTaskName }.also(::println))
		dependsOn(native.binaries.map { it.linkTaskName }.also(::println))

		doFirst {
			configurations.add(configurations["jvmRuntimeClasspath"])
			// Унёс в код
//			systemProperty("java.library.path", native.binaries.findSharedLib("debug")!!.outputDirectory)
		}
	}
}


fun kotlinx(simpleModuleName: String, version: String?): ExternalModuleDependency {
	val dependency = project.dependencies.create(
		"org.jetbrains.kotlinx:kotlinx-$simpleModuleName" + version?.let { ":$it" }.orEmpty()
	)

	return dependency as ExternalModuleDependency
}