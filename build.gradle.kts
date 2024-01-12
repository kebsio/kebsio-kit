plugins {
    `java-library`
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

allprojects {
    group = "dev.kebcio.kit"
    version = "1.0-SNAPSHOT"

    apply(plugin = "java-library")

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    }

    tasks {
        compileJava {
            options.encoding = Charsets.UTF_8.name()
            options.release.set(17)
        }
        javadoc {
            options.encoding = Charsets.UTF_8.name()
        }
        processResources {
            filteringCharset = Charsets.UTF_8.name()
        }
    }

    repositories {
        mavenCentral()
        maven(url = "https://storehouse.okaeri.eu/repository/maven-public/")
        maven(url = "https://repo.dreamcode.cc/releases/")
    }

    dependencies {
        compileOnly("org.projectlombok:lombok:1.18.30")
        annotationProcessor("org.projectlombok:lombok:1.18.30")
        testCompileOnly("org.projectlombok:lombok:1.18.30")
        testAnnotationProcessor("org.projectlombok:lombok:1.18.30")
    }

    apply(plugin = "com.github.johnrengelman.shadow")
}