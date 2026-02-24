plugins {
    id("convention.kmp.android") // common configuration in Conventions plugin
}

kotlin {
    android {
        namespace = "dev.marcosalis.clean.business.entity"
    }

    // iOS targets omitted (add if necessary)

    sourceSets {
        // note: this is a Kotlin-only module, no platform-specific source set should go here

        commonMain.dependencies {
            api(project(":sample-ktx"))
        }
    }
}
