package com.example.michael.tictactoe;

import android.view.View;
import android.widget.Button;

import java.util.HashMap;

/**
 * Created by michael on 12/7/14.
 */
public class GameUpdateManager implements View.OnClickListener {
    private final TicTacToeBoard board = new TicTacToeBoard();
    private final HashMap<Integer, BoardCoordinate> buttonIdToCoordinate = new HashMap<Integer, BoardCoordinate>();

    public GameUpdateManager(Integer[] buttonIds) {
        for (int i = 0; i < buttonIds.length; i += 1) {
            buttonIdToCoordinate.put(buttonIds[i], new BoardCoordinate(i / 3, i % 3));
        }
    }

    @Override
    public void onClick(View button) {
        BoardCoordinate coordinate = buttonIdToCoordinate.get(button.getId());
        board.handleMove(coordinate);
        ((Button) button).setText(board.coordinatesValue(coordinate));
    }
}
