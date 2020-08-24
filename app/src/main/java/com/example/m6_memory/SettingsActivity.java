package com.example.m6_memory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    private Button btnRetour;
    private Switch swChronomètre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final Context context = getApplicationContext();
        final CharSequence text = "En cours de développement...";
        final int duration = Toast.LENGTH_SHORT;

        btnRetour = findViewById(R.id.activity_settings_retour_btn);
        swChronomètre = findViewById(R.id.switch1);

        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingsActivity = new Intent (SettingsActivity.this, MainActivity.class);
                startActivity(settingsActivity);
            }
        });

        swChronomètre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, text, duration).show();
            }
        });
    }
}