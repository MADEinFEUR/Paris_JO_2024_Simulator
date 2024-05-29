package com.example.traindriversimulator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ShopActivity2 extends AppCompatActivity {
    public static int mapChoisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_activity2);
    }

    public void revenirBoutique (View v) {
        Intent gamewindow = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            gamewindow = new Intent(this, ShopActivity.class);
        }
        startActivities(new Intent[]{gamewindow});


    }
    public void lancerPaypal (View v) {
        String url = "https://paypal.me/tuturmoney?country.x=FR&locale.x=fr_FR";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
    public void exit(View v){
        Intent gamewindow = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            gamewindow = new Intent(this, MenuActivity.class);
        }
        startActivities(new Intent[]{gamewindow});

    }
}