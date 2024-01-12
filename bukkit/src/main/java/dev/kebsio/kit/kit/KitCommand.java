package dev.kebsio.kit.kit;

import cc.dreamcode.command.annotations.RequiredPlayer;
import cc.dreamcode.command.bukkit.BukkitCommand;
import eu.okaeri.injector.annotation.Inject;
import lombok.NonNull;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@RequiredPlayer
public class KitCommand extends BukkitCommand {

    private final KitMenu kitMenu;

    @Inject
    public KitCommand(KitMenu kitMenu) {
        super("kit", "zestaw");
        this.kitMenu = kitMenu;
    }

    @Override
    public void content(@NonNull CommandSender commandSender, @NotNull @NonNull String[] strings) {
        this.kitMenu.open((Player) commandSender);
    }

    @Override
    public List<String> tab(@NonNull CommandSender commandSender, @NotNull @NonNull String[] strings) {
        return null;
    }
}
