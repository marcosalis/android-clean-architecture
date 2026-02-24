import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryTarget
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.invoke
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

/**
 * Convention plugin for all KMP modules that include an Android target.
 *
 * Applies:
 *  - com.android.kotlin.multiplatform.library (AGP 9.0)
 *  - org.jetbrains.kotlin.multiplatform
 *
 * Configures:
 *  - JVM toolchain 21
 *  - Android compileSdk / minSdk  (read from version catalog)
 *  - Android compiler options     (JvmTarget 21)
 *  - Host Android test basic configuration
 */
@Suppress("unused")
class KmpAndroidConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("com.android.kotlin.multiplatform.library")
            apply("org.jetbrains.kotlin.multiplatform")
        }

        extensions.configure<KotlinMultiplatformExtension> {
            configureKmpModules(this)
        }
    }
}

private fun Project.configureKmpModules(extension: KotlinMultiplatformExtension) {
    extension.apply {
        val libs = this@configureKmpModules.extensions.getByType<VersionCatalogsExtension>()
            .named("libs")

        val compileSdkVersion = libs.findVersion("sdk.compile").get().requiredVersion.toInt()
        val minSdkVersion = libs.findVersion("sdk.min").get().requiredVersion.toInt()

        jvmToolchain(JvmTarget.JVM_21.target.toInt())

        applyDefaultHierarchyTemplate()

        targets.withType(KotlinMultiplatformAndroidLibraryTarget::class.java) {
            compileSdk { version = release(compileSdkVersion) }
            minSdk { version = release(minSdkVersion) }

            compilerOptions {
                jvmTarget.set(JvmTarget.JVM_21)
            }

            // Enable host tests for the Android target
            withHostTest {}
        }

        sourceSets {
            // shared testing configuration added here for all KMP modules

            // `./gradlew check` to run all targets unit tests

            getByName("commonTest") {
                dependencies {
                    implementation(kotlin("test"))
                }
            }

            getByName("androidHostTest") {
                dependencies {
                    implementation(libs.findLibrary("junit").get())
                }
            }
        }
    }
}
