package net.codedstingray.worldshaper.spigot.commands.area;

import net.codedstingray.worldshaper.core.WorldShaper;
import net.codedstingray.worldshaper.core.area.Area;
import net.codedstingray.worldshaper.core.util.chat.TextColor;
import net.codedstingray.worldshaper.core.util.vector.Vector3;
import net.codedstingray.worldshaper.core.util.vector.VectorUtil;
import net.codedstingray.worldshaper.spigot.util.VectorUtilSpigot;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class CmdPos implements CommandExecutor {

    private static final String MSG_INVALID_INDEX = TextColor.RED + "The index must be a number greater than 0";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(TextColor.RED + "This command can only be used by players");
            return true;
        }

        if(args.length != 1) {
            sender.sendMessage(TextColor.RED + "Invalid number of arguments. Command use:");
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

        Vector3 position = VectorUtilSpigot.toImmutableVector(player.getLocation().toVector());
        UUID world = player.getWorld().getUID();

        Area playerArea = WorldShaper.getInstance().getAreaForPlayer(player.getUniqueId());

        playerArea.setPosition(index, position, world);

        player.sendMessage(TextColor.WHITE + "Position " + TextColor.AQUA + (index + 1)
                + TextColor.WHITE + " set to " + TextColor.AQUA + VectorUtil.vectorBlockToString(position));

        return true;
    }
}
