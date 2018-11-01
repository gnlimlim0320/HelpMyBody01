package com.example.dlarb.helpmybody01;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.dlarb.helpmybody01.Alarm_bodypart.NeckAlarm;
import com.example.dlarb.helpmybody01.Alarm_bodypart.WaistAlarm;
import com.example.dlarb.helpmybody01.bodypart.All;
import com.example.dlarb.helpmybody01.bodypart.Arm;
import com.example.dlarb.helpmybody01.bodypart.Leg;
import com.example.dlarb.helpmybody01.bodypart.Neck;
import com.example.dlarb.helpmybody01.bodypart.Waist;
import com.example.dlarb.helpmybody01.bodypart.Wrist;

public class AlarmLayout extends Fragment {
    View v;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.alarm_layout,container,false);

        String[] items = {"허리","목"};

        ListAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
        ListView listView = (ListView) v.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    Class[] Alarm_Activities= new Class[]{WaistAlarm.class, NeckAlarm.class};

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                        String item = String.valueOf(parent.getItemAtPosition(i));

                        Intent intent = new Intent(getActivity(), Alarm_Activities[i]);
                        startActivity(intent);


                    }
                }
        );



        return v;
    }
}
