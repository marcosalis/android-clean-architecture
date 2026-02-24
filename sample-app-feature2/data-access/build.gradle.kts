plugins {
    id("convention.android.library")
}

android {
    namespace = "dev.marcosalis.clean.feature2.data.access"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {
    api(project(":sample-app-feature2:entity"))

    implementation(libs.javax.inject)
    implementation(libs.androidx.core.ktx)
}
