package com.mobiledeviceinfo.mobiledeviceinfoapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

public class InternetActivity extends AppCompatActivity {
    TextView network;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);

        network = findViewById(R.id.network);


        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            connected = true;

            WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();


                NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
                NetworkCapabilities nc = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());

            int ipAddress = wifiInfo.getIpAddress();
            String ip = String.format("%d.%d.%d.%d", (ipAddress & 0xff),(ipAddress >> 8 & 0xff),(ipAddress >> 16 & 0xff),(ipAddress >> 24 & 0xff));


                network.setText("Ip Adress :" + ip + "\n" +
                        "Mac Adress : " + wifiInfo.getMacAddress() + "\n" +
                        "SSID : " + wifiInfo.getSSID() + "\n" +
                        "BSSID : " + wifiInfo.getBSSID() + "\n" +
                        "Link Speed : " + wifiInfo.getLinkSpeed() + "Mbps" + "\n" +
                        "Frequency : " + wifiInfo.getFrequency() + "Hz"+ "\n" +
                        "RSSI : " + wifiInfo.getRssi() + "\n" +
                        "Download Speed : " + nc.getLinkDownstreamBandwidthKbps() + "Kbps" + "\n" +
                        "Upload Speed : " + nc.getLinkUpstreamBandwidthKbps() + "Kbps" + "\n"

                );
            }else {
                connected = false;


                Toast.makeText(this, "Please Make Sure You Are Connected To Internet", Toast.LENGTH_SHORT).show();


            }
        }



    }
