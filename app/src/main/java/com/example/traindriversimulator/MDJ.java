package com.example.traindriversimulator;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MDJ extends AppCompatActivity {


    public static int mapChoisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mdj_activity);

        MenuActivity.musicPlayer = MediaPlayer.create(this, R.raw.propulsion);
        MenuActivity.musicPlayer.setLooping(true);
        MenuActivity.musicPlayer.start();


    }

    public void lancerBossRush(View v) {
        Intent gamewindow = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            gamewindow = new Intent(this, GamesActivity.class);
        }
        startActivities(new Intent[]{gamewindow});
        GameView.modeDeJeu = 3;
        MenuActivity.stopMusic();
    }

    public void lancerInfinite(View v){
        Intent gamewindow = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            gamewindow = new Intent(this, GamesActivity.class);
        }
        startActivities(new Intent[]{gamewindow});
        GameView.modeDeJeu = 2;
        MenuActivity.stopMusic();

    }

    public void exit(View v){
        Intent gamewindow = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            gamewindow = new Intent(this, MenuActivity.class);
        }
        startActivities(new Intent[]{gamewindow});
        MenuActivity.stopMusic();





    }

    public void lancerQuickPlay(View v){

        Intent gamewindow = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            gamewindow = new Intent(this, GamesActivity.class);
        }
        startActivities(new Intent[]{gamewindow});
        GameView.modeDeJeu = 1;
        MenuActivity.stopMusic();

    }
}