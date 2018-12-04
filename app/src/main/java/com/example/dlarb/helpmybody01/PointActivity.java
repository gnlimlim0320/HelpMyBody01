package com.example.dlarb.helpmybody01;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class PointActivity extends AppCompatActivity {

    static int point = 0;
    SharedPreferences pref;
    static int savedpoint = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.point_layout);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final TextView pointtext = (TextView) findViewById(R.id.textView_p);
        final Button pointbutton = (Button) findViewById(R.id.button_p);
        final Button homebutton = (Button) findViewById(R.id.homebutton);

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

        homebutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplication(),MainActivity.class);
                        startActivity(intent);
                    }
                }

        );

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
