package net.codedstingray.worldshaper.core.world.block;

import net.codedstingray.worldshaper.core.world.block.exception.BlockStateParseException;

import java.util.*;

public class BlockState {

    /**
     * The block type
     */
    private BlockType blockType;

    /**
     * All mapped traits with their current values
     */
    private Map<BlockTrait<?>, Object> blockTraitMap = new HashMap<>();

    public BlockState(BlockType blockType) {
        this.blockType = blockType;
    }

    public BlockType getBlockType() {
        return blockType;
    }

    public Collection<BlockTrait<?>> getApplicableTraits() {
        return blockType.getApplicableTraits();
    }

    @SuppressWarnings("unchecked")
    public <T> T getTraitValue(BlockTrait<T> trait) {
        return (T) blockTraitMap.get(trait);
    }

    public <T> BlockState withTrait(BlockTrait<?> trait, T value) {
        if(trait.getType() != value.getClass())
            throw new IllegalArgumentException("Trait type and value class have to be identical");
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

    public static BlockState parseBlockState(String input) {
        if(input == null || input.equals("")) {
            throw new BlockStateParseException("Empty string or null string");
        }

        if(input.contains("[")) {
            //block type and block traits given
            String[] splitInput = input.split("\\[");
            if(splitInput.length > 2) {
                throw new BlockStateParseException("Unexpected \"[\" at index " + (splitInput[0].length() + splitInput[1].length() - 1));
            }

            //getting the block type and state
            String typeString = splitInput[0];
            BlockType type = getBlockType(typeString);

            BlockState state = new BlockState(type);

            //getting block traits
            String traitList = splitInput[1].trim();
            if(traitList.endsWith("]")) {
                //remove the trailing "]" if present; the parser also accepts strings without it
                traitList = traitList.substring(0, traitList.length() - 1);
            }

            String[] traits = traitList.split(",");
            for(String pair: traits) {
                String[] splitPair = pair.split("=");
                if(splitPair.length != 2) {
                    throw new BlockStateParseException("Invalid block trait entry: \"" + pair + "\"; must be of format 'trait=value'");
                }

                String key = splitPair[0];
                String value = splitPair[1];

                BlockTrait<?> trait = type.getTrait(key);
                if(trait == null) {
                    throw new BlockStateParseException("BlockTrait \"" + key + "\" does not exist or is not applicable to block type \"" + type + "\"");
                }

                Map.Entry<BlockTrait<?>, ?> entry = BlockTrait.parseTraitValuePair(trait, value);

                state.withTrait(trait, entry.getValue());
            }

            return state;
        } else {
            //only the block type given
            BlockType type = getBlockType(input);
            return new BlockState(type);
        }
    }

    private static BlockType getBlockType(String input) {
        BlockType type = BlockType.getByID(input.trim());
        if(type == null)
            throw new BlockStateParseException("Unable to parse BlockType: \"" + input + "\"");
        return type;
    }
}
