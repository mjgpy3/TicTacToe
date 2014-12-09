package com.example.michael.tictactoe;

import java.util.Map;

/**
* Created by michael on 12/8/14.
*/
public class GameTie implements EndConditionChecker {
    private final int _filledSlots;
    public GameTie(Map<BoardCoordinate, String> map) {
        _filledSlots = map.size();
    }

    public Boolean conditionMet() {
        return _filledSlots == 9;
    }
}
