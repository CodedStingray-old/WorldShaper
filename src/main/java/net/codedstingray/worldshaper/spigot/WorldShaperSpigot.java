package net.codedstingray.worldshaper.spigot;

import net.codedstingray.worldshaper.core.WorldShaper;
import net.codedstingray.worldshaper.core.world.block.BlockTypes;
import net.codedstingray.worldshaper.spigot.event.listeners.AreaWandListener;
import net.codedstingray.worldshaper.spigot.util.logging.SpigotLogger;
import org.bukkit.plugin.java.JavaPlugin;

public final class WorldShaperSpigot extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("WorldShaper started");

        instance = this;

        WorldShaper.getInstance().setLogger(new SpigotLogger());
        SpigotIntegration integration = new SpigotIntegration(this);
        WorldShaper.getInstance().setPluginIntegration(integration);
        WorldShaper.getInstance().init();

        BlockTypes.init();

        getServer().getPluginManager().registerEvents(new AreaWandListener(), this);
    }

    @Override
    public void onDisable() {

    }


    private static WorldShaperSpigot instance;

    public static WorldShaperSpigot getInstance() {
        return instance;
    }
}
