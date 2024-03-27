package com.example.traindriversimulator;

public class Enemy {
    private int health;
    private int positionX;
    private int positionY;
    private int attaque;
    private String type;


    public Enemy(String type, int health, int attaque, int positionX, int positionY ) {
        this.health = health;
        this.positionX = positionX;
        this.positionY = positionY;
        this.type = type;
        this.attaque = attaque;
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
