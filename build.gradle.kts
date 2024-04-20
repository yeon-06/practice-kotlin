plugins {
    kotlin("jvm") version "1.9.0"
    id("org.jlleitschuh.gradle.ktlint") version "12.1.0"
}

group = "com.yeonlog.practice"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

subprojects {
    repositories {
        mavenCentral()
    }

    apply(plugin = "kotlin")

    dependencies {
        testImplementation("org.junit.jupiter", "junit-jupiter", "5.10.2")
        testImplementation("org.assertj", "assertj-core", "3.25.3")
        testImplementation("io.kotest", "kotest-runner-junit5", "5.8.0")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }
    test {
        useJUnitPlatform()
    }
    ktlint {
        verbose.set(true)
    }
}
