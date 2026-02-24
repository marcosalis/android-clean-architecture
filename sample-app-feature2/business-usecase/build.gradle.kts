
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
}

kotlin {
    jvmToolchain(JvmTarget.JVM_21.target.toInt())

    android {
        namespace = "dev.marcosalis.feature2.business.usecase"
        compileSdk { version = release(libs.versions.sdk.compile.get().toInt()) }
        minSdk { version = release(libs.versions.sdk.min.get().toInt()) }

        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }

        @Suppress("UnstableApiUsage")
        optimization {
            consumerKeepRules.apply {
                publish = true
                file("consumer-rules.pro")
            }
        }

        // Enable host tests for the Android target
        withHostTest {}
    }

    // iOS targets omitted (add if necessary)

    sourceSets {
        @Suppress("unused") val commonMain by getting {
            dependencies {
    api(project(":sample-app-feature2:entity"))
    implementation(project(":sample-app-feature2:data-access"))
            }
        }

        @Suppress("unused") val androidMain by getting {
            dependencies {
                implementation(libs.androidx.core.ktx)

                implementation(libs.timber)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        @Suppress("unused") val androidHostTest by getting {
            dependsOn(commonTest)
            dependencies {
                implementation(libs.junit)
            }
        }
    }
}
