package com.deviceinfo.mobiledeviceinfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.AccessibilityService;
import android.app.ActivityManager;
import android.content.Context;

import android.media.VolumeShaper;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.List;


public class NetworkActivity extends AppCompatActivity {

TextView textView;
TextView listView,listView1,listView2,listView3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        textView = findViewById(R.id.netinfo);
        listView = findViewById(R.id.list);
        listView1 = findViewById(R.id.list1);
        listView2 = findViewById(R.id.list2);
        listView3 = findViewById(R.id.list3);





        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long bytesAvailable = (long)stat.getBlockSize() *(long)stat.getBlockCount();
        long megAvailable = bytesAvailable / 1048576;


        textView.setText("Total Internal Storage  : " +megAvailable +"MB");

        File path = Environment.getDataDirectory();
        StatFs stat2 = new StatFs(path.getPath());
        long blockSize = stat2.getBlockSize();
        long availableBlocks = stat2.getAvailableBlocks();
        String format =  Formatter.formatFileSize(this, availableBlocks * blockSize);
        listView.setText("Remaining : "+format);

        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(mi);
        double availableMegs = mi.availMem / 0x100000L;
        double totalmeg = mi.totalMem /  0x100000L;

        listView1.setText("RAM Usage Free space : " +availableMegs+"MB");
        listView3.setText("Total RAM : " +totalmeg +"MB");



        double percentAvail = mi.availMem / (double)mi.totalMem * 100.0;

        listView2.setText("Availble percentage off totalMemory : " +percentAvail +"%");


    }


}