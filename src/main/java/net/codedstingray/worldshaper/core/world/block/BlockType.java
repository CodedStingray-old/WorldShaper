package net.codedstingray.worldshaper.core.world.block;

import java.util.HashMap;
import java.util.Map;

public class BlockType {

    public static final String NAMESPACE_MINECRAFT = "minecraft";

    private static Map<String, BlockType> BY_NAMESPACED_ID = new HashMap<>();

    public final String namespace;
    public final String id;
    public final String namespacedID;

    private  BlockType(String id) {
        this(NAMESPACE_MINECRAFT, id);
    }

    private BlockType(String namespace, String id) {
        this.namespace = namespace;
        this.id = id;

        namespacedID = namespace + ":" + id;
    }

    public static BlockType getByID(String namespacedID) {
        if(!namespacedID.contains(":"))
            namespacedID = NAMESPACE_MINECRAFT + ":" + namespacedID;

        return BY_NAMESPACED_ID.get(namespacedID);
    }

    public static void register(BlockType blockType) {
        BY_NAMESPACED_ID.putIfAbsent(blockType.namespacedID, blockType);
    }

    public static BlockType register(String id) {
        return register(NAMESPACE_MINECRAFT, id);
    }

    public static BlockType register(String namespace, String id) {
        BlockType blockType = new BlockType(namespace, id);
        BY_NAMESPACED_ID.putIfAbsent(blockType.namespacedID, blockType);
        return blockType;
    }
}
