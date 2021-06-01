package com.deviceinfo.mobiledeviceinfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.VolumeShaper;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.content.Context;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;




public class ScreenActivity extends AppCompatActivity {

    private Context context;
    TextView wid,hei,den,dendpi;
    float value = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        wid = findViewById(R.id.width);
        hei = findViewById(R.id.height);
        den = findViewById(R.id.density);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowmanager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        windowmanager.getDefaultDisplay().getMetrics(displayMetrics);
        value = getResources().getDisplayMetrics().density;

        int deviceWidth = displayMetrics.widthPixels;
        int deviceHeight = displayMetrics.heightPixels;

        wid.setText(String.valueOf("Screen Width : "+deviceWidth + "Px"));
        hei.setText(String.valueOf("Screen Height : " +deviceHeight + "Px"));

        value = getResources().getDisplayMetrics().density;
        den.setText("Screen Density = " + String.valueOf(value));





    }

}