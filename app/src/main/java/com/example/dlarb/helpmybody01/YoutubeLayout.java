package com.example.dlarb.helpmybody01;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                        String item = String.valueOf(parent.getItemAtPosition(i));

                        if(i==1){
                            Intent intent = new Intent(getActivity(), Waist.class);
                            startActivity(intent);
                        }
                        else if(i==2) {
                            Intent intent = new Intent(getActivity(), Neck.class);
                            startActivity(intent);
                        }
                        else if(i==3) {
                            Intent intent = new Intent(getActivity(), Wrist.class);
                            startActivity(intent);
                        }
                        else if(i==4) {
                            Intent intent = new Intent(getActivity(), Arm.class);
                            startActivity(intent);
                        }
                        else if(i==5) {
                            Intent intent = new Intent(getActivity(), Leg.class);
                            startActivity(intent);
                        }
                        else if(i==6) {
                            Intent intent = new Intent(getActivity(), All.class);
                            startActivity(intent);
                        }
                    }
                }
        );
        return v;
    }
}


