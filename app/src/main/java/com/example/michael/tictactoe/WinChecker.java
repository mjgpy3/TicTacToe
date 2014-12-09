package com.example.michael.tictactoe;

import java.security.KeyException;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by michael on 12/8/14.
 */
public class WinChecker {
    private final Map<BoardCoordinate, String> _coordinateToValue;

    public WinChecker(Map<BoardCoordinate, String> map) {
        _coordinateToValue = map;
    }

    public Boolean hasBeenWon() {
        for (int x = 0; x < 3; x += 1) {
            if (allAreEqual(lookup(x, 0), lookup(x, 1), lookup(x, 2))) {
                return true;
            }
        }
        for (int y = 0; y < 3; y += 1) {
            if (allAreEqual(lookup(0, y), lookup(1, y), lookup(2, y))) {
                return true;
            }
        }
        return allAreEqual(lookup(0, 0), lookup(1, 1), lookup(2, 2)) ||
                allAreEqual(lookup(0, 2), lookup(1, 1), lookup(2, 0));
    }

    private Boolean allAreEqual(String a, String b, String c) {
        return a.equals(b) && b.equals(c) && !a.equals("_");
    }

    private String lookup(int x, int y) {
        BoardCoordinate toLookup = new BoardCoordinate(x, y);
        if (_coordinateToValue.containsKey(toLookup)) {
            return _coordinateToValue.get(toLookup);
        }
        return "_";
    }
}
