package net.codedstingray.worldshaper.spigot.commands.edits.area;

import net.codedstingray.worldshaper.core.WorldShaper;
import net.codedstingray.worldshaper.core.area.Area;
import net.codedstingray.worldshaper.core.util.vector.Vector3;
import net.codedstingray.worldshaper.core.util.vector.VectorUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdSet implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players");
            return false;
        }

        //arg validation
        if(args.length == 0) {
            sender.sendMessage(ChatColor.RED + "You need to provide a pattern to set; Usage:");
            return false;
        }
        if(args.length > 1) {
            sender.sendMessage(ChatColor.RED + "Too many arguments; Usage:");
            return false;
        }

        Player player = (Player) sender;
        Area area = WorldShaper.getInstance().getAreaForPlayer(player.getUniqueId());

        //area validation
        if(area == null || !area.isValid()) {
            player.sendMessage(ChatColor.RED + "Set an area before using this command");
            return true;
        }
        if(!player.getWorld().getUID().equals(area.getWorldUUID())) {
            player.sendMessage(ChatColor.RED + "Area is in a different world. Switch to that world or create a new area in this world to use this command");
            return true;
        }

        World world = Bukkit.getWorld(area.getWorldUUID());

        //TODO: parse pattern
        Material mat = Material.matchMaterial(args[0]);
        if(mat == null) {
            player.sendMessage(ChatColor.RED + "Unknown material: " + args[0]);
            return false;
        }

        //TODO: outsource this
        for(Vector3 position: area) {
            Block block = world.getBlockAt(position.getBlockX(), position.getBlockY(), position.getBlockZ());
            block.setType(mat);
        }

        return true;
    }
}
