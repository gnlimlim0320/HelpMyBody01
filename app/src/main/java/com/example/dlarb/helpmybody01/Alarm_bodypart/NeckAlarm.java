package com.example.dlarb.helpmybody01.Alarm_bodypart;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.dlarb.helpmybody01.R;

import java.util.Calendar;


public class NeckAlarm extends AppCompatActivity {
    private static int ONE_MINUTE=5626;
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.neck_layout);
        Intent intent = getIntent();
        new AlarmNECK(getApplicationContext()).Alarm();
        }

        public class AlarmNECK{
        private Context context;
        public AlarmNECK(Context context){
            this.context=context;
        }
        public void Alarm(){
            AlarmManager am=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(NeckAlarm.this, BroadcastD.class);

            PendingIntent sender = PendingIntent.getBroadcast(NeckAlarm.this,0,intent,0);

            Calendar calendar = Calendar.getInstance();

            calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE),01,40,0);
            am.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),sender);
        }
        }

}
