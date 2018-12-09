package com.example.dlarb.helpmybody01;


import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;
import android.app.DialogFragment;
import android.app.Dialog;

import java.util.Calendar;

import android.widget.TimePicker;


public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    static int hour;
    static int minute;
    static boolean time1;
    static String string;
    TextView tv;
    String dn = "오전";
    static int saved=0;





    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);;
        tv = (TextView) getActivity().findViewById(R.id.tv);


        TimePickerDialog tpd = new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));


        TextView tvTitle = new TextView(getActivity());
        tvTitle.setText("취침모드 시작시간");
        tvTitle.setBackgroundColor(Color.parseColor("#EEE8AA"));
        tvTitle.setPadding(5, 3, 5, 3);
        tvTitle.setGravity(Gravity.CENTER_HORIZONTAL);
        tpd.setCustomTitle(tvTitle);

        return tpd;
    }


    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar datetime = Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        datetime.set(Calendar.HOUR_OF_DAY, hourOfDay);
        datetime.set(Calendar.MINUTE, minute);

        if (datetime.getTimeInMillis() > c.getTimeInMillis()) { // 취침모드 실행을 위한 변수값 입력
            time1 = true;
        } else {
            time1= false;
        }



        if (hourOfDay > 11) { // 이 아래에는 sleeplayout화면에 스트링을 보기 쉽게 보여주기 위해 hour 값을 조정
            dn="오후";
        }

        int currentHour;
        if (hourOfDay > 11 && hourOfDay!=12) {
            currentHour = hourOfDay - 12;
        }
        else if(hourOfDay ==12){
            currentHour = 12;
        }
        else {
            currentHour = hourOfDay;
        }
        string = dn+" "+currentHour+"시 "+minute+"분부터는 알람이 울리지 않아요! \n\n";
        tv = (TextView) getActivity().findViewById(R.id.tv);
        tv.setText(string);
        tv.setFreezesText(true);
        saved=1;


    }

}