package com.example.traindriversimulator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;



class MurPetit {
    public int x;
    public int y;

    Bitmap murPetit[] = new Bitmap[2];
    int murFrame = 0;





    public MurPetit(Context context) {


        murPetit[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.mur_t2);



    }



    public Bitmap getMurPetit(int murFrame){
        return murPetit[murFrame];
    }
    public int getMPX() {
        return x;
    }

    public int getMPY() {
        return y;
    }
}

