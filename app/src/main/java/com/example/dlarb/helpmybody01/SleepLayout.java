package com.example.dlarb.helpmybody01;

import android.app.DialogFragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Time;


public class SleepLayout extends DialogFragment{

    View v;
    String string1;
    String string2;
    SharedPreferences pref;
    TextView tv;
    TextView tv2;
    int saved =TimePickerFragment.saved;
    int saved2 =TimePickerFragment2.saved;
    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.alarmsleep_layout, container, false);
       Button button = (Button)v.findViewById(R.id.btn);
       Button button2 = (Button)v.findViewById(R.id.btn2);
        tv = (TextView)v.findViewById(R.id.tv);
        tv2 = (TextView)v.findViewById(R.id.tv2);
        pref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor edit = pref.edit();



       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               DialogFragment newFragment = new TimePickerFragment();
               newFragment.show(getFragmentManager(), "TimePicker");
                saved=1;

           }
       });


        if(saved==1) {
            string1 = TimePickerFragment.string;
            edit.putString("save", string1);
            edit.commit();
            String savedstring = pref.getString("save", string1);
            tv.setText(string1);

        }
       button2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               DialogFragment newFragment2 = new TimePickerFragment2();
               newFragment2.show(getFragmentManager(),"TimePicker2");
               saved2=1;
           }
       });

        if(saved2==1) {
            string2 = TimePickerFragment2.string;
            edit.putString("save", string2);
            edit.commit();
            String savedstring = pref.getString("save", string2);
            tv2.setText(string2);

        }
       return v;
    }


}
