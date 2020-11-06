/*
   Class  : LoginActivity
   Author : Sylvain Villoz TINFPT2
   Date   : Novembre 2020
 */
package com.example.m6_memory.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.m6_memory.R;

/**
 * Class that represents the login.
 */
public class LoginActivity extends AppCompatActivity {

    private Button suivant;
    private EditText editTextPseudo;

    /**
     * Initialize the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        initializeView();
        setButtonNextClick();
    }

    /**
     * Save the pseudo in sharedpref.
     */
    public void getPseudo() {
        String value = editTextPseudo.getText().toString().trim();
        if (TextUtils.isEmpty(value)) {
            Toast.makeText(getApplicationContext(), "Veuillez entrer un pseudonyme !", Toast.LENGTH_SHORT).show();
        } else {
            SharedPreferences sharedPref = getSharedPreferences("pseudo", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("pseudo1", value);
            editor.apply();
            Intent intent1 = new Intent(LoginActivity.this, DifficultyLevelActivity.class);
            startActivity(intent1);
        }
    }

    private void initializeView() {
        suivant = findViewById(R.id.Activity_login_suivant_btn);
        editTextPseudo = findViewById(R.id.Activity_login_editText);
    }

    private void setButtonNextClick() {
        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPseudo();
            }
        });
    }
}