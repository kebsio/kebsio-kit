package dev.kebsio.kit.user.controller;

import dev.kebsio.kit.KitsPlugin;
import dev.kebsio.kit.user.User;
import dev.kebsio.kit.user.UserCache;
import dev.kebsio.kit.user.UserRepository;
import eu.okaeri.injector.annotation.Inject;
import eu.okaeri.tasker.core.Tasker;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

@RequiredArgsConstructor(onConstructor_= @Inject)
public class UserController implements Listener {

    private final KitsPlugin kitsPlugin;
    private final UserRepository userRepository;
    private final Tasker tasker;
    private final UserCache userCache;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        this.tasker.newChain()
                .async(() -> {
                    User user=this.userRepository.findOrCreateByHumanEntity(player);
                    user.setName(player.getName());
                    return user;
                })
                .acceptAsync(user -> {
                    user.save();
                    this.userCache.add(user);
                })
                .execute();

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        this.tasker.newChain()
                .async(() -> this.userCache.findByUUID(player.getUniqueId()))
                .acceptAsync(user -> {
                    user.save();
                    this.userCache.remove(user);
                })
                .execute();
   }
}
