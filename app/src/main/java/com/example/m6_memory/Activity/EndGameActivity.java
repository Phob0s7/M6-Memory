/*
   Class  : EndGameActivity
   Author : Sylvain Villoz TINFPT2
   Date   : Novembre 2020
 */
package com.example.m6_memory.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.m6_memory.Activity.GameActivity.GameActivityEasy;
import com.example.m6_memory.Activity.GameActivity.GameActivityHard;
import com.example.m6_memory.Activity.GameActivity.GameActivityMedium;
import com.example.m6_memory.R;

/**
 * Class that represents the end of the game.
 */
public class EndGameActivity extends AppCompatActivity {

    static int lastTime, best1, best2, best3, score;
    static SharedPreferences sharedPreferencesTime;
    public String choiceUser;
    public SharedPreferences.Editor editorLevelDifficulty;
    String pseudo1, pseudo2, pseudo3;
    boolean chronometer;
    private Button btnAccueil, btnNiveauSuivant;
    private SharedPreferences sharedPreferencesSettings;
    private SharedPreferences sharedPreferencesPseudo;
    private ImageView clockEnd, star;
    private SharedPreferences sharedPreferencesChoiceLevelDifficulty;

    /**
     * Initialize the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_end_game);

        sharedPreferencesChoiceLevelDifficulty = getSharedPreferences("levelDifficulty", 0);
        choiceUser = sharedPreferencesChoiceLevelDifficulty.getString("levelDifficulty", null);
        editorLevelDifficulty = sharedPreferencesChoiceLevelDifficulty.edit();

        clockEnd = findViewById(R.id.activity_game_end_timer_imageView);
        star = findViewById(R.id.activity_end_game_étoile_imageView);

        TextView tw_timeGame = findViewById(R.id.activity_game_easy_chronometer);
        TextView tw_score = findViewById(R.id.activity_end_game_scores_txt);

        TextView tw_best1 = findViewById(R.id.activity_end_game_scores1_txt);
        TextView tw_best2 = findViewById(R.id.activity_end_game_scores2_txt);
        TextView tw_best3 = findViewById(R.id.activity_end_game_scores3_txt);

        TextView pseudoBest1 = findViewById(R.id.activity_end_game_nom1_txt);


        sharedPreferencesTime = getSharedPreferences("myKey", MODE_PRIVATE);
        SharedPreferences.Editor editorTime = sharedPreferencesTime.edit();


        sharedPreferencesPseudo = getSharedPreferences("pseudo", MODE_PRIVATE);
        pseudo1 = sharedPreferencesPseudo.getString("pseudo1", null);

        sharedPreferencesSettings = getSharedPreferences("save", MODE_PRIVATE);

        chronometer = sharedPreferencesSettings.getBoolean("value", false);

        if (chronometer) {
            clockEnd.setVisibility(View.VISIBLE);
            tw_timeGame.setVisibility(View.VISIBLE);
            star.setVisibility(View.VISIBLE);
            tw_score.setVisibility(View.VISIBLE);

            lastTime = sharedPreferencesTime.getInt("lastTime", 0);
            best1 = sharedPreferencesTime.getInt("best1", 0);
            best2 = sharedPreferencesTime.getInt("best2", 0);
            best3 = sharedPreferencesTime.getInt("best3", 0);

            score = calculateScore();

            if (score > best3) {
                best3 = score;
                editorTime.putInt("best3", best3);
                editorTime.apply();

            }
            if (score > best2) {
                int tmp1 = best2;
                best2 = score;
                best3 = tmp1;

                String tmp2 = pseudo2;
                pseudo2 = pseudo1;
                pseudo3 = tmp2;

                editorTime.putInt("best3", best3);
                editorTime.putInt("best2", best2);
                editorTime.apply();

            }
            if (score > best1) {
                int tmp1 = best1;
                best1 = score;
                best2 = tmp1;

                String tmp2 = pseudo1;
                pseudo2 = pseudo1;
                pseudo3 = tmp2;

                editorTime.putInt("best2", best2);
                editorTime.putInt("best1", best1);
                editorTime.apply();

            }

            tw_timeGame.setText(lastTime + "");
            tw_score.setText(score + "");

            tw_best1.setText(best1 + "");
            tw_best2.setText(best2 + "");
            tw_best3.setText(best3 + "");

        } else {
            tw_timeGame.setVisibility(View.INVISIBLE);
            star.setVisibility(View.INVISIBLE);
            tw_score.setVisibility(View.INVISIBLE);
            clockEnd.setVisibility(View.INVISIBLE);
        }

        pseudoBest1.setText(pseudo1);

        btnAccueil = findViewById(R.id.activity_end_game_menu_difficulté_btn);
        btnNiveauSuivant = findViewById(R.id.activity_end_game_niveauSuivant_btn);

        btnAccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnNiveauSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;

                switch (choiceUser) {
                    case "easy":
                        editorLevelDifficulty.putString("levelDifficulty", "medium");
                        editorLevelDifficulty.apply();
                        intent = new Intent(EndGameActivity.this, GameActivityMedium.class);
                        startActivity(intent);
                        break;
                    case "medium":
                        editorLevelDifficulty.putString("levelDifficulty", "hard");
                        editorLevelDifficulty.apply();
                        intent = new Intent(EndGameActivity.this, GameActivityHard.class);
                        startActivity(intent);
                        break;
                    case "hard":
                        editorLevelDifficulty.putString("levelDifficulty", "easy");
                        editorLevelDifficulty.apply();
                        intent = new Intent(EndGameActivity.this, GameActivityEasy.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    /**
     * Calculate the score as a function of time.
     */
    public int calculateScore() {
        int score;

        if (lastTime >= 20) {
            score = 0;
        } else if (lastTime == 0) {
            score = 0;
        } else {
            score = 1000 - (lastTime * 49);
        }

        return score;
    }
}