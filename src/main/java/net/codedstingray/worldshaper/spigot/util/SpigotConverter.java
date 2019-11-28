package net.codedstingray.worldshaper.spigot.util;

import net.codedstingray.worldshaper.core.world.block.BlockState;
import net.codedstingray.worldshaper.core.world.block.BlockType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;

public class SpigotConverter {

    public static Material asMaterial(BlockType blockType) {
        return Material.matchMaterial(blockType.namespacedID);
    }

    public static BlockType asBlockType(Material mat) {
        return BlockType.getByID(mat.getKey().getKey());
    }

    public static BlockData asBlockData(BlockState blockState) {
        return Bukkit.createBlockData(blockState.toString());
    }

    public static BlockState asBlockState(BlockData blockData) {
        //TODO once BlockState parsing is implemented
        return null;
    }
}
