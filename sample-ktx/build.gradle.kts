import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
}

kotlin {
   jvmToolchain(JvmTarget.JVM_21.target.toInt())

    android {
        namespace = "dev.marcosalis.clean.ktx"
        compileSdk { version = release(libs.versions.sdk.compile.get().toInt()) }
        minSdk { version = release(libs.versions.sdk.min.get().toInt()) }

        compilerOptions {
           jvmTarget.set(JvmTarget.JVM_21)
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.javax.inject)
                api(libs.kotlinx.datetime)
                api(libs.kotlinx.coroutines)
                api(libs.kotlinx.collections.immutable)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libs.junit)
            }
        }
    }
}
