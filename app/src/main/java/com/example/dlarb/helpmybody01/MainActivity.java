package com.example.dlarb.helpmybody01;

import android.content.Intent;
import android.os.Bundle;
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
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView textView_01;
    TextView textView_02;
    TextView textView_03;
    TextView textView_04;
    int point = PointActivity.savedpoint;
    static Toolbar toolbar;
    public int calcul(){   // 스트레칭 시작 일수를 카운트 해줌. 처음으로 이 어플을 실행한 순간부터 시작
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
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView_02 = (TextView) findViewById(R.id.textView_02);
        textView_04 = (TextView) findViewById(R.id.textView_04);
        textView_03 = (TextView) findViewById(R.id.textView_03);
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
        textView_03.setText("적립된 포인트는 "+point+"점");
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

        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        FragmentManager manager = getFragmentManager();
        TextView textView_01 = (TextView) findViewById(R.id.textView_01);
        TextView textView_02 = (TextView)findViewById(R.id.textView_02);
        TextView textView_03 = (TextView)findViewById(R.id.textView_03);
        TextView textView_04 = (TextView)findViewById(R.id.textView_04);


        if (id == R.id.nav_youtube_layout) { // 네비게이션 바에서 각 메뉴로 넘어감. 메인 화면에 있는 텍스트뷰들이 사라지지 않아서 setVisibility 추가해줌
            manager.beginTransaction().replace(R.id.content_main, new YoutubeLayout()).commit();
            textView_01.setVisibility(View.INVISIBLE);
            textView_02.setVisibility(View.INVISIBLE);
            textView_03.setVisibility(View.INVISIBLE);
            textView_04.setVisibility(View.INVISIBLE);

        } else if (id == R.id.nav_alarm_layout) {
            manager.beginTransaction().replace(R.id.content_main, new AlarmLayout()).commit();
            textView_01.setVisibility(View.INVISIBLE);
            textView_02.setVisibility(View.INVISIBLE);
            textView_03.setVisibility(View.INVISIBLE);
            textView_04.setVisibility(View.INVISIBLE);

        } else if (id == R.id.nav_alarmsleep_layout) {
            manager.beginTransaction().replace(R.id.content_main, new SleepLayout()).commit();
            textView_01.setVisibility(View.INVISIBLE);
            textView_02.setVisibility(View.INVISIBLE);
            textView_03.setVisibility(View.INVISIBLE);
            textView_04.setVisibility(View.INVISIBLE);

        } else if (id == R.id.nav_alarmset_layout) {
            manager.beginTransaction().replace(R.id.content_main, new SettingsActivity()).commit();
            textView_01.setVisibility(View.INVISIBLE);
            textView_02.setVisibility(View.INVISIBLE);
            textView_03.setVisibility(View.INVISIBLE);
            textView_04.setVisibility(View.INVISIBLE);

        }else if(id == R.id.nav_home_layout){  // 다른 메뉴와 다르게 홈은 transaction이 아니라 intent 사용해줌. 대신 setFlag를 통해 전의 intent들을 비움.
            Intent intent = new Intent(getApplication(),MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        return true;

    }



}
