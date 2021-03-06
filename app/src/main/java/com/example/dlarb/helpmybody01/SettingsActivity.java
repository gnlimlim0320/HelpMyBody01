package com.example.dlarb.helpmybody01;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;


public class SettingsActivity extends android.app.Fragment{ // 알람음 변경 설정할 수 있는 클래스
    public static Uri myUri;
    public static int soundchange;
    View v;
    Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
    final int ringpicker = 1;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Button btn;

        v = inflater.inflate(R.layout.soundsetting, container, false);

        btn = (Button) v.findViewById(R.id.soundbutton);

        btn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        startActivityForResult(intent, ringpicker);
                    }
                } // 링피커를 통해 알림음을 바꿔줄 수 있음
        );
        return v;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ringpicker && resultCode == RESULT_OK) {
            switch (requestCode) {
                case 1:
                    myUri = data.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);
                    soundchange=1; // 알람음이 바뀌면 soundchange가 1이 되어 alarmreceiver에 넘어가게 됨 (알람음 변경 인식 변수)
                    break;
                default:
                    break;
            }
        }
    }




}



