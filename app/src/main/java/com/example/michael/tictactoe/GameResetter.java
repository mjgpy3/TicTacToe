package com.example.michael.tictactoe;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by michael on 12/8/14.
 */
public class GameResetter implements View.OnClickListener {
    private final GameActivity _activity;
    private final GameUpdateManager _game;

    public GameResetter(GameActivity gameActivity, GameUpdateManager updateManager) {
        _activity = gameActivity;
        _game = updateManager;
    }

    @Override
    public void onClick(View _) {
        for (int buttonId : _activity.BUTTON_IDS) {
            ((Button) _activity.findViewById(buttonId)).setText("");
        }

        _game.reset();
    }
}
