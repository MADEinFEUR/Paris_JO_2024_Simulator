package com.example.traindriversimulator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class ShopActivity extends AppCompatActivity {
    public static int mapChoisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_activity);
    }
    public void lancerBoutique2 (View v) {
        Intent gamewindow = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            gamewindow = new Intent(this, ShopActivity2.class);
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

    /* private Button payPalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        payPalButton = findViewById(R.id.imageView5);

        payPalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String payPalUrl = "https://www.paypal.com/checkoutnow"; // Replace this with the actual PayPal payment URL
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(payPalUrl));
                startActivity(intent);
} */


