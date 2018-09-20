package org.marthinwurer.germination;

import org.bukkit.plugin.java.JavaPlugin;

public final class Germination extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("onEnable has been invoked!");

        getLogger().info("Registering Listener!");
        getServer().getPluginManager().registerEvents(new SaplingDespawnListener(), this);
        getLogger().info("Listener registered!!");
    }

    @Override
    public void onDisable() {
        getLogger().info("onDisable has been invoked!");
    }

}
