package com.example.dlarb.helpmybody01.bodypart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.dlarb.helpmybody01.ImageAdpater.ImageAdapter_waist;
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


        String[] waist_youtube = {"허리 좋아지는 스트레칭 BEST모음","과학적으로 검증된 허리에 좋은 스트레칭 루틴 "};
        ListAdapter adapter = new ImageAdapter_waist(Waist.this,waist_youtube);
        ListView listView = (ListView)findViewById(R.id.waist_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    Class[] Waist_Youtube = new Class[]{WaistYoutube1.class, WaistYoutube2.class};

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getApplicationContext(), Waist_Youtube[position]);
                        startActivity(intent);

                    }

                });
    }
}
