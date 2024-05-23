package com.example.traindriversimulator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class GameTuto extends AppCompatActivity {
        private VideoView intro1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.tuto_activity);

            intro1 = (VideoView) findViewById(R.id.tuto);
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.tuto_php);
            intro1.setVideoURI(uri);

        }

    protected  void onResume(){
        super.onResume();
        intro1.start();
    }
    protected void onPause() {
        super.onPause();
        intro1.suspend();


    }

    public void tuto(View v){
        Intent gamewindow = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            gamewindow = new Intent(this, MenuActivity.class);
        }
        startActivities(new Intent[]{gamewindow});

    }


}
