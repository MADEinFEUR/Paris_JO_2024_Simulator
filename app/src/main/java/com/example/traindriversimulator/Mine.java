package com.example.traindriversimulator;

import static android.graphics.BitmapFactory.*;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

class Mine {
    private int damage;
    private int range;

    public int x;
    public int y;

    public int name;

    Bitmap mine[] = new Bitmap[6];

    int mineFrame = 0;


    public Bitmap getMine(int mineFrame){
        return mine[mineFrame];
    }

    public Mine(Context context, int x, int y, int name) {
        this.damage = damage;
        this.range = range;
        this.x = x;
        this.y = y;
        this.name = name;



        switch (name){
            case 1:

                    mine[0] = decodeResource(context.getResources(),R.drawable.mine1_ground);
                    mine[1] = decodeResource(context.getResources(),R.drawable.minet11);
                    mine[2] = decodeResource(context.getResources(),R.drawable.minet12);
                    mine[3] = decodeResource(context.getResources(),R.drawable.minet13);
                    mine[4] = decodeResource(context.getResources(),R.drawable.minet14);
                    mine[5] = decodeResource(context.getResources(),R.drawable.minet15);

                    damage = 10;
                    range = 90;

                break;
            case 2:
                mine[0] = decodeResource(context.getResources(),R.drawable.mine2_ground);
                mine[1] = decodeResource(context.getResources(),R.drawable.minet11);
                mine[2] = decodeResource(context.getResources(),R.drawable.minet12);
                mine[3] = decodeResource(context.getResources(),R.drawable.minet13);
                mine[4] = decodeResource(context.getResources(),R.drawable.minet14);
                mine[5] = decodeResource(context.getResources(),R.drawable.minet15);

                    damage = 70;
                    range = 90;
                break;

            case 3:
                mine[0] = decodeResource(context.getResources(),R.drawable.mine3_ground);
                mine[1] = decodeResource(context.getResources(),R.drawable.minet11);
                mine[2] = decodeResource(context.getResources(),R.drawable.minet12);
                mine[3] = decodeResource(context.getResources(),R.drawable.minet13);
                mine[4] = decodeResource(context.getResources(),R.drawable.minet14);
                mine[5] = decodeResource(context.getResources(),R.drawable.minet15);

                    damage = 100;
                    range = 90;
                break;

        }


    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }
    public void setDamage(int newDamage) {
        damage = newDamage;
    }
    public void setNewSkin(Bitmap bitmap) {
        mine[0] = bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
