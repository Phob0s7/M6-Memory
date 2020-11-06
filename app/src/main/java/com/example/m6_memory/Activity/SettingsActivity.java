/*
   Class  : SettingsActivity
   Author : Sylvain Villoz TINFPT2
   Date   : Novembre 2020
 */
package com.example.m6_memory.Activity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Switch;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.m6_memory.R;

/**
 * Class that represents the settings.
 */
public class SettingsActivity extends AppCompatActivity {

    public static Switch swChronometre;
    public static Chronometer chronometer;
    public int lastTime, best1, best2, best3;
    public String pseudo;
    SharedPreferences sharedPreferencesTime;
    SharedPreferences sharedPreferencesPseudo;
    private Button bResetScores;
    public static Chronometer getChronometer() {
        return chronometer;
    }

    /**
     * Initialize the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_settings);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        sharedPreferencesPseudo = getSharedPreferences("pseudo", MODE_PRIVATE);
        pseudo = sharedPreferencesPseudo.getString("valuePseudo", "");

        sharedPreferencesTime = getSharedPreferences("myKey", MODE_PRIVATE);
        lastTime = sharedPreferencesTime.getInt("lastTime", 0);
        best1 = sharedPreferencesTime.getInt("best1", 0);
        best2 = sharedPreferencesTime.getInt("best2", 0);
        best3 = sharedPreferencesTime.getInt("best3", 0);

        swChronometre = findViewById(R.id.activity_settings_chronomètre_swt);
        bResetScores = findViewById(R.id.activity_settings_effacer_btn);

        SharedPreferences settings = getSharedPreferences("save", 0);
        swChronometre.setChecked(settings.getBoolean("value", false));

        swChronometre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (swChronometre.isChecked() || swChronometre.isActivated()) {
                    SharedPreferences.Editor editor = getSharedPreferences("save", 0).edit();
                    editor.putBoolean("value", true);
                    editor.apply();
                    swChronometre.setChecked(true);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save", 0).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    swChronometre.setChecked(false);
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
}
