plugins {
    id("convention.android.library")
}

android {
    namespace = "dev.marcosalis.clean.data.injection"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    /** Connects `data` Dagger `@Module`s to the graph. See module's `README.md` for more details. */
    implementation(project(":sample-data"))

    implementation(project(":sample-app-feature2:data")) // data layer initialization for `feature2`
}
