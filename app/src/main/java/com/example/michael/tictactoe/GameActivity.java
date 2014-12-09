package com.example.michael.tictactoe;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class GameActivity extends ActionBarActivity {

    public final Integer[] BUTTON_IDS = {
            R.id.button1, R.id.button2, R.id.button3,
            R.id.button4, R.id.button5, R.id.button6,
            R.id.button7, R.id.button8, R.id.button9
    };
    private GameUpdateManager _updateManager;
    private boolean _intentBuilt = false;
    private Intent SETTINGS_INTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);

        if (!_intentBuilt) {
            SETTINGS_INTENT = new Intent(GameActivity.this, MenuActivity.class);
        }

        _updateManager = new GameUpdateManager(new GameViewInformation(BUTTON_IDS, findViewById(R.id.output)));

        for (Integer buttonId : BUTTON_IDS) {
            findViewById(buttonId).setOnClickListener(_updateManager);
        }

        findViewById(R.id.newGame).setOnClickListener(new GameResetter(this, _updateManager));
        findViewById(R.id.settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameActivity.this.startActivity(SETTINGS_INTENT);
             }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
