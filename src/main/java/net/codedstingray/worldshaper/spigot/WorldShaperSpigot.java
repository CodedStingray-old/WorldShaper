package net.codedstingray.worldshaper.spigot;

import net.codedstingray.worldshaper.core.WorldShaper;
import net.codedstingray.worldshaper.spigot.event.listeners.AreaWandListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class WorldShaperSpigot extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("WorldShaper started");

        SpigotIntegration integration = new SpigotIntegration(this);
        WorldShaper.getInstance().setPluginIntegration(integration);
        WorldShaper.getInstance().init();

        getServer().getPluginManager().registerEvents(new AreaWandListener(), this);
    }

    @Override
    public void onDisable() {

    }
}
