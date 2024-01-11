package dev.kebsio.kit.user;

import dev.kebsio.kit.user.controller.UserController;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class UserCache {

    private final Map<UUID, User> userMap = new ConcurrentHashMap<>();

    public void add(User user) {
        this.userMap.put(user.getUniqueId(), user);
    }

    public void remove(User user) {
        this.userMap.remove(user.getUniqueId());
    }

    public User findByUUID(UUID uuid) {
        return this.userMap.get(uuid);
    }
    public Collection<User> values(){
        return this.userMap.values();
    }
}
