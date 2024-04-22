package com.example.traindriversimulator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

class catapult {
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

    Bitmap catapult[] = new Bitmap[5];
    int catapultFrame = 0;


    public Bitmap catapult(int towerFrame){
        return catapult[towerFrame];
    }


    public catapult(Context context, int Tx, int Ty, int towerTimer, int name) {
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
                catapult[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.t3);



                range = 600;
                damage = 150;
                life = 100;
                catapultCoolDownLimit = 200;

                break;
            case 2:
                catapult[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.t3);
                catapult[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.t3);

                range = 600;
                damage = 170;
                life = 200;
                catapultCoolDownLimit = 150;
                break;
            case 3:
                catapult[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.t3);
                catapult[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.t3);

                range = 600;
                damage = 200;
                life = 400;
                catapultCoolDownLimit = 100;
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