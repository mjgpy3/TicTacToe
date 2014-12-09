package com.example.michael.tictactoe;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;


public class MenuActivity extends ActionBarActivity {
    private int _selectedId = R.id.multiPlayer;
    private RadioGroup _group;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        _group = (RadioGroup) findViewById(R.id.options);
        _selectedId = getIntent().getIntExtra("selected", R.id.multiPlayer);
        _group.check(_selectedId);

        for (int radioId : new int[] { R.id.multiPlayer, R.id.easy, R.id.medium, R.id.hard }) {
            findViewById(radioId).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getIntent().putExtra("selected", v.getId());
                    _selectedId = v.getId();
                }
            });
        }
    }

    @Override
    public void onResume() {
        _group.check(_selectedId);
        _group.check(getIntent().getIntExtra("selected", R.id.multiPlayer));
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
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
