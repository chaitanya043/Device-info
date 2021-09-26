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

import java.util.List;

public class RtvectorActivity extends AppCompatActivity {


    SensorManager sm = null;
    TextView textView7 = null;
    List list;
    SensorEventListener sel;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtvector);

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
                textView7.setText("x: "+values[0]+"\ny: "+values[1]+"\nz: "+values[2]);
            }
        };
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);

        textView7 = (TextView)findViewById(R.id.tvg);

        list = sm.getSensorList(Sensor.TYPE_ROTATION_VECTOR);
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