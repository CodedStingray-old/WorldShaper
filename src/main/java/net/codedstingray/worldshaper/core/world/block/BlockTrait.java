package net.codedstingray.worldshaper.core.world.block;

import java.util.*;

public class BlockTrait<T> {

    static Map<String, BlockTrait> BY_ID = new HashMap<>();

    private final String id;
    private final String key;
    private final Class<T> type;

    private final Collection<T> possibleValues;

    private BlockTrait(String id, String key, Class<T> type, Collection<T> possibleValues) {
        this.id = id;
        this.key = key;
        this.type = type;
        this.possibleValues = Collections.unmodifiableCollection(possibleValues);
    }

    public String getID() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public final Class<T> getType() {
        return type;
    }

    public final Collection<T> getPossibleValues() {
        return possibleValues;
    }


    @SafeVarargs
    public static<I> BlockTrait<I> register(String id, String key, Class<I> type, I... possibleValues) {
        Collection<I> valueCollection = Arrays.asList(possibleValues);

        return register(id, key, type, valueCollection);
    }

    public static<I> BlockTrait<I> register(String id, String key, Class<I> type, Collection<I> possibleValues) {
        if(BY_ID.get(id) != null) {
            throw new IllegalArgumentException("Unable to register the same blocktrait twice");
        }

        BlockTrait<I> trait = new BlockTrait<>(id, key, type, possibleValues);
        BY_ID.put(id, trait);

        return trait;
    }

    @Override
    public String toString() {
        return key;
    }
}
