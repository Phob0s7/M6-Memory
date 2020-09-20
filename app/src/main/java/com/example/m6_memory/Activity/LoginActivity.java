package com.example.m6_memory.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.m6_memory.R;

public class LoginActivity extends AppCompatActivity {

    private RadioButton radioButtonFemale;
    private RadioButton radioButtonMan;
    private Button suivant, retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        radioButtonFemale = findViewById(R.id.Activity_login_femme_radioBtn);
        radioButtonMan = findViewById(R.id.Activity_login_homme_radioBtn);
        suivant = findViewById(R.id.Activity_login_suivant_btn);
        retour = findViewById(R.id.Activity_login_retour_btn);

        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent difficultyLevelActivity = new Intent(LoginActivity.this, DifficultyLevelActivity.class);
                startActivity(difficultyLevelActivity);
            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(mainActivity);
            }
        });
    }

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.Activity_login_femme_radioBtn:
                if (checked)
                    break;
            case R.id.Activity_login_homme_radioBtn:
                if (checked)
                    break;
        }
    }
}