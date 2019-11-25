package net.codedstingray.worldshaper.core.util.logging;

public interface Logger {

    void debug(String message);

    default void debug(Object object) {
        debug(object.toString());
    }


    void info(String message);

    default void info(Object object) {
        info(object.toString());
    }


    void warn(String message);

    default void warn(Object object) {
        warn(object.toString());
    }


    void error(String message);

    default void error(Object object) {
        error(object.toString());
    }
}
