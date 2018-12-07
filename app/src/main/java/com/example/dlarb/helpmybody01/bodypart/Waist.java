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

import com.example.dlarb.helpmybody01.ImageAdpater.ImageAdapter_waist;
import com.example.dlarb.helpmybody01.R;
import com.example.dlarb.helpmybody01.bodypart.Waist_Youtube.WaistYoutube1;
import com.example.dlarb.helpmybody01.bodypart.Waist_Youtube.WaistYoutube2;
import com.example.dlarb.helpmybody01.bodypart.Waist_Youtube.WaistYoutube3;
import com.example.dlarb.helpmybody01.bodypart.Waist_Youtube.WaistYoutube4;
import com.example.dlarb.helpmybody01.bodypart.Waist_Youtube.WaistYoutube5;
import com.example.dlarb.helpmybody01.bodypart.Waist_Youtube.WaistYoutube6;
import com.example.dlarb.helpmybody01.bodypart.Waist_Youtube.WaistYoutube7;

public class Waist extends AppCompatActivity {
     View v;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.waist_layout);
        Intent intent = getIntent();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] waist_youtube = {"허리 좋아지는 스트레칭 BEST모음","과학적으로 검증된 허리에 좋은 스트레칭 루틴","허리 통증을 완화시켜주는 스트레칭 / 골반교정, 척추교정 스트레칭-콩필라테스","허리 통증 완화를 위한 요가 스트레칭 | 15분 통증 완화 요가 | 요가소년","허리스트레칭과 목스트레칭으로 내 몸을 바르게! 1편",
        "[고투더헬th] 틀어진 골반, 요추 통증, 디스크 잡는 골반 셀프 교정법///(골반교정 스트레칭)","허리 아플때 좋은 운동 / 자세 꿀팁과 경고!!(일상,스트레칭,운동,순서)"};
        ListAdapter adapter = new ImageAdapter_waist(Waist.this,waist_youtube);
        ListView listView = (ListView)findViewById(R.id.waist_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    Class[] Waist_Youtube = new Class[]{WaistYoutube1.class, WaistYoutube2.class,WaistYoutube3.class,WaistYoutube4.class,WaistYoutube5.class,WaistYoutube6.class,WaistYoutube7.class};

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getApplicationContext(), Waist_Youtube[position]);
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
