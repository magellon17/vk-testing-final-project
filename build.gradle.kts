plugins {
    id("java")
}

group = "ru.siobko.testing"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.junit:junit-bom:5.10.3"))
    implementation("org.junit.jupiter:junit-jupiter")
    runtimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("com.codeborne:selenide:7.5.0")
    runtimeOnly("io.goodforgod:slf4j-simple-logger:2.0.0")
}

tasks.test {
    useJUnitPlatform()
}