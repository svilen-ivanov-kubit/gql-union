plugins {
    kotlin("jvm") version "1.5.31"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.graphql-java-kickstart:graphql-java-tools:12.0.0")
    implementation("ch.qos.logback:logback-classic:1.2.6")
}

application.mainClass.set("Main")


