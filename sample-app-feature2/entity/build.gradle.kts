plugins {
    id("convention.kmp.android") // common configuration in Conventions plugin
}

kotlin {
    android {
        namespace = "dev.marcosalis.clean.feature2.business.entity"
    }

    // iOS targets omitted (add if necessary)

    sourceSets {
        commonMain.dependencies {
            api(project(":sample-entity"))
            api(project(":sample-ktx"))
        }
    }
}
