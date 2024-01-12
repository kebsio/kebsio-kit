package dev.kebsio.kit.kit;

import eu.okaeri.configs.OkaeriConfig;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Kit  extends OkaeriConfig {
    private ItemStack icon;
    private String name;
    private List<ItemStack> items;
    private String permission;
    private long delay;
}

