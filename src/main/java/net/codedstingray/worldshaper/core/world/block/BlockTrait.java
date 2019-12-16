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

    public Class<T> getType() {
        return type;
    }

    public Collection<T> getPossibleValues() {
        return possibleValues;
    }

    @SuppressWarnings("all")
    public boolean allowsValue(Object value) {
        return value != null && (possibleValues.contains(value) || possibleValues.isEmpty());
    }

    @SuppressWarnings("all")
    public void checkValue(Object value) {
        if(value == null || (!possibleValues.isEmpty() && !possibleValues.contains(value))) {
            throw new IllegalArgumentException("\"" + value + "\" is not a possible value for trait[key=" + key + ",id=" + id + "]");
        }
    }

    @Override
    public String toString() {
        return key;
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

    public static Map.Entry<BlockTrait<?>, ?> parseTraitValuePair(BlockTrait<?> trait, String rawValue) {
        Class<?> type = trait.getType();

        Map.Entry<BlockTrait<?>, Object> entry = new AbstractMap.SimpleEntry<>(trait, null);

        if(type == String.class) {
            //String
            trait.checkValue(rawValue);
            entry.setValue(rawValue);
        } else if(type == Integer.class) {
            //Integer
            try {
                int i = Integer.parseInt(rawValue);
                trait.checkValue(i);
                entry.setValue(i);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("\"" + rawValue + "\" cannot be parsed to Integer", e);
            }
        } else if (type == Boolean.class) {
            //Boolean
            boolean b = Boolean.parseBoolean(rawValue);
            entry.setValue(b);
        } else {
            throw new IllegalArgumentException("Illegal argument for BlockTrait value; only allowed types are: String, Boolean, Integer");
        }

        return entry;
    }
}
