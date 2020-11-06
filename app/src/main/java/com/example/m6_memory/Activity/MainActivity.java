/*
   Class  : MainActivity
   Author : Sylvain Villoz TINFPT2
   Date   : Novembre 2020
 */
package com.example.m6_memory.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.m6_memory.R;

/**
 * Class that represents the home screen.
 */
public class MainActivity extends AppCompatActivity {

    private Button mPlayButton, btnOptions;

    /**
     * Initialize the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initializeView();
        setButtonsClick();
    }

    /**
     * Initialize the elments of the home screen
     */
    private void initializeView() {
        setContentView(R.layout.activity_main);
        mPlayButton = findViewById(R.id.activity_main_play_btn);
        btnOptions = findViewById(R.id.activity_main_options_btn);
    }

    /**
     * Set the events of the buttons
     */
    private void setButtonsClick() {
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginActivity);
            }
        });

        btnOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingsActivity = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settingsActivity);
            }
        });
    }
}