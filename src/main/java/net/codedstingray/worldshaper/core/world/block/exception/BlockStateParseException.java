package net.codedstingray.worldshaper.core.world.block.exception;

public class BlockStateParseException extends IllegalArgumentException {
    public BlockStateParseException() {
        super();
    }

    public BlockStateParseException(String message) {
        super(message);
    }

    public BlockStateParseException(Throwable cause) {
        super(cause);
    }

    public BlockStateParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
