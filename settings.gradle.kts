rootProject.name = "practice-kotlin"

include(
    "ladder",
    "practice",
    "racingcar",
)

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        id("org.jetbrains.kotlin.jvm") version "1.8.10" apply false
    }
}
