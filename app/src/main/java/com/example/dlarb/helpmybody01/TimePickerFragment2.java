package com.example.dlarb.helpmybody01;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;



public class TimePickerFragment2 extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

    int hour;
    int minute;
    boolean time1 = TimePickerFragment.time1;
    boolean time2;
    public static boolean sleepalarm;
    static String string;
    TextView tv;
    String dn = "오전";
    static int saved=0;




    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
        tv = (TextView) getActivity().findViewById(R.id.tv2);



        // TimePickerDialog tpd = new TimePickerDialog(getActivity(), AlertDialog.THEME_DEVICE_DEFAULT_DARK
        //        ,this, prehour, preminute, DateFormat.is24HourFormat(getActivity()));

        TimePickerDialog tpd = new TimePickerDialog(getActivity(),this,hour,minute,
                DateFormat.is24HourFormat(getActivity()));


        TextView tvTitle = new TextView(getActivity());
        tvTitle.setText("취침모드 종료시간");
        tvTitle.setBackgroundColor(Color.parseColor("#EEE8AA"));
        tvTitle.setPadding(5, 3, 5, 3);
        tvTitle.setGravity(Gravity.CENTER_HORIZONTAL);
        tpd.setCustomTitle(tvTitle);

        return tpd;
    }

    //onTimeSet() callback method
    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
        Calendar datetime = Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        datetime.set(Calendar.HOUR_OF_DAY, hourOfDay);
        datetime.set(Calendar.MINUTE, minute);

        if (datetime.getTimeInMillis() > c.getTimeInMillis()) {
            time2 = false;
        } else {
            time2 = true;
        }

        if(time1==false && time2 == false){ // 다른것은 timepicker와 같지만 여기서 다른 점은 timepickerfragment에서 받아온 변수값이 false이고
                                            // 여기서의 변수도 false여야지만 취침모드가 실행된다는 점. 여기서의 sleepalarm은 alarmreceiver로 넘어감
            sleepalarm = true;
        }
        else{
            sleepalarm = false;
        }



        TextView tv = (TextView) getActivity().findViewById(R.id.tv2);

        if(hourOfDay >11)
        {
            dn="오후";
        }

        int currentHour;
        if(hourOfDay>11 && hourOfDay!=12)
        {
            currentHour = hourOfDay - 12;
        }
        else if(hourOfDay==12){
            currentHour=12;
        }
        else
        {
            currentHour = hourOfDay;
        }

        string = dn+" "+currentHour+"시 "+minute+"분까지는 알람이 울리지 않아요! \n\n";
        tv.setText(string);
        tv.setText(string);
        tv.setFreezesText(true);
        saved=1;

    }
}