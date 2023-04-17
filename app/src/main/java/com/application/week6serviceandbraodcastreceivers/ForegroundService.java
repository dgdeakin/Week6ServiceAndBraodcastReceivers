package com.application.week6serviceandbraodcastreceivers;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class ForegroundService extends Service {
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
                        Log.e("Service status", "Foreground Service Running!");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        ).start();



        //Todo: Create Notification Channel

        final String CHANNEL_ID = "Foreground chanel";

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "My Channel", NotificationManager.IMPORTANCE_LOW);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);

            //Todo Notification Builder
            Notification.Builder notification = new Notification.Builder(this, CHANNEL_ID)
                    .setContentTitle("Service is Running")
                    .setContentText("Description of the Notification");


            startForeground(100, notification.build());
        }


        return super.onStartCommand(intent, flags, startId);
    }
}
