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
import com.example.dlarb.helpmybody01.bodypart.Neck_Youtube.NeckYoutube1;
import com.example.dlarb.helpmybody01.bodypart.Neck_Youtube.NeckYoutube2;
import com.example.dlarb.helpmybody01.bodypart.Neck_Youtube.NeckYoutube3;
import com.example.dlarb.helpmybody01.bodypart.Neck_Youtube.NeckYoutube4;
import com.example.dlarb.helpmybody01.bodypart.Neck_Youtube.NeckYoutube5;


public class Neck extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.neck_layout);
        Intent intent = getIntent();


        String[] waist_youtube = {"영상1","영상2","영상3","영상4","영상5"};
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,waist_youtube);
        ListView listView = (ListView)findViewById(R.id.neck_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    Class[] Neck_Youtube = new Class[]{NeckYoutube1.class, NeckYoutube2.class, NeckYoutube3.class, NeckYoutube4.class, NeckYoutube5.class};

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getApplicationContext(), Neck_Youtube[position]);
                        startActivity(intent);


                    }

                });
    }
}
