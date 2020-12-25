plugins {
  kotlin("jvm") version "1.4.10"
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib"))        
  implementation(kotlin("reflect:1.3.50"))
  testCompile("io.kotlintest:kotlintest-runner-junit5:3.4.0")
}

val test by tasks.getting(Test::class) {
  useJUnitPlatform {}
}

defaultTasks("clean", "test")
