plugins {
    `kotlin-dsl`
}

java {
    // Must match the JVM toolchain used in modules
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

// Read versions from catalog via the non-generated API — works reliably in included builds
val libs: VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

dependencies {
    compileOnly("com.android.tools.build:gradle:${libs.findVersion("agp").get()}")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.findVersion("kotlin").get()}")
}

gradlePlugin {
    plugins {
        // Base KMP + Android convention (shared by both modules)
        register("kmpAndroid") {
            id = "convention.kmp.android"
            implementationClass = "KmpAndroidConventionPlugin"
        }
    }
}