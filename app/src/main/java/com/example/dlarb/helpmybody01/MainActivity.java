package com.example.dlarb.helpmybody01;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView textView_fla;
    TextView textView_01;
    TextView textView_02;


    public int calcul(){
        try {
            final Calendar start = Calendar.getInstance();
            Calendar today = Calendar.getInstance();

            final long startday = start.getTimeInMillis() / 86400000;
            long nowday = today.getTimeInMillis() / 86400000;
            long count = nowday - startday;
            return (int) count + 1;
        }
        catch (Exception e){
            e.printStackTrace();
            return -1;
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView_02 = (TextView) findViewById(R.id.textView_02);
        textView_01=(TextView)findViewById(R.id.textView_01);
        String days = String.valueOf(calcul());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        textView_02.setText(days+"일째");


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        FragmentManager manager = getFragmentManager();
        ImageView imageView_fla = (ImageView) findViewById(R.id.imageView_fla);
        TextView textView_01 = (TextView) findViewById(R.id.textView_01);
        TextView textView_02 = (TextView)findViewById(R.id.textView_02);

        if (id == R.id.nav_youtube_layout) {
            manager.beginTransaction().replace(R.id.content_main, new YoutubeLayout()).commit();
            imageView_fla.setVisibility(View.INVISIBLE);
            textView_01.setVisibility(View.INVISIBLE);
            textView_02.setVisibility(View.INVISIBLE);
        } else if (id == R.id.nav_alarm_layout) {
            manager.beginTransaction().replace(R.id.content_main, new AlarmLayout()).commit();
            imageView_fla.setVisibility(View.INVISIBLE);
            textView_01.setVisibility(View.INVISIBLE);
            textView_02.setVisibility(View.INVISIBLE);

        } else if (id == R.id.nav_alarmsleep_layout) {
            manager.beginTransaction().replace(R.id.content_main, new SleepLayout()).commit();
            imageView_fla.setVisibility(View.INVISIBLE);
            textView_01.setVisibility(View.INVISIBLE);
            textView_02.setVisibility(View.INVISIBLE);

        } else if (id == R.id.nav_alarmset_layout) {
            manager.beginTransaction().replace(R.id.content_main, new SettingsActivity()).commit();
            imageView_fla.setVisibility(View.INVISIBLE);
            textView_01.setVisibility(View.INVISIBLE);
            textView_02.setVisibility(View.INVISIBLE);

        }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        return true;

    }

}
