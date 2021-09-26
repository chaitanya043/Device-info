package com.mobiledeviceinfo.mobiledeviceinfoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class    ChoiceActivity extends AppCompatActivity {

    CardView dev,sense,processor,battery,apps,screen,soft,connec,accele,mag,gyr,z,y,x,u,v,in;
    AdView mAdView;
    private InterstitialAd mInterstitialAd;
    InterstitialAd interstitialAd;

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
        in = findViewById(R.id.ininfo);

        AdRequest adRequest = new AdRequest.Builder().build();



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

                createad();
            }

            private void createad() {

                InterstitialAd.load(ChoiceActivity.this,"ca-app-pub-7557609468922859/2884288565", adRequest, new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {

                        mInterstitialAd = interstitialAd;

                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                Log.d("TAG", "The ad was dismissed.");
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                Log.d("TAG", "The ad failed to show.");
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {

                                mInterstitialAd = null;
                                Log.d("TAG", "The ad was shown.");
                            }
                        });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                    }
                });

            }
        });

        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ChoiceActivity.this);

                }else {

                    Intent netintent = new Intent(ChoiceActivity.this, InternetActivity.class);
                    startActivity(netintent);
                }

            }
        });


        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ChoiceActivity.this);

                }else{

                    Intent appsintent = new Intent(ChoiceActivity.this, OrientationActivity.class);
                        startActivity(appsintent);

                    }

                }


        });



        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ChoiceActivity.this);

                } else {

                    Intent appsintent = new Intent(ChoiceActivity.this, gamerotationActivity.class);
                    startActivity(appsintent);
                }
            }


        });

        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ChoiceActivity.this);


                }else {

                    Intent appsintent = new Intent(ChoiceActivity.this, GravityActivity.class);
                    startActivity(appsintent);
                }

            }
        });

        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ChoiceActivity.this);




                }else {

                        Intent appsintent = new Intent(ChoiceActivity.this, LinearActivity.class);
                        startActivity(appsintent);
                    }
                }


        });

        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ChoiceActivity.this);

                }else {

                    Intent appsintent = new Intent(ChoiceActivity.this, RtvectorActivity.class);
                    startActivity(appsintent);
                }

            }
        });




        gyr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ChoiceActivity.this);


                }else {

                    Intent appsintent = new Intent(ChoiceActivity.this, GyroscopeActivity.class);
                    startActivity(appsintent);
                }

            }
        });



        accele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ChoiceActivity.this);
                }else {

                    Intent appsintent = new Intent(ChoiceActivity.this, acceleActivity.class);
                    startActivity(appsintent);
                }

            }
        });

        mag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ChoiceActivity.this);



                }else {

                    Intent appsintent = new Intent(ChoiceActivity.this, MagActivity.class);
                    startActivity(appsintent);

                }

            }
        });




        connec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ChoiceActivity.this);
                }else {

                    Intent appsintent = new Intent(ChoiceActivity.this, ConnectionActivity.class);
                    startActivity(appsintent);
                }

            }
        });

        soft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ChoiceActivity.this);

                } else {

                    Intent appsintent = new Intent(ChoiceActivity.this, OsActivity.class);
                    startActivity(appsintent);

                }
            }
        });


        screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ChoiceActivity.this);


                }else {

                    Intent appsintent = new Intent(ChoiceActivity.this, ScreenActivity.class);
                    startActivity(appsintent);
                }

            }
        });


        apps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ChoiceActivity.this);

                }else {

                    Intent appsintent = new Intent(ChoiceActivity.this, NetworkActivity.class);
                    startActivity(appsintent);
                }

            }
        });


        battery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ChoiceActivity.this);


                }else {

                    Intent batryintent = new Intent(ChoiceActivity.this, BatteryActivity.class);
                    startActivity(batryintent);
                }

            }
        });


        processor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ChoiceActivity.this);

                }else {

                    Intent proceint = new Intent(ChoiceActivity.this, Processoractivity.class);
                    startActivity(proceint);
                }

            }
        });

        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ChoiceActivity.this);

                }else {

                    Intent senseint = new Intent(ChoiceActivity.this, MainActivity.class);
                    startActivity(senseint);
                }

            }
        });

        sense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ChoiceActivity.this);
                }else {

                    Intent senseint = new Intent(ChoiceActivity.this, SensorActivity.class);
                    startActivity(senseint);
                }


            }
        });



    }
}