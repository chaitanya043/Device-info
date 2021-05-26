package com.deviceinfo.mobiledeviceinfoapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.legacy.content.WakefulBroadcastReceiver;

import android.app.ApplicationErrorReport;
import android.content.Context;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.IntentFilter;
import android.content.Intent;
import android.content.BroadcastReceiver;


public class BatteryActivity extends AppCompatActivity {

    TextView text,text1;
    IntentFilter intentfilter;
    int deviceStatus;
    String currentBatteryStatus="Battery Info";
    int batteryLevel;
    Button button;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);

        text = findViewById(R.id.text);
        text1 = findViewById(R.id.text1);

        intentfilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        button = findViewById(R.id.button);

        BatteryManager bm = (BatteryManager) getSystemService(BATTERY_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            int percentage = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
            text.setText("Battery Percentage is " + percentage + " %");

        }

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                BatteryActivity.this.registerReceiver(broadcastreceiver,intentfilter);

            }
        });

    }

        private BroadcastReceiver broadcastreceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {

                deviceStatus = intent.getIntExtra(BatteryManager.EXTRA_STATUS,-1);
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
                int batteryLevel=(int)(((float)level / (float)scale) * 100.0f);

                if(deviceStatus == BatteryManager.BATTERY_STATUS_CHARGING){

                    text1.setText(currentBatteryStatus+" = Charging at "+batteryLevel+" %");

                }

                if(deviceStatus == BatteryManager.BATTERY_STATUS_DISCHARGING){

                    text1.setText(currentBatteryStatus+" = Discharging at "+batteryLevel+" %");

                }

                if (deviceStatus == BatteryManager.BATTERY_STATUS_FULL){

                    text1.setText(currentBatteryStatus+"= Battery Full at "+batteryLevel+" %");

                }

                if(deviceStatus == BatteryManager.BATTERY_STATUS_UNKNOWN){

                    text1.setText(currentBatteryStatus+" = Unknown at "+batteryLevel+" %");
                }


                if (deviceStatus == BatteryManager.BATTERY_STATUS_NOT_CHARGING){

                    text1.setText(currentBatteryStatus+" = Not Charging at "+batteryLevel+" %");

                }

            }
        };





        }



