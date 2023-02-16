package com.example.loginregisterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class WelcomeScreenActivity extends AppCompatActivity {
    // Public class declaration of Welcome Screen which acts as the splash screen of the demo app of login and register
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(new Intent(WelcomeScreenActivity.this, MainActivity.class));
//                With this intention, it is to bring from the Welcome Screen to the eventual register activity to register an account
                finish();
            }

        }, 2000L);
    }
}