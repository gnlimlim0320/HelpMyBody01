package com.example.dlarb.helpmybody01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Wrist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.wrist_layout);
        Intent intent = getIntent();
    }

}
