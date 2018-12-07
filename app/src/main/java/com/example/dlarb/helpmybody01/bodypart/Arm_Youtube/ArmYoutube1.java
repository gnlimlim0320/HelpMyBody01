package com.example.dlarb.helpmybody01.bodypart.Arm_Youtube;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.dlarb.helpmybody01.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ArmYoutube1 extends YouTubeBaseActivity {

    YouTubePlayerView youtubeView;
    Button button;
    YouTubePlayer.OnInitializedListener listener;
    private AppCompatDelegate delegate;
    private AppCompatCallback callback;

    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.body_youtube);
        Intent intent = getIntent();

        delegate = AppCompatDelegate.create(this,callback);
        delegate.onCreate(bundle);
        delegate.setContentView(R.layout.body_youtube);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar2);
        delegate.setSupportActionBar(toolbar);
        delegate.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button = (Button) findViewById(R.id.wabutton);
        youtubeView = (YouTubePlayerView) findViewById(R.id.youtubeview);
        listener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("061cdM_A4bo");


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
