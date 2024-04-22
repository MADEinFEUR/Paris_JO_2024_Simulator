package com.example.traindriversimulator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

class Catapult {
    private int damage;
    private int range;

    private int life;
    public int catapultTimer;
    public int catapultCoolDownLimit;
    public int Tx;
    public int Ty;
    public int nb_rotation;

    public int name;

    public static Enemy cible = null;

    Bitmap catapult[] = new Bitmap[2];
    int catapultFrame = 0;


    public Bitmap getCatapult(int towerFrame){
        return catapult[towerFrame];
    }


    public Catapult(Context context, int Tx, int Ty, int catapultTimer, int name) {
        this.damage = damage;
        this.range = range;
        this.life = life;
        this.Tx = Tx;
        this.Ty = Ty;
        this.catapultTimer = catapultTimer;
        this.name = name;
        this.cible = cible;
        this.catapultCoolDownLimit = catapultCoolDownLimit;

        ChangementLvlTower(context,name);
    }

    public void ChangementLvlTower(Context context,int newLvl){
        switch (name){
            case 1:
                catapult[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.t3);
                catapult[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.t3_1);



                range = 900;
                damage = 150;
                life = 100;
                catapultCoolDownLimit = 150;

                break;
            case 2:
                catapult[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.t3);
                catapult[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.t3_1);

                range = 900;
                damage = 170;
                life = 200;
                catapultCoolDownLimit = 100;
                break;
            case 3:
                catapult[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.t3);
                catapult[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.t3_1);

                range = 900;
                damage = 200;
                life = 400;
                catapultCoolDownLimit = 50;
                break;

        }


    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }
    public void setName(int newName) {
        name = newName;
    }
    public void setDamage(int newDamage) {
        damage = newDamage;
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