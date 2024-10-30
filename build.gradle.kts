plugins {
    kotlin("jvm") version "2.0.20"
}

group = "wtf.bernzrdo.snake"
version = "0.0.1"
val mainClass = "MainKt"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.github.palex65:CanvasLib-jvm:1.0.2")
}

tasks.withType<Jar>{
    manifest{
        attributes["Main-Class"] = mainClass
    }
}

tasks.test {
    useJUnitPlatform()
}



kotlin {
    jvmToolchain(21)
}