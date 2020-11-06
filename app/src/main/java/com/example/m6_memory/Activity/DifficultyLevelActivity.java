/*
   Class  : DifficultyLevelActivity
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
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.m6_memory.Activity.GameActivity.GameActivityEasy;
import com.example.m6_memory.Activity.GameActivity.GameActivityHard;
import com.example.m6_memory.Activity.GameActivity.GameActivityMedium;
import com.example.m6_memory.R;

/**
 * Class that represents the level of difficulty.
 */
public class DifficultyLevelActivity extends AppCompatActivity {

    SharedPreferences sharedPreferencesChoiceLevelDifficulty;
    SharedPreferences.Editor editorLevel;
    private Button btnFacile, btnMoyen, btnDifficile;

    /**
     * Initialize the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_level);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnFacile = findViewById(R.id.activity_difficulty_level_facile_btn);
        btnMoyen = findViewById(R.id.activity_difficulty_level_moyen_btn);
        btnDifficile = findViewById(R.id.activity_difficulty_level_difficile_btn);

        sharedPreferencesChoiceLevelDifficulty = getSharedPreferences("levelDifficulty", MODE_PRIVATE);
        editorLevel = sharedPreferencesChoiceLevelDifficulty.edit();

        btnFacile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editorLevel.putString("levelDifficulty", "easy");
                editorLevel.apply();
                Intent intent = new Intent(DifficultyLevelActivity.this, GameActivityEasy.class);
                startActivity(intent);
            }
        });
        btnMoyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editorLevel.putString("levelDifficulty", "medium");
                editorLevel.apply();
                Intent intent = new Intent(DifficultyLevelActivity.this, GameActivityMedium.class);
                startActivity(intent);

            }

        });
        btnDifficile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editorLevel.putString("levelDifficulty", "hard");
                editorLevel.apply();
                Intent intent = new Intent(DifficultyLevelActivity.this, GameActivityHard.class);
                startActivity(intent);
            }
        });
    }
}