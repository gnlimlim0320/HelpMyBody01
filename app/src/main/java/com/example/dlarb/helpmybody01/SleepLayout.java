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
    SharedPreferences pref;
    TextView tv;
    int saved =TimePickerFragment.saved;
    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.alarmsleep_layout, container, false);
       Button button = (Button)v.findViewById(R.id.btn);
       Button button2 = (Button)v.findViewById(R.id.btn2);
       tv = (TextView)v.findViewById(R.id.tv);



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
            pref = PreferenceManager.getDefaultSharedPreferences(getActivity());
            SharedPreferences.Editor edit = pref.edit();
            edit.putString("save", string1);
            edit.commit();
            Log.d("saved", "0");
            String savedstring = pref.getString("save", string1);
            Log.d("get","0");
            tv.setText(string1);

        }
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
