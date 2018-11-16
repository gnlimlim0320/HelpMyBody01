package com.example.dlarb.helpmybody01;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.dlarb.helpmybody01.bodypart.All;
import com.example.dlarb.helpmybody01.bodypart.Arm;
import com.example.dlarb.helpmybody01.bodypart.Leg;
import com.example.dlarb.helpmybody01.bodypart.Neck;
import com.example.dlarb.helpmybody01.bodypart.Waist;
import com.example.dlarb.helpmybody01.bodypart.Wrist;

public class SettingsActivity extends android.app.Fragment {
    View v;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.soundsetting, container, false);
        final String[] items = {"알람음1","알람음2"};
        ListAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
        ListView listView = (ListView) v.findViewById(R.id.soundsetlist);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?>parent, View view, int i, long id) {

                    }
                });


        return v;
    }

}


