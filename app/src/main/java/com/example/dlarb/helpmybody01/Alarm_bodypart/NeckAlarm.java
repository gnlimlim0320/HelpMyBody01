package com.example.dlarb.helpmybody01.Alarm_bodypart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.dlarb.helpmybody01.R;


public class NeckAlarm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.neck_layout);
        Intent intent = getIntent();
    }
}
