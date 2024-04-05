package com.example.traindriversimulator;

import static com.example.traindriversimulator.GamesActivity.towers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.os.Handler;
import android.widget.Button;
import android.util.AttributeSet;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;
import java.util.Random;

public class GameView extends View {

    Bitmap background, base, train, rail, murT1, murT2,tourT1;
    Rect rectBackground, rectBase, rectTrain, rectRail, rectMurT1;
    Context context;
    Handler handler;
    final long UPADATE_MILLIS = 30;
    Runnable runnable;
    Paint textPaint = new Paint();
    Paint healthPaint = new Paint();

    float TEXT_SIZE = 120;
    int points = 0;
    int life = 1000;
    static int dWidth, dHeight;
    Random random;
    int nb_spawn, positionMurX;
    float baseX, baseY, trainX, trainY, doigtX, doigtY;
    public static int timer;


    Boolean positionMurY;
    ArrayList<Enemy> enemies;
    ArrayList<Explosion> explosions;


    ArrayList<MurGrand> mursG;
    ArrayList<MurPetit> mursP;
    private int randMur;
    private int mapAuto ;
    private int tirEtat;

    private View.OnTouchListener onTouchListener= new View.OnTouchListener() {
        @RequiresApi(api = Build.VERSION_CODES.R)
        @Override
        public boolean onTouch(View v, MotionEvent event) {







            return false;
        }
    };



    @RequiresApi(api = Build.VERSION_CODES.R)
    public GameView(Context context) {
        super(context);
        this.context = context;
        background = BitmapFactory.decodeResource(getResources(), R.drawable.map);
        base = BitmapFactory.decodeResource(getResources(), R.drawable.base);
        train = BitmapFactory.decodeResource(getResources(), R.drawable.base1);
        rail = BitmapFactory.decodeResource(getResources(), R.drawable.rail);
        murT1 = BitmapFactory.decodeResource(getResources(), R.drawable.mur_t1);
        murT2 = BitmapFactory.decodeResource(getResources(), R.drawable.mur_t2);
        tourT1 = BitmapFactory.decodeResource(getResources(), R.drawable.tower0);





        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        dWidth = size.x;
        dHeight = size.y;
        rectBackground = new Rect(0, 0, dWidth, dHeight);
        rectBase = new Rect(0, dHeight - base.getHeight(), dWidth, dHeight);
        rectTrain = new Rect(0, 0, dWidth, 200);
        rectRail = new Rect(0, 0, dWidth, 250);
        rectMurT1 = new Rect(0, 0, murT1.getWidth(), murT1.getHeight());
        handler = new Handler();




        textPaint.setColor(Color.rgb(255, 165, 0));
        textPaint.setTextSize(TEXT_SIZE);
        textPaint.setTextAlign(Paint.Align.LEFT);
        healthPaint.setColor(Color.GREEN);
        random = new Random();
        baseX = 0;
        baseY = size.y;
        trainX = 0;
        trainY = 0;
        enemies = new ArrayList<>();
        towers = new ArrayList<>();
        explosions = new ArrayList<>();
        mursG = new ArrayList<>();
        mursP = new ArrayList<>();
        nb_spawn = random.nextInt(500);
        randMur = random.nextInt(200);
        mapAuto = random.nextInt(1);


        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();

            }
        };



        //spawn
        for (int i = 0; i < nb_spawn; i++) {
            Enemy enemy = new Enemy(context);
            enemies.add(enemy);
        }
        for (int i = 0; i < 3; i++) {
            MurGrand murGrand = new MurGrand(context);
            mursG.add(murGrand);
        }

        for (int i = 0; i < 2; i++) {
            MurPetit murPetit = new MurPetit(context);
            mursP.add(murPetit);
        }


    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        GestionTimer();
        canvas.drawBitmap(background, null, rectBackground, null);
        canvas.drawBitmap(rail, null, rectRail, null);
        canvas.drawBitmap(train, null, rectTrain, null);


    //=================appel mode de jeu====================


    //=================appel choix de la map================

        ChoixMap(canvas, /*MenuActivity.mapChoisi*/1);








