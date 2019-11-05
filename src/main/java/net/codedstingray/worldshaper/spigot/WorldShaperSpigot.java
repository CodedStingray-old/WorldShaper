package net.codedstingray.worldshaper.spigot;

import net.codedstingray.worldshaper.core.WorldShaper;
import org.bukkit.plugin.java.JavaPlugin;

public final class WorldShaperSpigot extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("WorldShaper started");

        SpigotIntegration integration = new SpigotIntegration(this);
        WorldShaper.getInstance().setPluginIntegration(integration);
        WorldShaper.getInstance().init();
    }

    @Override
    public void onDisable() {

    }
}
