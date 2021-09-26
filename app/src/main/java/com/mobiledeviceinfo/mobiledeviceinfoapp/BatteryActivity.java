package com.mobiledeviceinfo.mobiledeviceinfoapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.IntentFilter;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class BatteryActivity extends AppCompatActivity {

    TextView text, text1,textr,text3,text4,text5,text6,text7;
    IntentFilter intentfilter;
    int deviceStatus;
    String currentBatteryStatus = "Battery Info";
    int batteryLevel;
    Button button;
    AdView mAdView;
    LinearLayout linearLayout;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);

        linearLayout = findViewById(R.id.blinear);

        linearLayout.setVisibility(View.INVISIBLE);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        text = findViewById(R.id.text);
        text1 = findViewById(R.id.text1);
        textr = findViewById(R.id.textr);
        text4 = findViewById(R.id.text4);
        text5 = findViewById(R.id.text5);
        text6 = findViewById(R.id.text6);
        text7 = findViewById(R.id.text7);


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

                linearLayout.setVisibility(View.VISIBLE);
                BatteryActivity.this.registerReceiver(broadcastreceiver, intentfilter);


            }
        });

    }

    private BroadcastReceiver broadcastreceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            updateBatteryData(intent);


            deviceStatus = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            int batteryLevel = (int) (((float) level / (float) scale) * 100.0f);

            if (deviceStatus == BatteryManager.BATTERY_STATUS_CHARGING) {

                text1.setText(" Battery State :  Charging at " + batteryLevel + " %");

            }

            if (deviceStatus == BatteryManager.BATTERY_STATUS_DISCHARGING) {

                text1.setText(" Battery State :  Discharging at " + batteryLevel + " %");

            }

            if (deviceStatus == BatteryManager.BATTERY_STATUS_FULL) {

                text1.setText(" Battery State :  Battery Full at " + batteryLevel + " %");

            }

            if (deviceStatus == BatteryManager.BATTERY_STATUS_UNKNOWN) {

                text1.setText(" Battery State :  Unknown at " + batteryLevel + " %");


                if (deviceStatus == BatteryManager.BATTERY_STATUS_NOT_CHARGING) {

                    text1.setText(" Battery State :  Not Charging at " + batteryLevel + " %");

                }

            }
        }

    };

    private void updateBatteryData(Intent intent) {
        boolean present = intent.getBooleanExtra(BatteryManager.EXTRA_PRESENT, false);

        if (present) {
            int health = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, 0);
            int healthLbl = -1;

            switch (health) {
                case BatteryManager.BATTERY_HEALTH_COLD:
                    healthLbl = R.string.health;
                    break;

                case BatteryManager.BATTERY_HEALTH_DEAD:
                    healthLbl = R.string.health1;
                    break;

                case BatteryManager.BATTERY_HEALTH_GOOD:
                    healthLbl = R.string.health2;
                    break;

                case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:
                    healthLbl = R.string.health3;
                    break;

                case BatteryManager.BATTERY_HEALTH_OVERHEAT:
                    healthLbl = R.string.health4;
                    break;

                case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:
                    healthLbl = R.string.health5;
                    break;

                case BatteryManager.BATTERY_HEALTH_UNKNOWN:
                default:
                    break;
            }

            if (healthLbl != -1) {
                textr.setText("Health : " + getString(healthLbl));
            }


            /*int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);
            int pluggedLbl = R.string.health6;

            switch (plugged) {
                case BatteryManager.BATTERY_PLUGGED_WIRELESS:
                    pluggedLbl = R.string.health7;
                    break;

                case BatteryManager.BATTERY_PLUGGED_USB:
                    pluggedLbl = R.string.health8;
                    break;

                case BatteryManager.BATTERY_PLUGGED_AC:
                    pluggedLbl = R.string.health9;
                    break;

                default:
                    pluggedLbl = R.string.health10;
                    break;
            }

            // display plugged status ...
            text3.setText("Plugged : " + getString(pluggedLbl));*/


            if (intent.getExtras() != null) {
                String technology = intent.getExtras().getString(BatteryManager.EXTRA_TECHNOLOGY);

                if (!"".equals(technology)) {
                    text4.setText("Technology : " + technology);
                }
            }

            int temperature = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0);

            if (temperature > 0) {
                float temp = ((float) temperature) / 10f;
                text5.setText("Temperature : " + temp + "°C");


                int voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0);

                if (voltage > 0) {
                    text6.setText( "Voltage : " +voltage + " mV");

                }

                long capacity = getBatteryCapacity(this);

                if (capacity > 0) {
                    text7.setText("Capacity : " + capacity + " mAh");
                }

            } else {
                Toast.makeText(this, "No Battery present", Toast.LENGTH_SHORT).show();
            }

        }

    }



    public long getBatteryCapacity(Context ctx) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            BatteryManager mBatteryManager = (BatteryManager) ctx.getSystemService(Context.BATTERY_SERVICE);
            Long chargeCounter = mBatteryManager.getLongProperty(BatteryManager.BATTERY_PROPERTY_CHARGE_COUNTER);
            Long capacity = mBatteryManager.getLongProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);

            if (chargeCounter != null && capacity != null) {
                long value = (long) (((float) chargeCounter / (float) capacity) * 100f);
                return value;
            }
        }

        return 0;
    }



}



