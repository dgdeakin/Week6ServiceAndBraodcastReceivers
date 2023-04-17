package com.application.week6serviceandbraodcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.


//        throw new UnsupportedOperationException("Not yet implemented");


        if(intent.getAction() != null){
            if(intent.getAction() == Intent.ACTION_POWER_CONNECTED){
                Log.i("Battery Charging Status", "Power Connected");
            }
            else if(intent.getAction() == intent.ACTION_POWER_DISCONNECTED)
            {
                Log.i("Battery Charging Status", "Power Disconnected");
            }
        }
    }
}