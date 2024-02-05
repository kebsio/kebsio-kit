plugins {
    id("io.papermc.paperweight.userdev") version "1.5.11"
    id("xyz.jpenilla.run-paper") version "2.2.2"
}

dependencies {



    paperweight.paperDevBundle("1.17.1-R0.1-SNAPSHOT")


    implementation("cc.dreamcode.platform:core:1.9.7")
    implementation("cc.dreamcode.platform:bukkit:1.9.7")
    implementation("cc.dreamcode.platform:bukkit-command:1.9.7")
    implementation("cc.dreamcode.platform:bukkit-config:1.9.7")
    implementation("cc.dreamcode.platform:persistence:1.9.7")


    implementation("cc.dreamcode:utilities:1.2.20")
    implementation("cc.dreamcode:utilities-bukkit:1.2.20")


    implementation("cc.dreamcode.notice:minecraft:1.3.10")
    implementation("cc.dreamcode.notice:bukkit:1.3.10")
    implementation("cc.dreamcode.notice:bukkit-serdes:1.3.10")


    implementation("cc.dreamcode.command:core:1.4.15")
    implementation("cc.dreamcode.command:bukkit:1.4.15")

    implementation("cc.dreamcode.menu:core:1.1.7")
    implementation("cc.dreamcode.menu:bukkit:1.1.7")
    implementation("cc.dreamcode.menu:bukkit-serdes:1.1.7")


    implementation("eu.okaeri:okaeri-configs-yaml-bukkit:5.0.0-beta.5")
    implementation("eu.okaeri:okaeri-configs-serdes-bukkit:5.0.0-beta.5")
    implementation("eu.okaeri:okaeri-configs-serdes-commons:5.0.0-beta.5")


    implementation("eu.okaeri:okaeri-persistence-flat:2.0.0-beta.1")
    implementation("eu.okaeri:okaeri-persistence-jdbc:2.0.0-beta.1")
    implementation("eu.okaeri:okaeri-persistence-mongo:2.0.0-beta.1")


    implementation("eu.okaeri:okaeri-configs-json-gson:5.0.0-beta.5")
    implementation("eu.okaeri:okaeri-configs-json-simple:5.0.0-beta.5")

    implementation("eu.okaeri:okaeri-injector:2.1.0")


    implementation("eu.okaeri:okaeri-placeholders-core:4.0.7")


    implementation("eu.okaeri:okaeri-tasker-bukkit:1.2.0")


    implementation("com.github.cryptomorin:XSeries:9.9.0")
}
tasks{
    assemble {
        dependsOn(reobfJar)
    }
    shadowJar {
        archiveFileName.set("kebsio-kit-${project.version}.jar")

        minimize()

        relocate("com.cryptomorin", "cc.dreamcode.template.libs.com.cryptomorin")
        relocate("eu.okaeri", "cc.dreamcode.template.libs.eu.okaeri")

        relocate("cc.dreamcode.platform", "cc.dreamcode.template.libs.cc.dreamcode.platform")
        relocate("cc.dreamcode.utilities", "cc.dreamcode.template.libs.cc.dreamcode.utilities")
        relocate("cc.dreamcode.menu", "cc.dreamcode.template.libs.cc.dreamcode.menu")
        relocate("cc.dreamcode.command", "cc.dreamcode.template.libs.cc.dreamcode.command")
        relocate("cc.dreamcode.notice", "cc.dreamcode.template.libs.cc.dreamcode.notice")

        relocate("org.bson", "cc.dreamcode.template.libs.org.bson")
        relocate("com.mongodb", "cc.dreamcode.template.libs.com.mongodb")
        relocate("com.zaxxer", "cc.dreamcode.template.libs.com.zaxxer")
        relocate("org.slf4j", "cc.dreamcode.template.libs.org.slf4j")
        relocate("org.json", "cc.dreamcode.template.libs.org.json")
        relocate("com.google.gson", "cc.dreamcode.template.libs.com.google.gson")
    }
}
