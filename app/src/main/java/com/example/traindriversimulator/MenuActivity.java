package com.example.traindriversimulator;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import android.widget.ImageButton;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {


    public static int mapChoisi;

    private MediaPlayer musicPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        // Musique de guedin
        musicPlayer = MediaPlayer.create(this, R.raw.sncf_remix_coupe_decale);
        musicPlayer.setLooping(true);
        musicPlayer.start();


        // Video de malade
        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.winnie_dance);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.requestFocus();

        // looping OnPreparedListener pour winnie et donald qui dansent
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                mp.start();
            }
        });

        // Assurez-vous que la vidéo boucle sans arrêter la musique
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.start();
            }
        });

        // Lance la video
        videoView.start();
    }

    // Pour éviter les fuites de mémoire, n'oubliez pas d'arrêter et de libérer les MediaPlayer instances
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (musicPlayer != null) {
            musicPlayer.stop();
            musicPlayer.release();
            musicPlayer = null;
        }
    }
    private void stopMusic() {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.sncf_remix_coupe_decale);
        mediaPlayer.stop();
        mediaPlayer.release();
    }
    public void lancerJouer(View v){
        stopMusic();

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
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.sncf_remix_coupe_decale);
        mediaPlayer.stop();
        mediaPlayer.release();

    }

    public void lancerQuitter(View v){
        moveTaskToBack(true);
        finishAndRemoveTask();

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.sncf_remix_coupe_decale);
        mediaPlayer.stop();
        mediaPlayer.release();
    }

}