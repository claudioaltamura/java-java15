import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
  java
  idea
  eclipse
}

repositories {
  jcenter()
}

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")

  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.2")
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
