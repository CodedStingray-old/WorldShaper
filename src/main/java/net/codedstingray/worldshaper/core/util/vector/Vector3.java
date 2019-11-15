package net.codedstingray.worldshaper.core.util.vector;

public interface Vector3 {

    double getX();
    double getY();
    double getZ();

    int getBlockX();
    int getBlockY();
    int getBlockZ();

    Vector3M toMutable();
    Vector3I toImmutable();

    Vector3 add(Vector3 other);
    Vector3 subtract(Vector3 other);
    Vector3 scale(Vector3 other);
    Vector3 scaleInv(Vector3 other);

    Vector3 negate();
    Vector3 invert();

    double length();
    double lengthSquared();
    double distance(Vector3 other);
    double distanceSquared(Vector3 other);

    Vector3 setX(double x);
    Vector3 setY(double y);
    Vector3 setZ(double z);
}
