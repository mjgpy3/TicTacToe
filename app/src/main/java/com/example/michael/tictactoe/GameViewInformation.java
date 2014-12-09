package com.example.michael.tictactoe;

import android.view.View;
import android.widget.TextView;

public class GameViewInformation {
    private final Integer[] _buttonIds;
    private final TextView _view;

    public GameViewInformation(Integer[] buttonIds, View view) {
        _buttonIds = buttonIds;
        _view = (TextView) view;
    }

    public Integer[] getButtonIds() {
        return _buttonIds;
    }

    public TextView getView() {
        return _view;
    }
}
