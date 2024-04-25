package com.example.traindriversimulator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.GameManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;
import android.util.DisplayMetrics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class App extends AppCompatActivity {

    private VideoView intro1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intro1 = (VideoView) findViewById(R.id.videoView2);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.intro_rer_gaming);
        intro1.setVideoURI(uri);


    }

    public void launchGameWindow(){
        Intent gamewindow = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            gamewindow = new Intent(this, GamesActivity.class);
        }
        startActivities(new Intent[]{gamewindow});

    }

    //____________________________vidéo intro_________________________________________________________________
    protected  void onResume(){
        super.onResume();
        intro1.start();
    }
    protected void onPause() {
        super.onPause();
        intro1.suspend();


    }

    public void intro(View v){
        Intent gamewindow = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            gamewindow = new Intent(this, MenuActivity.class);
        }
        startActivities(new Intent[]{gamewindow});

    }

}