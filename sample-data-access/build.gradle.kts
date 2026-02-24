plugins {
    id("convention.android.library")
}

android {
    namespace = "dev.marcosalis.clean.data.access"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {
    api(project(":sample-entity"))

    implementation(libs.javax.inject)
    implementation(libs.androidx.core.ktx)
}
