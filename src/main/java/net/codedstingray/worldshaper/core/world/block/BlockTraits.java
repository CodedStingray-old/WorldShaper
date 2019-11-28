package net.codedstingray.worldshaper.core.world.block;

public class BlockTraits {
    //<editor-fold desc="Boolean Traits" defaultstate="collapsed">
    //<editor-fold desc="Redstone" defaultstate="collapsed">
    public static final BlockTrait<Boolean> OPEN = BlockTrait.register("open", Boolean.class);
    public static final BlockTrait<Boolean> POWERED = BlockTrait.register("powered", Boolean.class);
    public static final BlockTrait<Boolean> TRIGGERED = BlockTrait.register("triggered", Boolean.class);
    public static final BlockTrait<Boolean> ENABLED = BlockTrait.register("enabled", Boolean.class); //Hopper
    public static final BlockTrait<Boolean> LOCKED = BlockTrait.register("locked", Boolean.class); //Repeater
    public static final BlockTrait<Boolean> UNSTABLE = BlockTrait.register("unstable", Boolean.class); //TNT
    public static final BlockTrait<Boolean> ATTACHED = BlockTrait.register("attached", Boolean.class); //Tripwire
    public static final BlockTrait<Boolean> DISARMED = BlockTrait.register("disarmed", Boolean.class); //Tripwire
    public static final BlockTrait<Boolean> INVERTED = BlockTrait.register("inverted", Boolean.class); //Daylight Sensor
    //</editor-fold>
    //<editor-fold desc="Piston" defaultstate="collapsed">
    public static final BlockTrait<Boolean> EXTENDED = BlockTrait.register("extended", Boolean.class);
    public static final BlockTrait<Boolean> SHORT = BlockTrait.register("short", Boolean.class);
    //</editor-fold>
    //<editor-fold desc="Connections" defaultstate="collapsed">
    public static final BlockTrait<Boolean> EAST = BlockTrait.register("east", Boolean.class);
    public static final BlockTrait<Boolean> NORTH = BlockTrait.register("north", Boolean.class);
    public static final BlockTrait<Boolean> SOUTH = BlockTrait.register("south", Boolean.class);
    public static final BlockTrait<Boolean> WEST = BlockTrait.register("west", Boolean.class);
    public static final BlockTrait<Boolean> UP = BlockTrait.register("up", Boolean.class);
    public static final BlockTrait<Boolean> DOWN = BlockTrait.register("down", Boolean.class);
    //</editor-fold>
    //<editor-fold desc="Brewing Stand" defaultstate="collapsed">
    public static final BlockTrait<Boolean> HAS_BOTTLE_0 = BlockTrait.register("has_bottle_0", Boolean.class);
    public static final BlockTrait<Boolean> HAS_BOTTLE_1 = BlockTrait.register("has_bottle_1", Boolean.class);
    public static final BlockTrait<Boolean> HAS_BOTTLE_2 = BlockTrait.register("has_bottle_2", Boolean.class);
    //</editor-fold>
    //<editor-fold desc="Misc" defaultstate="collapsed">
    public static final BlockTrait<Boolean> IN_WALL = BlockTrait.register("in_wall", Boolean.class); //Fence Gate
    public static final BlockTrait<Boolean> OCCUPIED = BlockTrait.register("occupied", Boolean.class); //Bed
    public static final BlockTrait<Boolean> SNOWY = BlockTrait.register("snowy", Boolean.class);
    public static final BlockTrait<Boolean> EYE = BlockTrait.register("eye", Boolean.class);
    public static final BlockTrait<Boolean> HAS_RECORD = BlockTrait.register("has_record", Boolean.class);
    public static final BlockTrait<Boolean> PERSISTENT = BlockTrait.register("persistent", Boolean.class);
    public static final BlockTrait<Boolean> WET = BlockTrait.register("wet", Boolean.class);
    //</editor-fold>
    //</editor-fold>


    //<editor-fold desc="Integer Traits" defaultstate="collapsed">
    //<editor-fold desc="Plants" defaultstate="collapsed">
    public static final BlockTrait<Integer> AGE = BlockTrait.register("age", Integer.class, 0, 1, 2, 3, 4, 5, 6, 7);
    public static final BlockTrait<Integer> STAGE = BlockTrait.register("stage", Integer.class, 0, 1); //Saplings
    public static final BlockTrait<Integer> MOISTURE = BlockTrait.register("moisture", Integer.class, 0, 1, 2, 3, 4, 5, 6, 7);
    //</editor-fold>
    //<editor-fold desc="Redstone" defaultstate="collapsed">
    public static final BlockTrait<Integer> POWER = BlockTrait.register("power", Integer.class, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
    public static final BlockTrait<Integer> DELAY = BlockTrait.register("delay", Integer.class, 1, 2, 3, 4);
    //</editor-fold>
    //<editor-fold desc="Misc" defaultstate="collapsed">
    public static final BlockTrait<Integer> BITES = BlockTrait.register("bites", Integer.class, 0, 1, 2, 3, 4, 5, 6);
    public static final BlockTrait<Integer> LEVEL = BlockTrait.register("level", Integer.class, 0, 1, 2, 3, 4, 5, 6, 7); //Water, Lava, Cauldron
    public static final BlockTrait<Integer> LAYERS = BlockTrait.register("layers", Integer.class, 1, 2, 3, 4, 5, 6, 7, 8);
    public static final BlockTrait<Integer> ROTATION = BlockTrait.register("rotation", Integer.class, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
    //</editor-fold>
    //</editor-fold>


    //<editor-fold desc="String/Enum Traits" defaultstate="collapsed">
    //<editor-fold desc="Redstone" defaultstate="collapsed">
    public static final BlockTrait<String> RS_EAST = BlockTrait.register("east", String.class, "none", "side", "up");
    public static final BlockTrait<String> RS_NORTH = BlockTrait.register("north", String.class, "none", "side", "up");
    public static final BlockTrait<String> RS_SOUTH = BlockTrait.register("south", String.class, "none", "side", "up");
    public static final BlockTrait<String> RS_WEST = BlockTrait.register("west", String.class, "none", "side", "up");
    public static final BlockTrait<String> MODE = BlockTrait.register("mode", String.class, "compare", "subtract");
    public static final BlockTrait<String> TYPE = BlockTrait.register("type", String.class, "normal", "sticky");
    //</editor-fold>
    //<editor-fold desc="Shape/Form" defaultstate="collapsed">
    public static final BlockTrait<String> FACING = BlockTrait.register("facing", String.class, "north", "east", "south", "west");
    public static final BlockTrait<String> AXIS = BlockTrait.register("axis", String.class, "x", "y", "z");
    public static final BlockTrait<String> HALF = BlockTrait.register("half", String.class, "top", "bottom");
    public static final BlockTrait<String> HINGE = BlockTrait.register("hinge", String.class, "left", "right");
    public static final BlockTrait<String> PART = BlockTrait.register("part", String.class, "foot", "head");
    public static final BlockTrait<String> SHAPE = BlockTrait.register("shape", String.class,
            "straight", "inner_left", "inner_right", "outer_left", "outer_right",
            "north_south", "east_west", "ascending_east", "ascending_west", "ascending_north", "ascending_south",
            "south_east", "south_west", "north_east", "north_west");
    //</editor-fold>
    //</editor-fold>
}
