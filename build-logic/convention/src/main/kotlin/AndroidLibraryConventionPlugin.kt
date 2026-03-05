import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

@Suppress("unused")
class AndroidLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("com.android.library")
        }

        val libs = extensions
            .getByType<VersionCatalogsExtension>()
            .named("libs")

        extensions.configure<LibraryExtension> {
                configureAndroidLibrary(libs)
        }

        configureKotlinJvm()

        commonAndroidDependencies(libs)
        commonTestDependencies(libs)
    }
}
