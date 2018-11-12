package com.example.dlarb.helpmybody01;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.text.format.DateFormat;
import android.view.Gravity;
import android.widget.TextView;
import android.app.DialogFragment;
import android.app.Dialog;
import java.util.Calendar;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.dlarb.helpmybody01.Alarm_bodypart.AlarmReceiver_All;
import com.example.dlarb.helpmybody01.Alarm_bodypart.AlarmReceiver_Arm;
import com.example.dlarb.helpmybody01.Alarm_bodypart.AlarmReceiver_Leg;
import com.example.dlarb.helpmybody01.Alarm_bodypart.AlarmReceiver_Neck;
import com.example.dlarb.helpmybody01.Alarm_bodypart.AlarmReceiver_Waist;
import com.example.dlarb.helpmybody01.Alarm_bodypart.AlarmReceiver_Wrist;
import com.example.dlarb.helpmybody01.Alarm_bodypart.AllAlarm;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{
    static int hour;
    static int minute;
    private AlarmManager am = null;
    private Intent intent;
    private PendingIntent pendingIntent;
 //   PendingIntent pendingIntent;
  //  final Intent intent = new Intent(getActivity(), SleepAlarmReceiver.class);

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
    //    pendingIntent = PendingIntent.getBroadcast(getActivity(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);


        TimePickerDialog tpd = new TimePickerDialog(getActivity(), AlertDialog.THEME_DEVICE_DEFAULT_DARK
                ,this, hour, minute, DateFormat.is24HourFormat(getActivity()));

        TextView tvTitle = new TextView(getActivity());
        tvTitle.setText("취침모드 시작시간");
        tvTitle.setBackgroundColor(Color.parseColor("#EEE8AA"));
        tvTitle.setPadding(5, 3, 5, 3);
        tvTitle.setGravity(Gravity.CENTER_HORIZONTAL);
        tpd.setCustomTitle(tvTitle);

       // intent.putExtra("state","alarm off");
        //sendBroadcast(intent);
        return tpd;
    }



    public void onTimeSet(TimePicker view, int hourOfDay, int minute){

        TextView tv = (TextView) getActivity().findViewById(R.id.tv);

        String aMpM = "AM";
        if(hourOfDay >11)
        {
            aMpM = "PM";
        }

        int currentHour;
        if(hourOfDay>11)
        {
            currentHour = hourOfDay - 12;
        }
        else
        {
            currentHour = hourOfDay;
        }

        tv.setText("잘자요!\n\n");
        tv.setText(tv.getText()+ String.valueOf(currentHour)
                + " : " + String.valueOf(minute) + " " + aMpM + "\n");

    }

}