package com.example.dlarb.helpmybody01.bodypart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.dlarb.helpmybody01.ImageAdapter;
import com.example.dlarb.helpmybody01.ImageAdapter_neck;
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


        final String[] neck_youtube = {"예쁜 일자어깨 만드는 승모근 스트레칭 BEST3","목디스크 거북목에 좋은 1분 스트레칭","[즉빵 통증 완화 스트레칭] 목 결림을 바~로 풀어주는 목 스트레칭","뭉친 어깨와 목을 이완 시켜주는 요가","목스트레칭! 묘한매력 완선생님과 시원하게 목좀 풀어볼까요?"};
        final Integer[] images = {R.drawable._neck1, R.drawable._neck2, R.drawable._neck3, R.drawable._neck4,R.drawable._neck5};
        ListAdapter adapter = new ImageAdapter_neck(Neck.this,neck_youtube);
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
