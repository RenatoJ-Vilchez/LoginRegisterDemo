package com.example.loginregisterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
// Note that MainActivity should be treated as the choices activity of the project folder

    private Button loginButton,
            registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Information from the layout of activity_main will be connect with this java activity//

        loginButton = (Button) findViewById(R.id.loginButton);

//        Login Button is set to be found through findViewById
        registerButton = (Button) findViewById(R.id.registerButton);

//        Register Button is set to be found through findViewById

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        });
//The user is sent to either to the login or register activity, depending on the button they select//
        //For LoginActivity, there is a connection between the MainActivity and LoginActivity through the
        //startActivity and new Intent. Likewise. the same for the RegisterActivity//
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                finish();
            }
        });
    }
}