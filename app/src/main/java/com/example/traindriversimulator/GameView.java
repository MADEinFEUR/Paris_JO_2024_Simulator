package com.example.traindriversimulator;

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
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.os.Handler;
import android.widget.Button;

import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;
import java.util.Random;

public class GameView extends View{

    Bitmap background, base, train;
    Rect rectBackground, rectBase;
    Context context;
    Handler handler;
    final long UPADATE_MILLIS = 30;
    Runnable runnable;
    Paint textPaint = new Paint();
    Paint healthPaint = new Paint();
    float TEXT_SIZE = 120;
    int points = 0;
    int life = 9;
    static int dWidth, dHeight;
    Random random;
    float baseX, baseY;
    ArrayList<Enemy> enemies;
    ArrayList<Explosion> explosions;

    ArrayList<Tower> towers;




    public  GameView(Context context){
        super(context);
        this.context = context;
        background = BitmapFactory.decodeResource(getResources(),R.drawable.map);
        base = BitmapFactory.decodeResource(getResources(),R.drawable.base);
        train = BitmapFactory.decodeResource(getResources(),R.drawable.base1);
        Display display = ((Activity)getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        dWidth = size.x;
        dHeight = size.y;
        rectBackground = new Rect(0,0,dWidth,dHeight);
        rectBase = new Rect(0,dHeight-base.getHeight(),dWidth,dHeight);
        handler = new Handler();





        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();

            }
        };
        textPaint.setColor(Color.rgb(255,165,0));
        textPaint.setTextSize(TEXT_SIZE);
        textPaint.setTextAlign(Paint.Align.LEFT);
        healthPaint.setColor(Color.GREEN);
        random = new Random();
        baseX = 0 ;
        baseY = size.y;
        enemies = new ArrayList<>();
        towers = new ArrayList<>();
        explosions = new ArrayList<>();

        for(int i=0; i<3; i++){
            Enemy enemy = new Enemy(context);
            enemies.add(enemy);
        }
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(background, null, rectBackground, null);
        canvas.drawBitmap(base, null, rectBase, null);

        for (int i = 0; i < enemies.size(); i++) {
            canvas.drawBitmap(enemies.get(i).getEnemy(enemies.get(i).enemyFrame), enemies.get(i).getPositionX(), enemies.get(i).getPositionY(), null);
            enemies.get(i).enemyFrame++;
            if (enemies.get(i).enemyFrame > 3) {
                enemies.get(i).enemyFrame = 0;

            }
            enemies.get(i).positionY += enemies.get(i).enemyVelocity;

            if (enemies.get(i).getPositionY() >= baseY - base.getHeight() - 10) {

            }

        }

        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).positionY + enemies.get(i).getEnemyWidth() >=  baseY - base.getHeight()) {
                life--;
                Explosion explosion = new Explosion(context);
                explosion.explosionX = enemies.get(i).getPositionX();
                explosion.explosionY = enemies.get(i).positionY;
                explosions.add(explosion);
                enemies.get(i).resetPosition();
                if (life == 0) {
                    Intent intent = new Intent(context, GameOver.class);
                    intent.putExtra("Tires de transports", points);
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
        if (life <= 6 && life >3) {
            healthPaint.setColor(Color.YELLOW);

        } else if (life <= 3) {
            healthPaint.setColor(Color.RED);
        }
        canvas.drawRect(0, dHeight - 100, (int)((dWidth)*0.1*life) , dHeight - 150, healthPaint);
        canvas.drawText("" + points, 20, TEXT_SIZE, textPaint);
        handler.postDelayed(runnable, UPADATE_MILLIS);

    }



}
