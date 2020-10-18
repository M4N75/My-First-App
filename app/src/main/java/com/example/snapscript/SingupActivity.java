package com.example.snapscript;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SingupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        //button:
        Button singup = findViewById(R.id.final_singup_button);

        //EditText:
        final EditText username = findViewById(R.id.singup_username);
        final EditText password = findViewById(R.id.singup_password);
        final  EditText email = findViewById(R.id.singup_email);

        singup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                username.setError(null);
                email.setError(null);
                password.setError(null);
                if(!Validation.isValidUsername(username.getText().toString())) {
                    username.setError("Klaida! Patikrinkite slapyvardi!");
                    username.requestFocus();
                }
                else if (!Validation.isValidEmail(email.getText().toString())){
                    email.setError("Klaida! Patikrinkite el. pasta!");
                    email.requestFocus();
                }
                else if(!Validation.isValidPassword(password.getText().toString())){
                    password.setError("Klaida! Patikrinkite slaptazodi!");
                    password.requestFocus();
                }
                else{
                    Intent GotoLoginActivity = new Intent(SingupActivity.this, MainActivity.class);
                    startActivity(GotoLoginActivity);
                }
            }
        });
    }
}