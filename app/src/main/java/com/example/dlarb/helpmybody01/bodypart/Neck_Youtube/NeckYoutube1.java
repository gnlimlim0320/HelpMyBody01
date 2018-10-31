package com.example.dlarb.helpmybody01.bodypart.Neck_Youtube;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.dlarb.helpmybody01.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class NeckYoutube1 extends YouTubeBaseActivity {

    YouTubePlayerView youtubeView;
    Button button;
    YouTubePlayer.OnInitializedListener listener;


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.neck_youtube1);
        Intent intent = getIntent();

        button = (Button) findViewById(R.id.nybutton1);
        youtubeView = (YouTubePlayerView) findViewById(R.id.neck_youtubeview1);
        listener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("TpPwI_Lo0YY");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          youtubeView.initialize("AIzaSyCvDRDZUCGB5-HggR-LTbA34VXrJkGsi1I",listener);
        }
    });
    }
}
