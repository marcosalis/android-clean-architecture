plugins {
    id("convention.kmp.android") // common configuration in Conventions plugin
}

kotlin {
    android {
        namespace = "dev.marcosalis.clean.feature2.data"

        @Suppress("UnstableApiUsage")
        optimization {
            consumerKeepRules.apply {
                publish = true
                file("consumer-rules.pro")
            }
        }
    }

    // iOS targets omitted (add if necessary)

    applyDefaultHierarchyTemplate()

    sourceSets {
        commonMain.dependencies {
            api(project(":sample-app-feature2:data-access"))

            implementation(libs.hilt.android) // only used for annotations
        }

        androidMain.dependencies {
            implementation(libs.androidx.core.ktx)

            implementation(libs.kotlinx.serialization.json)

            implementation(libs.timber)
        }
    }
}
