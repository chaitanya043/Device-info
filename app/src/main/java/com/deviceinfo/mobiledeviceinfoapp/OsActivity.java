package com.deviceinfo.mobiledeviceinfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class OsActivity extends AppCompatActivity {

    TextView a,c,d,k,l,m,n,o;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os);

        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        k = findViewById(R.id.k);
        l = findViewById(R.id.l);
        m = findViewById(R.id.m);
        n = findViewById(R.id.n);
        o = findViewById(R.id.o);

        c.setText("Host : "+ Build.HOST);
        d.setText("Build ID : "+ Build.ID);
        k.setText("Time : "+ Build.TIME);
        l.setText("Tags : "+ Build.TAGS);
        m.setText("Version : "+ Build.VERSION.RELEASE);
        n.setText("Version Name : "+ Build.VERSION.CODENAME);
        o.setText("API Level : "+ Build.VERSION.SDK);



    }
}