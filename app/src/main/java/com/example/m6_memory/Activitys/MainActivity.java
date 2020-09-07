package com.example.m6_memory.Activitys;

        import androidx.appcompat.app.AppCompatActivity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import com.example.m6_memory.R;

public class MainActivity extends AppCompatActivity {

    private Button mPlayButton, btnOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayButton = findViewById(R.id.activity_main_play_btn);
        btnOptions = findViewById(R.id.activity_main_options_btn);

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(MainActivity.this, com.example.m6_memory.LoginActivity.class);
                startActivity(loginActivity);
            }
        });

        btnOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingsActivity = new Intent(MainActivity.this, com.example.m6_memory.SettingsActivity.class);
                startActivity(settingsActivity);
            }
        });
    }
}