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
            gamewindow = new Intent(this, MDJ.class);
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
        Intent gamewindow = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            gamewindow = new Intent(this, GameTuto.class);
        }
        startActivities(new Intent[]{gamewindow});

    }

    public void lancerOption(View v){

    }

    public void lancerCredit(View v){
        Intent gamewindow = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            gamewindow = new Intent(this, GameCredit.class);
        }
        startActivities(new Intent[]{gamewindow});


    }

    public void lancerQuitter(View v){
        moveTaskToBack(true);
        finishAndRemoveTask();
    }

}