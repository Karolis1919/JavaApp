package com.example.dinnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText username = findViewById(R.id.editText);
        final EditText password = findViewById(R.id.editText2);

        Button loginBtn = findViewById(R.id.button);

        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String username2 = username.getText().toString();
                String password2 = password.getText().toString();
                Toast.makeText(LoginActivity.this, "Username: " + username2 + "\n" + "Password: " + password2, Toast.LENGTH_SHORT).show();

                Intent gotoSearchActivity = new Intent(LoginActivity.this, SearchActivity.class);
                startActivity(gotoSearchActivity);

                username.setError(null);
                password.setError(null);

                if(Validation.isCredentialsValid(username2) && Validation.isCredentialsValid(password2)){
                    Intent gotoSearchActivity = new Intent(LoginActivity.this, SearchActivity.class);
                    startActivity(gotoSearchActivity);
                }else{
                    username.setError(getResources().getString(R.string.login_invalid_credentials_message));
                    username.requestFocus();
                }
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String username2 = username.getText().toString();
                String password2 = password.getText().toString();

                Intent gotoRegisterActivity = new Intent(LoginActivity.this, SearchActivity.class);
                startActivity(gotoRegisterActivity);

                username.setError(null);
                password.setError(null);

                if(Validation.isCredentialsValid(username2) && Validation.isCredentialsValid(password2)){
                    Intent gotoRegisterActivity = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(gotoRegisterActivity);
                }else{
                    username.setError(getResources().getString(R.string.login_invalid_credentials_message));
                    username.requestFocus();
                }
            }
        });
    }
}
