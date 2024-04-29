package com.example.traindriversimulator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Batiment {

        private int damage;
        private int range;

        private int life;
        public int batimentTimer;
        public int batimentCoolDownLimit;
        public int Cx;
        public int Cy;
        public int nb_rotation;

        public int name;

        Bitmap batiment[] = new Bitmap[1];
        int batimentFrame = 0;


        public Bitmap getBatiment(int batimentFrame){
            return batiment[batimentFrame];
        }


        public Batiment(Context context, int Cx, int Cy, int name) {
            this.damage = damage;
            this.range = range;
            this.life = life;
            this.Cx = Cx;
            this.Cy = Cy;
            this.batimentTimer = batimentTimer;
            this.name = name;
            this.batimentCoolDownLimit = batimentCoolDownLimit;


            switch(name){
                case 1:
                    //infirmerie
                    life=150;
                    batiment[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.infirmerie);

                    break;
                case 2:
                    //reserve
                    life=350;
                    batiment[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.reserve);

                    break;
                case 3:
                    //avant poste
                    life=750;
                    batiment[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.avantpost);

                    break;
                case 4:
                    //potion
                    life=175;
                    batiment[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.potion);

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
            return Cx;
        }

        public int getTY() {
            return Cy;
        }


}
