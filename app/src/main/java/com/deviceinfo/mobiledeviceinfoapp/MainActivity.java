package com.deviceinfo.mobiledeviceinfoapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   TextView deviceinfo,manfac,board,display,screensize,model,cpuabi,a,b,c,d,e,f,g,h,i,j;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deviceinfo = findViewById(R.id.device);
        manfac = findViewById(R.id.manufacturer);
        board = findViewById(R.id.Board);
        display = findViewById(R.id.display);
        screensize = findViewById(R.id.screensize);
        model = findViewById(R.id.model);
        cpuabi = findViewById(R.id.CPUABI);

        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        e = findViewById(R.id.e);
        f = findViewById(R.id.f);
        g = findViewById(R.id.g);
        h = findViewById(R.id.h);
        i = findViewById(R.id.i);
        j = findViewById(R.id.j);








        deviceinfo.setText("Brand : " + Build.BRAND);
        manfac.setText("Manufacturer : " + Build.MANUFACTURER);
        board.setText("Board : " + Build.BOARD);
        display.setText("Display : " + Build.DISPLAY);
        model.setText("Model : " + Build.MODEL);
        screensize.setText("User : "+ Build.USER);
        cpuabi.setText("Device : "+ Build.DEVICE);
        b.setText("Hardware : "+ Build.HARDWARE);
        e.setText("Product : "+ Build.PRODUCT);
        f.setText("Serial : "+ Build.SERIAL);
        g.setText("Supported Abis : "+ Build.SUPPORTED_ABIS);
        h.setText("Radio : "+ Build.RADIO);
        i.setText("Type : "+ Build.TYPE);
        j.setText("BootLoader : "+ Build.BOOTLOADER);


    }
}