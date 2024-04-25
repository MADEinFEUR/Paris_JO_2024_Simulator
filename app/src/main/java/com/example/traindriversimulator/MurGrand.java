package com.example.traindriversimulator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

class MurGrand {
    public int x;
    public int y;

    Bitmap murGrand[] = new Bitmap[2];
    int murFrame = 0;

    int taille;




    public MurGrand(Context context) {


        murGrand[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mur_t2);



    }



    public Bitmap getMurGrand(int murFrame){
        return murGrand[murFrame];
    }
    public int getMGX() {
        return x;
    }

    public int getMGY() {
        return y;
    }
}
