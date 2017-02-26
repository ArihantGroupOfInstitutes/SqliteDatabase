package com.sachinshelke.sqlitedatabase;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navigateToLoginScreen();
            }
        }, 7000);


    }


    private void navigateToLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);

        startActivity(intent);
        finish();
    }


}
