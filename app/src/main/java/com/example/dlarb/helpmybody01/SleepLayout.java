package com.example.dlarb.helpmybody01;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dlarb.helpmybody01.R;
import com.example.dlarb.helpmybody01.TimePickerFragment;

public class SleepLayout extends DialogFragment{

    static final int DIALOG_ID=0;
    int hour_x;
    int minute_x;
    View v;
    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
    }
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.alarmsleep_layout, container, false);
       Button button = (Button)v.findViewById(R.id.btn);
       Button button2 = (Button)v.findViewById(R.id.btn2);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               DialogFragment newFragment = new TimePickerFragment();
               newFragment.show(getFragmentManager(), "TimePicker");
           }
       });
       button2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               DialogFragment newFragment2 = new TimePickerFragment2();
               newFragment2.show(getFragmentManager(),"TimePicker2");
           }
       });
       return v;
    }
}