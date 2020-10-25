package com.example.m6_memory.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.m6_memory.R;

public class EndGameActivity extends AppCompatActivity {

    private Button btnAccueil, btnNiveauSuivant;
    static int lastTime, best1, best2, best3, score;
    String pseudo1, pseudo2, pseudo3;
    boolean chronometer;
    static SharedPreferences sharedPreferencesTime;
    private SharedPreferences sharedPreferencesSettings;
    private SharedPreferences sharedPreferencesPseudo;
    private ImageView clockEnd,star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_end_game);

        clockEnd = findViewById(R.id.activity_game_end_timer_imageView);
        star = findViewById(R.id.activity_end_game_étoile_imageView);

        TextView tw_timeGame = findViewById(R.id.activity_game_easy_chronometer);
        TextView tw_score = findViewById(R.id.activity_end_game_scores_txt);

        TextView tw_best1 = findViewById(R.id.textView20);
        TextView tw_best2 = findViewById(R.id.textView11);
        TextView tw_best3 = findViewById(R.id.textView15);

        TextView pseudoBest1 = findViewById(R.id.textView7);
        TextView pseudoBest2 = findViewById(R.id.textView6);
        TextView pseudoBest3 = findViewById(R.id.textView10);



        sharedPreferencesTime = getSharedPreferences("myKey", MODE_PRIVATE);
        SharedPreferences.Editor editorTime = sharedPreferencesTime.edit();


        sharedPreferencesPseudo = getSharedPreferences("pseudo", MODE_PRIVATE);
        pseudo1 = sharedPreferencesPseudo.getString("pseudo1",null);
        pseudo2 = sharedPreferencesPseudo.getString("pseudo1",null);
        pseudo3 = sharedPreferencesPseudo.getString("pseudo1",null);

        SharedPreferences.Editor editorPseudo = sharedPreferencesPseudo.edit();


        sharedPreferencesSettings = getSharedPreferences("save", MODE_PRIVATE);
        SharedPreferences.Editor editorSettings = sharedPreferencesSettings.edit();

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
                editorPseudo.putString("pseudo3", pseudo3);
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
                editorPseudo.putString("pseudo2", pseudo2);
                editorPseudo.putString("pseudo3", pseudo3);
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
                pseudoBest1.setText(pseudo1);
            }

            tw_timeGame.setText(lastTime + "");
            tw_score.setText(score + "");

            tw_best1.setText(best1 + "");
            tw_best2.setText(best2 + "");
            tw_best3.setText(best3 + "");

            //pseudoBest2.setText(pseudo1);
            //pseudoBest3.setText(pseudo1);
        }

        else {
            tw_timeGame.setVisibility(View.INVISIBLE);
            star.setVisibility(View.INVISIBLE);
            tw_score.setVisibility(View.INVISIBLE);
            clockEnd.setVisibility(View.INVISIBLE);

        }

        btnAccueil = findViewById(R.id.activity_end_game_accueil_btn);
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

            }
        });
    }


    public int calculateScore() {
        int score = 0;

        if (lastTime >= 20) {
            score = 0;
        }
        else if (lastTime == 0) {
            score = 0;
        }
        else {
            score = 1000 - (lastTime * 49);
        }

        return score;
    }

    public void getPreferences() {

    }

    public static void clearScoreBoard() {
        sharedPreferencesTime.edit().clear().apply();
    }
}