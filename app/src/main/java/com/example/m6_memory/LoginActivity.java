package com.example.m6_memory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.RadioButton;

public class LoginActivity extends AppCompatActivity {

    private RadioButton radioButtonFemale;
    private RadioButton radioButtonMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        radioButtonFemale = (RadioButton) findViewById(R.id.Activity_login_femme_radioBtn);
        radioButtonMan = (RadioButton) findViewById(R.id.Activity_login_homme_radioBtn);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.Activity_login_femme_radioBtn:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.Activity_login_homme_radioBtn:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}