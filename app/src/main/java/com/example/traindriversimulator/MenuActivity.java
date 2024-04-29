package com.example.traindriversimulator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

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

    public void lancerBoutique(View v){

    }

    public void lancerMDJ(View v){

    }

    public void lancerOption(View v){

    }

    public void lancerCredit(View v){

    }

    public void lancerQuitter(View v){

    }
}