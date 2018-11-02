package com.example.dlarb.helpmybody01.Alarm_bodypart.Alarm_min;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import java.util.Calendar;

public class none extends AppCompatActivity {
    private Context context;
    final Intent intent = getIntent();

    public none(Context context) {
        this.context = context;
    }


    public void Alarm() {

        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        PendingIntent sender = PendingIntent.getBroadcast(none.this, 0, intent, 0);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, (int) System.currentTimeMillis());
        calendar.set(Calendar.MINUTE, (int) System.currentTimeMillis());
        calendar.set(Calendar.SECOND, (int) System.currentTimeMillis());

        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 6000 * 20, sender);
    }
}

