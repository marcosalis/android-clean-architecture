plugins {
    id("convention.android.library")
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "dev.marcosalis.clean.feature2.data"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {
    implementation(project(":sample-app-feature2:data-access"))

    implementation(libs.androidx.core.ktx)

    implementation(libs.kotlinx.serialization.json)

    // Dagger / Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
