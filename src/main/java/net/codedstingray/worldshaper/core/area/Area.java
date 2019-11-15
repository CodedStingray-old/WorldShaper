package net.codedstingray.worldshaper.core.area;

import net.codedstingray.worldshaper.core.util.vector.Vector3;

import java.util.UUID;

public abstract class Area implements Iterable<Vector3> {

    protected UUID worldUUID = null;

    public UUID getWorldUUID() {
        return worldUUID;
    }


    public abstract void setPosition(int index, Vector3 position, UUID world);
    public abstract Vector3 getPosition(int index);

    public abstract boolean isValid();

    public abstract Vector3 getMinPos();
    public abstract Vector3 getMaxPos();

    public abstract int getSize();
}
