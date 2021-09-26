package com.mobiledeviceinfo.mobiledeviceinfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.content.Context;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class ScreenActivity extends AppCompatActivity {

    private Context context;
    TextView wid,hei,den,dendpi;
    float value = 0;
    AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

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