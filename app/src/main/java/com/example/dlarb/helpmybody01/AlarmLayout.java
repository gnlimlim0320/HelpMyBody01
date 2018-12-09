package com.example.dlarb.helpmybody01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dlarb.helpmybody01.Alarm_bodypart.AllAlarm;
import com.example.dlarb.helpmybody01.Alarm_bodypart.ArmAlarm;
import com.example.dlarb.helpmybody01.Alarm_bodypart.LegAlarm;
import com.example.dlarb.helpmybody01.Alarm_bodypart.NeckAlarm;
import com.example.dlarb.helpmybody01.Alarm_bodypart.WaistAlarm;
import com.example.dlarb.helpmybody01.Alarm_bodypart.WristAlarm;

public class AlarmLayout extends Fragment { // 알람 메뉴에서 각 해당하는 신체부위 클래스를 intent 넘겨주기 위한 클래스.
    View v;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.alarm_layout,container,false);

        String[] items = {"허리 알람","목 알람","손목 알람","팔 알람","다리 알람","전신 알람"};

        ListAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
        ListView listView = (ListView) v.findViewById(R.id.alarm_list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    Class[] Alarm_Activities= new Class[]{WaistAlarm.class, NeckAlarm.class,WristAlarm.class, ArmAlarm.class, LegAlarm.class, AllAlarm.class};

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
