package com.example.m6_memory.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.m6_memory.R;

public class EndGameActivity extends AppCompatActivity {

    private Button btnAccueil, btnNiveauSuivant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        btnAccueil = findViewById(R.id.activity_end_game_accueil_btn);
        btnNiveauSuivant = findViewById(R.id.activity_end_game_niveauSuivant_btn);

        final Context context = getApplicationContext();
        final CharSequence text = "En cours de développement...";
        final int duration = Toast.LENGTH_SHORT;

        btnAccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameActivity = new Intent(EndGameActivity.this, DifficultyLevelActivity.class);
                startActivity(gameActivity);
            }
        });

        btnNiveauSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, text, duration).show();
            }
        });
    }
}