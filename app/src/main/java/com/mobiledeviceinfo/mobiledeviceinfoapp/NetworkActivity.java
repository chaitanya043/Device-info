package com.mobiledeviceinfo.mobiledeviceinfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.text.format.Formatter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.io.File;
import java.text.DecimalFormat;


public class NetworkActivity extends AppCompatActivity {

TextView textView;
TextView listView,listView1,listView2,listView3;
private ProgressBar progressBar;
    private int pStatus = 0;
    private Handler handler = new Handler();
    double i = 0;

    AdView mAdView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        textView = findViewById(R.id.netinfo);
        listView = findViewById(R.id.list);
        listView1 = findViewById(R.id.list1);
        listView2 = findViewById(R.id.list2);
        listView3 = findViewById(R.id.list3);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);









        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long bytesAvailable = (long)stat.getBlockSize() *(long)stat.getBlockCount();
        long megAvailable = bytesAvailable / 1048576;


        textView.setText("Total Internal " +
                "Storage  : " +megAvailable +"MB");

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


        double percentAvail = availableMegs / totalmeg * 100;
        i = percentAvail;

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // set the limitations for the numeric
                // text under the progress bar
                if  (i == (double) percentAvail) {
                    //listView2.setText("" + percentAvail+"%");
                    listView2.setText(new DecimalFormat("##.##").format(percentAvail)+"%");


                    progressBar.setProgress((int) i);
                    handler.postDelayed(this, 30);
                } else {
                    handler.removeCallbacks(this);
                }
            }
        }, 200);
    }

    }


