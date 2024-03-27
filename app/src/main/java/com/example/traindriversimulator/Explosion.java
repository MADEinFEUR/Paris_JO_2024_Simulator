package com.example.traindriversimulator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Explosion {
    Bitmap explosion[] = new Bitmap[9];
    int explosionFrame = 0;
    int explosionX;
    int explosionY;
    public Explosion(Context context){
        explosion[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explo1);
        explosion[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explo2);
        explosion[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explo3);
        explosion[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explo4);
        explosion[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explo5);
        explosion[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explo6);
        explosion[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explo7);
        explosion[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.explo8);

    }
    public Bitmap getExplosion(int explosionFrame){
        return explosion[explosionFrame];
    }
}
