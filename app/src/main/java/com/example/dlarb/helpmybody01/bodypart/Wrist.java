package com.example.dlarb.helpmybody01.bodypart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.dlarb.helpmybody01.R;
import com.example.dlarb.helpmybody01.bodypart.Waist_Youtube.WaistYoutube1;
import com.example.dlarb.helpmybody01.bodypart.Waist_Youtube.WaistYoutube2;
import com.example.dlarb.helpmybody01.bodypart.Wrist_Youtube.WristYoutube1;
import com.example.dlarb.helpmybody01.bodypart.Wrist_Youtube.WristYoutube2;

public class Wrist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.wrist_layout);
        Intent intent = getIntent();

        String[] waist_youtube = {"영상1","영상2"};
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,waist_youtube);
        ListView listView = (ListView)findViewById(R.id.wrist_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    Class[] Wrist_Youtube = new Class[]{WristYoutube1.class, WristYoutube2.class};

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getApplicationContext(), Wrist_Youtube[position]);
                        startActivity(intent);

                    }

                });
    }

}
