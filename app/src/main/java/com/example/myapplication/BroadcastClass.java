package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;
import com.example.myapplication.PlayerActivity;

public class BroadcastClass extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if("com.example.EXAMPLE_ACTION".equals(intent.getAction())){
            String receivedText = intent.getStringExtra("com.example.EXTRA_TEXT");
            Toast.makeText(context,"Status: "+receivedText,Toast.LENGTH_SHORT).show();
            action(receivedText);
        }
    }

    public void action(String s){
        int i;
        if(s.equals("up")) {
            for (i = 0; i < 10; i++) {
                PlayerActivity.audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
            }
        }
        if(s.equals("down")){
            for (i = 0;i<10;i++) {
                PlayerActivity.audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
            }
        }

    }

}
