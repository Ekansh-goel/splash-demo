package com.example.splash_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static java.lang.Thread.sleep;

public class splash extends AppCompatActivity {
//change the starting activity in AndroidManifest files from main activity to splash .

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread th = new Thread() {
            @Override
            //creating the splash screen
            public void run() {
                super.run();
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(splash.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        th.start();
    }

    //so that splash activity is not again displayed
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
