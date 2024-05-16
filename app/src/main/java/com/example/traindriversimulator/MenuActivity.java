package com.example.traindriversimulator;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;
import android.widget.ImageButton;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {


    public static int mapChoisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);


    }
    public void lancerJouer(View v){
        Intent gamewindow = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            gamewindow = new Intent(this, GamesActivity.class);
        }
        startActivities(new Intent[]{gamewindow});
        GameView.partieLancer=0;
    }

    public void lancerBoutique(View v) {
        Intent gamewindow = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            gamewindow = new Intent(this, ShopActivity.class);
        }
        startActivities(new Intent[]{gamewindow});
    }

    public void lancerMDJ(View v){

    }

    public void lancerOption(View v){

    }

    public void lancerCredit(View v){

    }

    public void lancerQuitter(View v){
        moveTaskToBack(true);
        finishAndRemoveTask();
    }
//musik
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mediaPlayer = MediaPlayer.create(this, R.raw.your_music_file); // replace "your_music_file" with the name of your music file

        Button playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });

        Button pauseButton = findViewById(R.id.pauseButton);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

        Button stopButton = findViewById(R.id.stopButton);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
}