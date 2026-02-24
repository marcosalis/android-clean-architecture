plugins {
    id("convention.kmp.android") // common configuration in Conventions plugin
}

kotlin {
    android {
        namespace = "dev.marcosalis.clean.data"

        @Suppress("UnstableApiUsage")
        optimization {
            consumerKeepRules.apply {
                publish = true
                file("consumer-rules.pro")
            }
        }
    }

    // iOS targets omitted (add if necessary)

    sourceSets {
        commonMain.dependencies {
            api(project(":sample-data-access"))
        }

        androidMain.dependencies {
            implementation(libs.androidx.core.ktx)

            implementation(libs.kotlinx.serialization.json)

            implementation(libs.timber)
        }
    }
}
