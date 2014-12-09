package com.example.michael.tictactoe;

import java.util.Map;

/**
 * Created by michael on 12/8/14.
 */
public class GameWon implements EndConditionChecker {
    private final Map<BoardCoordinate, String> COORDINATE_TO_VALUE;
    private final String EMPTY_SPOT = "_";
    private final int[][][] WINNING_CASES = {
            {{0, 0}, {0, 1}, {0, 2}},
            {{1, 0}, {1, 1}, {1, 2}},
            {{2, 0}, {2, 1}, {2, 2}},
            {{0, 0}, {1, 0}, {2, 0}},
            {{0, 1}, {1, 1}, {2, 1}},
            {{0, 2}, {1, 2}, {2, 2}},
            {{0, 0}, {1, 1}, {2, 2}},
            {{0, 2}, {1, 1}, {2, 0}}
    };


    public GameWon(Map<BoardCoordinate, String> map) {
        COORDINATE_TO_VALUE = map;
    }

    @Override
    public Boolean conditionMet() {
        for (int[][] trio : WINNING_CASES) {
            if (allAreEqual(lookup(trio[0]), lookup(trio[1]), lookup(trio[2]))) {
                return true;
            }
        }
        return false;
    }

    private Boolean allAreEqual(String a, String b, String c) {
        return !a.equals(EMPTY_SPOT) && a.equals(b) && b.equals(c);
    }

    private String lookup(int[] pair) {
        BoardCoordinate toLookup = new BoardCoordinate(pair[0], pair[1]);
        if (COORDINATE_TO_VALUE.containsKey(toLookup)) {
            return COORDINATE_TO_VALUE.get(toLookup);
        }
        return EMPTY_SPOT;
    }
}
