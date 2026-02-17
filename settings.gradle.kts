pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Android Clean Architecture"
include(":sample-app")
include(":sample-business-usecase")
include(":sample-data-access")
include(":sample-data")
include(":sample-data:injection")
include(":sample-entity")
include(":sample-ktx")
include(":sample-app-feature2")
include(":sample-app-feature2:business-usecase")
include(":sample-app-feature2:data-access")
include(":sample-app-feature2:data")
include(":sample-app-feature2:entity")
