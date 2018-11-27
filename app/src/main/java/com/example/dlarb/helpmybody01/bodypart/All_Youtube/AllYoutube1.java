package com.example.dlarb.helpmybody01.bodypart.All_Youtube;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dlarb.helpmybody01.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class AllYoutube1 extends YouTubeBaseActivity {

    YouTubePlayerView youtubeView;
    Button button;
    YouTubePlayer.OnInitializedListener listener;

    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.body_youtube);
        Intent intent = getIntent();

        button = (Button) findViewById(R.id.wabutton);
        youtubeView = (YouTubePlayerView) findViewById(R.id.youtubeview);
        listener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("xNYJud41I_c");


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
