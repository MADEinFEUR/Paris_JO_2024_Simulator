package com.example.traindriversimulator;

class Tower {
    private int damage;
    private int range;
    private int x;
    private int y;

    public Tower(int damage, int range, int x, int y) {
        this.damage = damage;
        this.range = range;
        this.x = x;
        this.y = y;
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}