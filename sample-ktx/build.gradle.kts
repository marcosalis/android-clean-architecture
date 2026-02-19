import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
}

kotlin {
    jvmToolchain(JvmTarget.JVM_21.target.toInt())

    jvm() // only for unit tests

    android {
        namespace = "dev.marcosalis.clean.ktx"
        compileSdk { version = release(libs.versions.sdk.compile.get().toInt()) }
        minSdk { version = release(libs.versions.sdk.min.get().toInt()) }

        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }

    // iOS targets go here

    sourceSets {
        // note: this is a Kotlin-only module, no platform-specific code should go here

        @Suppress("unused") val commonMain by getting {
            dependencies {
                api(libs.javax.inject)
                api(libs.kotlinx.datetime)
                api(libs.kotlinx.coroutines)
                api(libs.kotlinx.collections.immutable)
            }
        }

        // `./gradlew :sample-ktx:check` to run all targets tests

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        @Suppress("unused") // `jvmTest` source set declaration is required to run `commonTest` tests
        val jvmTest by getting {
            dependsOn(commonTest)
            dependencies {
                implementation(libs.junit)
            }
        }
    }
}
