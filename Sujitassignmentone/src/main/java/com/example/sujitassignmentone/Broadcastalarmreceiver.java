package com.example.sujitassignmentone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

public class Broadcastalarmreceiver extends BroadcastReceiver {
    MediaPlayer mp;
    @Override
    public void onReceive(Context context, Intent intent) {
        mp = (MediaPlayer.create(context, R.raw.morning_tone));
        mp.start();
    }

}
