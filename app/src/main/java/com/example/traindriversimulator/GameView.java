package com.example.traindriversimulator;

import static com.example.traindriversimulator.GamesActivity.X;
import static com.example.traindriversimulator.GamesActivity.longclick;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.os.Handler;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Random;

public class GameView extends View {

    Bitmap background, base, train, rail, murT1, murT2,tourT1,mineT1,titreTransport,cataT1,emplacmentConstru,constru1,constru2,constru3,constru4,avantPartie;
    Rect rectBackground, rectBase, rectTrain, rectRail, rectMurT1,rectTitreTransport,rectEmplacementConstru,rectB1,rectB2,rectB3,rectB4,rectAvantPartie;
    public static Context context;
    Handler handler;
    final long UPADATE_MILLIS = 30;
    Runnable runnable;
    Paint textPaint = new Paint();
    Paint ennemiHeath = new Paint();
    Paint textPaint2 = new Paint();
    Paint healthPaint = new Paint();
    Paint infoTopPaint = new Paint();
    Paint projectilePiant = new Paint();
    Paint projectilePiantCatapult = new Paint();

    public static int points = 0;
    public static int partieLancer= 0;
    public static int etatConstruction=0;
    int animTrain=0;
    int life = 1000;
    private int lifeInit = 1000;
    int range_munition = 70;
    static int dWidth, dHeight;
    Random random;
    int  positionMurX;
    public static int nb_spawn;
    float baseX, baseY, trainX= -850, trainY, doigtX, doigtY,angle;
    public static int timerMancheAttaque=0;
    public static int timerMancheDefense=0;
    private int timerseconde=0;
    public static int globalTimer;
    private int etatPartie = 0;
    public static int constructionPossible = 1;
    public static int nb_manche = 0;
    public static int pouvoirPossible = 0;
    public static int outilPossible = 1;


    Boolean positionMurY;
    public  static ArrayList<Enemy> enemies;
    ArrayList<Explosion> explosions;
    public static ArrayList<Tower> towers;
    public static ArrayList<Mine> mines;
    public static ArrayList<Catapult> catapults;
    public static ArrayList<Batiment> batiments1;
    public static ArrayList<Batiment> batiments2;
    public static ArrayList<Batiment> batiments3;
    ArrayList<MurGrand> mursG;
    ArrayList<MurPetit> mursP;

    private int randMur;
    private int mapAuto ;
    private int tirEtat;
    private Matrix matrix = new Matrix();
    private int rdm_deplacement;
    private int choixConstru;
    private int choixEmplacement;
    private int Xemplacement;
    private int Yemplacement;
    private int batimentCC;
    private int nb_infirmerie;
    public static int nb_Reserve;
    private int healInfEffectue;
    private int nb_avantP;
    private int nb_Potion;
    private boolean etatBoostReserve = true;


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
        cataT1 = BitmapFactory.decodeResource(getResources(), R.drawable.t3);
        titreTransport = BitmapFactory.decodeResource(getResources(), R.drawable.titre_de_transport);
        tourT1 = BitmapFactory.decodeResource(getResources(), R.drawable.t1);
        mineT1 = BitmapFactory.decodeResource(getResources(), R.drawable.mine1_ground);
        emplacmentConstru = BitmapFactory.decodeResource(getResources(), R.drawable.construction);
        constru1 = BitmapFactory.decodeResource(getResources(), R.drawable.infirmerie);
        constru2 = BitmapFactory.decodeResource(getResources(), R.drawable.reserve);
        constru3= BitmapFactory.decodeResource(getResources(), R.drawable.avantpost);
        constru4= BitmapFactory.decodeResource(getResources(), R.drawable.potion);
        avantPartie= BitmapFactory.decodeResource(getResources(), R.drawable.avantlapartie);








        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        dWidth = size.x;
        dHeight = size.y;
        rectBackground = new Rect(0, 0, dWidth, dHeight);
        rectAvantPartie = new Rect(0, 0, dWidth, dHeight);
        rectBase = new Rect(0, dHeight - base.getHeight(), dWidth, dHeight);
        rectB1 = new Rect(0, dHeight - base.getHeight(), dWidth, dHeight);
        rectB4 = new Rect(0, dHeight - base.getHeight(), dWidth, dHeight);
        rectB3 = new Rect(0, dHeight - base.getHeight(), dWidth, dHeight);
        rectB2 = new Rect(0, dHeight - base.getHeight(), dWidth, dHeight);
        rectTrain = new Rect((int) trainX, 0, (int) (train.getWidth()+ trainX), 200);
        rectRail = new Rect(0, 0, dWidth, 250);
        rectMurT1 = new Rect(0, 0, murT1.getWidth(), murT1.getHeight());
        rectTitreTransport = new Rect(10, 10, titreTransport.getWidth()+10, titreTransport.getHeight()+10);
        rectEmplacementConstru = new Rect(10, 10, titreTransport.getWidth()+10, titreTransport.getHeight()+10);