//____________________________________spawn

        //gestion graphique des enemis
        for (int i = 0; i < enemies.size(); i++) {
            canvas.drawBitmap(enemies.get(i).getEnemy(enemies.get(i).enemyFrame), enemies.get(i).getPositionX(), enemies.get(i).getPositionY(), null);
            enemies.get(i).enemyFrame++;
            if (enemies.get(i).enemyFrame > 6) {
                enemies.get(i).enemyFrame = 0;
            }
        //Gestion des bâtiments d'attaque
            int range = 200;
            for(int j =0; j<towers.size();j++){
                if(towers.get(j).Tx - enemies.get(i).positionX <= range && towers.get(j).Ty - enemies.get(i).positionY <= range
                        && enemies.get(i).positionX -towers.get(j).Tx <= range && towers.get(j).Ty - enemies.get(i).positionY <= range
                        && towers.get(j).Tx - enemies.get(i).positionX <= range && enemies.get(i).positionY - towers.get(j).Ty <= range
                        && enemies.get(i).positionX -towers.get(j).Tx <= range && enemies.get(i).positionY - towers.get(j).Ty <= range){


                    if(towers.get(j).towerTimer >= 50){
                        towers.get(j).towerFrame++;

                    }

                    if (towers.get(j).towerFrame > 4) {
                       towers.get(j).towerFrame = 0;
                        towers.get(j).towerTimer = 0;

                       MortEnemy(canvas,i);
                    }

                }





            }



        //_________________________"IA"_____________________________________________________________
            //gestion déplacement enemie sur les murs de gauche

            for (int j = 0; j < mursG.size(); j++) {

                if (enemies.get(i).positionY + enemies.get(i).getEnemyWidth() > mursG.get(j).getMGY() && enemies.get(i).positionY + enemies.get(i).getEnemyWidth() < mursG.get(j).getMGY() + murT1.getHeight() && enemies.get(i).positionX < mursG.get(j).getMGX() + murT1.getWidth()) {
                    enemies.get(i).positionX += enemies.get(i).enemyVelocityX;
                    enemies.get(i).enemyVelocityY = 0;
                }
            }


            //gestion déplacement enemie sur les murs de droite
            for (int j = 0; j < mursP.size(); j++) {
                if (enemies.get(i).positionY + enemies.get(i).getEnemyWidth() > mursP.get(j).getMPY() && enemies.get(i).positionY + enemies.get(i).getEnemyWidth() < mursP.get(j).getMPY()+murT2.getHeight() && enemies.get(i).positionX < mursP.get(j).getMPX() + murT2.getWidth() && enemies.get(i).positionX + enemies.get(i).getEnemyWidth() > mursP.get(j).getMPX()) {
                    enemies.get(i).positionX += -enemies.get(i).enemyVelocityX;
                    enemies.get(i).enemyVelocityY = 0;

                }




            }
            enemies.get(i).positionY += enemies.get(i).enemyVelocityY;
            enemies.get(i).enemyVelocityY = 5;
        }


        //Gestion des dégâts sur la base
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).positionY + enemies.get(i).getEnemyWidth() >= baseY - base.getHeight()) {
                life--;
                MortEnemy(canvas,i);
                /*


                Explosion explosion = new Explosion(context);
                explosion.explosionX = enemies.get(i).getPositionX();
                explosion.explosionY = enemies.get(i).positionY;
                explosions.add(explosion);
                enemies.get(i).resetPosition();
                */

                //Mort lancement activité GameOver
                if (life == 0) {
                    Intent intent = new Intent(context, GameOver.class);
                    intent.putExtra("Titres de transports", points);
                    context.startActivity(intent);
                    ((Activity) context).finish();
                }

            }
        }



        for (int i = 0; i < explosions.size(); i++) {
            canvas.drawBitmap(explosions.get(i).getExplosion(explosions.get(i).explosionFrame), explosions.get(i).explosionX, explosions.get(i).explosionY, null);
            explosions.get(i).explosionFrame++;

            if (explosions.get(i).explosionFrame >= 8) {
                explosions.remove(i);
            }
        }

        //_________________________Gestion barre de vie
        if (life <= 750 && life > 500) {
            healthPaint.setColor(Color.YELLOW);
            base = BitmapFactory.decodeResource(getResources(), R.drawable.base);

        } else if (life <= 500 && life > 250) {
            healthPaint.setColor(Color.rgb(255,127,0));
            base = BitmapFactory.decodeResource(getResources(), R.drawable.base);
        }else if (life <= 250) {
            healthPaint.setColor(Color.RED);
            base = BitmapFactory.decodeResource(getResources(), R.drawable.base_casse);

        }
        canvas.drawRect( (int)(dWidth*0.001*(1000-life)), dHeight - 9*dHeight/60, (int) ( dWidth*0.001 * life), dHeight - 9*dHeight/60 - 10, healthPaint);
        canvas.drawText("" + points, 20, TEXT_SIZE, textPaint);
        handler.postDelayed(runnable, UPADATE_MILLIS);

    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void ChoixMap(Canvas canvas, int mapChoisi){



        switch (mapChoisi) {
            default:
                break;

            case 1:

                for (int i = 1; i < mursG.size(); i++) {
                    mursG.get(0).y = +rail.getHeight() + randMur;
                    canvas.drawBitmap(mursG.get(0).getMurGrand(mursG.get(0).murFrame), mursG.get(0).getMGX(), mursG.get(0).getMGY(), null);

                    mursG.get(i).y = mursP.get(i - 1).y + murT2.getHeight() + 100;
                    canvas.drawBitmap(mursG.get(i).getMurGrand(mursG.get(i).murFrame), mursG.get(i).getMGX(), mursG.get(i).getMGY(), null);

                }

                for (int i = 1; i < mursP.size(); i++) {
                    mursP.get(0).y = rail.getHeight() + mursG.get(0).y;
                    mursP.get(0).x = dWidth - murT2.getWidth();

                    canvas.drawBitmap(mursP.get(0).getMurPetit(mursP.get(0).murFrame), mursP.get(0).getMPX(), mursP.get(0).getMPY(), null);

                    mursP.get(i).y = mursG.get(i).y + murT1.getHeight() + 100;
                    mursP.get(i).x = mursP.get(0).x;
                    canvas.drawBitmap(mursP.get(i).getMurPetit(mursP.get(i).murFrame), mursP.get(i).getMPX(), mursP.get(i).getMPY(), null);
                }

                for (int i=0; i < towers.size();i++){
                    canvas.drawBitmap(towers.get(i).getTower(towers.get(i).towerFrame),towers.get(i).getTX() - tourT1.getWidth()/2 ,towers.get(i).getTY() - 4*tourT1.getHeight()/5 ,null);

                }

                canvas.drawBitmap(base, null, rectBase, null);
            break;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.R)
    public void GestionTimer(){
        timer++;
        for (int i=0;i<towers.size();i++){
            towers.get(i).towerTimer++;
        }

    }

    public void MortEnemy(Canvas canvas, int enemyi){
        Explosion explosion = new Explosion(context);
        explosion.explosionX = enemies.get(enemyi).getPositionX();
        explosion.explosionY = enemies.get(enemyi).positionY;
        explosions.add(explosion);
        enemies.get(enemyi).resetPosition();



    }




}
