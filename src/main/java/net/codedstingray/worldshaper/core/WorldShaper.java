package net.codedstingray.worldshaper.core;

public class WorldShaper {

    private PluginIntegration pluginIntegration;

    private WorldShaper() {}

    public void setPluginIntegration(PluginIntegration pluginIntegration) {
        this.pluginIntegration = pluginIntegration;
    }

    public void init() {
        pluginIntegration.initCommands();
    }

    //singleton
    private static WorldShaper instance = new WorldShaper();

    public static WorldShaper getInstance() {
        return instance;
    }
}
