package net.codedstingray.worldshaper.core.util.vector;

public class Vector3I implements Vector3 {
    protected final double x;
    protected final double y;
    protected final double z;

    public Vector3I() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Vector3I(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3I(Vector3 other) {
        this.x = other.getX();
        this.y = other.getY();
        this.z = other.getZ();
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getZ() {
        return z;
    }

    @Override
    public int getBlockX() {
        return (int) Math.floor(x);
    }

    @Override
    public int getBlockY() {
        return (int) Math.floor(y);
    }

    @Override
    public int getBlockZ() {
        return (int) Math.floor(z);
    }

    @Override
    public Vector3M toMutable() {
        return new Vector3M(this);
    }

    @Override
    public Vector3I toImmutable() {
        return this;
    }

    @Override
    public Vector3 add(Vector3 other) {
        return new Vector3M(this).add(other);
    }

    @Override
    public Vector3 subtract(Vector3 other) {
        return new Vector3M(this).add(other);
    }

    @Override
    public Vector3 scale(Vector3 other) {
        return new Vector3M(this).scale(other);
    }

    @Override
    public Vector3 scaleInv(Vector3 other) {
        return new Vector3M(this).scaleInv(other);
    }

    @Override
    public Vector3 negate() {
        return new Vector3M(this).negate();
    }

    @Override
    public Vector3 invert() {
        return new Vector3M(this).invert();
    }

    @Override
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public double lengthSquared() {
        return x * x + y * y + z * z;
    }

    @Override
    public double distance(Vector3 other) {
        double dx = other.getX() - x;
        double dy = other.getY() - y;
        double dz = other.getZ() - z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public double distanceSquared(Vector3 other) {
        double dx = other.getX() - x;
        double dy = other.getY() - y;
        double dz = other.getZ() - z;
        return dx * dx + dy * dy + dz * dz;
    }

    @Override
    public Vector3 setX(double x) {
        return new Vector3M(this).setX(x);
    }

    @Override
    public Vector3 setY(double y) {
        return new Vector3M(this).setY(y);
    }

    @Override
    public Vector3 setZ(double z) {
        return new Vector3M(this).setZ(z);
    }
}
