package com.mobiledeviceinfo.mobiledeviceinfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.content.Intent;

public class SplashActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView = findViewById(R.id.image);


        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(1500);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent openStartingPoint = new Intent(SplashActivity.this,ChoiceActivity.class);
                    startActivity(openStartingPoint);
                    finish();

                }
            }
        };
        timer.start();

    }
    }
