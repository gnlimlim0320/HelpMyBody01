package com.example.dlarb.helpmybody01;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.dlarb.helpmybody01.bodypart.All;
import com.example.dlarb.helpmybody01.bodypart.Arm;
import com.example.dlarb.helpmybody01.bodypart.Leg;
import com.example.dlarb.helpmybody01.bodypart.Neck;
import com.example.dlarb.helpmybody01.bodypart.Waist;
import com.example.dlarb.helpmybody01.bodypart.Wrist;


public class YoutubeLayout extends Fragment { // youtube 메뉴. listview를 누르면 해당하게 intent됨
    View v;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.youtube_layout, container, false);
        final String[] items = {"허리","목","손목","팔","다리","전신"};
        final Integer[] images = {R.drawable.waist, R.drawable.neck, R.drawable.wrist, R.drawable.arm,R.drawable.leg,R.drawable.all};
       ListAdapter adapter = new ImageAdapter(getActivity(),items);
        // ListAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
        final ListView listView = (ListView) v.findViewById(R.id.listView);
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    Class[] Activities= new Class[]{Waist.class, Neck.class, Wrist.class, Arm.class, Leg.class, All.class};
                    @Override
                    public void onItemClick(AdapterView<?>parent, View view, int i, long id) {
                        Intent intent = new Intent(getActivity(), Activities[i]);
                        startActivity(intent);

                    }
                });


        return v;
    }

}


