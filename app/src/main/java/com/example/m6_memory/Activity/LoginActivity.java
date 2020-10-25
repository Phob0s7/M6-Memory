package com.example.m6_memory.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.m6_memory.R;

public class LoginActivity extends AppCompatActivity {

    private RadioButton radioButtonFemale;
    private RadioButton radioButtonMan;
    private Button suivant;
    private EditText editTextPseudo;

    public static final String EXTRA_MESSAGE = "MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        //radioButtonFemale = findViewById(R.id.Activity_login_femme_radioBtn);
       // radioButtonMan = findViewById(R.id.Activity_login_homme_radioBtn);
        suivant = findViewById(R.id.Activity_login_suivant_btn);
        editTextPseudo = findViewById(R.id.editTextTextPersonName);

        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPseudo();
            }
        });
    }

    /*
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
    */


    public void getPseudo() {
        String value = editTextPseudo.getText().toString().trim();
        SharedPreferences sharedPref = getSharedPreferences("pseudo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("pseudo1", value);
        editor.apply();
        Intent intent1 = new Intent(LoginActivity.this, DifficultyLevelActivity.class);
        Intent intent = new Intent(LoginActivity.this, EndGameActivity.class);
        startActivity(intent1);
    }
}