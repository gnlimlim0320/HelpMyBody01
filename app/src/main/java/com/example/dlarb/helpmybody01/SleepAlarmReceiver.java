package com.example.dlarb.helpmybody01;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

public class SleepAlarmReceiver extends BroadcastReceiver {
    Context context;

    @Override
    public void onReceive(final Context context, Intent intent){
        this.context = context;
        PowerManager powerManager=(PowerManager)context.getSystemService(Context.POWER_SERVICE);
        @SuppressLint("InvalidWakeLockTag") PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"");
        wakeLock.acquire();

        Log.d("alarm","^^");


        Toast toast = Toast.makeText(context,"전신 스트레칭 시간이에요!",Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP,0,200);
        toast.show();

        wakeLock.release();
    }
}

