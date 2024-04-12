package com.example.traindriversimulator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

public class Enemy {
    private int health;

    private int etat = 1;
    private int rank;
    private int attaque;
    private int attaqueRange;
    private String name;
    private int moneyReward;
    public int enemyVelocityY;
    public int enemyVelocityX;

    Bitmap enemy[] = new Bitmap[7];
    int enemyFrame = 0;
    public int positionX;
    public int positionY;
    Random random;



    public Enemy(Context context,String name) {
        this.health = health;
        this.rank = rank;
        this.attaqueRange = attaqueRange;
        this.enemyVelocityY = enemyVelocityY;
        this.positionX = positionX;
        this.positionY = positionY;
        this.name = name;
        this.attaque = attaque;


        switch (name){
            case /*davidLeLent*/"t1" :
                enemy[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);

                attaque = 10;
                health=30;

                enemyVelocityY = 4;
                enemyVelocityX = enemyVelocityY;

                break;

            case /*joseLetreLent*/ "t2":
                enemy[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);

                attaque = 30;
                health=50;

                enemyVelocityY = 2;
                enemyVelocityX = enemyVelocityY;

                break;
            case /*joseLetreLent*/ "t3":
                enemy[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);

                attaque = 50;
                health=150;

                enemyVelocityY = 2;
                enemyVelocityX = enemyVelocityY;

                break;
            case /*joseLetreLent*/ "boss":
                enemy[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
                enemy[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);

                attaque = 200;
                health=700;

                enemyVelocityY = 1;
                enemyVelocityX = enemyVelocityY;

                break;




        }
        random = new Random();
        spawnRandom();






    }

    public Bitmap getEnemy(int enemyFrame) {
        return enemy[this.enemyFrame];
    }



    public int getEnemyWidth(){
        return enemy[0].getWidth();
    }

    public int getEnemyHeight(){
        return  enemy[0].getHeight();
    }

    public void spawnRandom(){
        positionX = random.nextInt(GameView.dWidth - getEnemyWidth());
        positionY = -200 + random.nextInt(600)*-1;
    }
    public void resetEnemyVelocity(){
        switch (name){
            case "t1":
                enemyVelocityY = 4;
                break;
            case "t2":
                enemyVelocityY = 2;
                break;

            }

    }
    public void enemyTuer(){
        positionY=-100;
        positionX=-100;
        enemyVelocityY = 0;
        enemyVelocityX = 0;
        etat=0;
    }

    public int getHealth() {
        return health;
    }
    public int getEtat() {
        return etat;
    }
    public void setHealth(int newHealth) {
        health = newHealth;
    }

    public int getAttaque(){
        return attaque;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public String getType(){
        return name;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }
}
