package com.example.traindriversimulator;

import android.annotation.SuppressLint;
import android.graphics.HardwareRenderer;
import android.media.MediaPlayer;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import android.widget.ImageButton;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {


    public static int mapChoisi;
    public static MediaPlayer musicPlayer;

    private HardwareRenderer mediaPlayer;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        // Musique de guedin
        musicPlayer = MediaPlayer.create(this, R.raw.sncf_remix_coupe_decale);
        musicPlayer.setLooping(true);
        musicPlayer.start();





    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (musicPlayer != null) {
            musicPlayer.stop();
            musicPlayer.release();
            musicPlayer = null;
        }
    }

    public static void stopMusic() {
        musicPlayer.stop();
    }
    @RequiresApi(api = Build.VERSION_CODES.R)
    public void lancerJouer(View v){
        stopMusic();
        Intent gamewindow = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            gamewindow = new Intent(this, MDJ.class);
        }
        startActivities(new Intent[]{gamewindow});
        GameView.partieLancer=0;


    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void lancerBoutique(View v) {
        Intent gamewindow = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            gamewindow = new Intent(this, ShopActivity.class);
        }
        startActivities(new Intent[]{gamewindow});

    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void lancerMDJ(View v){
        Intent gamewindow = null;
        stopMusic();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            gamewindow = new Intent(this, GameTuto.class);
        }
        startActivities(new Intent[]{gamewindow});


    }

    public void lancerOption(View v){

    }

    public void lancerCredit(View v){
        Intent gamewindow = null;
        stopMusic();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            gamewindow = new Intent(this, GameCredit.class);
        }
        startActivities(new Intent[]{gamewindow});

        stopMusic();

    }

    public void lancerQuitter(View v){
        moveTaskToBack(true);
        finishAndRemoveTask();

        stopMusic();
    }

}