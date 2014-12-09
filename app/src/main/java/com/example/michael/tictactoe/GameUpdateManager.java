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
    private final Integer[] BUTTON_IDS;
    private final TextView OUTPUT;
    private Board _board;
    private Map<Integer, BoardCoordinate> _buttonIdToCoordinate;
    private boolean _gameOver;

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
        _board = new TicTacToeBoard();
        _gameOver = false;
        _buttonIdToCoordinate = new HashMap<Integer, BoardCoordinate>();
        for (int i = 0; i < BUTTON_IDS.length; i += 1) {
            _buttonIdToCoordinate.put(BUTTON_IDS[i], new BoardCoordinate(i % 3, i / 3));
        }
        displayPlayerTurnOutput();
    }

    private void endGameWithText(String text) {
        _gameOver = true;
        OUTPUT.setText(text);
    }

    private void displayPlayerTurnOutput() {
        OUTPUT.setText("Player " + _board.currentPlayerCharacter() + "'s turn");
    }

    private void accountForCoordinate(View button) {
        BoardCoordinate coordinate = _buttonIdToCoordinate.get(button.getId());
        _board.handleMove(coordinate);
        ((Button) button).setText(_board.coordinatesValue(coordinate));
        displayPlayerTurnOutput();
    }

    private boolean gameIsNotOver() {
        return !_gameOver;
    }

    private void checkEndGame() {
        if (_board.hasBeenWon()) {
            endGameWithText(_board.winningPlayer() + " has won");
        }
        else if (_board.isTie()) {
            endGameWithText("Tie!");
        }
    }
}
