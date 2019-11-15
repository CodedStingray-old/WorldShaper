package net.codedstingray.worldshaper.core.util.vector;

public class Vector3M implements Vector3 {

    protected double x;
    protected double y;
    protected double z;

    public Vector3M() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Vector3M(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3M(Vector3 other) {
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
        return this;
    }

    @Override
    public Vector3I toImmutable() {
        return new Vector3I(this);
    }

    @Override
    public Vector3 add(Vector3 other) {
        x += other.getX();
        y += other.getY();
        z += other.getZ();
        return this;
    }

    @Override
    public Vector3 subtract(Vector3 other) {
        x -= other.getX();
        y -= other.getY();
        z -= other.getZ();
        return this;
    }

    @Override
    public Vector3 scale(Vector3 other) {
        x *= other.getX();
        y *= other.getY();
        z *= other.getZ();
        return this;
    }

    @Override
    public Vector3 scaleInv(Vector3 other) {
        x /= other.getX();
        y /= other.getY();
        z /= other.getZ();
        return this;
    }

    @Override
    public Vector3 negate() {
        x = -x;
        y = -y;
        z = -z;
        return this;
    }

    @Override
    public Vector3 invert() {
        x = 1 / x;
        y = 1 / y;
        z = 1 / z;
        return this;
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
        this.x = x;
        return this;
    }

    @Override
    public Vector3 setY(double y) {
        this.y = y;
        return this;
    }

    @Override
    public Vector3 setZ(double z) {
        this.z = z;
        return this;
    }
}
