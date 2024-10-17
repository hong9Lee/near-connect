import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    val kotlinVersion = "1.9.22"
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
}

val jar: Jar by tasks
val bootJar: BootJar by tasks
bootJar.enabled = true
jar.enabled = true

dependencies {
    implementation(project(":near-connect:core"))

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // websocket
    implementation("org.springframework.boot:spring-boot-starter-websocket")
    implementation("org.springframework:spring-messaging")

//    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation("mysql:mysql-connector-java:8.0.23")

    // redis
    implementation("org.springframework.boot:spring-boot-starter-data-redis")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}
