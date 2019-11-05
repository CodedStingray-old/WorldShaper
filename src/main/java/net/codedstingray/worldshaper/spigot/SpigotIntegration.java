package net.codedstingray.worldshaper.spigot;

import net.codedstingray.worldshaper.core.PluginIntegration;
import net.codedstingray.worldshaper.spigot.commands.CommandInitializer;

public class SpigotIntegration implements PluginIntegration {

    private WorldShaperSpigot spigotPlugin;

    public SpigotIntegration(WorldShaperSpigot spigotPlugin) {
        this.spigotPlugin = spigotPlugin;
    }

    @Override
    public void initCommands() {
        //TODO: clean this up
        spigotPlugin.getLogger().info("Initializing commands...");
        new CommandInitializer().init(spigotPlugin);
        spigotPlugin.getLogger().info("Command initialization complete");
    }
}
