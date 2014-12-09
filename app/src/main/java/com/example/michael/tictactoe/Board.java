package com.example.michael.tictactoe;

/**
 * Created by michael on 12/8/14.
 */
public interface Board {
    void handleMove(BoardCoordinate boardCoordinate);

    boolean hasBeenWon();

    boolean isTie();

    String coordinatesValue(BoardCoordinate c);

    String currentPlayerCharacter();

    String winningPlayer();
}
