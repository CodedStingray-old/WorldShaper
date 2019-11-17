package net.codedstingray.worldshaper.spigot.event.listeners;

import net.codedstingray.worldshaper.core.WorldShaper;
import net.codedstingray.worldshaper.core.area.Area;
import net.codedstingray.worldshaper.core.util.chat.TextColor;
import net.codedstingray.worldshaper.core.util.vector.Vector3;
import net.codedstingray.worldshaper.core.util.vector.VectorUtil;
import net.codedstingray.worldshaper.core.wand.WandData;
import net.codedstingray.worldshaper.spigot.util.VectorUtilSpigot;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

public class AreaWandListener implements Listener {

    @EventHandler
    public void onWandUsed(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        Action action = event.getAction();
        Player player = event.getPlayer();
        Block clickedBlock = event.getClickedBlock();

        if(item == null || clickedBlock == null)
            return;

        int index;
        switch(action) {
            case LEFT_CLICK_BLOCK:
                index = 0;
                break;
            case RIGHT_CLICK_BLOCK:
                index = 1;
                break;
            default: return;
        }

        if(Material.IRON_AXE.equals(item.getType())) {
            ItemMeta itemMeta = item.getItemMeta();
            String itemName = itemMeta.getDisplayName();

            if(WandData.areaWandName.equals(itemName)) {
                Area playerArea = WorldShaper.getInstance().getAreaForPlayer(player.getUniqueId());
                if(playerArea == null)
                    playerArea = WorldShaper.getInstance().createAreaForPlayer(player.getUniqueId());

                Vector3 position = VectorUtilSpigot.toImmutableVector(clickedBlock.getLocation().toVector());
                UUID world = player.getWorld().getUID();

                playerArea.setPosition(index, position, world);
                player.sendMessage(TextColor.WHITE + "Position " + TextColor.AQUA + (index + 1)
                        + TextColor.WHITE + " set to " + TextColor.AQUA + VectorUtil.vectorBlockToString(position));

                event.setCancelled(true);
            }
        }
    }
}
