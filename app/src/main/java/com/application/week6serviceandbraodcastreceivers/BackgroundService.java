package com.application.week6serviceandbraodcastreceivers;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.ThemedSpinnerAdapter;

import androidx.annotation.Nullable;

public class BackgroundService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while(true){
                            Log.e("Service Status", "Background Service is running");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
        ).start();
        return super.onStartCommand(intent, flags, startId);
    }
}
