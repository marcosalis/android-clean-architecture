import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.kotlinx.serialization)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    implementation(libs.javax.inject)

    // Kotlin fundamentals
    api(libs.kotlinx.datetime)
    api(libs.kotlinx.coroutines)
    api(libs.kotlinx.serialization.json)
    api(libs.kotlinx.collections.immutable)

    testImplementation(libs.junit)
}
