package dev.kebsio.kit.kit;

import cc.dreamcode.menu.bukkit.base.BukkitMenu;
import cc.dreamcode.utilities.bukkit.ChatUtil;
import cc.dreamcode.utilities.bukkit.builder.ItemBuilder;
import dev.kebsio.kit.config.PluginConfig;
import dev.kebsio.kit.user.User;
import dev.kebsio.kit.user.UserCache;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor(onConstructor_=@Inject)
public class KitMenu {
    private final PluginConfig pluginConfig;
    private final UserCache userCache;
    public void open(Player player){
        BukkitMenu menu = new BukkitMenu("&#f607fbZ&#e50bfbe&#d30ffcs&#c213fct&#b116fca&#9f1afdw&#8e1efdy",1,0);
        User user = this.userCache.findByUUID(player.getUniqueId());
        for (Kit kit : this.pluginConfig.kits) {
            if (!kit.getPermission().isEmpty() && !player.hasPermission(kit.getPermission())){
                continue;
            }
            menu.addItem(ItemBuilder.of(kit.getIcon())
                            .fixColors()
                    .toItemStack(),event -> {
                if (user.getCooldownTime(kit.getName()) > System.currentTimeMillis()) {
                    player.sendMessage(ChatUtil.fixColor("&cPoczekaj"));
                    return;
                }
                user.addCooldownTime(kit.getName(), kit.getDelay());
                openKit(player, kit);
            });
        }
        menu.open(player);
    }
    public void openKit(Player player,Kit kit){
        BukkitMenu menu = new BukkitMenu(kit.getName(), 1,0);
        menu.setCancelInventoryClick(false);
        for (ItemStack item : kit.getItems()) {
            menu.addItem(item);
        }
        menu.open(player);

    }
}
