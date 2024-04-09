package com.example.traindriversimulator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

class Tower {
    private int damage;
    private int range;

    private int life;
    public int towerTimer;
    public int towerCoolDownLimit;
    public int Tx;
    public int Ty;

    public String name;

    Bitmap tower[] = new Bitmap[5];
    int towerFrame = 0;


    public Bitmap getTower(int towerFrame){
        return tower[towerFrame];
    }

    public Tower(Context context, int Tx, int Ty,int towerTimer, String name) {
        this.damage = damage;
        this.range = range;
        this.life = life;
        this.Tx = Tx;
        this.Ty = Ty;
        this.towerTimer = towerTimer;
        this.name = name;
        this.towerCoolDownLimit = towerCoolDownLimit;


        switch (name){
            case "t1":
                tower[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.towert10);
                tower[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.towert11);
                tower[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.towert12);
                tower[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.towert13);
                tower[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.towert14);


                range = 200;
                damage = 10;
                life = 100;
                towerCoolDownLimit = 50;

                break;
            case "t2":
                tower[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.towert10);
                tower[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.towert11);
                tower[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.towert12);
                tower[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.towert13);
                tower[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.towert14);

                range = 200;
                damage = 30;
                life = 200;
                towerCoolDownLimit = 30;
                break;
            case "t3":
                tower[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.towert10);
                tower[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.towert11);
                tower[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.towert12);
                tower[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.towert13);
                tower[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.towert14);

                range = 200;
                damage = 50;
                life = 400;
                towerCoolDownLimit = 10;
                break;

        }


    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }
    public void setName(String newName) {
        name = newName;
    }
    public int getLife() {
        return life;
    }

    public int getTX() {
        return Tx;
    }

    public int getTY() {
        return Ty;
    }
}