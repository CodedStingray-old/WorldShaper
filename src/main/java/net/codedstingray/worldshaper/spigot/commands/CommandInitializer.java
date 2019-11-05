package net.codedstingray.worldshaper.spigot.commands;

import net.codedstingray.worldshaper.spigot.WorldShaperSpigot;
import net.codedstingray.worldshaper.spigot.commands.utility.CmdWand;

public class CommandInitializer {

    public void init(WorldShaperSpigot plugin) {
        CmdWand cmdWand = new CmdWand();
        plugin.getCommand("wands").setExecutor(cmdWand);
        plugin.getCommand("wand").setExecutor(cmdWand);
    }
}
