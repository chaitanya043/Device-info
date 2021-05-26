package com.deviceinfo.mobiledeviceinfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class gamerotationActivity extends AppCompatActivity {

    SensorManager sm = null;
    TextView textView4 = null;
    List list;
    SensorEventListener sel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamerotation);

        sel = new SensorEventListener(){
            public void onAccuracyChanged(Sensor sensor, int accuracy) {}
            public void onSensorChanged(SensorEvent event) {
                float[] values = event.values;
                textView4.setText("x: "+values[0]+"\ny: "+values[1]+"\nz: "+values[2]);
            }
        };
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);

        textView4 = (TextView)findViewById(R.id.tvd);

        list = sm.getSensorList(Sensor.TYPE_GAME_ROTATION_VECTOR);
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