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
        return playerMappedAreas.get(player);
    }

    /**
     * Maps an {@link Area} to the given player.<br>
     * Will not throw an error if provided with a null value.
     * @param player the player to create a new area for
     * @return the created area
     */
    public Area createAreaForPlayer(UUID player) {
        Area area = new CuboidArea(); //TODO change depending on selection type
        playerMappedAreas.putIfAbsent(player, area);
        return area;
    }

    //singleton
    private static WorldShaper instance = new WorldShaper();

    public static WorldShaper getInstance() {
        return instance;
    }
}
