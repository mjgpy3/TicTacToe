package com.example.michael.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by michael on 12/7/14.
 */
public class TicTacToeBoard {
    private ArrayList<String> _characters = new ArrayList<String>(Arrays.asList("X", "O"));
    private int _characterIndex = 0;

    public String currentCharacter() {
        return _characters.get(_characterIndex % _characters.size());
    }

    public boolean isSet(String character) {
        return _characters.contains(character);
    }

    public void nextCharacter() {
        _characterIndex += 1;
    }
}
