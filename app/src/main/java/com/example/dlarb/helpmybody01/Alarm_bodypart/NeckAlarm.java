package com.example.dlarb.helpmybody01.Alarm_bodypart;



import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.dlarb.helpmybody01.R;
import java.util.Calendar;


public class NeckAlarm extends AppCompatActivity {
    Context context;
    private int min = 0;
    private AlarmManager am = null;
    private Intent intent;
    SharedPreferences sharedPreferences = context.getSharedPreferences("myref",Context.MODE_PRIVATE);

    private PendingIntent ServicePending = null;
    int interval;

    @Override

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.alarm_neck);
        Intent intent = getIntent();

        String[] minutes = {"20분", "30분", "1시간", "2시간", "취소"};

        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, minutes);
        ListView listView = (ListView) findViewById(R.id.neck_alist);
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
        intent = new Intent(NeckAlarm.this, AlarmReceiver_Neck.class);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, (int) System.currentTimeMillis());
        calendar.set(Calendar.MINUTE, (int) System.currentTimeMillis());
        calendar.set(Calendar.SECOND, (int) System.currentTimeMillis());
        ServicePending = PendingIntent.getBroadcast(
                NeckAlarm.this, 111, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Log.d("ServePending: ", "" + ServicePending.toString());

        try {
            am.cancel(ServicePending);
        } catch (Exception ignored) {
        }
        am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(), 6000 * 20, ServicePending);
        Toast.makeText(getBaseContext(), "알람이 설정되었습니당!", Toast.LENGTH_SHORT).show();

        TextView alltext = (TextView) findViewById(R.id.existalarm_neck);
        String string = "알람이 설정되어있습니다! (20분)";
        alltext.setText(string);
        interval = 6000*20;
        SaveData();
    }

    void setAlarm2() {
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        intent = new Intent(NeckAlarm.this, AlarmReceiver_Neck.class);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, (int) System.currentTimeMillis());
        calendar.set(Calendar.MINUTE, (int) System.currentTimeMillis());
        calendar.set(Calendar.SECOND, (int) System.currentTimeMillis());
        ServicePending = PendingIntent.getBroadcast(
                NeckAlarm.this, 111, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Log.d("ServePending: ", "" + ServicePending.toString());
        try {
            am.cancel(ServicePending);
        } catch (Exception ignored) {
        }
        am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(), 6000 * 30, ServicePending);
        Toast.makeText(getBaseContext(), "알람이 설정되었습니당!", Toast.LENGTH_SHORT).show();
        TextView alltext = (TextView) findViewById(R.id.existalarm_neck);
        String string = "알람이 설정되어있습니다! (30분)";
        alltext.setText(string);
        interval = 6000*30;
        SaveData();
    }

    void setAlarm3() {
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        intent = new Intent(NeckAlarm.this, AlarmReceiver_Neck.class);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, (int) System.currentTimeMillis());
        calendar.set(Calendar.MINUTE, (int) System.currentTimeMillis());
        calendar.set(Calendar.SECOND, (int) System.currentTimeMillis());
        ServicePending = PendingIntent.getBroadcast(
                NeckAlarm.this, 111, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Log.d("ServePending: ", "" + ServicePending.toString());
        try {
            am.cancel(ServicePending);
        } catch (Exception ignored) {
        }
        am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(), 6000 * 60, ServicePending);
        Toast.makeText(getBaseContext(), "알람이 설정되었습니당!", Toast.LENGTH_SHORT).show();
        TextView alltext = (TextView) findViewById(R.id.existalarm_neck);
        String string = "알람이 설정되어있습니다! (1시간)";
        alltext.setText(string);
        interval = 6000*60;
        SaveData();
    }

    void setAlarm4() {
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        intent = new Intent(NeckAlarm.this, AlarmReceiver_Neck.class);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, (int) System.currentTimeMillis());
        calendar.set(Calendar.MINUTE, (int) System.currentTimeMillis());
        calendar.set(Calendar.SECOND, (int) System.currentTimeMillis());
        ServicePending = PendingIntent.getBroadcast(
                NeckAlarm.this, 111, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Log.d("ServePending: ", "" + ServicePending.toString());
        try {
            am.cancel(ServicePending);
        } catch (Exception ignored) {
        }
        am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(), 6000 * 120, ServicePending);
        Toast.makeText(getBaseContext(), "알람이 설정되었습니당!", Toast.LENGTH_SHORT).show();
        TextView alltext = (TextView) findViewById(R.id.existalarm_neck);
        String string = "알람이 설정되어있습니다! (2시간)";
        alltext.setText(string);
        interval = 6000*120;
        SaveData();

    }

    void removeAlarm() {
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        intent = new Intent(NeckAlarm.this, AlarmReceiver_Neck.class);
        ServicePending = PendingIntent.getBroadcast(
                NeckAlarm.this, 111, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Toast.makeText(getBaseContext(), "알람이 해제되었습니당!", Toast.LENGTH_SHORT).show();

        am.cancel(ServicePending);
        TextView alltext = (TextView) findViewById(R.id.existalarm_neck);
        String string = "알람 설정이 되어 있지 않습니다";
        alltext.setText(string);
        interval=0;
        SaveData();
    }

    void SaveData(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("interval",interval);
        editor.commit();
    }

    int getNeckInt()
    {
      return sharedPreferences.getInt("interval",0);
    }

}