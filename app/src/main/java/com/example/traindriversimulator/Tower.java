package com.example.traindriversimulator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

class Tower {
    private int damage;
    private int range;
    private int Tx;
    private int Ty;

    Bitmap tower[] = new Bitmap[5];
    int towerFrame = 0;


    public Bitmap getTower(int towerFrame){
        return tower[towerFrame];
    }

    public Tower(Context context) {
        this.damage = damage;
        this.range = range;
        this.Tx = Tx;
        this.Ty = Ty;

        tower[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.tower0);
        tower[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.tower1);
        tower[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.tower2);
        tower[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.tower3);
        tower[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.tower4);


    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public int getTX() {
        return Tx;
    }

    public int getTY() {
        return Ty;
    }
}