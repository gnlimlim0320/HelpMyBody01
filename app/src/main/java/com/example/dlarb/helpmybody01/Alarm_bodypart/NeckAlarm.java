package com.example.dlarb.helpmybody01.Alarm_bodypart;



import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.dlarb.helpmybody01.Alarm_bodypart.Alarm_min.none;
import com.example.dlarb.helpmybody01.Alarm_bodypart.Alarm_min.onehour;
import com.example.dlarb.helpmybody01.Alarm_bodypart.Alarm_min.thirty;
import com.example.dlarb.helpmybody01.Alarm_bodypart.Alarm_min.twenty;
import com.example.dlarb.helpmybody01.Alarm_bodypart.Alarm_min.twohour;
import com.example.dlarb.helpmybody01.R;

import java.util.Calendar;


public class NeckAlarm extends AppCompatActivity {
   private static int ONE_MINUTE = 6000;
    private int min=0;

    @Override

    protected void onCreate (Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.alarm_neck);
        Intent intent = getIntent();
        new AlarmHATT(getApplicationContext()).Alarm();

        String[] minutes = {"20분", "30분", "1시간", "2시간", "취소"};

        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, minutes);
        ListView listView = (ListView) findViewById(R.id.neck_alist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                        String item = String.valueOf(parent.getItemAtPosition(i));
                        if(i==0) min=6000;
                        else if(i==1) min=12000;
                        else if(i==2) min=60;
                        else if(i==3) min=120;
                        else min=0;

                    }
                });
    }

    public class AlarmHATT{
        private Context context;
        public AlarmHATT(Context context){
            this.context = context;
        }

        public void Alarm(){
            AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(NeckAlarm.this, BroadcastD.class);


            PendingIntent sender = PendingIntent.getBroadcast(NeckAlarm.this, 0, intent, 0);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(Calendar.HOUR_OF_DAY, (int) System.currentTimeMillis());
            calendar.set(Calendar.MINUTE, (int) System.currentTimeMillis());
            calendar.set(Calendar.SECOND, (int) System.currentTimeMillis());

            am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), min, sender);

        }
    }

}
