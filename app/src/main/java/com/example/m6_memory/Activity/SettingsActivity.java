package com.example.m6_memory.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.view.WindowManager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.m6_memory.R;

public class SettingsActivity extends AppCompatActivity {

    public static Switch swChronometre;
    private Button bResetScores;
    public static Chronometer chronometer;
    public int lastTime, best1, best2, best3;
    public String pseudo;
    public ImageView clock;

    SharedPreferences sharedPreferencesTime;
    SharedPreferences sharedPreferencesPseudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_settings);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        sharedPreferencesPseudo = getSharedPreferences("pseudo", MODE_PRIVATE);
        pseudo = sharedPreferencesPseudo.getString("valuePseudo","");

        sharedPreferencesTime = getSharedPreferences("myKey", MODE_PRIVATE);
        lastTime = sharedPreferencesTime.getInt("lastTime", 0);
        best1 = sharedPreferencesTime.getInt("best1", 0);
        best2 = sharedPreferencesTime.getInt("best2", 0);
        best3 = sharedPreferencesTime.getInt("best3", 0);

        swChronometre = findViewById(R.id.switch1);
        bResetScores = findViewById(R.id.button);
        //clock = findViewById(R.id.activity_game_easy_timer_imageView);
        //chronometer = findViewById(R.id.activity_game_easy_chronometer);

        SharedPreferences settings = getSharedPreferences("save",0);
        swChronometre.setChecked(settings.getBoolean("value", false));

        swChronometre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (swChronometre.isChecked() || swChronometre.isActivated()) {
                    //chronometer = findViewById(R.id.activity_game_easy_chronometer);
                    SharedPreferences.Editor editor = getSharedPreferences("save", 0).edit();
                    editor.putBoolean("value", true);
                    editor.apply();
                    swChronometre.setChecked(true);
                   // setChronometer();
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save", 0).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    swChronometre.setChecked(false);
                    //clock.setVisibility(View.INVISIBLE);
                }
            }
        });

        bResetScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("Etes-vous sûr de supprimer les données sauvegardées ?")
                        .setCancelable(false)
                        .setPositiveButton("oui", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                sharedPreferencesTime.edit().clear().apply();
                                sharedPreferencesPseudo.edit().clear().apply();
                            }
                        })

                        .setNegativeButton("Non", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                 AlertDialog alertDialog = builder.create();
                 alertDialog.show();
            }
        });
    }
    public static Switch getCurrentStateSwitch() {
        return swChronometre;
    }

    public static Chronometer getChronometer() {
        return chronometer;
    }

    public void setChronometer() {
        chronometer = new Chronometer(this);
    }
}