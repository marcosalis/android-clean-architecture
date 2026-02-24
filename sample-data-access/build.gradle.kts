plugins {
    id("convention.kmp.android") // common configuration in Conventions plugin
}

kotlin {
    android {
        namespace = "dev.marcosalis.clean.data.access"
    }

    // iOS targets omitted (add if necessary)

    sourceSets {
        commonMain.dependencies {
            api(project(":sample-entity"))
        }
    }
}
