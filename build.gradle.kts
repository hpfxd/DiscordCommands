plugins {
    java
    `java-library`
    `maven-publish`
    signing
}

group = "com.hpfxd.discordcommands"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:16.0.2")
    implementation("software.pando.crypto:salty-coffee:1.0.4")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.0-rc1")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.1")
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
            }

            pom {
                url.set("https://hpfxd.com/")
                developers {
                    developer {
                        id.set("hpfxd")
                        name.set("Nate")
                        email.set("me@hpfxd.com")
                    }
                }
            }
        }
    }

    repositories {
        maven {
            name = "hpfxd-repo"

            val releasesRepoUrl = uri("https://repo.hpfxd.com/releases/")
            val snapshotsRepoUrl = uri("https://repo.hpfxd.com/snapshots/")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl

            credentials {
                username = property("repository.hpfxd.username") as String
                password = property("repository.hpfxd.password") as String
            }
        }
    }
}

signing {
    sign(publishing.publications["mavenJava"])
    useGpgCmd()
}
