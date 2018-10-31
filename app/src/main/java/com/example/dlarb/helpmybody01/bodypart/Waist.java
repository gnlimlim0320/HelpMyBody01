package com.example.dlarb.helpmybody01.bodypart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.dlarb.helpmybody01.R;
import com.example.dlarb.helpmybody01.bodypart.Waist_Youtube.WaistYoutube1;
import com.example.dlarb.helpmybody01.bodypart.Waist_Youtube.WaistYoutube2;

public class Waist extends AppCompatActivity {
     View v;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.waist_layout);
        Intent intent = getIntent();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        v = inflater.inflate(R.layout.waist_layout,container,false);

        String[] waist_youtube = {"영상1","영상2"};
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,waist_youtube);
        ListView listView = (ListView)findViewById(R.id.waist_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    Class[] Waist_Youtube=new Class[]{WaistYoutube1.class, WaistYoutube2.class};
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getApplicationContext(), Waist_Youtube[position]);
                        startActivity(intent);

                    }
                }
        );
        return v;
    }

}
