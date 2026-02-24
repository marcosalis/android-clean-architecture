plugins {
    id("convention.android.library")
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "dev.marcosalis.clean.business.usecase"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {
    api(project(":sample-entity"))
    implementation(project(":sample-data-access"))

    implementation(libs.androidx.core.ktx)

    // Dagger / Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}
