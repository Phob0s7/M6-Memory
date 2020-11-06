/*
   Class  : GameGridActivity
   Author : Sylvain Villoz TINFPT2
   Date   : Novembre 2020
 */

/*
  THIS CLASS IS NOT USED, IT'S JUST TO SHOW THE GRIDVIEW
 */
package com.example.m6_memory.Activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.m6_memory.R;

/**
 * Class that represents the draw of the board with GridView.
 */
public class GameGridActivity extends Activity {

    static String choiceUser;
    boolean chronometer;
    int[] hiddenCards = new int[]{R.drawable.hiddencards, R.drawable.hiddencards, R.drawable.hiddencards, R.drawable.hiddencards,
            R.drawable.hiddencards, R.drawable.hiddencards, R.drawable.hiddencards, R.drawable.hiddencards, R.drawable.hiddencards, R.drawable.hiddencards, R.drawable.hiddencards, R.drawable.hiddencards};
    private SharedPreferences sharedPreferencesChoiceLevelDifficulty;
    private ImageView clock;
    private SharedPreferences settings;
    private GridView gridView;
    private Chronometer time;

    /**
     * Initialize the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_grid);

        clock = findViewById(R.id.activity_game_grid_clock_iV);
        time = findViewById(R.id.activity_game_grid_chronometer);

        settings = getSharedPreferences("save", MODE_PRIVATE);

        chronometer = settings.getBoolean("value", false);

        sharedPreferencesChoiceLevelDifficulty = getSharedPreferences("levelDifficulty", 0);
        choiceUser = sharedPreferencesChoiceLevelDifficulty.getString("levelDifficulty", "");

        gridView = (GridView) findViewById(R.id.gridView);
        MainAdapter adapter = new MainAdapter(GameGridActivity.this, hiddenCards, choiceUser);
        gridView.setAdapter(adapter);

        playGame();
    }

    /**
     * Start the game.
     */
    public void playGame() {

        if (chronometer) {
            SettingsActivity.chronometer = findViewById(R.id.activity_game_grid_chronometer);
            SettingsActivity.chronometer.setBase(SystemClock.elapsedRealtime());
            SettingsActivity.chronometer.start();
            time.setVisibility(View.VISIBLE);
            clock.setVisibility(View.VISIBLE);
        } else {
            clock.setVisibility(View.INVISIBLE);
            time.setVisibility(View.INVISIBLE);
        }

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
    }
}


















