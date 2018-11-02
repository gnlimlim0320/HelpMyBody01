package com.example.dlarb.helpmybody01.Alarm_bodypart.Alarm_min;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.dlarb.helpmybody01.Alarm_bodypart.BroadcastD;

import java.util.Calendar;

public class thirty extends AppCompatActivity {
    private Context context;
    final Intent intent = getIntent();
    private static int ONE_MINUTE = 6000;


    public thirty(Context context) {
        this.context = context;
    }


    public void Alarm() {

        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(thirty.this, BroadcastD.class);

        PendingIntent sender = PendingIntent.getBroadcast(thirty.this, 0, intent, 0);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, (int) System.currentTimeMillis());
        calendar.set(Calendar.MINUTE, (int) System.currentTimeMillis());
        calendar.set(Calendar.SECOND, (int) System.currentTimeMillis());

        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 6000 * 2, sender);
    }
}

