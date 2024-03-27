package com.example.traindriversimulator;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RequiresApi(api = Build.VERSION_CODES.R)
public class Game {


    private List<Enemy> enemies;
    private List<Tower> towers;
    private int gridX;
    private int gridY;
    private int castleHealth;



    public int position_baseX = 0;
    public int position_baseY = 0;







    public void game(int gridX, int gridY, int castleHealth) {
        this.gridX = gridX;
        this.gridY = gridY;
        this.castleHealth = castleHealth;

        enemies = new ArrayList<Enemy>();
        towers = new ArrayList<Tower>();


    }

    public void spawn() {
        //test spawn manuel
       // addEnemy(new Enemy("t",10,20,10,10,10));
      //  addEnemy(new Enemy("t",10,20,10,10,10));
       // addEnemy(new Enemy("t",10,20,10,10,10));



    }
    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
    }



    public void addTower(Tower tower) {
        towers.add(tower);

    }



    public void startgame() {

        System.out.println("base Health: " + castleHealth);
        System.out.println("Enemies:");
        for (Enemy enemy : enemies) {
            System.out.println("Position: " + enemy.getPositionX() + " | Health: " + enemy.getHealth());
        }


        // prochaine action construction
        System.out.println("Construire une tourelle? (Y/N)");
        String input = "Y";

        if (input == "Y") {
            System.out.println("emplacement de tourelle(1 à 4):");
            int emplacement = 1;
            int rangeplus = 0;
            switch (emplacement) {
                case 1:
                    rangeplus = 20;
                    break;

                case 2:
                    rangeplus = 15;
                    break;

                case 3:
                    rangeplus = 10;
                    break;

                case 4:
                    rangeplus = 5;
                    break;
                default:
                    System.out.println("Plus d'emplacement disponible");
                    break;
            }

            System.out.println("niveau de tourelle(1 à 3):");

            int lvl = 1;
            switch (lvl) {
                case 1:
                   // addTower(new Tower(10, 10 + rangeplus, 1, 1));
                    break;

                case 2:
                   // addTower(new Tower(30, 10 + rangeplus, 1, 1));
                    break;
                case 3:
                  //  addTower(new Tower(50, 10 + rangeplus, 1, 1));
                    break;

                default:
                    System.out.println("erreur pas le bon nombre");
                    break;
            }

            // movement ennemie
            for (Enemy enemy : enemies) {
                enemy.move();
                if (enemy.getPositionX() <= position_baseX + 10) {
                    castleHealth -= enemy.getAttaque();
                    enemies.remove(enemy);
                    break;
                }
            }

            // attaque ennemie
            for (Tower tower : towers) {
                for (Enemy enemy : enemies) {
                    if (Math.abs(enemy.getPositionX() - gridX) <= tower.getRange()) {
                        enemy.takeDamage(tower.getDamage());
                        if (enemy.getHealth() <= 0) {
                            enemies.remove(enemy);
                            break;
                        }
                    }
                }
            }

            // Condition de victoire
            if (castleHealth <= 0 || enemies.isEmpty()) {
                //gameRunning = false;
                if (castleHealth <= 0) {
                    System.out.println("Défaite garguantuesque!");
                } else {
                    System.out.println("Victoire Royale!");
                }

            }


        }
    }
}
