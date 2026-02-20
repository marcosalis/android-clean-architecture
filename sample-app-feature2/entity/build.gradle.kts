import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
}

kotlin {
    jvmToolchain(JvmTarget.JVM_21.target.toInt())

    android {
        namespace = "dev.marcosalis.clean.feature2.business.entity"
        compileSdk { version = release(libs.versions.sdk.compile.get().toInt()) }
        minSdk { version = release(libs.versions.sdk.min.get().toInt()) }

        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }

    // iOS targets omitted (add if necessary)

    sourceSets {
       @Suppress("unused") val commonMain by getting {
            dependencies {
                api(project(":sample-entity"))
                api(project(":sample-ktx"))
            }
        }
    }
}
