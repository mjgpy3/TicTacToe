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
    private final TicTacToeBoard board = new TicTacToeBoard();
    private final Map<Integer, BoardCoordinate> buttonIdToCoordinate = new HashMap<Integer, BoardCoordinate>();
    private final TextView output;
    private boolean _gameOver = false;

    public GameUpdateManager(Integer[] buttonIds, View view) {
        for (int i = 0; i < buttonIds.length; i += 1) {
            buttonIdToCoordinate.put(buttonIds[i], new BoardCoordinate(i / 3, i % 3));
        }
        output = ((TextView) view);

        displayPlayerTurnOutput();
    }

    @Override
    public void onClick(View button) {
        if (!_gameOver) {
            BoardCoordinate coordinate = buttonIdToCoordinate.get(button.getId());
            board.handleMove(coordinate);
            ((Button) button).setText(board.coordinatesValue(coordinate));
            displayPlayerTurnOutput();

            if (board.hasBeenWon()) {
                _gameOver = true;
                output.setText(board.winningPlayer() + " has won");
            }
        }
    }

    private void displayPlayerTurnOutput() {
        output.setText("Player " + board.currentPlayerCharacter() + "'s turn");
    }
}
