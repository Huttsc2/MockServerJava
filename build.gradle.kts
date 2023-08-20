plugins {
    id("java")
    id("application")
}

application {
    mainClass.set("Main.MainClass")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.mock-server:mockserver-netty-no-dependencies:5.14.0")
    implementation("org.mock-server:mockserver-client-java-no-dependencies:5.14.0")
    implementation("ch.qos.logback:logback-classic:1.2.9")
}

tasks.test {
    useJUnitPlatform()
}