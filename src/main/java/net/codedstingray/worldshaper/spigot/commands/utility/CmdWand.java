package net.codedstingray.worldshaper.spigot.commands.utility;

import net.codedstingray.worldshaper.core.util.chat.TextColor;
import net.codedstingray.worldshaper.core.wand.WandData;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class CmdWand implements CommandExecutor {

    public static final ItemStack wandArea;
    public static final ItemStack wandBrush;

    static {
        wandArea = new ItemStack(Material.IRON_AXE);
        ItemMeta wandAreaMeta = wandArea.getItemMeta();
        wandAreaMeta.setDisplayName(WandData.areaWandName);
        LinkedList<String> loreArea = new LinkedList<>();
        loreArea.add(WandData.areaWandLore);
        wandAreaMeta.setLore(loreArea);
        wandArea.setItemMeta(wandAreaMeta);

        wandBrush = new ItemStack(Material.IRON_SHOVEL);
        ItemMeta wandBrushMeta = wandBrush.getItemMeta();
        wandBrushMeta.setDisplayName(WandData.brushWandName);
        LinkedList<String> loreBrush = new LinkedList<>();
//        loreBrush.add(WandData.brushWandLore);
        loreBrush.add(TextColor.DARK_RED + "[NYI] " + TextColor.RED + "Brushes are not yet implemented");
        wandBrushMeta.setLore(loreBrush);
        wandBrush.setItemMeta(wandBrushMeta);
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(TextColor.RED + "This commands can only be used by a player");
            return false;
        }
        Player player = (Player) sender;

        switch (label) {
            case "wands":
                giveWands(player, Wand.values());
                return true;
            case "wand":
                if(args.length == 0) {
                    player.sendMessage(TextColor.RED + "Provide the names of the wands you'd like to request, or use " +
                            TextColor.WHITE + "/wands" + TextColor.RED + " to get all wands");
                    return false;
                }
                giveWands(player, Wand.fromString(args));
                return true;
        }

        return false;
    }

    private void giveWands(Player player, Wand... wands) {
        player.getInventory().addItem(Arrays.stream(wands).map(Wand::getWandItem).toArray(ItemStack[]::new));
    }



    private enum Wand {
        AREA_WAND(wandArea, "area"),
        BRUSH_WAND(wandBrush, "brush");

        private ItemStack wandItem;
        private String alias;

        Wand(ItemStack wandItem, String alias) {
            this.wandItem = wandItem;
            this.alias = alias;
        }

        public ItemStack getWandItem() {
            return wandItem;
        }


        public static Wand fromString(String input) {
            for(Wand wand: Wand.values()) {
                if(wand.alias.equals(input)) {
                    return wand;
                }
            }
            return null;
        }

        public static Wand[] fromString(String... input) {
            Set<Wand> wands = new HashSet<>();
            for(Wand wand: Wand.values()) {
                for(String in: input) {
                    if (wand.alias.equals(in)) {
                        wands.add(wand);
                    }
                }
            }
            return wands.toArray(new Wand[0]);
        }
    }
}
