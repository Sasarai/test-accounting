plugins {
    kotlin("jvm") version "2.1.10"
}

group = "fr.tvallierremy"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val assertjVersion = "3.11.1"
val jacksonVersion = "2.18.2"
val mockitoVersion = "5.15.2"

dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")

    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:$assertjVersion")
    testImplementation("org.mockito:mockito-core:$mockitoVersion")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
