plugins {
    id("convention.kmp.android") // common configuration in Conventions plugin
}

kotlin {
    android {
        namespace = "dev.marcosalis.feature2.business.usecase"

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
            api(project(":sample-app-feature2:entity"))
            implementation(project(":sample-app-feature2:data-access"))
        }

        androidMain.dependencies {
            implementation(libs.androidx.core.ktx)

            implementation(libs.timber)
        }
    }
}