        handler = new Handler();




        textPaint.setColor(Color.rgb(255, 165, 0));
        textPaint.setTextSize(50);
        textPaint.setTextAlign(Paint.Align.LEFT);

        textPaint2.setColor(Color.rgb(255, 0, 0));
        textPaint2.setTextSize(50);
        textPaint2.setTextAlign(Paint.Align.CENTER);


        projectilePiant.setColor(Color.CYAN);
        projectilePiantCatapult.setColor(Color.RED);
        projectilePiant.setStrokeWidth(10);
        projectilePiantCatapult.setStrokeWidth(30);
        healthPaint.setColor(Color.GREEN);
        ennemiHeath.setColor(Color.GREEN);
        infoTopPaint.setColor(Color.GRAY);
        random = new Random();
        baseX = 0;
        baseY = size.y;
        trainY = 0;
        nb_manche=0;
        points=0;
        enemies = new ArrayList<>();
        towers = new ArrayList<>();
        explosions = new ArrayList<>();
        catapults = new ArrayList<>();
        batiments1 = new ArrayList<>();
        batiments2 = new ArrayList<>();
        batiments3 = new ArrayList<>();
        mines = new ArrayList<>();
        mursG = new ArrayList<>();
        mursP = new ArrayList<>();
        randMur = random.nextInt(200);
        mapAuto = random.nextInt(1);


        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();

            }
        };

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

        canvas.drawBitmap(background, null, rectBackground, null);
        canvas.drawBitmap(rail, null, rectRail, null);
        canvas.drawBitmap(train, null, rectTrain, null);


        switch(partieLancer) {
            case 1:
                //=================appel mode de jeu====================
                QuickPlay(canvas);


                //=================appel choix de la map================
                ChoixMap(canvas, /*MenuActivity.mapChoisi*/1);

                //gestion des timers
                GestionTimer();


                //Fonction importante
                switch (etatPartie) {
                    case 0:
                        switch (etatConstruction) {
                            case 1:
                                Construction(canvas);
                                break;
                        }
                        break;
                }
            break;
            case 0:
                switch (""+(rectAvantPartie.contains((int)GamesActivity.X,(int)GamesActivity.Y))){
                case "true":
                    partieLancer=1;
                    break;
                }
                break;
        }







