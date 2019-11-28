package net.codedstingray.worldshaper.core.world.block;

import java.util.*;

public class BlockState {

    /**
     * The data type, mostly used for Spigot conversion
     */
    private String dataType;

    /**
     * The block type
     */
    private BlockType blockType;

    private Collection<BlockTrait<?>> applicableTraits;

    /**
     * All mapped traits with their current values
     */
    private Map<BlockTrait<?>, Object> blockTraitMap = new HashMap<>();

    public BlockState(String dataType, BlockType blockType) {
        this.dataType = dataType;
        this.blockType = blockType;
    }

    public String getDataType() {
        return dataType;
    }

    public BlockType getBlockType() {
        return blockType;
    }

    public Collection<BlockTrait<?>> getApplicableTraits() {
        return applicableTraits;
    }

    @SuppressWarnings("unchecked")
    public <T> T getTraitValue(BlockTrait<T> trait) {
        return (T) blockTraitMap.get(trait);
    }

    public <T> BlockState withTrait(BlockTrait<T> trait, T value) {
        blockTraitMap.put(trait, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(blockType);

        if(!blockTraitMap.isEmpty()) {
            sb.append('[');
            boolean first = true;
            for(Map.Entry<BlockTrait<?>, ?> entry: blockTraitMap.entrySet()) {
                if(first)
                    first = false;
                else
                    sb.append(',');
                sb.append(entry.getKey()).append('=').append(entry.getValue());
            }
            sb.append(']');
        }

        return sb.toString();
    }
}
