package com.example.dlarb.helpmybody01;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PointActivity extends AppCompatActivity {

    static int point = 0;
    static int change = 0;
    SharedPreferences pref;
    static int savedpoint = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.point_layout);

        final TextView pointtext = (TextView) findViewById(R.id.textView_p);
        final Button pointbutton = (Button) findViewById(R.id.button_p);

        pointtext.setText(point + "점");

        pointbutton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        point += 3;
                        pref = PreferenceManager.getDefaultSharedPreferences(PointActivity.this);
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putInt("point", point);
                        edit.apply();
                        pointtext.setText(point + "점");
                        pointbutton.setClickable(false);


                        pref = PreferenceManager.getDefaultSharedPreferences(PointActivity.this);
                        savedpoint = pref.getInt("point", point);
                    }
                }
        );
    }
}