//____________________________________spawn_________________
        if(animTrain==1 && trainX + train.getWidth() < dWidth - 100 ){
            trainX = trainX + 4;
            rectTrain.set((int) trainX, 0, (int) (train.getWidth()+ trainX), 200);
        }

        if((etatPartie==0 && 200- timerseconde < 30 )|| (etatPartie==1 && nb_spawn < 5*nb_manche)){
            trainX = trainX + 12;
            rectTrain.set((int) trainX, 0, (int) (train.getWidth()+ trainX), 200);
        }






        //gestion des ennemi__________________________________________________________________

        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).rdm_deplacement = random.nextInt(70);
            canvas.drawBitmap(enemies.get(i).getEnemy(enemies.get(i).enemyFrame), enemies.get(i).getPositionX(), enemies.get(i).getPositionY(), null);
            enemies.get(i).enemyFrame++;
            if (enemies.get(i).enemyFrame > 6) {
                enemies.get(i).enemyFrame = 0;
            }

            //gestion vie graphique ennemi

            canvas.drawRect(enemies.get(i).positionX, enemies.get(i).positionY, (int) (enemies.get(i).positionX + ((enemies.get(i).getHealth() * 100 / enemies.get(i).healthInit)) * 0.5), enemies.get(i).positionY + 5, ennemiHeath);


            //Gestion des bâtiments spéciaux

            //infirmerie


            switch(nb_infirmerie){
                case 0 :
                    break;
                default:
                    switch (etatPartie){
                        case 0:
                            switch (healInfEffectue){
                                case 1:
                                    if(life + 100*nb_infirmerie < lifeInit){
                                        life += 100*nb_infirmerie;
                                        System.out.println("heal");
                                        healInfEffectue = 0;
                                }
                                    break;
                            }
                            break;
                        case 1:
                            healInfEffectue = 1;
                            break;
                    }
                    break;
            }

            //Reserve








            //tourelle
            for (int j = 0; j < towers.size(); j++) {
                if (towers.get(j).Tx - enemies.get(i).positionX <= towers.get(j).getRange() && towers.get(j).Ty - enemies.get(i).positionY <= towers.get(j).getRange()
                        && enemies.get(i).positionX - towers.get(j).Tx <= towers.get(j).getRange() && towers.get(j).Ty - enemies.get(i).positionY <= towers.get(j).getRange()
                        && towers.get(j).Tx - enemies.get(i).positionX <= towers.get(j).getRange() && enemies.get(i).positionY - towers.get(j).Ty <= towers.get(j).getRange()
                        && enemies.get(i).positionX - towers.get(j).Tx <= towers.get(j).getRange() && enemies.get(i).positionY - towers.get(j).Ty <= towers.get(j).getRange()
                        && enemies.get(i).getEtat() == 1) {


                    if (towers.get(j).towerTimer >= towers.get(j).towerCoolDownLimit) {
                        towers.get(j).towerFrame = 3;
                        Explosion(i);
                        canvas.drawLine(towers.get((j)).Tx, towers.get((j)).Ty - 6 * tourT1.getHeight() / 10, enemies.get(i).positionX, enemies.get(i).positionY, projectilePiant);
                        towers.get(j).towerTimer = 0;
                        MortEnemy(canvas, i, towers.get(j).getDamage());
                        towers.get(j).towerFrame = 0;
                    }

                }

            }

            //pétard de voie
            for (int j = 0; j < mines.size(); j++) {

                if (mines.get(j).x - enemies.get(i).positionX <= mines.get(j).getRange() && mines.get(j).y - enemies.get(i).positionY <= mines.get(j).getRange()
                        && enemies.get(i).positionX - mines.get(j).x <= mines.get(j).getRange() && mines.get(j).y - enemies.get(i).positionY <= mines.get(j).getRange()
                        && mines.get(j).x - enemies.get(i).positionX <= mines.get(j).getRange() && enemies.get(i).positionY - mines.get(j).y <= mines.get(j).getRange()
                        && enemies.get(i).positionX - mines.get(j).x <= mines.get(j).getRange() && enemies.get(i).positionY - mines.get(j).y <= mines.get(j).getRange()) {


                    switch (mines.get(j).mineFrame) {

                        default:
                            mines.get(j).mineFrame = 1;
                            mines.get(j).mineFrame = 2;
                            mines.get(j).mineFrame = 3;
                            mines.get(j).mineFrame = 4;
                            mines.get(j).mineFrame = 5;
                            break;


                        case 5:
                            for (int e = 0; e < enemies.size(); e++) {
                                if (mines.get(j).x - enemies.get(e).positionX <= mines.get(j).getRange() + 100 && mines.get(j).y - enemies.get(e).positionY <= mines.get(j).getRange() + 100
                                        && enemies.get(e).positionX - mines.get(j).x <= mines.get(j).getRange() + 100 && mines.get(j).y - enemies.get(e).positionY <= mines.get(j).getRange() + 100
                                        && mines.get(j).x - enemies.get(e).positionX <= mines.get(j).getRange() + 100 && enemies.get(e).positionY - mines.get(j).y <= mines.get(j).getRange() + 100
                                        && enemies.get(e).positionX - mines.get(j).x <= mines.get(j).getRange() + 100 && enemies.get(e).positionY - mines.get(j).y <= mines.get(j).getRange() + 100) {
                                    MortEnemy(canvas, e, mines.get(j).getDamage());
                                }
                            }

                            Explosion(i);
                            mines.get(j).mineFrame = 0;
                            mines.remove(j);
                            break;

                    }


                }
            }

            //catapult
            for (int j = 0; j < catapults.size(); j++) {

                if (catapults.get(j).Tx - enemies.get(i).positionX <= catapults.get(j).getRange() && catapults.get(j).Ty - enemies.get(i).positionY <= catapults.get(j).getRange()
                        && enemies.get(i).positionX - catapults.get(j).Tx <= catapults.get(j).getRange() && catapults.get(j).Ty - enemies.get(i).positionY <= catapults.get(j).getRange()
                        && catapults.get(j).Tx - enemies.get(i).positionX <= catapults.get(j).getRange() && enemies.get(i).positionY - catapults.get(j).Ty <= catapults.get(j).getRange()
                        && enemies.get(i).positionX - catapults.get(j).Tx <= catapults.get(j).getRange() && enemies.get(i).positionY - catapults.get(j).Ty <= catapults.get(j).getRange()) {


                    if (catapults.get(j).catapultTimer >= catapults.get(j).catapultCoolDownLimit) {
                        catapults.get(j).catapultFrame = 1;
                        canvas.drawLine(catapults.get((j)).Tx, catapults.get((j)).Ty - 6 * cataT1.getHeight() / 10, enemies.get(i).positionX, enemies.get(i).positionY, projectilePiantCatapult);

                        Explosion(i);
                        MortEnemy(canvas, i, catapults.get(j).getDamage());

                        /*
                        for(int e=0; e<enemies.size(); e++) {
                            if(enemies.get(i).positionX - enemies.get(e).positionX <= range_munition && enemies.get(i).positionY - enemies.get(e).positionY <= range_munition
                                    && enemies.get(e).positionX -enemies.get(i).positionX <= range_munition && enemies.get(i).positionY - enemies.get(e).positionY <= range_munition
                                    && enemies.get(i).positionX - enemies.get(e).positionX <= range_munition && enemies.get(e).positionY - enemies.get(i).positionY <= range_munition
                                    && enemies.get(e).positionX -enemies.get(i).positionX <= range_munition && enemies.get(e).positionY - enemies.get(i).positionY <= range_munition) {
                                MortEnemy(canvas, e, catapults.get(j).getDamage());


                                Explosion(e);
                                MortEnemy(canvas,i,catapults.get(j).getDamage());
                            }
                        }*/


                        catapults.get(j).catapultFrame = 0;
                        catapults.get(j).catapultTimer = 0;
                    }


                }

            }


            //_________________________"IA"_____________________________________________________________
            //gestion déplacement enemie sur les murs de gauche


            switch (batimentCC){
                default:


                    for (int j = 0; j < mursG.size(); j++) {

                        if (enemies.get(i).positionY + enemies.get(i).getEnemyWidth() + enemies.get(i).rdm_deplacement > mursG.get(j).getMGY()
                                && enemies.get(i).positionY + enemies.get(i).getEnemyWidth() + enemies.get(i).rdm_deplacement < mursG.get(j).getMGY() + murT1.getHeight()
                                && enemies.get(i).positionX - enemies.get(i).rdm_deplacement < mursG.get(j).getMGX() + murT1.getWidth()) {

                            enemies.get(i).positionX += enemies.get(i).enemyVelocityX;
                            enemies.get(i).enemyVelocityY = 0;
                        }
                    }


                    //gestion déplacement enemie sur les murs de droite
                    for (int j = 0; j < mursP.size(); j++) {
                        if (enemies.get(i).positionY + enemies.get(i).getEnemyWidth() + enemies.get(i).rdm_deplacement > mursP.get(j).getMPY()
                                && enemies.get(i).positionY + enemies.get(i).getEnemyWidth() + enemies.get(i).rdm_deplacement < mursP.get(j).getMPY() + murT2.getHeight()
                                && enemies.get(i).positionX + enemies.get(i).rdm_deplacement < mursP.get(j).getMPX() + murT2.getWidth()
                                && enemies.get(i).positionX + enemies.get(i).getEnemyWidth() + enemies.get(i).rdm_deplacement > mursP.get(j).getMPX()) {

                            enemies.get(i).positionX += -enemies.get(i).enemyVelocityX;
                            enemies.get(i).enemyVelocityY = 0;

                        }


                    }
                    if (enemies.get(i).getEtat() != 0) {
                        enemies.get(i).positionY += enemies.get(i).enemyVelocityY;
                        enemies.get(i).resetEnemyVelocity();
                    }
                    break;
            }
        }



        //Gestion des suicides sur la base
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).positionY + enemies.get(i).getEnemyWidth() >= baseY - base.getHeight() && enemies.get(i).getEtat() == 1) {
                life = life - enemies.get(i).getAttaque();
                MortEnemy(canvas,i,10);

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
        if ((float) (((life*100)/lifeInit)) <= 75 && (float) (((life*100)/lifeInit))> 50) {
            healthPaint.setColor(Color.YELLOW);
            base = BitmapFactory.decodeResource(getResources(), R.drawable.base);

        } else if ((float) (((life*100)/lifeInit)) <= 50 && (float) (((life*100)/lifeInit)) > 25) {
            healthPaint.setColor(Color.rgb(255,127,0));
            base = BitmapFactory.decodeResource(getResources(), R.drawable.base);
        }else if ((float) (((life*100)/lifeInit)) <= 25) {
            healthPaint.setColor(Color.RED);
            base = BitmapFactory.decodeResource(getResources(), R.drawable.base_casse);

        }




        canvas.drawRect( 50, dHeight - 9*dHeight/60, (float) ( (dWidth - 50 )*(((life*100)/lifeInit)*0.01)), dHeight - 9*dHeight/60 - 10, healthPaint);
        canvas.drawRect(0,0,dWidth,45+55,infoTopPaint );
        canvas.drawText("" + points, titreTransport.getWidth()+20, 45, textPaint);
        canvas.drawBitmap(titreTransport,null,rectTitreTransport,null);


        switch (etatPartie){
            case 0:
                canvas.drawText(" "+(30 - timerseconde)+" sec ||"+" Préparation ||",dWidth/2,45,textPaint2);
                //canvas.drawText("Préparation",dWidth/2,50*2,textPaint2);
                break;
            case 1:
                canvas.drawText("||"+" Manche " + nb_manche + "||",dWidth/2,45,textPaint2);
                canvas.drawText("// "+nb_spawn+" Ennemie restant "+"\\",dWidth/2,45 + 50,textPaint2);
                //canvas.drawText("Manche " + nb_manche,dWidth/2,50*2,textPaint2);
                break;
            case 2:
                canvas.drawText("|| VICTOIRE ||",dWidth/2,dHeight/2,textPaint2);
                //canvas.drawText("Manche " + nb_manche,dWidth/2,50*2,textPaint2);
                break;
        }
        handler.postDelayed(runnable, UPADATE_MILLIS);


        switch(partieLancer){
            case 0 :
                canvas.drawBitmap(avantPartie,null,rectAvantPartie,null);
                break;
            default:
                break;


        }




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

                    //emplacement construction
                    //canvas.drawBitmap(emplacmentConstru,mursG.get(i).getMGX() + 10,mursG.get(i).getMGY() - murT1.getHeight() - emplacmentConstru.getHeight() + 50 ,null);


                }

                for (int i = 1; i < mursP.size(); i++) {
                    mursP.get(0).y = rail.getHeight() + mursG.get(0).y;
                    mursP.get(0).x = dWidth - murT2.getWidth();

                    canvas.drawBitmap(mursP.get(0).getMurPetit(mursP.get(0).murFrame), mursP.get(0).getMPX(), mursP.get(0).getMPY(), null);

                    mursP.get(i).y = mursG.get(i).y + murT1.getHeight() + 100;
                    mursP.get(i).x = mursP.get(0).x;
                    canvas.drawBitmap(mursP.get(i).getMurPetit(mursP.get(i).murFrame), mursP.get(i).getMPX(), mursP.get(i).getMPY(), null);

                    //emplacement contruction
                    //canvas.drawBitmap(emplacmentConstru,mursP.get(i).getMPX() - 10 + 2*emplacmentConstru.getWidth(),mursP.get(i).getMPY()  - murT1.getHeight() - emplacmentConstru.getHeight() + 50 ,null);

                }

                //graphique bâtiment
                canvas.drawBitmap(base, null, rectBase, null);

                for (int i=0; i < towers.size();i++){
                        canvas.drawBitmap(towers.get(i).getTower(towers.get(i).towerFrame), towers.get(i).getTX() - tourT1.getWidth() / 2, towers.get(i).getTY() - 4 * tourT1.getHeight() / 5, null);


                }
                for (int i=0; i < catapults.size();i++){
                    canvas.drawBitmap(catapults.get(i).getCatapult(catapults.get(i).catapultFrame),catapults.get(i).Tx - cataT1.getWidth()/2 ,catapults.get(i).Ty - 3*cataT1.getHeight()/4 ,null);

                }


                for (int i=0; i < mines.size();i++){
                    canvas.drawBitmap(mines.get(i).getMine(mines.get(i).mineFrame),mines.get(i).x - mineT1.getWidth()/2 ,mines.get(i).y - mineT1.getHeight()/2 ,null);

                }
                for (int i=0; i < batiments1.size();i++){
                    canvas.drawBitmap(batiments1.get(i).getBatiment(batiments1.get(i).batimentFrame),batiments1.get(i).Cx -constru1.getWidth()/2 ,batiments1.get(i).Cy - constru1.getHeight()/2 ,null);

                }
                for (int i=0; i < batiments2.size();i++){
                    canvas.drawBitmap(batiments2.get(i).getBatiment(batiments2.get(i).batimentFrame),batiments2.get(i).Cx -constru1.getWidth()/2 ,batiments2.get(i).Cy - constru1.getHeight()/2 ,null);

                }for (int i=0; i < batiments3.size();i++){
                canvas.drawBitmap(batiments3.get(i).getBatiment(batiments3.get(i).batimentFrame),batiments3.get(i).Cx -constru1.getWidth()/2 ,batiments3.get(i).Cy - constru1.getHeight()/2 ,null);

            }


            break;
        }
    }



    @RequiresApi(api = Build.VERSION_CODES.R)
    public void GestionTimer(){
        globalTimer++;


        switch(etatPartie){
            case 0:
                timerMancheDefense++;
                timerMancheAttaque=0;
                if(timerMancheDefense >= 25){
                    timerseconde++;
                    timerMancheDefense=0;
                }
                break;
            case 1:
                timerMancheAttaque++;
                timerMancheDefense=0;
                if(timerMancheAttaque >= 25){
                    timerseconde++;
                    timerMancheAttaque=0;
                }
                break;
            case 2:
                timerMancheAttaque++;
                timerMancheDefense=0;
                if(timerMancheAttaque >= 25){
                    timerseconde++;
                    timerMancheAttaque=0;
                }
                break;
        }

        for (int i=0;i<towers.size();i++){
            towers.get(i).towerTimer++;
        }
        for (int i=0;i<catapults.size();i++){
            catapults.get(i).catapultTimer++;
        }

    }

    public void MortEnemy(Canvas canvas, int enemyi, int damage) {
        enemies.get(enemyi).setHealth(enemies.get(enemyi).getHealth() - damage);
        if (enemies.get(enemyi).getHealth() <= 0) {
            enemies.get(enemyi).enemyTuer();
            nb_spawn--;
            /// Faire en sorte que chaque type d'ennemi donne une somme diff
            points  += enemies.get(enemyi).loot; // Add 20 points to the score when an enemy dies


        }


    }

    public class MyLongClickListener implements View.OnLongClickListener {
        @RequiresApi(api = Build.VERSION_CODES.R)
        @Override
        public boolean onLongClick(View v) {
            switch (etatConstruction){
                case 1:



                    break;
            }

            return false;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.R)
    public void Construction(Canvas canvas){
        for (int i = 1; i < mursP.size(); i++) {
            rectEmplacementConstru.set(mursP.get(i).getMPX() +360,mursP.get(i).getMPY() -300  ,mursP.get(i).getMPX()+ emplacmentConstru.getWidth() +360 ,mursP.get(i).getMPY()-300 + emplacmentConstru.getHeight());
            canvas.drawBitmap(emplacmentConstru,null,rectEmplacementConstru,null);

            switch(""+(rectEmplacementConstru.contains((int)GamesActivity.X,(int)GamesActivity.Y))){
                case "true":
                            choixConstru=1;
                            contruBatGraphique(canvas);
                            choixEmplacement=10+i;
                break;

            }
       }
        for (int i = 1; i < mursG.size(); i++) {
            rectEmplacementConstru.set(mursG.get(i).getMGX() + dWidth/40,mursG.get(i).getMGY() - murT1.getHeight() - emplacmentConstru.getHeight() +dWidth/40,mursG.get(i).getMGX() + dWidth/40 + 1*emplacmentConstru.getWidth(),mursG.get(i).getMGY() - murT1.getHeight() - emplacmentConstru.getHeight() +dWidth/40 + emplacmentConstru.getHeight());
            canvas.drawBitmap(emplacmentConstru,null,rectEmplacementConstru,null);

            switch(""+(rectEmplacementConstru.contains((int)GamesActivity.X,(int)GamesActivity.Y))){
                case "true":
                            choixConstru=1;
                            contruBatGraphique(canvas);
                            choixEmplacement=i;

                break;

            }
        }
        switch (choixEmplacement){
            case 1:
                Xemplacement=mursG.get(1).getMGX() + dWidth/40;
                Yemplacement=mursG.get(1).getMGY() - murT1.getHeight() - emplacmentConstru.getHeight() +dWidth/8;
                batimentCC = 1;

                break;
            case 2:
                Xemplacement=mursG.get(2).getMGX() + dWidth/40;
                Yemplacement=mursG.get(2).getMGY() - murT1.getHeight() - emplacmentConstru.getHeight() +dWidth/8;
                batimentCC = 2;

                break;
            case 11:
                Xemplacement=mursP.get(1).getMPX() +560;
                Yemplacement=mursP.get(1).getMPY() -180;
                batimentCC = 3;
                break;
        }

        switch(""+(rectB1.contains((int)GamesActivity.X,(int)GamesActivity.Y))){
            case "true":
                GamesActivity.X = -1000;
                GamesActivity.Y=-1000;
                switch (choixConstru) {
                    case 1 :
                    switch(choixEmplacement) {
                        case 1:
                            Batiment batiment = new Batiment(context, Xemplacement, Yemplacement, 1);
                            batiments1.add(batiment);
                            choixConstru = 0;
                            nb_infirmerie +=1;

                            if(batiments1.size() > 1){
                                batiments1.remove(0);
                                nb_infirmerie =- 1;
                            }
                            System.out.println(batiments1.size());

                            break;
                        case 2:
                            batiment = new Batiment(context, Xemplacement, Yemplacement, 1);
                            batiments2.add(batiment);
                            choixConstru = 0;
                            nb_infirmerie +=1;
                            if(batiments2.size() > 1){
                                batiments2.remove(0);
                                nb_infirmerie =- 1;
                            }
                            break;
                        case 11:
                            batiment = new Batiment(context, Xemplacement, Yemplacement, 1);
                            batiments3.add(batiment);
                            choixConstru = 0;
                            nb_infirmerie +=1;
                            if(batiments3.size() > 1){
                                batiments3.remove(0);
                                nb_infirmerie =- 1;
                            }
                            break;
                    }
                    break;

                }

                break;

        }

        switch(""+(rectB2.contains((int)GamesActivity.X,(int)GamesActivity.Y))){
            case "true":
                GamesActivity.X = -1000;
                GamesActivity.Y=-1000;
                switch (choixConstru) {
                    case 1 :
                        switch(choixEmplacement) {

                            case 1:
                                Batiment batiment = new Batiment(context, Xemplacement, Yemplacement, 2);
                                batiments1.add(batiment);
                                choixConstru = 0;
                                boostDegat();
                                if(batiments1.size() > 1){
                                    batiments1.remove(0);
                                    deBoostDegat();
                                }
                                break;
                            case 2:
                                batiment = new Batiment(context, Xemplacement, Yemplacement, 2);
                                batiments2.add(batiment);
                                boostDegat();
                                if(batiments2.size() > 1){
                                    batiments2.remove(0);
                                    deBoostDegat();
                                }
                                choixConstru = 0;

                                break;
                            case 11:
                                batiment = new Batiment(context, Xemplacement, Yemplacement, 2);
                                batiments3.add(batiment);
                                choixConstru = 0;
                                boostDegat();
                                if(batiments3.size() > 1){
                                    batiments3.remove(0);
                                    deBoostDegat();

                                }
                                break;
                        }
                        break;

                }
                break;
        }
        switch(""+(rectB3.contains((int)GamesActivity.X,(int)GamesActivity.Y))){
            case "true":
                GamesActivity.X = -1000;
                GamesActivity.Y=-1000;
                switch (choixConstru) {
                    case 1 :
                        switch(choixEmplacement) {

                            case 1:
                                Batiment batiment = new Batiment(context, Xemplacement, Yemplacement, 3);
                                batiments1.add(batiment);
                                choixConstru = 0;
                                nb_avantP += 1;
                                if(batiments1.size() > 1){
                                    batiments1.remove(0);
                                    nb_avantP -= 1;
                                }
                                break;
                            case 2:
                                batiment = new Batiment(context, Xemplacement, Yemplacement, 3);
                                batiments2.add(batiment);
                                choixConstru = 0;
                                nb_avantP += 1;
                                if(batiments2.size() > 1){
                                    batiments2.remove(0);
                                    nb_avantP -= 1;

                                }
                                break;
                            case 11:
                                batiment = new Batiment(context, Xemplacement, Yemplacement, 3);
                                batiments3.add(batiment);
                                choixConstru = 0;
                                nb_avantP += 1;
                                if(batiments3.size() > 1){
                                    batiments3.remove(0);
                                    nb_avantP -= 1;

                                }
                                break;
                        }
                        break;

                }
        }
        switch(""+(rectB4.contains((int)GamesActivity.X,(int)GamesActivity.Y))){
            case "true":
                GamesActivity.X = -1000;
                GamesActivity.Y=-1000;
                switch (choixConstru) {
                    case 1 :
                        switch(choixEmplacement) {

                            case 1:
                                Batiment batiment = new Batiment(context, Xemplacement, Yemplacement, 4);
                                batiments1.add(batiment);
                                choixConstru = 0;
                                nb_Potion +=1;
                                if(batiments1.size() > 1){
                                    batiments1.remove(0);
                                    nb_Potion -=1;

                                }
                                break;
                            case 2:
                                batiment = new Batiment(context, Xemplacement, Yemplacement, 4);
                                batiments2.add(batiment);
                                choixConstru = 0;
                                nb_Potion +=1;
                                if(batiments2.size() > 1){
                                    batiments2.remove(0);
                                    nb_Potion -=1;
                                }
                                break;
                            case 11:
                                batiment = new Batiment(context, Xemplacement, Yemplacement, 4);
                                batiments3.add(batiment);
                                choixConstru = 0;
                                nb_Potion +=1;
                                if(batiments3.size() > 1){
                                    batiments3.remove(0);
                                    nb_Potion -=1;
                                }
                                break;
                        }
                        break;
                }
                break;
        }
    }

    private void contruBatGraphique(Canvas canvas){
        rectB1.set(dWidth/2 -constru1.getWidth()/2-200,dHeight/2- constru1.getWidth()/2 ,dWidth/2+constru1.getWidth()- constru1.getWidth()/2-200,dHeight/2+ constru1.getHeight()- constru1.getWidth()/2);
        rectB2.set(dWidth/2 - constru1.getWidth()/2+200,dHeight/2 - constru1.getWidth()/2,dWidth/2+constru1.getWidth()- constru1.getWidth()/2+200,dHeight/2+ constru1.getHeight()- constru1.getWidth()/2);
        rectB3.set(dWidth/2- constru1.getWidth()/2,dHeight/2 - constru1.getWidth()/2-200,dWidth/2+constru1.getWidth()- constru1.getWidth()/2,dHeight/2+ constru1.getHeight()- constru1.getWidth()/2-200);
        rectB4.set(dWidth/2- constru1.getWidth()/2,dHeight/2- constru1.getWidth()/2+200 ,dWidth/2+constru1.getWidth()- constru1.getWidth()/2,dHeight/2 + constru1.getHeight()- constru1.getWidth()/2 + 200);

        canvas.drawBitmap(constru1,null,rectB1,null);
        canvas.drawBitmap(constru2,null,rectB2,null);
        canvas.drawBitmap(constru3,null,rectB3,null);
        canvas.drawBitmap(constru4,null,rectB4,null);
    }

    private void Explosion(int enemyi){
        Explosion explosion = new Explosion(context);
        explosion.explosionX = enemies.get(enemyi).getPositionX();
        explosion.explosionY = enemies.get(enemyi).positionY;
        explosions.add(explosion);
    }

    private void spawnEnemy(int nb_spawn,String name){
        for (int i = 0; i < nb_spawn; i++) {
            Enemy enemy = new Enemy(context,name);
            enemies.add(enemy);
        }
    }

    private void boostDegat(){
        for (int i = 0; i < towers.size(); i++) {
            towers.get(i).setDamage((int)(towers.get(i).getDamage()*1.50));
        }
        for (int i = 0; i < mines.size(); i++) {
            mines.get(i).setDamage((int)(mines.get(i).getDamage()*1.30) );

        }
        for (int i = 0; i < catapults.size(); i++) {
            catapults.get(i).setDamage((int)(catapults.get(i).getDamage()*1.20) );

        }
        System.out.println("boost degat");
    }

    private void deBoostDegat(){
        for (int i = 0; i < towers.size(); i++) {
            towers.get(i).setDamage((int)(towers.get(i).getDamage()*0.50));
        }
        for (int i = 0; i < mines.size(); i++) {
            mines.get(i).setDamage((int)(mines.get(i).getDamage()*0.30) );

        }
        for (int i = 0; i < catapults.size(); i++) {
            catapults.get(i).setDamage((int)(catapults.get(i).getDamage()*0.20) );

        }
        System.out.println("deboost de degat");
    }









    @RequiresApi(api = Build.VERSION_CODES.R)
    public void QuickPlay(Canvas canvas){
        // pendant 30 secondes le joueur build les defenses
        switch (etatPartie){
            case 0 : //Round préparation

                constructionPossible=1;
                pouvoirPossible=0;
                outilPossible=1;

                ///Faire en sorte que toute les n manches la somme augmente
                if(30 - timerseconde == 29){
                    points += 200*nb_Potion;
                    points += 2 + (int)(points * 0.01) ;

                }

                if(30 - timerseconde == 0){
                    nb_manche++;
                    timerseconde=0;
                    etatPartie = 1;

                    animTrain=0;

                    VagueEnemyMaker.Spawn(nb_manche);
                    GamesActivity.choisi="Rien pour le moment";
                }

                if(30 - timerseconde <= 10){
                    animTrain=1;


                }
                if(nb_manche==15){
                    etatPartie=2;
                }

                break;
            case 1: //Round de defense
                constructionPossible=0;
                pouvoirPossible=1;
                outilPossible=0;





                if(nb_spawn <= 0){
                    timerseconde=0;
                    etatPartie = 0;
                    trainX = -850;
                }

                break;
            case 2:
                constructionPossible=0;
                pouvoirPossible=1;
                outilPossible=0;

                if(nb_spawn <= 0){
                    Intent intent = new Intent(context, GGezWin.class);
                    intent.putExtra("Titres de transports", points);
                    context.startActivity(intent);
                    ((Activity) context).finish();

                }


                break;
        }
    }
}
