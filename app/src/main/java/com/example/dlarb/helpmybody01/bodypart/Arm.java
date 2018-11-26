package com.example.dlarb.helpmybody01.bodypart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.dlarb.helpmybody01.ImageAdpater.ImageAdapter_arm;
import com.example.dlarb.helpmybody01.ImageAdpater.ImageAdapter_waist;
import com.example.dlarb.helpmybody01.R;
import com.example.dlarb.helpmybody01.bodypart.Arm_Youtube.ArmYoutube1;
import com.example.dlarb.helpmybody01.bodypart.Arm_Youtube.ArmYoutube2;
import com.example.dlarb.helpmybody01.bodypart.Arm_Youtube.ArmYoutube3;
import com.example.dlarb.helpmybody01.bodypart.Arm_Youtube.ArmYoutube4;
import com.example.dlarb.helpmybody01.bodypart.Arm_Youtube.ArmYoutube5;
import com.example.dlarb.helpmybody01.bodypart.Waist_Youtube.WaistYoutube1;
import com.example.dlarb.helpmybody01.bodypart.Waist_Youtube.WaistYoutube2;
import com.example.dlarb.helpmybody01.bodypart.Waist_Youtube.WaistYoutube3;
import com.example.dlarb.helpmybody01.bodypart.Waist_Youtube.WaistYoutube4;
import com.example.dlarb.helpmybody01.bodypart.Waist_Youtube.WaistYoutube5;
import com.example.dlarb.helpmybody01.bodypart.Waist_Youtube.WaistYoutube6;

public class Arm extends AppCompatActivity {
    View v;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.arm_layout);
        Intent intent = getIntent();


        String[] arm_youtube = {"팔이 결릴 때 하는 !!정확한!! 스트레칭을 배워봐요",
                "맨손으로 쉽게! 팔뚝 뭉친 근육 쉽게 스트레칭!","오십견예방! 팔 많이 쓰시는 분들! 어서 시작합시다~~",
                "굽은어깨 교정, 어깨결림 초간단 스트레칭","[5분 스트레칭] 팔 근육 풀어주기"};
        ListAdapter adapter = new ImageAdapter_arm(Arm.this,arm_youtube);
        ListView listView = (ListView)findViewById(R.id.arm_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    Class[] Arm_Youtube = new Class[]{ArmYoutube1.class,ArmYoutube2.class,ArmYoutube3.class,ArmYoutube4.class,ArmYoutube5.class};

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getApplicationContext(), Arm_Youtube[position]);
                        startActivity(intent);

                    }

                });
    }
}
