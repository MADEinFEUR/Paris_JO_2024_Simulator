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
    public int nb_rotation;

    public int name;

    public static Enemy cible = null;

    Bitmap tower[] = new Bitmap[5];
    int towerFrame = 0;


    public Bitmap getTower(int towerFrame){
        return tower[towerFrame];
    }


    public Tower(Context context, int Tx, int Ty,int towerTimer, int name) {
        this.damage = damage;
        this.range = range;
        this.life = life;
        this.Tx = Tx;
        this.Ty = Ty;
        this.towerTimer = towerTimer;
        this.name = name;
        this.cible = cible;
        this.towerCoolDownLimit = towerCoolDownLimit;

        ChangementLvlTower(context,name);
    }

    public void ChangementLvlTower(Context context,int newLvl){
        switch (name){
            case 1:
                tower[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.t1);
                tower[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.t1);
                tower[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.t1);
                tower[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.t1);
                tower[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.t1);



                range = 200;
                damage = 15;
                life = 100;
                towerCoolDownLimit = 40;
                System.out.println("ici c'est t1");

                break;
            case 2:
                tower[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.towerlvl2);
                tower[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.towert11);
                tower[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.towert12);
                tower[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.towert13);
                tower[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.towert14);

                range = 200;
                damage = 30;
                life = 200;
                towerCoolDownLimit = 30;
                System.out.println("passage t2");
                break;
            case 3:
                tower[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.towerlvl3);
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