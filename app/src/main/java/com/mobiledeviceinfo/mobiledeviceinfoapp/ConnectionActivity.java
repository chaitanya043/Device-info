package com.mobiledeviceinfo.mobiledeviceinfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

import android.content.pm.PackageManager;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.List;

public class ConnectionActivity extends AppCompatActivity {


    private ListView tv;
    TextView tv1;
    AdView mAdView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);
        tv = findViewById(R.id.conetinfo);
        tv1 = findViewById(R.id.textViewStatus);




                List<ApplicationInfo> listApplicationInfo = getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);
                String[] stringsList = new String[listApplicationInfo.size()];
                int i =0;
                for (ApplicationInfo applicationInfo : listApplicationInfo) {
                    stringsList[i] = applicationInfo.loadLabel(getPackageManager()).toString();
                    i++;


                }


                tv.setAdapter(new ArrayAdapter<String>(ConnectionActivity.this, android.R.layout.simple_list_item_1, stringsList));
                tv1.setText(listApplicationInfo.size() + " Apps are installed");


                MobileAds.initialize(this, new OnInitializationCompleteListener() {
                    @Override
                    public void onInitializationComplete(InitializationStatus initializationStatus) {
                    }
                });

                mAdView = findViewById(R.id.adView);
                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView.loadAd(adRequest);


            }
        }
