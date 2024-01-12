package dev.kebsio.kit.config;

import cc.dreamcode.platform.bukkit.component.configuration.Configuration;
import cc.dreamcode.platform.persistence.StorageConfig;
import cc.dreamcode.utilities.bukkit.builder.ItemBuilder;
import dev.kebsio.kit.kit.Kit;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.*;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration(
        child = "config.yml"
)
@Header("## Dream-Template (Main-Config) ##")
@Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
public class PluginConfig extends OkaeriConfig {
    @Comment("Debug pokazuje dodatkowe informacje do konsoli. Lepiej wylaczyc. :P")
    public boolean debug = true;

    @Comment("Uzupelnij dane do logowania bazy danych.")
    public StorageConfig storageConfig = new StorageConfig("dreamtemplate");

    public List<Kit> kits = Arrays.asList(
            Kit.builder()
                    .name("gracz")
                    .delay(TimeUnit.MINUTES.toMillis(1))
                    .items(Arrays.asList(
                            ItemBuilder.of(Material.COOKED_PORKCHOP).toItemStack()
                    ))
                    .icon(ItemBuilder.of(Material.CHAINMAIL_HELMET)
                            .setName("&8&k|&b&l&kO&8&k|&r &b&lStartowy Ekwipunek &8&k|&b&l&kO&8&k|&r")
                            .toItemStack())
                    .permission("")
                    .build()

    );

}
