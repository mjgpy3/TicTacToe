package com.example.michael.tictactoe;

import android.view.View;
import android.widget.Button;

/**
 * Created by michael on 12/7/14.
 */
public class GameUpdateManager implements View.OnClickListener {
    private final TicTacToeBoard board = new TicTacToeBoard();

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        if (!board.isSet((String) b.getText())) {
            b.setText(board.currentCharacter());
            board.nextCharacter();
        }
    }
}
