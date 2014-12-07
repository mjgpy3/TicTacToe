package com.example.michael.tictactoe;

import android.view.View;
import android.widget.Button;

/**
 * Created by michael on 12/7/14.
 */
public class GameUpdateManager implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        ((Button) v).setText("X");
    }
}
