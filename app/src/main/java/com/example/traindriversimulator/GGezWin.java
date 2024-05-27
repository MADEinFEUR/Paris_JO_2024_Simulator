package com.example.traindriversimulator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class GGezWin extends AppCompatActivity {
    TextView tvPoints;
    TextView tvHighest;
    SharedPreferences sharedPreferences;
    ImageView ivNewHighest;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ggezwin_activity);
        tvPoints = findViewById(R.id.tvPoints);
        tvHighest = findViewById(R.id.tvHighest);
        ivNewHighest = findViewById(R.id.ivNewHighest);
        int points = getIntent().getExtras().getInt("points");
        tvPoints.setText(""+points);
        sharedPreferences = getSharedPreferences("my_pref",0);
        int highest =0;
        highest =sharedPreferences.getInt("highest",0);
        if (points > highest){
            ivNewHighest.setVisibility(View.VISIBLE);
            highest= points;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("highest", highest);
            editor.commit();
        }
        tvHighest.setText(""+highest);

        MenuActivity.musicPlayer = MediaPlayer.create(this, R.raw.royale_victory_hdmi);
        MenuActivity.musicPlayer .setLooping(true);
        MenuActivity.musicPlayer .start();
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void restart(View view){
        Intent intent = new Intent(GGezWin.this, GamesActivity.class);
        startActivity(intent);
        finish();
        MenuActivity.musicPlayer.stop();


    }

    public  void exit(View view){
        Intent intent = new Intent(GGezWin.this, App.class);
        startActivity(intent);
        finish();
        MenuActivity.musicPlayer.stop();

    }
}

