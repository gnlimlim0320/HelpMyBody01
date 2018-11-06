package com.example.dlarb.helpmybody01.Alarm_bodypart;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dlarb.helpmybody01.R;

import java.util.Calendar;


public class LegAlarm extends AppCompatActivity {
    private int min = 0;
    private AlarmManager am = null;
    private Intent intent;
    private PendingIntent ServicePending = null;

    @Override

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.alarm_leg);
        Intent intent = getIntent();

        String[] minutes = {"20분", "30분", "1시간", "2시간", "취소"};

        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, minutes);
        ListView listView = (ListView) findViewById(R.id.leg_alist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                        if (i == 0) {
                            setAlarm();
                        } else if (i == 1) {
                            setAlarm2();
                        } else if (i == 2) {
                            setAlarm3();
                        } else if (i == 3) {
                            setAlarm4();
                        } else {
                            removeAlarm();
                        }


                    }
                });
    }

    void setAlarm() {
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        intent = new Intent(LegAlarm.this, AlarmReceiver_Leg.class);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, (int) System.currentTimeMillis());
        calendar.set(Calendar.MINUTE, (int) System.currentTimeMillis());
        calendar.set(Calendar.SECOND, (int) System.currentTimeMillis());
        ServicePending = PendingIntent.getBroadcast(
                LegAlarm.this, 555, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Log.d("ServePending: ", "" + ServicePending.toString());

        try {
            am.cancel(ServicePending);
        } catch (Exception ignored) {
        }
        am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(), 6000 * 20, ServicePending);
        Toast.makeText(getBaseContext(), "알람이 설정되었습니당!", Toast.LENGTH_SHORT).show();

    }

    void setAlarm2() {
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        intent = new Intent(LegAlarm.this, AlarmReceiver_Leg.class);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, (int) System.currentTimeMillis());
        calendar.set(Calendar.MINUTE, (int) System.currentTimeMillis());
        calendar.set(Calendar.SECOND, (int) System.currentTimeMillis());
        ServicePending = PendingIntent.getBroadcast(
                LegAlarm.this, 555, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Log.d("ServePending: ", "" + ServicePending.toString());
        try {
            am.cancel(ServicePending);
        } catch (Exception ignored) {
        }
        am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(), 6000 * 30, ServicePending);
        Toast.makeText(getBaseContext(), "알람이 설정되었습니당!", Toast.LENGTH_SHORT).show();

    }

    void setAlarm3() {
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        intent = new Intent(LegAlarm.this, AlarmReceiver_Leg.class);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, (int) System.currentTimeMillis());
        calendar.set(Calendar.MINUTE, (int) System.currentTimeMillis());
        calendar.set(Calendar.SECOND, (int) System.currentTimeMillis());
        ServicePending = PendingIntent.getBroadcast(
                LegAlarm.this, 555, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Log.d("ServePending: ", "" + ServicePending.toString());
        try {
            am.cancel(ServicePending);
        } catch (Exception ignored) {
        }
        am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(), 6000 * 60, ServicePending);
        Toast.makeText(getBaseContext(), "알람이 설정되었습니당!", Toast.LENGTH_SHORT).show();

    }

    void setAlarm4() {
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        intent = new Intent(LegAlarm.this, AlarmReceiver_Leg.class);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, (int) System.currentTimeMillis());
        calendar.set(Calendar.MINUTE, (int) System.currentTimeMillis());
        calendar.set(Calendar.SECOND, (int) System.currentTimeMillis());
        ServicePending = PendingIntent.getBroadcast(
                LegAlarm.this, 555, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Log.d("ServePending: ", "" + ServicePending.toString());
        try {
            am.cancel(ServicePending);
        } catch (Exception ignored) {
        }
        am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(), 6000 * 120, ServicePending);
        Toast.makeText(getBaseContext(), "알람이 설정되었습니당!", Toast.LENGTH_SHORT).show();

    }

    void removeAlarm() {
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        intent = new Intent(LegAlarm.this, AlarmReceiver_Leg.class);
        ServicePending = PendingIntent.getBroadcast(
                LegAlarm.this, 555, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Toast.makeText(getBaseContext(), "알람이 해제되었습니당!", Toast.LENGTH_SHORT).show();

        am.cancel(ServicePending);

    }
}


