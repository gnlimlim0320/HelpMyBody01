package com.example.dlarb.helpmybody01.Alarm_bodypart;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.example.dlarb.helpmybody01.TimePickerFragment2;

public class AlarmReceiver_Neck extends BroadcastReceiver {

    Context context;
    boolean sleepalarm = TimePickerFragment2.sleepalarm;


    @Override
    public void onReceive(final Context context, Intent intent){
        this.context = context;
      //  SharedPreferences sharedPreferences = context.getSharedPreferences("myref",Context.MODE_PRIVATE);
        PowerManager powerManager=(PowerManager)context.getSystemService(Context.POWER_SERVICE);
        @SuppressLint("InvalidWakeLockTag") PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"");
        wakeLock.acquire();

        Log.d("alarm","NECK gogo");

        PendingIntent pendingIntent;

        Toast toast = Toast.makeText(context,"목 스트레칭 시간이에요!",Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP,0,200);
        toast.show();

        wakeLock.release();
        notification();



    }

    void notification() {
        Intent intent = new Intent();
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), android.R.drawable.ic_menu_gallery);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_ONE_SHOT);


        if (sleepalarm == false) {
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                    .setSmallIcon(android.R.drawable.ic_menu_gallery)
                    .setLargeIcon(bitmap)
                    .setContentTitle("목 스트레칭을 해주세요!")
                    .setContentText("시-작!")
                    .setAutoCancel(true)
                    .setSound(soundUri)
                    .setContentIntent(pendingIntent);

            NotificationManager notificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(1, notificationBuilder.build());

        }
        else if(sleepalarm==true){}
    }

}
