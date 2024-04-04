package com.example.traindriversimulator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

public class Enemy {
    private int health;
    private int rank;
    private int attaque;
    private int attaqueRange;
    private String name;
    private int moneyReward;
    public int enemyVelocity;

    Bitmap enemy[] = new Bitmap[7];
    int enemyFrame = 0;
    public int positionX;
    public int positionY;
    Random random;


    public Enemy(Context context) {
        this.health = health;
        this.rank = rank;
        this.attaqueRange = attaqueRange;
        this.enemyVelocity = enemyVelocity;
        this.rank = rank;
        this.positionX = positionX;
        this.positionY = positionY;
        this.name = name;
        this.attaque = attaque;

        enemy[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
        enemy[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
        enemy[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
        enemy[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
        enemy[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
        enemy[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
        enemy[6] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);

        random = new Random();
        resetPosition();



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

    public void resetPosition(){
        positionX = random.nextInt(GameView.dWidth - getEnemyWidth());
        positionY = -200 + random.nextInt(600)*-1;
        enemyVelocity = 35 + random.nextInt(16);
    }

    public int getHealth() {
        return health;
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

    public void move() {
        positionX--;
    }



    public void takeDamage(int damage) {
        health -= damage;
    }
}
