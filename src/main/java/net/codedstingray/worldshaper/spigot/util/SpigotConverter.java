package net.codedstingray.worldshaper.spigot.util;

import net.codedstingray.worldshaper.core.world.block.BlockType;
import org.bukkit.Material;

public class SpigotConverter {

    public static Material asMaterial(BlockType blockType) {
        return Material.matchMaterial(blockType.namespacedID);
    }

    public static BlockType asBlockType(Material mat) {
        return BlockType.getByID(mat.getKey().getKey());
    }
}
