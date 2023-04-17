package com.application.week6serviceandbraodcastreceivers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button musicPlayActivity, backGroundServiceButton, foreGroundServiceButton;

    MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        musicPlayActivity = findViewById(R.id.buttonMusicActivity);
        backGroundServiceButton = findViewById(R.id.button2);
        foreGroundServiceButton = findViewById(R.id.button3);


        IntentFilter intentFilter = new IntentFilter();

        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        this.registerReceiver(myBroadcastReceiver, intentFilter);


        musicPlayActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MusicPlayerActivity.class));
            }
        });


        backGroundServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(MainActivity.this, BackgroundService.class));
            }
        });

        foreGroundServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(new Intent(MainActivity.this, ForegroundService.class));
                }
            }
        });
    }


}