package net.codedstingray.worldshaper.core;

import net.codedstingray.worldshaper.core.area.Area;
import net.codedstingray.worldshaper.core.area.CuboidArea;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WorldShaper {

    private PluginIntegration pluginIntegration;

    private Map<UUID, Area> playerMappedAreas = new HashMap<>();

    private WorldShaper() {}

    public void setPluginIntegration(PluginIntegration pluginIntegration) {
        this.pluginIntegration = pluginIntegration;
    }

    public void init() {
        pluginIntegration.initCommands();
    }

    //areas
    public Area getAreaForPlayer(UUID player) {
        Area ret = playerMappedAreas.get(player);
        if(ret == null) {
            playerMappedAreas.put(player, ret = new CuboidArea()); //TODO: change depending on selection type
        }

        return ret;
    }

    //singleton
    private static WorldShaper instance = new WorldShaper();

    public static WorldShaper getInstance() {
        return instance;
    }
}
