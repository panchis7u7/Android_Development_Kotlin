import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.5"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.4.32"
	kotlin("plugin.spring") version "1.4.32"
	kotlin("plugin.jpa") version "1.4.32"
}

group = "com.scholar"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation ("org.springframework.security:spring-security-core")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	//Postgres and hibernate ORM.
	implementation("org.hibernate:hibernate-core:5.4.31.Final")
	implementation("org.postgresql:postgresql")
	implementation("org.xerial:sqlite-jdbc:3.34.0")
	runtimeOnly("com.h2database:h2")

	//Graphql.
	implementation ("com.graphql-java:graphql-spring-boot-starter:5.0.2")
    implementation ("com.graphql-java:graphiql-spring-boot-starter:5.0.2")
    implementation ("com.graphql-java:voyager-spring-boot-starter:5.0.2")
    implementation ("com.graphql-java:graphql-java-tools:5.2.4")

	//JWT
	implementation ("io.jsonwebtoken:jjwt:0.9.1")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
