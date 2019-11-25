package net.codedstingray.worldshaper.spigot.util.logging;

import net.codedstingray.worldshaper.core.util.logging.Logger;
import net.codedstingray.worldshaper.spigot.WorldShaperSpigot;

public class SpigotLogger implements Logger {

    private java.util.logging.Logger internalLogger = WorldShaperSpigot.getInstance().getLogger();

    @Override
    public void debug(String message) {
        internalLogger.fine(message);
    }

    @Override
    public void info(String message) {
        internalLogger.info(message);
    }

    @Override
    public void warn(String message) {
        internalLogger.warning(message);
    }

    @Override
    public void error(String message) {
        internalLogger.severe(message);
    }
}
