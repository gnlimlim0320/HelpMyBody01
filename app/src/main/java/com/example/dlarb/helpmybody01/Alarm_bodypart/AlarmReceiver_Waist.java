package com.example.dlarb.helpmybody01.Alarm_bodypart;

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

import com.example.dlarb.helpmybody01.PointActivity;
import com.example.dlarb.helpmybody01.R;
import com.example.dlarb.helpmybody01.SettingsActivity;
import com.example.dlarb.helpmybody01.TimePickerFragment2;

public class AlarmReceiver_Waist extends BroadcastReceiver {

    Context context;
    boolean sleepalarm = TimePickerFragment2.sleepalarm;
    Uri uri = SettingsActivity.myUri;
    int soundchange = 0;


    @Override
    public void onReceive(final Context context, Intent intent){
        soundchange = SettingsActivity.soundchange;
        this.context = context;
        PowerManager powerManager=(PowerManager)context.getSystemService(Context.POWER_SERVICE);
        @SuppressLint("InvalidWakeLockTag") PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"");
        wakeLock.acquire();

        Log.d("alarm","WAIST gogo");

        PendingIntent pendingIntent;

        Toast toast = Toast.makeText(context,"허리 스트레칭 시간이에요!",Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP,0,200);
        toast.show();

        wakeLock.release();
        notification();
    }

    void notification(){
        Intent intent = new Intent();
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.waist);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_ONE_SHOT);

        if(sleepalarm==false) {
            Intent intent1 = new Intent(context,PointActivity.class);
            PendingIntent pi = PendingIntent.getActivity(context, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
            if(soundchange==0) {
                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.waist)
                        .setLargeIcon(bitmap)
                        .setContentTitle("허리 스트레칭을 해주세요!")
                        .setContentText("상체를 좌우로 회전해 주세요!")
                        .setAutoCancel(true)
                        .setSound(soundUri)
                        .setContentIntent(pi);

                NotificationManager notificationManager =
                        (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0, notificationBuilder.build());

            }
            else if(soundchange==1){
                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.waist)
                        .setLargeIcon(bitmap)
                        .setContentTitle("허리 스트레칭을 해주세요!")
                        .setContentText("상체를 좌우로 회전해 주세요!")
                        .setAutoCancel(true)
                        .setSound(uri)
                        .setContentIntent(pi);

                NotificationManager notificationManager =
                        (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0, notificationBuilder.build());

            }
        }
        else if(sleepalarm==true){}
    }
}
