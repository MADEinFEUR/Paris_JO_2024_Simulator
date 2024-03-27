package com.example.traindriversimulator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

public class Enemy {
    private int health;

    private int attaque;
    private String type;

    Bitmap enemy[] = new Bitmap[3];
    int enemyFrame = 0;
    private int positionX;
    public int positionY;
    public int enemyVelocity;
    Random random;


    public Enemy(Context context) {
        this.health = health;
        this.enemyVelocity = enemyVelocity;
        this.positionX = positionX;
        this.positionY = positionY;
        this.type = type;
        this.attaque = attaque;

        enemy[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
        enemy[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);
        enemy[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemi1);

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
        return type;
    }

    public void move() {
        positionX--;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }
}
