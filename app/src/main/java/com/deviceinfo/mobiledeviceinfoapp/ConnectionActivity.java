package com.deviceinfo.mobiledeviceinfoapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;
import android.widget.TextView;

public class ConnectionActivity extends AppCompatActivity {

    WifiManager mainWifiObj;
    TextView conet;
    private Context context;
    ConnectivityManager cm;
    private Object ConnectivityManager;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkCapabilities nc = cm.getNetworkCapabilities(cm.getActiveNetwork());
         int Downspeed = nc.getLinkDownstreamBandwidthKbps()/1000;
        int Upspeed = nc.getLinkUpstreamBandwidthKbps()/1000;

        conet = findViewById(R.id.conetinfo);


        mainWifiObj = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        String winfo = mainWifiObj.getConnectionInfo().toString();

        String ipAddress = Formatter.formatIpAddress(mainWifiObj.getConnectionInfo().getIpAddress());
         int linkSpeed = mainWifiObj.getConnectionInfo().getLinkSpeed();
         int networkID = mainWifiObj.getConnectionInfo().getNetworkId();
         String ssid = mainWifiObj.getConnectionInfo().getSSID();
         boolean hssid = mainWifiObj.getConnectionInfo().getHiddenSSID();
         String bssid = mainWifiObj.getConnectionInfo().getBSSID();
         String macAddress = mainWifiObj.getConnectionInfo().getMacAddress();
         int networktype = mainWifiObj.getConnectionInfo().getMaxSupportedRxLinkSpeedMbps();
         int frequency = mainWifiObj.getConnectionInfo().getFrequency();
          int Connectionstatus = mainWifiObj.getConnectionInfo().getWifiStandard();

        conet.setText( "IP Address : " +ipAddress+"\n" +
                "Link Speed : " + linkSpeed+ "Mbps" + "\n"+
                "Network ID : " + networkID +"\n" +
                "SSID : " + ssid + "\n" +
                "Hidden SSID : " + hssid +"\n" +
                "BSSID : " + bssid + "\n" +
                "MAC Address : " + macAddress + "\n" +
                "Max Supported LinkSpeed : " + networktype + "Mbps" + "\n" +
                "Frequency : " + frequency + "Hz" + "\n" +
                "Wifi standard : " + Connectionstatus + "\n" +
                "Download Speed : " + Downspeed + "Mbps"+ "\n" +
                "Upload Speed : " + Upspeed +"Mbps "+ "\n");




    }
}