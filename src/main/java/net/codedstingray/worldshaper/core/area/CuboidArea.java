package net.codedstingray.worldshaper.core.area;

import net.codedstingray.worldshaper.core.util.vector.Vector3;
import net.codedstingray.worldshaper.core.util.vector.Vector3I;
import net.codedstingray.worldshaper.core.util.vector.Vector3M;
import net.codedstingray.worldshaper.core.util.vector.VectorUtil;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.UUID;

public class CuboidArea extends Area {

    private Vector3 pos1 = null; //corresponds to index 0
    private Vector3 pos2 = null; //corresponds to index 1

    private Vector3 minPos = null;
    private Vector3 maxPos = null;

    @Override
    public void setPosition(int index, Vector3 position, UUID world) {
        if(index < 0 || index > 1)
            throw new IndexOutOfBoundsException();

        //if the new position is in a different world than the area,
        //remove all positions and set the world's area to the new world
        if(!world.equals(worldUUID)) {
            worldUUID = world;
            pos1 = null;
            pos2 = null;
        }

        //we already know index can only be 0 or 1
        if(index == 0)
            pos1 = position;
        else
            pos2 = position;

        calculateMinMaxPos();
    }

    @Override
    public Vector3 getPosition(int index) {
        switch (index) {
            case 0: return pos1;
            case 1: return pos2;
            default: throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean isValid() {
        return pos1 != null && pos2 != null && worldUUID != null;
    }

    @Override
    public Vector3 getMinPos() {
        return minPos;
    }

    @Override
    public Vector3 getMaxPos() {
        return maxPos;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public Iterator<Vector3> iterator() {
        return  new Iterator<Vector3>() {
            Vector3 min = getMinPos();
            Vector3 max = getMaxPos();

            Vector3 current = new Vector3M(min);

            @Override
            public boolean hasNext() {
                return current.getBlockY() <= max.getBlockY();
            }

            @Override
            public Vector3 next() {
                if(!hasNext()) throw new NoSuchElementException();
                Vector3 result = new Vector3I(current);

                //move pointer
                current.add(VectorUtil.BASE_X);
                if(current.getBlockX() > max.getBlockX()) {
                    current.setX(min.getBlockX());
                    current.add(VectorUtil.BASE_Z);
                    if(current.getBlockZ() > max.getBlockZ()) {
                        current.setZ(min.getBlockZ());
                        current.add(VectorUtil.BASE_Y);
                    }
                }

                return result;
            }
        };
    }

    private void calculateMinMaxPos() {
        minPos = VectorUtil.min(pos1, pos2);
        maxPos = VectorUtil.max(pos1, pos2);
    }
}
