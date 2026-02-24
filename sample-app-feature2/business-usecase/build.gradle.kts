

plugins {
    id("convention.android.library")
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "dev.marcosalis.feature2.business.usecase"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    api(project(":sample-app-feature2:entity"))
    implementation(project(":sample-app-feature2:data-access"))

    implementation(libs.androidx.core.ktx)

    // Dagger / Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    implementation(libs.timber)
}
