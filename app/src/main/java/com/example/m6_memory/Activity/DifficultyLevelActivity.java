package com.example.m6_memory.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.m6_memory.Activity.GameActivity.GameActivityEasy;
import com.example.m6_memory.R;
import android.view.WindowManager;

public class DifficultyLevelActivity extends AppCompatActivity {

    private Button btnFacile, btnMoyen, btnDifficile;
    private EditText editTextPseudo;
    private  String choiceUser, easy, medium, hard;
    public static final String EXTRA_MESSAGE = "com.timer.Memory.MESSAGE";

    SharedPreferences sharedPreferencesChoiceLevelDifficulty;
    SharedPreferences.Editor editorLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_level);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnFacile = findViewById(R.id.activity_difficulty_level_facile_btn);
        btnMoyen = findViewById(R.id.activity_difficulty_level_moyen_btn);
        btnDifficile = findViewById(R.id.activity_difficulty_level_difficile_btn);
        editTextPseudo = findViewById(R.id.editTextTextPersonName);

        sharedPreferencesChoiceLevelDifficulty = getSharedPreferences("levelDifficulty", MODE_PRIVATE);
        editorLevel = sharedPreferencesChoiceLevelDifficulty.edit();

        btnFacile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editorLevel.putString("levelDifficulty", "easy");
                editorLevel.apply();
                Intent intent = new Intent(DifficultyLevelActivity.this, GameGridActivity.class);
                startActivity(intent);
            }
        });
        btnMoyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editorLevel.putString("levelDifficulty", "medium");
                editorLevel.apply();
                Intent intent = new Intent(DifficultyLevelActivity.this, GameGridActivity.class);
                startActivity(intent);

            }

        });
        btnDifficile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editorLevel.putString("levelDifficulty", "hard");
                editorLevel.apply();
                Intent intent = new Intent(DifficultyLevelActivity.this, GameGridActivity.class);
                startActivity(intent);
            }
        });


    }


}