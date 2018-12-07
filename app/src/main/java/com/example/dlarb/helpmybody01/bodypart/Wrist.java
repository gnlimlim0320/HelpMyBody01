package com.example.dlarb.helpmybody01.bodypart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.dlarb.helpmybody01.ImageAdpater.ImageAdapter_waist;
import com.example.dlarb.helpmybody01.ImageAdpater.ImageAdapter_wrist;
import com.example.dlarb.helpmybody01.R;
import com.example.dlarb.helpmybody01.bodypart.Waist_Youtube.WaistYoutube1;
import com.example.dlarb.helpmybody01.bodypart.Waist_Youtube.WaistYoutube2;
import com.example.dlarb.helpmybody01.bodypart.Wrist_Youtube.WristYoutube1;
import com.example.dlarb.helpmybody01.bodypart.Wrist_Youtube.WristYoutube2;
import com.example.dlarb.helpmybody01.bodypart.Wrist_Youtube.WristYoutube3;
import com.example.dlarb.helpmybody01.bodypart.Wrist_Youtube.WristYoutube4;
import com.example.dlarb.helpmybody01.bodypart.Wrist_Youtube.WristYoutube5;
import com.example.dlarb.helpmybody01.bodypart.Wrist_Youtube.WristYoutube6;

public class Wrist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.wrist_layout);
        Intent intent = getIntent();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] wrist_youtube = {"손목 통증에 좋은 운동","손목 통증-손목터널증후군 치료 방법","[즉빵 통증 완화 스트레칭] 욱씬욱씬 & 시큰시큰한 손목 통증 완화 스트레칭","손목터널증후군 스트레칭 by 꽃보다손목조","[퀵팁] 여성에게 더 많이 발생하는 '손목터널증후군' 자가진단 & 예방운동 | 쉐어하우스","손목터널증후근 자가진단법과 스트레칭 [미스터빡,조제알통]"};
        ListAdapter adapter = new ImageAdapter_wrist(Wrist.this,wrist_youtube);
        ListView listView = (ListView)findViewById(R.id.wrist_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    Class[] Wrist_Youtube = new Class[]{WristYoutube1.class, WristYoutube2.class,WristYoutube3.class,WristYoutube4.class,WristYoutube5.class,WristYoutube6.class};

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getApplicationContext(), Wrist_Youtube[position]);
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
