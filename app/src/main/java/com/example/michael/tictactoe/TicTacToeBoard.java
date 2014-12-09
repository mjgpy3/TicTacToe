package com.example.michael.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 12/7/14.
 */
public class TicTacToeBoard implements Board {
    private List<String> _characters = new ArrayList<String>(Arrays.asList("X", "O"));
    private int _characterIndex = 0;
    private Map<BoardCoordinate, String> _coordinateToValue = new HashMap<BoardCoordinate, String>();

    @Override
    public void handleMove(BoardCoordinate boardCoordinate) {
        if (positionNotFilled(boardCoordinate)) {
            addCoordinate(boardCoordinate);
            toggleToNextCharacter();
        }
    }

    @Override
    public boolean hasBeenWon() {
        return new GameWon(_coordinateToValue).conditionMet();
    }

    @Override
    public boolean isTie() {
        return new GameTie(_coordinateToValue).conditionMet();
    }

    @Override
    public String coordinatesValue(BoardCoordinate c) {
        return _coordinateToValue.get(c);
    }

    @Override
    public String currentPlayerCharacter() {
        return _characters.get(_characterIndex);
    }

    @Override
    public String winningPlayer() {
        return _characters.get((_characterIndex + 1) % 2);
    }

    private void toggleToNextCharacter() {
        _characterIndex = (_characterIndex + 1) % _characters.size();
    }

    private String addCoordinate(BoardCoordinate boardCoordinate) {
        return _coordinateToValue.put(boardCoordinate, _characters.get(_characterIndex));
    }

    private boolean positionNotFilled(BoardCoordinate boardCoordinate) {
        return !_coordinateToValue.containsKey(boardCoordinate);
    }
}
