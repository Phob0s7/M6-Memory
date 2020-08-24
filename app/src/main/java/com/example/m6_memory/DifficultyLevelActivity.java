package com.example.m6_memory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DifficultyLevelActivity extends AppCompatActivity {

    private Button btnFacile, btnMoyen,btnDifficile,btnPrototype,btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_level);

        btnFacile = findViewById(R.id.activity_difficulty_level_facile_btn);
        btnMoyen = findViewById(R.id.activity_difficulty_level_moyen_btn);
        btnDifficile = findViewById(R.id.activity_difficulty_level_difficile_btn);
        btnPrototype = findViewById(R.id.activity_difficulty_level_prototype_btn);
        btnRetour = findViewById(R.id.activity_difficulty_level_retour_btn);

        final Context context = getApplicationContext();
        final CharSequence text = "En cours de développement...";
        final int duration = Toast.LENGTH_SHORT;

        btnFacile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, text, duration).show();
            }
        });
        btnMoyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Toast.makeText(context, text, duration).show();
                }

        });
        btnDifficile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Toast.makeText(context, text, duration).show();
                }
        });
        btnPrototype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameActivity = new Intent (DifficultyLevelActivity.this, GameActivity.class);
                startActivity(gameActivity);
            }
        });

       btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginActivity = new Intent (DifficultyLevelActivity.this, LoginActivity.class);
                startActivity(LoginActivity);
            }
        });
    }
}