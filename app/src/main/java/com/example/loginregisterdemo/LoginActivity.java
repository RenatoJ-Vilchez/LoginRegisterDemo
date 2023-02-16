package com.example.loginregisterdemo;

import static com.example.loginregisterdemo.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(layout.activity_login);
//Information will be based from the activity_login XMl file//

        TextView username =(TextView) findViewById(R.id.usernameField);
        TextView password =(TextView) findViewById(R.id.passwordField);

        Button loginButton = (Button) findViewById(id.loginButton);

        //Text View username and passwords connected with the declared Android IDs in the activity login XML

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){

                    Toast.makeText(LoginActivity.this,"You are now logged in",Toast.LENGTH_SHORT).show();
                }else
//Message from system that indicates to the user their login attempt has been a success//
                    Toast.makeText(LoginActivity.this,"Login has not worked. Please try again",Toast.LENGTH_SHORT).show();
            }
        });
//Message from system that indicates to the user their login attempt has been a failure and to try again//

    }
}