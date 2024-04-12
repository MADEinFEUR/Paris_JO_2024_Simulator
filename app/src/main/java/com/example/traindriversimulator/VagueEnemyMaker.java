package com.example.traindriversimulator;

import java.util.ArrayList;

public class VagueEnemyMaker {

    public static void Spawn(int nb_manche){
        switch((int)(nb_manche/5)+1){
            case 1:
                for (int i=1 ;i<10+5*(nb_manche-1);i++){
                    GameView.enemies.add(new Enemy(GameView.context,"t1"));
                    GameView.nb_spawn++;
                }


                break;
            case 2:
                for (int i=1 ;i<10+5*(nb_manche-1);i++){
                    GameView.enemies.add(new Enemy(GameView.context,"t2"));
                }
                break;
            case 3:
                for (int i=1 ;i<10+5*(nb_manche-1);i++){
                    GameView.enemies.add(new Enemy(GameView.context,"t3"));
                }
                GameView.enemies.add(new Enemy(GameView.context,"boss"));
                break;
        }

    }
}
