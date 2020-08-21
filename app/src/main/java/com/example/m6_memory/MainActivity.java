package com.example.m6_memory;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mMemory;
    private TextView mPrototype;
    private Button mPlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMemory = (TextView) findViewById(R.id.activity_main_memory_txt);
        mPrototype = (TextView) findViewById(R.id.activity_main_prototype_txt);
        mPlayButton = (Button) findViewById(R.id.activity_main_play_btn);

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginActivity);
            }
        });
    }
}