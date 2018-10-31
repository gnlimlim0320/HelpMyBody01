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

import com.example.dlarb.helpmybody01.bodypart.All;
import com.example.dlarb.helpmybody01.bodypart.Arm;
import com.example.dlarb.helpmybody01.bodypart.Leg;
import com.example.dlarb.helpmybody01.bodypart.Neck;
import com.example.dlarb.helpmybody01.bodypart.Waist;
import com.example.dlarb.helpmybody01.bodypart.Wrist;

public class YoutubeLayout extends Fragment {
    View v;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.youtube_layout, container, false);

        String[] items = {"허리","목","손목","팔","다리","전신"};

        ListAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
        ListView listView = (ListView) v.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    Class[] Activities= new Class[]{Waist.class, Neck.class, Wrist.class, Arm.class, Leg.class, All.class};

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                        String item = String.valueOf(parent.getItemAtPosition(i));

                        Intent intent = new Intent(getActivity(), Activities[i]);
                        startActivity(intent);


                    }
                }
        );
        return v;
    }
}


