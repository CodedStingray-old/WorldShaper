package net.codedstingray.worldshaper.core.function;

public class PatternParseException extends IllegalArgumentException {

    public PatternParseException() {
        super();
    }

    public PatternParseException(String message) {
        super(message);
    }

    public PatternParseException(Throwable cause) {
        super(cause);
    }

    public PatternParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
