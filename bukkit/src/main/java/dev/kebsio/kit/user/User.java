package dev.kebsio.kit.user;

import eu.okaeri.configs.annotation.NameModifier;
import eu.okaeri.configs.annotation.NameStrategy;
import eu.okaeri.configs.annotation.Names;
import eu.okaeri.persistence.document.Document;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
public class User extends Document {

    private String name;
    private Map<String, Long> kitCooldowns;

    public UUID getUniqueId() {
        return this.getPath().toUUID();
    }

    public long getCooldownTime(String name) {
        return this.kitCooldowns.getOrDefault(name.toLowerCase(), 0L);
    }

    public void addCooldownTime(String name, long time){
        this.kitCooldowns.put(name.toLowerCase(), System.currentTimeMillis()+time);

    }
}
