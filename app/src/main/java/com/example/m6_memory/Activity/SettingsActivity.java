package com.example.m6_memory.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.m6_memory.R;

public class SettingsActivity extends AppCompatActivity {

    private Switch swChronometre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final Context context = getApplicationContext();
        final CharSequence text = "En cours de développement...";
        final int duration = Toast.LENGTH_SHORT;

        swChronometre = findViewById(R.id.switch1);

        swChronometre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, text, duration).show();
            }
        });
    }
}