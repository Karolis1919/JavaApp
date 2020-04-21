package com.example.dinnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText username = findViewById(R.id.editText3);
        final EditText email = findViewById(R.id.editText4);
        final EditText password = findViewById(R.id.editText5);

        Button registerBtn = findViewById(R.id.button3);

        registerBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String username2 = username.getText().toString();
                String email2 = email.getText().toString();
                String password2 = password.getText().toString();


                Intent gotoLoginActivity = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(gotoLoginActivity);

                username.setError(null);
                email.setError(null);
                password.setError(null);

                if(Validation.isCredentialsValid(username2) && Validation.isCredentialsValid(password2)){
                    Intent gotoLoginActivity = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(gotoLoginActivity);
                }else{
                    username.setError(getResources().getString(R.string.login_invalid_credentials_message));
                    username.requestFocus();
                }

                if(Validation.isCredentialsValid(email2)){
                    Intent gotoLoginActivity = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(gotoLoginActivity);
                }else{
                    email.setError(getResources().getString(R.string.login_invalid_credentials_message));
                    email.requestFocus();
                }
            }
        });
    }
}