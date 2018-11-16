package com.example.dlarb.helpmybody01.Alarm_bodypart;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.example.dlarb.helpmybody01.R;
import com.example.dlarb.helpmybody01.TimePickerFragment;
import com.example.dlarb.helpmybody01.TimePickerFragment2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AlarmReceiver_All extends BroadcastReceiver {

    Context context;
    boolean sleepalarm = TimePickerFragment2.sleepalarm;
    Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
   // Ringtone r= RingtoneManager.getRingtone(context,notification);

    @Override
    public void onReceive(final Context context, Intent intent) {


            this.context = context;
            PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            @SuppressLint("InvalidWakeLockTag") PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
            wakeLock.acquire();

            Log.d("alarm", "ALL gogo");

            PendingIntent pendingIntent;

          if(sleepalarm ==false) {
              Toast toast = Toast.makeText(context, "전신 스트레칭 시간이에요!", Toast.LENGTH_LONG);
              toast.setGravity(Gravity.TOP, 0, 200);
              toast.show();
          }
            wakeLock.release();

             notification();

    }

    void notification(){
        Intent intent = new Intent();
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.all);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_ONE_SHOT);

     if(sleepalarm==false) {
         NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                 .setSmallIcon(R.drawable.all)
                 .setLargeIcon(bitmap)
                 .setContentTitle("전신 스트레칭을 해주세요!")
                 .setContentText("시-작!")
                 .setAutoCancel(true)
                 .setSound(notification)
                 .setContentIntent(pendingIntent);

         NotificationManager notificationManager =
                 (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
         notificationManager.notify(5, notificationBuilder.build());
     }
     else if(sleepalarm==true){}

    }

}
