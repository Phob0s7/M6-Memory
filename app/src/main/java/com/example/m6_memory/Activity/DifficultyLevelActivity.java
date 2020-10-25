package com.example.m6_memory.Activity;

import android.content.Context;
import android.content.Intent;
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

    public static final String EXTRA_MESSAGE = "com.timer.Memory.MESSAGE";

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

        final Context context = getApplicationContext();
        final CharSequence text = "En cours de développement...";
        final int duration = Toast.LENGTH_SHORT;

        btnFacile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent facile = new Intent(DifficultyLevelActivity.this, GameActivityEasy.class);
                facile.putExtra(EXTRA_MESSAGE, facile);


                Intent GameActivityEasy = new Intent(DifficultyLevelActivity.this, com.example.m6_memory.Activity.GameActivity.GameActivityEasy.class);
                startActivity(GameActivityEasy);

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


    }


}