plugins {
    id("convention.kmp.android") // common configuration in Conventions plugin
}

kotlin {
    compilerOptions {
        // Common compiler options applied to all Kotlin source sets
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }

    android {
        namespace = "dev.marcosalis.clean.ktx"
    }

    // iOS targets omitted (add if necessary)

    sourceSets {
        // note: this is mostly a Kotlin-only module, only shared platform-specific code should be added here

        commonMain.dependencies {
            api(libs.javax.inject)
            api(libs.kotlinx.datetime)
            api(libs.kotlinx.coroutines)
            api(libs.kotlinx.collections.immutable)
        }

        androidMain.dependencies {
            implementation(libs.timber)
        }
    }
}
