package com.example.michael.tictactoe;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by michael on 12/7/14.
 */
public class GameUpdateManager implements View.OnClickListener {
    private Board board;
    private Map<Integer, BoardCoordinate> buttonIdToCoordinate;
    private boolean _gameOver;
    private final TextView OUTPUT;
    private final Integer[] BUTTON_IDS;

    public GameUpdateManager(GameViewInformation gameViewInformation) {
        BUTTON_IDS = gameViewInformation.getButtonIds();
        OUTPUT = gameViewInformation.getView();

        reset();
    }

    @Override
    public void onClick(View button) {
        if (gameIsNotOver()) {
            accountForCoordinate(button);
            checkEndGame();
        }
    }

    public void reset() {
        board = new TicTacToeBoard();
        _gameOver = false;
        buttonIdToCoordinate = new HashMap<Integer, BoardCoordinate>();
        for (int i = 0; i < BUTTON_IDS.length; i += 1) {
            buttonIdToCoordinate.put(BUTTON_IDS[i], new BoardCoordinate(i % 3, i / 3));
        }
        displayPlayerTurnOutput();
    }

    private void endGameWithText(String text) {
        _gameOver = true;
        OUTPUT.setText(text);
    }

    private void displayPlayerTurnOutput() {
        OUTPUT.setText("Player " + board.currentPlayerCharacter() + "'s turn");
    }

    private void accountForCoordinate(View button) {
        BoardCoordinate coordinate = buttonIdToCoordinate.get(button.getId());
        board.handleMove(coordinate);
        ((Button) button).setText(board.coordinatesValue(coordinate));
        displayPlayerTurnOutput();
    }

    private boolean gameIsNotOver() {
        return !_gameOver;
    }

    private void checkEndGame() {
        if (board.hasBeenWon()) {
            endGameWithText(board.winningPlayer() + " has won");
        }
        else if (board.isTie()) {
            endGameWithText("Tie!");
        }
    }
}
