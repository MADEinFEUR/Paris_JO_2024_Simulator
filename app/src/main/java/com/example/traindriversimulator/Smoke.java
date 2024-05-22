package com.example.traindriversimulator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Smoke {
    Bitmap smoke[] = new Bitmap[16];
    int smokeFrame = 0;
    public Smoke(Context context){

        smoke[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.smoke0);
        smoke[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.smoke1);
        smoke[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.smoke2);
        smoke[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.smoke3);
        smoke[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.smoke4);
        smoke[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.smoke5);
        smoke[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.smoke6);
        smoke[7] = BitmapFactory.decodeResource(context.getResources(),R.drawable.smoke7);
        smoke[8] = BitmapFactory.decodeResource(context.getResources(),R.drawable.smoke8);
        smoke[9] = BitmapFactory.decodeResource(context.getResources(),R.drawable.smoke9);
        smoke[10] = BitmapFactory.decodeResource(context.getResources(),R.drawable.smoke10);
        smoke[11] = BitmapFactory.decodeResource(context.getResources(),R.drawable.smoke11);
        smoke[12] = BitmapFactory.decodeResource(context.getResources(),R.drawable.smoke12);
        smoke[13] = BitmapFactory.decodeResource(context.getResources(),R.drawable.smoke13);
        smoke[14] = BitmapFactory.decodeResource(context.getResources(),R.drawable.smoke14);
        smoke[15] = BitmapFactory.decodeResource(context.getResources(),R.drawable.smoke15);

    }
    public Bitmap getSmoke(int smokeFrame){
        return smoke[smokeFrame];
    }
}
