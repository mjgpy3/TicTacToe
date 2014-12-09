package com.example.michael.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 12/7/14.
 */
public class TicTacToeBoard {
    private Boolean _hasBeenWon = false;
    private List<String> _characters = new ArrayList<String>(Arrays.asList("X", "O"));
    private int _characterIndex = 0;
    private Map<BoardCoordinate, String> _coordinateToValue = new HashMap<BoardCoordinate, String>();

    public void handleMove(BoardCoordinate boardCoordinate) {
        if (!_coordinateToValue.containsKey(boardCoordinate)) {
            _coordinateToValue.put(boardCoordinate, _characters.get(_characterIndex));
            _characterIndex = (_characterIndex + 1) % _characters.size();
        }

        _hasBeenWon = new WinChecker(_coordinateToValue).hasBeenWon();
    }

    public boolean hasBeenWon() {
        return _hasBeenWon;
    }

    public boolean isTie() {
        return _coordinateToValue.size() == 9;
    }

    public String coordinatesValue(BoardCoordinate c) {
        return _coordinateToValue.get(c);
    }

    public String currentPlayerCharacter() {
        return _characters.get(_characterIndex);
    }

    public String winningPlayer() {
        return _characters.get((_characterIndex + 1) % 2);
    }
}
