import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    java
    idea
    eclipse
    id("com.diffplug.spotless") version "6.5.0"
    id("com.github.ben-manes.versions") version "0.42.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.assertj:assertj-core:3.22.0")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

java {
    sourceCompatibility = JavaVersion.VERSION_15
    targetCompatibility = JavaVersion.VERSION_15
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("--enable-preview")
}

val test by tasks.getting(Test::class) {
    jvmArgs("--enable-preview")
    useJUnitPlatform()
    testLogging {
        events = setOf(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
    }
}
