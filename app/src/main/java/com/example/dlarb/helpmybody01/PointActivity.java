package com.example.dlarb.helpmybody01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PointActivity extends AppCompatActivity {


    static int point = 0;
    int change = 0;


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
                        if(change==1){
                            pointbutton.setClickable(false);
                        }

                       else {
                            point += 3;
                            pointtext.setText(point + "점");
                            change=1;
                        }

                    }

                }

        );
    }


}
