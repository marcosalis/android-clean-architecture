plugins {
    id("convention.kotlin.library")
}

dependencies {
    // Kotlin fundamentals
    api(libs.kotlinx.datetime)
    api(libs.kotlinx.coroutines)
    api(libs.kotlinx.collections.immutable)
}
