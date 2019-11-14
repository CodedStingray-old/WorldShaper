package net.codedstingray.worldshaper.core.area;

import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.UUID;

public class Area {

    private ArrayList<Vector> positions = new ArrayList<>();

    private UUID worldUUID = null;

    public void setPosition(int index, Vector position, UUID world) {
        //if the new position is in a different world than the area,
        //remove all positions and set the world's area tot he new world
        if(!world.equals(worldUUID)) {
            worldUUID = world;
            positions.clear();
        }

        if(index < positions.size()) {
            positions.set(index, position);
        } else {
            positions.ensureCapacity(index + 1);
            for(int i = positions.size(); i < index; i++) {
                positions.add(null);
            }
            positions.add(position);
        }
    }

    public Vector getPosition(int index) {
        return positions.get(index);
    }

    public UUID getWorldUUID() {
        return worldUUID;
    }

    public boolean isValid() {
        return false; //TODO
    }
}
