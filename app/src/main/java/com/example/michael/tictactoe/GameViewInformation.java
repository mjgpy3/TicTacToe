package com.example.michael.tictactoe;

import android.view.View;
import android.widget.TextView;

public class GameViewInformation {
    private final Integer[] buttonIds;
    private final TextView view;

    public GameViewInformation(Integer[] buttonIds, View view) {
        this.buttonIds = buttonIds;
        this.view = (TextView) view;
    }

    public Integer[] getButtonIds() {
        return buttonIds;
    }

    public TextView getView() {
        return view;
    }
}
