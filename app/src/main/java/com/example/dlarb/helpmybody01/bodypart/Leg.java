package com.example.dlarb.helpmybody01.bodypart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.dlarb.helpmybody01.ImageAdpater.ImageAdapter_arm;
import com.example.dlarb.helpmybody01.ImageAdpater.ImageAdapter_leg;
import com.example.dlarb.helpmybody01.R;
import com.example.dlarb.helpmybody01.bodypart.Arm_Youtube.ArmYoutube1;
import com.example.dlarb.helpmybody01.bodypart.Arm_Youtube.ArmYoutube2;
import com.example.dlarb.helpmybody01.bodypart.Arm_Youtube.ArmYoutube3;
import com.example.dlarb.helpmybody01.bodypart.Arm_Youtube.ArmYoutube4;
import com.example.dlarb.helpmybody01.bodypart.Arm_Youtube.ArmYoutube5;
import com.example.dlarb.helpmybody01.bodypart.Leg_Youtube.LegYoutube1;
import com.example.dlarb.helpmybody01.bodypart.Leg_Youtube.LegYoutube2;
import com.example.dlarb.helpmybody01.bodypart.Leg_Youtube.LegYoutube3;
import com.example.dlarb.helpmybody01.bodypart.Leg_Youtube.LegYoutube4;
import com.example.dlarb.helpmybody01.bodypart.Leg_Youtube.LegYoutube5;
import com.example.dlarb.helpmybody01.bodypart.Leg_Youtube.LegYoutube6;

public class Leg extends AppCompatActivity {
    View v;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.leg_layout);
        Intent intent = getIntent();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] leg_youtube = {"스쿼트 하는데 다리가 두꺼워지는것같다면? (하체스트레칭,하체다이어트)","저녁에도 아침같은 다리 만들기! 골반교정으로 하비탈출!)",
        "다리살 붓기 빨리 빼는 스트레칭 3가지","하루 10분 하체 스트레칭. [데스런]",
        "[무나홈트] 침대에서 하는 다리스트레칭(초간단)","[EVA YOGA]인스타에 업로드 됐던 완벽한 다리 스트레칭"};
        ListAdapter adapter = new ImageAdapter_leg(Leg.this,leg_youtube);
        ListView listView = (ListView)findViewById(R.id.leg_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    Class[] Leg_Youtube = new Class[]{LegYoutube1.class,LegYoutube2.class,LegYoutube3.class,LegYoutube4.class,LegYoutube5.class,LegYoutube6.class};

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getApplicationContext(), Leg_Youtube[position]);
                        startActivity(intent);

                    }

                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:{
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
