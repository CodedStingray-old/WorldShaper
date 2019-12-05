package net.codedstingray.worldshaper.core.world.block;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BlockType {

    public static final String NAMESPACE_MINECRAFT = "minecraft";

    static Map<String, BlockType> BY_NAMESPACED_ID = new HashMap<>();

    public final String namespace;
    public final String id;
    public final String namespacedID;

    /**
     * Maps BlockTrait keys to BlockTraits
     */
    private Map<String, BlockTrait<?>> applicableTraits = new HashMap<>();

    private  BlockType(String id, BlockTrait... applicableTraits) {
        this(NAMESPACE_MINECRAFT, id, applicableTraits);
    }

    private BlockType(String namespace, String id, BlockTrait<?>... applicableTraits) {
        this.namespace = namespace;
        this.id = id;

        namespacedID = namespace + ":" + id;

        for(BlockTrait<?> trait: applicableTraits) {
            this.applicableTraits.put(trait.getKey(), trait);
        }
    }

    @Override
    public String toString() {
        return namespacedID;
    }

    public Collection<BlockTrait<?>> getApplicableTraits() {
        return applicableTraits.values();
    }

    public BlockTrait<?> getTrait(String key) {
        return applicableTraits.get(key);
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
        if(id.contains(":")) {
            String[] split = id.split(":");
            return register(split[0], split[1]);
        }

        return register(NAMESPACE_MINECRAFT, id);
    }

    public static BlockType register(String namespace, String id) {
        BlockType blockType = new BlockType(namespace, id);
        BY_NAMESPACED_ID.putIfAbsent(blockType.namespacedID, blockType);
        return blockType;
    }
}
