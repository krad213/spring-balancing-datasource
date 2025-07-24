plugins {
    java
    groovy
    `maven-publish`
}

group = "com.github.krad213"
version = "1.0.11.2-alpha"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}


dependencies {
    compileOnly("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.projectlombok:lombok:1.18.38")
    compileOnly("org.springframework.boot:spring-boot-configuration-processor:3.2.4")


    implementation("org.springframework.boot:spring-boot-starter-jdbc:3.2.4")
    implementation("com.zaxxer:HikariCP:6.3.0")
    implementation("org.springframework.boot:spring-boot-starter-actuator:3.2.4")


    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.codehaus.groovy:groovy-all:3.0.25")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.4")
    testImplementation("org.springframework.boot:spring-boot-starter-web:3.2.4")
    testImplementation("org.testcontainers:mariadb:1.21.3")
    testImplementation("org.mariadb.jdbc:mariadb-java-client:3.5.4")

    testCompileOnly("org.projectlombok:lombok:1.18.38")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.38")
}

tasks.test {
    useJUnitPlatform()
}


tasks.register<Jar>("sourcesJar") {
    archiveClassifier.set("sources")
    from(sourceSets["main"].allSource)
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            artifact(tasks["sourcesJar"])
        }
    }
    repositories {
        maven {
            name = "local"
            url = uri("${System.getProperty("user.home")}/.m2/repository")
        }
    }
}
