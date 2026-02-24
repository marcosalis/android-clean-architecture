plugins {
    id("convention.kmp.android") // common configuration in Conventions plugin
}

kotlin {
    android {
        namespace = "dev.marcosalis.clean.business.usecase"

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
            api(project(":sample-entity"))
            implementation(project(":sample-data-access"))
        }

        androidMain.dependencies {
            implementation(libs.androidx.core.ktx)

            implementation(libs.timber)
        }
    }
}
