package net.codedstingray.worldshaper.spigot.commands.area;

import net.codedstingray.worldshaper.core.WorldShaper;
import net.codedstingray.worldshaper.core.area.Area;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.UUID;

public class CmdPos implements CommandExecutor {

    private static final String MSG_INVALID_INDEX = ChatColor.RED + "The index must be a number greater than 0";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players");
            return true;
        }

        if(args.length != 1) {
            sender.sendMessage(ChatColor.RED + "Invalid number of arguments. Command use:");
            return false;
        }

        String indexString = args[0];
        int index;
        try {
            //subtracting one since position count starts at one, but needs to be converted to list indices
            index = Integer.parseInt(indexString) - 1;
        } catch (NumberFormatException e) {
            sender.sendMessage(MSG_INVALID_INDEX);
            return false;
        }

        if(index < 0) {
            sender.sendMessage(MSG_INVALID_INDEX);
            return false;
        }

        //TODO: we probably need to outsource this into a method once we implement setting positions via area wand
        Player player = (Player) sender;

        Area playerArea = WorldShaper.getInstance().getAreaForPlayer(player.getUniqueId());
        if(playerArea == null)
            playerArea = WorldShaper.getInstance().createAreaForPlayer(player.getUniqueId());

        Vector position = player.getLocation().toVector();
        UUID world = player.getWorld().getUID();

        playerArea.setPosition(index, position, world);

        player.sendMessage(ChatColor.WHITE + "Position " + ChatColor.AQUA + (index + 1)
                + ChatColor.WHITE + " set to " + ChatColor.AQUA + vectorBlockToString(position));

        player.sendMessage(ChatColor.DARK_RED + "[DEBUG]" + ChatColor.WHITE + " Actual position at index "
                + (index + 1) + ": " + vectorBlockToString(playerArea.getPosition(index)));

        return true;
    }

    private String vectorBlockToString(Vector vector) {
        return "[" + vector.getBlockX() + " | " + vector.getBlockY() + " | " + vector.getBlockZ() + "]";
    }
}
