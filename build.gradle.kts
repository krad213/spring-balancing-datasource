plugins {
    java
    groovy
}

group = "su.kore"
version = "1.0.11-SNAPSHOT"

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