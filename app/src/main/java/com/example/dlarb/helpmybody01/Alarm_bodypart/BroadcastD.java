package com.example.dlarb.helpmybody01.Alarm_bodypart;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.dlarb.helpmybody01.R;

public class BroadcastD extends BroadcastReceiver {
    String INTENT_ACTION=Intent.ACTION_BOOT_COMPLETED;
    @Override
    public void onReceive(Context context, Intent intent){
        NotificationManager notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,new Intent(context,NeckAlarm.class),PendingIntent.FLAG_UPDATE_CURRENT);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setSmallIcon(R.drawable.ic_menu_gallery).setTicker("HETT").setWhen(System.currentTimeMillis())
                .setNumber(1).setContentTitle("푸쉬 제목").setContentText("푸쉬내용")
                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE).setContentIntent(pendingIntent).setAutoCancel(true);

        notificationManager.notify(1,builder.getNotification());
    }
}
