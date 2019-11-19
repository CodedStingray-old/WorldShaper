package net.codedstingray.worldshaper.spigot.commands;

import net.codedstingray.worldshaper.spigot.WorldShaperSpigot;
import net.codedstingray.worldshaper.spigot.commands.area.CmdPos;
import net.codedstingray.worldshaper.spigot.commands.area.operations.CmdSet;
import net.codedstingray.worldshaper.spigot.commands.utility.CmdWand;

public class CommandInitializer {

    public void init(WorldShaperSpigot plugin) {
        CmdWand cmdWand = new CmdWand();
        plugin.getCommand("wands").setExecutor(cmdWand);
        plugin.getCommand("wand").setExecutor(cmdWand);

        CmdPos cmdPos = new CmdPos();
        plugin.getCommand("pos").setExecutor(cmdPos);

        CmdSet cmdSet = new CmdSet();
        plugin.getCommand("set").setExecutor(cmdSet);
    }
}
