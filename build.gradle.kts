plugins {
    kotlin("jvm") version "1.5.31"
    id("org.jetbrains.intellij") version "1.2.0"
    java
}

group = "io.github.drahot"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.31")
    // https://mvnrepository.com/artifact/redis.clients/jedis
    implementation("redis.clients:jedis:3.6.3")
    // https://mvnrepository.com/artifact/com.github.mwiede/jsch
    implementation("com.github.mwiede:jsch:0.1.68")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version.set("2021.2.2")
}
tasks {
    patchPluginXml {
        changeNotes.set("""
            Add change notes here.<br>
            <em>most HTML tags may be used</em>        """.trimIndent())
    }
}
tasks.getByName<Test>("test") {
    useJUnitPlatform()
}