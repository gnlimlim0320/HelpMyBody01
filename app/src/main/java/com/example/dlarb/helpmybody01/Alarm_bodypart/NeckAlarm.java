package com.example.dlarb.helpmybody01.Alarm_bodypart;



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

import com.example.dlarb.helpmybody01.Alarm_bodypart.Alarm_min.none;
import com.example.dlarb.helpmybody01.Alarm_bodypart.Alarm_min.onehour;
import com.example.dlarb.helpmybody01.Alarm_bodypart.Alarm_min.thirty;
import com.example.dlarb.helpmybody01.Alarm_bodypart.Alarm_min.twenty;
import com.example.dlarb.helpmybody01.Alarm_bodypart.Alarm_min.twohour;
import com.example.dlarb.helpmybody01.R;



public class NeckAlarm extends AppCompatActivity {
    @Nullable

    protected void onCreate (Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.alarm_neck);
        Intent intent = getIntent();

        String[] minutes = {"20분", "30분", "1시간", "2시간", "취소"};

        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, minutes);
        ListView listView = (ListView) findViewById(R.id.neck_alist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    Class[] Activities = new Class[]{twenty.class, thirty.class, onehour.class, twohour.class, none.class};

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                        String item = String.valueOf(parent.getItemAtPosition(i));

                        Intent intent = new Intent(NeckAlarm.this, Activities[i]);
                        startActivity(intent);

                    }
                });
    }

}
