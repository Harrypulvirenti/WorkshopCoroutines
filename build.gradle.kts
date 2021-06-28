import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.0"
}

group = "me.harrypulvirenti"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val coroutineVersion = "1.5.0-RC"
    val turbine = "0.5.2"

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutineVersion")
    testImplementation ("app.cash.turbine:turbine:$turbine")
    testImplementation(kotlin("test-junit"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}