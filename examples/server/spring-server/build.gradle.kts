import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

description = "An example GraphQL Spring server"

plugins {
    id("org.springframework.boot") version "2.4.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("com.expediagroup.graphql") version "4.1.1"
    war
    java
    kotlin("jvm") version "1.4.31"
    kotlin("plugin.spring") version "1.4.31"
}

java.sourceCompatibility = JavaVersion.VERSION_1_8

dependencies {
    implementation("com.expediagroup:graphql-kotlin-spring-server:4.1.1")
    implementation("com.expediagroup:graphql-kotlin-hooks-provider:4.1.1")
    implementation("org.springframework.boot", "spring-boot-starter-validation")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.4.4")
    testImplementation("io.projectreactor:reactor-test")
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
}

graphql {
    schema {
        packages = listOf("com.expediagroup.graphql.examples.server.spring")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
