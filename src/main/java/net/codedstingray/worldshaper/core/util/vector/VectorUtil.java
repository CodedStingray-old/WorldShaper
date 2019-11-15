package net.codedstingray.worldshaper.core.util.vector;

public class VectorUtil {

    public static final Vector3 BASE_X = new Vector3I(1, 0, 0);
    public static final Vector3 BASE_Y = new Vector3I(0, 1, 0);
    public static final Vector3 BASE_Z = new Vector3I(0, 0, 1);

    public static String vectorBlockToString(Vector3 vector) {
        return "[" + vector.getBlockX() + " | " + vector.getBlockY() + " | " + vector.getBlockZ() + "]";
    }

    /**
     * Returns a new mutable Vector with the minimum coordinate values of the 2 input Vectors.
     * Useful in combination with {@link #max(Vector3, Vector3)} for calculations of AABBs.
     * If one of the inputs is null, a copy of the other vector is returned.
     * @param v1 The first Vector
     * @param v2 The second Vector
     * @return A new vector with the minimum coordinate values for x, y and z
     * @throws NullPointerException If both inputs are null
     */
    public static Vector3 min(Vector3 v1, Vector3 v2) {
        if(v1 == null && v2 == null) throw new NullPointerException("At least one input vector needs to be not null");
        if(v1 == null) return new Vector3M(v2);
        if(v2 == null) return new Vector3M(v1);

        return new Vector3M(
                Math.min(v1.getX(), v2.getX()),
                Math.min(v1.getY(), v2.getY()),
                Math.min(v1.getZ(), v2.getZ())
        );
    }

    /**
     * Returns a new mutable Vector with the maximum coordinate values of the 2 input Vectors.
     * Useful in combination with {@link #min(Vector3, Vector3)} for calculations of AABBs.
     * If one of the inputs is null, a copy of the other vector is returned.
     * @param v1 The first Vector
     * @param v2 The second Vector
     * @return A new vector with the maximum coordinate values for x, y and z
     * @throws NullPointerException If both inputs are null
     */
    public static Vector3 max(Vector3 v1, Vector3 v2) {
        if(v1 == null && v2 == null) throw new NullPointerException("At least one input vector needs to be not null");
        if(v1 == null) return new Vector3M(v2);
        if(v2 == null) return new Vector3M(v1);

        return new Vector3M(
                Math.max(v1.getX(), v2.getX()),
                Math.max(v1.getY(), v2.getY()),
                Math.max(v1.getZ(), v2.getZ())
        );
    }
}
