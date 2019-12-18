package net.codedstingray.worldshaper.core.function;

import net.codedstingray.worldshaper.core.world.block.BlockState;
import net.codedstingray.worldshaper.core.world.block.exception.BlockStateParseException;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class Pattern {

    /**
     * Pattern elements with accumulated probabilities
     */
    private LinkedHashMap<BlockState, Float> elements;

    private static Random randomizer = new Random();

    public Pattern(LinkedHashMap<BlockState, Float> elements) {
        if(elements == null)
            throw new IllegalArgumentException("Elements must not be null");

        this.elements = elements;
    }

    public BlockState apply() {
        float r = randomizer.nextFloat();
        BlockState ret = null; //TODO replace with first element?

        for(Map.Entry<BlockState, Float> element: elements.entrySet()) {
            if(r >= element.getValue()) //always true in first iteration
                ret = element.getKey();
            else
                break;
        }

        return ret;
    }

    public static Pattern parse(String input) {
        String[] tokens = input.split(",");

        LinkedList<String> patternElements = new LinkedList<>();

        StringBuilder nextElement = new StringBuilder();

        //building the list of pattern elements from all the tokens
        for(String token: tokens) {
            if(token.contains("[") && token.contains("]")) {
                //type with 1 trait
                patternElements.add(token);
            } else if(token.contains("[")) {
                //type with 1st trait / beginning of state with more than 1 trait
                nextElement.append(token);
            } else if (token.contains("]")) {
                //last trait of type with more than 1 trait
                nextElement.append(token);
                patternElements.add(nextElement.toString());
                nextElement.setLength(0);
            } else if(token.contains("=")) {
                //middle trait of type with more than 2 traits
                nextElement.append(token);
            } else {
                //type without traits
                patternElements.add(token);
            }
        }

        LinkedHashMap<BlockState, Float> withGivenPercentage = new LinkedHashMap<>();
        LinkedList<BlockState> withoutPercentage = new LinkedList<>();

        for(String element: patternElements) {
            String[] withIsolatedPercentage = element.split("%");

            String sPercentage;
            String sState;

            if(withIsolatedPercentage.length == 1) {
                sPercentage = "-1";
                sState = withIsolatedPercentage[0];
            } else {
                sPercentage = withIsolatedPercentage[0];
                sState = withIsolatedPercentage[1];
            }

            //parse percentage and block state
            float percentage;
            BlockState state;

            try {
                percentage = Float.parseFloat(sPercentage) / 100f;
                state = BlockState.parseBlockState(sState);
            } catch (NumberFormatException e) {
                throw new PatternParseException(sPercentage + " is not a valid percentage value", e);
            } catch (BlockStateParseException e) {
                throw new PatternParseException("Unable to parse \"" + sState + "\" into a BlockState", e);
            }

            if(percentage <= 0) {
                withoutPercentage.add(state);
            } else {
                withGivenPercentage.put(state, percentage);
            }
        }

        LinkedHashMap<BlockState, Float> elements = new LinkedHashMap<>();

        //add elements with accumulated probabilities
        float acc = 0;
        for(Map.Entry<BlockState, Float> element: withGivenPercentage.entrySet()) {
            elements.put(element.getKey(), acc);
            acc += element.getValue();
        }

        //since acc is now all given percentages added up, 1 - acc will contain the remaining percentage
        float remainingPercentage = 1f - acc;
        if(remainingPercentage > 0) {
            float individualPercentage = remainingPercentage / withoutPercentage.size();

            for(BlockState state: withoutPercentage) {
                elements.put(state, individualPercentage);
            }
        }

        return new Pattern(elements);
    }
}
