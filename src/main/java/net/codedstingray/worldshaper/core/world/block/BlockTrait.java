package net.codedstingray.worldshaper.core.world.block;

import java.util.*;

public class BlockTrait<T> {

    static Map<String, BlockTrait> BY_KEY = new HashMap<>();

    public final String key;
    public final Class<T> type;

    public final Collection<T> possibleValues;

    private BlockTrait(String key, Class<T> type, Collection<T> possibleValues) {
        this.key = key;
        this.type = type;
        this.possibleValues = Collections.unmodifiableCollection(possibleValues);
    }


    @SafeVarargs
    public static<I> BlockTrait<I> register(String key, Class<I> type, I... possibleValues) {
        Collection<I> valueCollection = Arrays.asList(possibleValues);

        return register(key, type, valueCollection);
    }

    public static<I> BlockTrait<I> register(String key, Class<I> type, Collection<I> possibleValues) {
        if(BY_KEY.get(key) != null) {
            throw new IllegalArgumentException("Unable to register the same blocktrait twice");
        }

        BlockTrait<I> trait = new BlockTrait<>(key, type, possibleValues);
        BY_KEY.put(key, trait);

        return trait;
    }

    @Override
    public String toString() {
        return key;
    }
}
