package net.codedstingray.worldshaper.spigot.util;

import net.codedstingray.worldshaper.core.util.vector.Vector3;
import net.codedstingray.worldshaper.core.util.vector.Vector3I;
import net.codedstingray.worldshaper.core.util.vector.Vector3M;
import org.bukkit.util.Vector;

public class VectorUtilSpigot {
    public static Vector3M toMutableVector(Vector bukkitVector) {
        return new Vector3M(bukkitVector.getX(), bukkitVector.getY(), bukkitVector.getZ());
    }

    public static Vector3I toImmutableVector(Vector bukkitVector) {
        return new Vector3I(bukkitVector.getX(), bukkitVector.getY(), bukkitVector.getZ());
    }

    public static Vector toBukkitVector(Vector3 wsVector) {
        return new Vector(wsVector.getX(), wsVector.getY(), wsVector.getZ());
    }
}
