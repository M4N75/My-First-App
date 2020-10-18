package com.example.snapscript;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //buttons:
        Button singup = findViewById(R.id.singup_button);
        Button singin = findViewById(R.id.login_button);

        //inputs:
        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);

        singup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent GotoSingupActivity = new Intent(MainActivity.this, SingupActivity.class);
                startActivity(GotoSingupActivity);
            }
        });

        singin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username.setError(null);
                password.setError(null);
                if(!Validation.isValidUsername(username.getText().toString())){
                    username.setError("Klaida! Patikrinkite slapyvardi!");
                    username.requestFocus();
                }
                else if(!Validation.isValidPassword(password.getText().toString())){
                    password.setError("Klaida! Patikrinkite slaptazodi!");
                    password.requestFocus();
                }
                else {
                    Intent GotoSearchActivity = new Intent(MainActivity.this, SearchActivity.class);
                    startActivity(GotoSearchActivity);
                }
            }
        });

    }
}