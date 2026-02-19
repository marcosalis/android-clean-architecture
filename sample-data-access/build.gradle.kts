import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
}

kotlin {
    jvmToolchain(JvmTarget.JVM_21.target.toInt())

    jvm() // just for unit tests

    android {
        namespace = "dev.marcosalis.clean.data.access"
        compileSdk { version = release(libs.versions.sdk.compile.get().toInt()) }
        minSdk { version = release(libs.versions.sdk.min.get().toInt()) }

        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }

    sourceSets {
        @Suppress("unused") val commonMain by getting {
            dependencies {
                api(project(":sample-entity"))
            }
        }

        @Suppress("unused") val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.junit)
            }
        }
    }
}
