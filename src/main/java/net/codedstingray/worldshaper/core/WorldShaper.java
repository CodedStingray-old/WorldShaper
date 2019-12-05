package net.codedstingray.worldshaper.core;

import net.codedstingray.worldshaper.core.area.Area;
import net.codedstingray.worldshaper.core.area.CuboidArea;
import net.codedstingray.worldshaper.core.util.logging.Logger;
import net.codedstingray.worldshaper.core.world.block.BlockTraits;
import net.codedstingray.worldshaper.core.world.block.BlockTypes;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WorldShaper {

    private PluginIntegration pluginIntegration;
    private Logger logger;

    private Map<UUID, Area> playerMappedAreas = new HashMap<>();

    private WorldShaper() {}

    public void setPluginIntegration(PluginIntegration pluginIntegration) {
        this.pluginIntegration = pluginIntegration;
    }

    public void init() {
        if(pluginIntegration == null) {
            throw new IllegalStateException("Unable to initialize; no PluginIntegration provided");
        }
        if(logger == null) {
            throw new IllegalStateException("Unable to initialize; no Logger provided");
        }

        BlockTypes.init();
        BlockTraits.init();

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

    //logger
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public Logger getLogger() {
        return logger;
    }

    //singleton
    private static WorldShaper instance = new WorldShaper();

    public static WorldShaper getInstance() {
        return instance;
    }
}
