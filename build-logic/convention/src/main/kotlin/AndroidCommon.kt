
import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

internal fun ApplicationExtension.configureAndroidApplication(libs: VersionCatalog) {
    compileSdk = libs.findVersion("sdk.compile").get().requiredVersion.toInt()

    defaultConfig {
        minSdk = libs.findVersion("sdk.min").get().requiredVersion.toInt()
        targetSdk = libs.findVersion("sdk.target").get().requiredVersion.toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

internal fun Project.configureKotlinJvm() {
    tasks.withType<KotlinJvmCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }
}

internal fun Project.commonAndroidDependencies(libs: VersionCatalog) {
    dependencies {
        add("implementation", libs.findLibrary("timber").get())
    }
}

internal fun Project.commonTestDependencies(libs: VersionCatalog) {
    dependencies {
        add("testImplementation", libs.findLibrary("junit").get())
    }
}
