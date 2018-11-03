package com.example.dlarb.helpmybody01.Alarm_bodypart;



import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.example.dlarb.helpmybody01.R;

import java.sql.Time;
import java.util.Calendar;


public class NeckAlarm extends AppCompatActivity {
   private static int ONE_MINUTE = 6000;
    private int min=0;
    private AlarmManager am;
    private Intent intent;
    private PendingIntent ServicePending;

    @Override

    protected void onCreate (Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.alarm_neck);
        Intent intent = getIntent();
       /* new AlarmHATT(getApplicationContext()).Alarm(); */

        String[] minutes = {"20분", "30분", "1시간", "2시간", "취소"};

        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, minutes);
        ListView listView = (ListView) findViewById(R.id.neck_alist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                        if(i==0) {
                            setAlarm();
                        }
                        else if(i==1) {
                            setAlarm2();
                        }
                        else if(i==2) {
                            setAlarm3();
                        }
                        else if(i==3) {
                            setAlarm4();
                        }
                        else {
                            removeAlarm();
                        }


                    }
                });
    }

    void setAlarm(){
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        intent = new Intent(NeckAlarm.this, AlarmReceiver.class);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, (int) System.currentTimeMillis());
        calendar.set(Calendar.MINUTE, (int) System.currentTimeMillis());
        calendar.set(Calendar.SECOND, (int) System.currentTimeMillis());
        ServicePending= PendingIntent.getBroadcast(
                NeckAlarm.this,111,intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Log.d("ServePending: ",""+ServicePending.toString());
        am.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),6000, ServicePending);
        Toast.makeText(getBaseContext(),"알람이 설정되었습니당!",Toast.LENGTH_SHORT).show();

    }
    void setAlarm2(){
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        intent = new Intent(NeckAlarm.this, AlarmReceiver.class);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, (int) System.currentTimeMillis());
        calendar.set(Calendar.MINUTE, (int) System.currentTimeMillis());
        calendar.set(Calendar.SECOND, (int) System.currentTimeMillis());
        ServicePending= PendingIntent.getBroadcast(
                NeckAlarm.this,111,intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Log.d("ServePending: ",""+ServicePending.toString());
        am.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),12000, ServicePending);
        Toast.makeText(getBaseContext(),"알람이 설정되었습니당!",Toast.LENGTH_SHORT).show();
s
    }
    void setAlarm3(){
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        intent = new Intent(NeckAlarm.this, AlarmReceiver.class);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, (int) System.currentTimeMillis());
        calendar.set(Calendar.MINUTE, (int) System.currentTimeMillis());
        calendar.set(Calendar.SECOND, (int) System.currentTimeMillis());
        ServicePending= PendingIntent.getBroadcast(
                NeckAlarm.this,111,intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Log.d("ServePending: ",""+ServicePending.toString());
        am.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),360000*min, ServicePending);
        Toast.makeText(getBaseContext(),"알람이 설정되었습니당!",Toast.LENGTH_SHORT).show();

    }
    void setAlarm4(){
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        intent = new Intent(NeckAlarm.this, AlarmReceiver.class);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, (int) System.currentTimeMillis());
        calendar.set(Calendar.MINUTE, (int) System.currentTimeMillis());
        calendar.set(Calendar.SECOND, (int) System.currentTimeMillis());
        ServicePending= PendingIntent.getBroadcast(
                NeckAlarm.this,111,intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Log.d("ServePending: ",""+ServicePending.toString());
        am.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),720000, ServicePending);
        Toast.makeText(getBaseContext(),"알람이 설정되었습니당!",Toast.LENGTH_SHORT).show();

    }

    void removeAlarm(){
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        intent = new Intent(NeckAlarm.this, AlarmReceiver.class);
        ServicePending = PendingIntent.getBroadcast(
                NeckAlarm.this, 111, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Toast.makeText(getBaseContext(),"알람이 해제되었습니당!",Toast.LENGTH_SHORT).show();

        am.cancel(ServicePending);

    }



/*
    public class AlarmHATT{
        private Context context;
        public AlarmHATT(Context context){
            this.context = context;
        }

        public void Alarm(){
            AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(NeckAlarm.this, BroadcastD.class);


            PendingIntent sender = PendingIntent.getBroadcast(NeckAlarm.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(Calendar.HOUR_OF_DAY, (int) System.currentTimeMillis());
            calendar.set(Calendar.MINUTE, (int) System.currentTimeMillis());
            calendar.set(Calendar.SECOND, (int) System.currentTimeMillis());

            am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), min, sender);
            Toast.makeText(getBaseContext(),"알람이 설정되었습니다.",Toast.LENGTH_SHORT).show();

        }
    }
    */

}
