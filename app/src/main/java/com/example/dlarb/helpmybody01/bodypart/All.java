package com.example.dlarb.helpmybody01.bodypart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.dlarb.helpmybody01.ImageAdpater.ImageAdapter_all;
import com.example.dlarb.helpmybody01.ImageAdpater.ImageAdapter_leg;
import com.example.dlarb.helpmybody01.R;
import com.example.dlarb.helpmybody01.bodypart.All_Youtube.AllYoutube1;
import com.example.dlarb.helpmybody01.bodypart.All_Youtube.AllYoutube2;
import com.example.dlarb.helpmybody01.bodypart.All_Youtube.AllYoutube3;
import com.example.dlarb.helpmybody01.bodypart.All_Youtube.AllYoutube4;
import com.example.dlarb.helpmybody01.bodypart.All_Youtube.AllYoutube5;
import com.example.dlarb.helpmybody01.bodypart.All_Youtube.AllYoutube6;
import com.example.dlarb.helpmybody01.bodypart.Leg_Youtube.LegYoutube1;

public class All extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.all_layout);
        Intent intent = getIntent();


        String[] all_youtube = {"데일리 전신스트레칭 (상체.하체 요약)","초간단! 전신 스트레칭 끝판왕 BEST5",
                "[Playing Pilates]전신 스트레칭 10 min★Full Body Stretch",
                "전신스트레칭! 완선생님의 정밀하게 구체적인 전신스트레칭~",
                "[무나홈트]함께하는 전신운동 / 스트레칭 포함 풀세트 운동 / 복부자극","매트없이!어디서든! 서서하는 전신스트레칭!"};
        ListAdapter adapter = new ImageAdapter_all(All.this,all_youtube);
        ListView listView = (ListView)findViewById(R.id.all_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    Class[] All_Youtube = new Class[]{AllYoutube1.class,AllYoutube2.class,AllYoutube3.class,AllYoutube4.class,AllYoutube5.class,AllYoutube6.class};

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getApplicationContext(), All_Youtube[position]);
                        startActivity(intent);

                    }

                });
    }
}
