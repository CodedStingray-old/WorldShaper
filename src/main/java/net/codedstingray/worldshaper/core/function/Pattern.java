package net.codedstingray.worldshaper.core.function;

import net.codedstingray.worldshaper.core.world.block.BlockType;

public class Pattern {

    private BlockType blockType;

    public Pattern(BlockType blockType) {
        this.blockType = blockType;
    }

    //TODO replace with apply function
    public BlockType getBlockType() {
        return blockType;
    }

    public static Pattern parse(String input) {
        BlockType blockType = BlockType.getByID(input);
        if(blockType == null)
            throw new PatternParseException("Unable to parse material \"" + input + "\"");
        return new Pattern(blockType);
    }
}
