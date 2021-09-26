package com.mobiledeviceinfo.mobiledeviceinfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;

import java.util.List;

public class acceleActivity extends AppCompatActivity {

    SensorManager sm = null;
    TextView textView1 = null;

    AdView mAdView;
    private InterstitialAd mInterstitialAd;
    InterstitialAd interstitialAd;


    List list;
    SensorEventListener sel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accele);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);





        sel = new SensorEventListener(){
            public void onAccuracyChanged(Sensor sensor, int accuracy) {}
            public void onSensorChanged(SensorEvent event) {
                float[] values = event.values;
                textView1.setText("x: "+values[0]+"\ny: "+values[1]+"\nz: "+values[2]);
            }
        };


        sm = (SensorManager)getSystemService(SENSOR_SERVICE);

        textView1 = (TextView)findViewById(R.id.tva);



        list = sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if(list.size()>0){
            sm.registerListener(sel, (Sensor) list.get(0), SensorManager.SENSOR_DELAY_NORMAL);
        }else{
            Toast.makeText(getBaseContext(), "Error: No Accelerometer.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStop() {
        if(list.size()>0){
            sm.unregisterListener(sel);
        }
        super.onStop();
    }



}