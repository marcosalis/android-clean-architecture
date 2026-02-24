plugins {
    id("convention.kotlin.library")
    alias(libs.plugins.kotlinx.serialization)
}

dependencies {
    api(project(":sample-entity"))
    api(project(":sample-ktx"))

    api(libs.kotlinx.serialization.json)
}
