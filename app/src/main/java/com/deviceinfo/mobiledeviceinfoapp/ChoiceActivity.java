package com.deviceinfo.mobiledeviceinfoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class    ChoiceActivity extends AppCompatActivity {

    CardView dev,sense,processor,battery,apps,screen,soft,connec,accele,mag,gyr,z,y,x,u,v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        dev = findViewById(R.id.dev);
        sense = findViewById(R.id.sense);
        processor = findViewById(R.id.processor);
        battery = findViewById(R.id.battery);
        apps = findViewById(R.id.Apps);
        screen = findViewById(R.id.screen);
        soft = findViewById(R.id.soft);
        connec = findViewById(R.id.connection);
        accele = findViewById(R.id.accele);
        mag = findViewById(R.id.mag);
        gyr = findViewById(R.id.gyr);
        z = findViewById(R.id.z);
        y = findViewById(R.id.y);
        x = findViewById(R.id.x);
        u = findViewById(R.id.u);
        v = findViewById(R.id.v);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent appsintent = new Intent(ChoiceActivity.this,OrientationActivity.class);
                startActivity(appsintent);

            }
        });



        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent appsintent = new Intent(ChoiceActivity.this,gamerotationActivity.class);
                startActivity(appsintent);

            }
        });

        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent appsintent = new Intent(ChoiceActivity.this,GravityActivity.class);
                startActivity(appsintent);

            }
        });

        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent appsintent = new Intent(ChoiceActivity.this,LinearActivity.class);
                startActivity(appsintent);

            }
        });

        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent appsintent = new Intent(ChoiceActivity.this,RtvectorActivity.class);
                startActivity(appsintent);

            }
        });




        gyr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent appsintent = new Intent(ChoiceActivity.this,GyroscopeActivity.class);
                startActivity(appsintent);

            }
        });



        accele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent appsintent = new Intent(ChoiceActivity.this,acceleActivity.class);
                startActivity(appsintent);

            }
        });

        mag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent appsintent = new Intent(ChoiceActivity.this,MagActivity.class);
                startActivity(appsintent);

            }
        });




        connec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent appsintent = new Intent(ChoiceActivity.this,ConnectionActivity.class);
                startActivity(appsintent);

            }
        });

        soft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent appsintent = new Intent(ChoiceActivity.this,OsActivity.class);
                startActivity(appsintent);

            }
        });


        screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent appsintent = new Intent(ChoiceActivity.this,ScreenActivity.class);
                startActivity(appsintent);

            }
        });


        apps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent appsintent = new Intent(ChoiceActivity.this,NetworkActivity.class);
                startActivity(appsintent);

            }
        });


        battery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent batryintent = new Intent(ChoiceActivity.this,BatteryActivity.class);
                startActivity(batryintent);

            }
        });


        processor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent proceint = new Intent(ChoiceActivity.this,Processoractivity.class);
                startActivity(proceint);

            }
        });

        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent senseint = new Intent(ChoiceActivity.this,MainActivity.class);
                startActivity(senseint);

            }
        });

        sense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent senseint = new Intent(ChoiceActivity.this,SensorActivity.class);
                startActivity(senseint);


            }
        });



    }
}