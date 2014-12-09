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
    private TicTacToeBoard board;
    private Map<Integer, BoardCoordinate> buttonIdToCoordinate;
    private boolean _gameOver;
    private final TextView OUTPUT;
    private final Integer[] BUTTON_IDS;

    public GameUpdateManager(GameViewInformation gameViewInformation) {
        BUTTON_IDS = gameViewInformation.getButtonIds();
        OUTPUT = gameViewInformation.getView();

        initialize();
    }

    @Override
    public void onClick(View button) {
        if (!_gameOver) {
            BoardCoordinate coordinate = buttonIdToCoordinate.get(button.getId());
            board.handleMove(coordinate);
            ((Button) button).setText(board.coordinatesValue(coordinate));
            displayPlayerTurnOutput();

            if (board.hasBeenWon()) {
                endGameWithText(board.winningPlayer() + " has won");
            }

            if (board.isTie()) {
                endGameWithText("Tie!");
            }
        }
    }

    public void displayPlayerTurnOutput() {
        OUTPUT.setText("Player " + board.currentPlayerCharacter() + "'s turn");
    }

    public void reset() {
        initialize();
    }

    private void endGameWithText(String text) {
        _gameOver = true;
        OUTPUT.setText(text);
    }

    private void initialize() {
        board = new TicTacToeBoard();
        _gameOver = false;
        buttonIdToCoordinate = new HashMap<Integer, BoardCoordinate>();
        for (int i = 0; i < BUTTON_IDS.length; i += 1) {
            buttonIdToCoordinate.put(BUTTON_IDS[i], new BoardCoordinate(i / 3, i % 3));
        }
        displayPlayerTurnOutput();
    }
}
