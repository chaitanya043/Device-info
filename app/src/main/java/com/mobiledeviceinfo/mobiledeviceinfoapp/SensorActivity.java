package com.mobiledeviceinfo.mobiledeviceinfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SensorActivity extends AppCompatActivity {

    SensorManager sensorManager;
    TextView accele, mag, gyro;
    Sensor sensor;
    List list, list1;
    TextView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);


        listView = findViewById(R.id.list);
        List sensorlist = new ArrayList<String>();


        SensorManager sensorManager =
                (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> listSensor =
                sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (int i = 1; i < listSensor.size(); i++) {

            listView.append("\n"+listSensor.get(i).getName());

        }
    }



}




