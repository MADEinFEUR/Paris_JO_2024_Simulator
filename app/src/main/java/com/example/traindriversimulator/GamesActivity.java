package com.example.traindriversimulator;

import static android.graphics.BitmapFactory.decodeResource;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.graphics.Canvas;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.R)
public class GamesActivity extends AppCompatActivity {

    int cost =0;
    public static float X=-1000;
    public static float Y=-1000;
    FrameLayout gameActivity;
    RelativeLayout GameButtons;
    GameView gameView;
    private Context context;
    public static int longclick;


    public int boutonjeux;

    //public int points = 0;

    public static String choisi = "zizi";

    public static float doigtX;
    public static float doigtY;

    private Mine mine;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;

    private View.OnTouchListener onTouchListener= new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            onClick(event);
            return false;
        }
    };



    private TextView txt;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        gameView=new GameView(this);
        gameActivity = new FrameLayout(this);
        GameButtons = new RelativeLayout(this);

        gameActivity.setOnTouchListener(onTouchListener);






        LinearLayout linearLayout1 = new LinearLayout(this);
        linearLayout1.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout1.setMinimumWidth(GameView.dWidth);
        linearLayout1.setRotationX(20);

        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout2.setMinimumHeight(100);
        linearLayout2.setMinimumWidth(GameView.dWidth);
        linearLayout2.setRotationX(-20);

        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(LinearLayout.VERTICAL);







        button1 = new Button(this);
        button2 = new Button(this);
        button3 = new Button(this);
        button4 = new Button(this);
        button5 = new Button(this);
        button6 = new Button(this);
        button7 = new Button(this);



        //bouton

        //button1.setBackgroundResource(R.drawable.t1);
        button1.setId(1);
        button1.setWidth(200);
        button1.setHeight(50);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                bouton1jeu();
            }
        });


        //button2.setBackgroundResource(R.drawable.t2);
        button2.setId(2);
        button2.setWidth(200);
        button2.setHeight(50);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bouton3jeu();

            }
        });



        //button3.setBackgroundResource(R.drawable.t3);
        button3.setId(3);
        button3.setWidth(200);

        button3.setHeight(50);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bouton2jeu();
            }
        });



        button4.setText("Armes");
        button4.setId(4);
        button4.setWidth(200);
        button4.setHeight(50);
        button4.setBackgroundColor(Color.argb(100,255,255,255));
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Armes();
            }
        });






        button5.setText("Outils");
        button5.setId(5);
        button5.setWidth(200);
        button5.setHeight(50);
        button5.setBackgroundColor(Color.argb(100,255,255,255));
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Outils();
            }
        });

        button6.setText("Pouvoirs");
        button6.setId(6);
        button6.setWidth(200);
        button6.setHeight(50);
        button6.setBackgroundColor(Color.argb(100,255,255,255));
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Power();
            }
        });



        ViewGroup.LayoutParams b1= new RelativeLayout.LayoutParams(GameView.dWidth/3,GameView.dHeight/11);
        ((RelativeLayout.LayoutParams) b1).addRule(RelativeLayout.RIGHT_OF,RelativeLayout.TRUE);
        ((RelativeLayout.LayoutParams) b1).addRule(RelativeLayout.ALIGN_TOP,RelativeLayout.TRUE);
        button1.setLayoutParams(b1);

        ViewGroup.LayoutParams b2= new RelativeLayout.LayoutParams(GameView.dWidth/3,GameView.dHeight/11);
        ((RelativeLayout.LayoutParams) b2).addRule(RelativeLayout.RIGHT_OF,RelativeLayout.TRUE);
        ((RelativeLayout.LayoutParams) b2).addRule(RelativeLayout.ALIGN_TOP,RelativeLayout.TRUE);
        button2.setLayoutParams(b2);

        ViewGroup.LayoutParams b3= new RelativeLayout.LayoutParams(GameView.dWidth/3,GameView.dHeight/11);
        ((RelativeLayout.LayoutParams) b3).addRule(RelativeLayout.RIGHT_OF,RelativeLayout.TRUE);
        ((RelativeLayout.LayoutParams) b3).addRule(RelativeLayout.ALIGN_TOP,RelativeLayout.TRUE);
        button3.setLayoutParams(b3);

        ViewGroup.LayoutParams b4= new RelativeLayout.LayoutParams(GameView.dWidth/3,GameView.dHeight/14);
        ((RelativeLayout.LayoutParams) b4).addRule(RelativeLayout.RIGHT_OF,RelativeLayout.TRUE);
        ((RelativeLayout.LayoutParams) b4).addRule(RelativeLayout.ALIGN_TOP,RelativeLayout.TRUE);
        button4.setLayoutParams(b4);

        ViewGroup.LayoutParams b5= new RelativeLayout.LayoutParams(GameView.dWidth/3,GameView.dHeight/14);
        ((RelativeLayout.LayoutParams) b5).addRule(RelativeLayout.RIGHT_OF,RelativeLayout.TRUE);
        ((RelativeLayout.LayoutParams) b5).addRule(RelativeLayout.ALIGN_TOP,RelativeLayout.TRUE);
        button5.setLayoutParams(b5);

        ViewGroup.LayoutParams b6= new RelativeLayout.LayoutParams(GameView.dWidth/3,GameView.dHeight/14);
        ((RelativeLayout.LayoutParams) b6).addRule(RelativeLayout.RIGHT_OF,RelativeLayout.TRUE);
        ((RelativeLayout.LayoutParams) b6).addRule(RelativeLayout.ALIGN_TOP,RelativeLayout.TRUE);
        button6.setLayoutParams(b6);






        //ScrollView

        HorizontalScrollView viewCapacite = new HorizontalScrollView(this);
        viewCapacite.setId(100);
        viewCapacite.setMinimumWidth(GameView.dWidth);

        HorizontalScrollView viewBoutton = new HorizontalScrollView(this);
        viewBoutton.setId(101);
        viewBoutton.setMinimumWidth(GameView.dWidth);

        ViewGroup.LayoutParams SV1= new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        ((RelativeLayout.LayoutParams) SV1).addRule(RelativeLayout.ALIGN_PARENT_LEFT,RelativeLayout.TRUE);
        ((RelativeLayout.LayoutParams) SV1).addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        ((RelativeLayout.LayoutParams) SV1).addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
        viewCapacite.setLayoutParams(SV1);

        ViewGroup.LayoutParams SV2= new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        ((RelativeLayout.LayoutParams) SV2).addRule(RelativeLayout.ALIGN_PARENT_LEFT,RelativeLayout.TRUE);
        ((RelativeLayout.LayoutParams) SV2).addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        ((RelativeLayout.LayoutParams) SV2).addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
        viewBoutton.setLayoutParams(SV2);










        //param
        ViewGroup.LayoutParams params= new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);







        GameButtons.setLayoutParams(params);
        GameButtons.addView(linearLayout3);



        linearLayout1.addView(button1);
        linearLayout1.addView(button2);
        linearLayout1.addView(button3);

        linearLayout2.addView(button4);
        linearLayout2.addView(button5);
        linearLayout2.addView(button6);

        viewCapacite.addView(linearLayout1);
        viewBoutton.addView(linearLayout2);

        linearLayout3.addView(viewBoutton);
        linearLayout3.addView(viewCapacite);

        linearLayout3.setY(GameView.dHeight - 5*GameView.dHeight/32);
        linearLayout3.setX(0);











        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.games_activity);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        gameActivity.addView(gameView);
        gameActivity.addView(GameButtons);
        setContentView(gameActivity);









    }



    WindowManager.LayoutParams ds = new WindowManager.LayoutParams(1,2);








    public void Armes() {

        boutonjeux = 1;
        //button1.setText("T1");
        button1.setBackgroundResource(R.drawable.t1);
        //button2.setText("T2");
        button2.setBackgroundResource(R.drawable.t2);
        //button3.setText("T3");
        button3.setBackgroundResource(R.drawable.t3);


    }

    public void Outils() {

        boutonjeux = 2;
       //button1.setText("Réparation");
        button1.setBackgroundResource(R.drawable.construction);
      //button2.setText("Amélioration");
        button2.setBackgroundResource(R.drawable.amelioration);
      //button3.setText("Destruction");
        button3.setBackgroundResource(R.drawable.destruction);


    }

    public void Power() {

        boutonjeux = 3;
      //button1.setText("Force Syndicale");
        button1.setBackgroundResource(R.drawable.force_syndicale);
      //button2.setText("Lanceur LBD");
        button2.setBackgroundResource(R.drawable.lanceur_lbd);
     // button3.setText("Lacrymogène");
        button3.setBackgroundResource(R.drawable.lacrymogene);


    }

    ///_________________________________bouton___________________________________________________
    public void bouton1jeu() {

        switch (boutonjeux) {
            case 1:
                switch (GameView.constructionPossible){
                    case 1:
                        choisi = "T1 choisie";
                        button1.setBackgroundColor(Color.GREEN);
                        button3.setBackgroundResource(R.drawable.t3);
                        button2.setBackgroundResource(R.drawable.t2);
                        GameView.etatConstruction = 0;
                        break;
                    default:
                        button1.setBackgroundResource(R.drawable.desactiver);
                        button3.setBackgroundResource(R.drawable.t3);
                        button2.setBackgroundResource(R.drawable.t2);
                        break;
                }

                break;
            case 2:
                switch (GameView.outilPossible){
                    case 1:
                        choisi = "Réparation choisie";
                        button1.setBackgroundColor(Color.GREEN);
                        button3.setBackgroundResource(R.drawable.destruction);
                        button2.setBackgroundResource(R.drawable.amelioration);
                        GameView.etatConstruction = 1;
                        break;
                    default:
                        button1.setBackgroundResource(R.drawable.desactiver);
                        button3.setBackgroundResource(R.drawable.destruction);
                        button2.setBackgroundResource(R.drawable.amelioration);
                        break;
                }

                break;
            case 3:
                switch (GameView.pouvoirPossible){
                    case 1:
                        choisi = "Force syndicale choisie";
                        button1.setBackgroundColor(Color.GREEN);
                        button3.setBackgroundResource(R.drawable.lacrymogene);
                        button2.setBackgroundResource(R.drawable.lanceur_lbd);
                        GameView.etatConstruction = 0;
                        if(GameView.forceSyndic = false){
                            button1.setBackgroundResource(R.drawable.desactiver);
                        }
                        break;
                    default:
                        button1.setBackgroundResource(R.drawable.desactiver);
                        button3.setBackgroundResource(R.drawable.lacrymogene);
                        button2.setBackgroundResource(R.drawable.lanceur_lbd);
                        break;
                }

                break;
        }

    }

    public void bouton2jeu() {

        switch (boutonjeux) {
            case 1:
                switch (GameView.constructionPossible){
                    case 1:
                        choisi = "T3 choisie";
                        button3.setBackgroundColor(Color.GREEN);
                        button2.setBackgroundResource(R.drawable.t2);
                        button1.setBackgroundResource(R.drawable.t1);
                        GameView.etatConstruction = 0;
                        break;
                    default:
                        button3.setBackgroundResource(R.drawable.desactiver);
                        button2.setBackgroundResource(R.drawable.t2);
                        button1.setBackgroundResource(R.drawable.t1);
                        break;
                }

                break;
            case 2:
                switch (GameView.outilPossible){
                    case 1:
                        choisi = "Destruction choisie";
                        button3.setBackgroundColor(Color.GREEN);
                        button2.setBackgroundResource(R.drawable.amelioration);
                        button1.setBackgroundResource(R.drawable.construction);
                        GameView.etatConstruction = 0;
                        break;
                    default:
                        button3.setBackgroundResource(R.drawable.desactiver);
                        button2.setBackgroundResource(R.drawable.amelioration);
                        button1.setBackgroundResource(R.drawable.construction);
                        break;
                }

                break;
            case 3:
                switch (GameView.pouvoirPossible){
                    case 1:

                        choisi = "Lacrymogène choisie";
                        button3.setBackgroundColor(Color.GREEN);
                        button2.setBackgroundResource(R.drawable.lanceur_lbd);
                        button1.setBackgroundResource(R.drawable.force_syndicale);
                        GameView.etatConstruction = 0;
                        break;
                    default:
                        button3.setBackgroundResource(R.drawable.desactiver);
                        button2.setBackgroundResource(R.drawable.lanceur_lbd);
                        button1.setBackgroundResource(R.drawable.force_syndicale);
                        break;
                }

                break;
        }

    }

    public void bouton3jeu() {

        switch (boutonjeux) {
            case 1:
                switch (GameView.constructionPossible){
                    case 1:
                        choisi = "T2 choisie";
                        button2.setBackgroundColor(Color.GREEN);
                        button3.setBackgroundResource(R.drawable.t3);
                        button1.setBackgroundResource(R.drawable.t1);
                        GameView.etatConstruction = 0;
                        break;
                    default:
                        button2.setBackgroundResource(R.drawable.desactiver);
                        button3.setBackgroundResource(R.drawable.t3);
                        button1.setBackgroundResource(R.drawable.t1);
                        break;
                }

                break;
            case 2:
                switch (GameView.outilPossible){
                    case 1:
                        choisi = "Amélioration choisie";
                        button2.setBackgroundColor(Color.GREEN);
                        button3.setBackgroundResource(R.drawable.destruction);
                        button1.setBackgroundResource(R.drawable.construction);
                        GameView.etatConstruction = 0;
                        break;
                    default:
                        button2.setBackgroundResource(R.drawable.desactiver);
                        button3.setBackgroundResource(R.drawable.destruction);
                        button1.setBackgroundResource(R.drawable.construction);
                        break;
                }

                break;
            case 3:
                switch (GameView.pouvoirPossible){
                    case 1:
                        choisi = "Lanceur LBD choisie";
                        button2.setBackgroundColor(Color.GREEN);
                        button3.setBackgroundResource(R.drawable.lacrymogene);
                        button1.setBackgroundResource(R.drawable.force_syndicale);
                        GameView.etatConstruction = 0;
                        break;
                    default:
                        button2.setBackgroundResource(R.drawable.desactiver);
                        button3.setBackgroundResource(R.drawable.lacrymogene);
                        button1.setBackgroundResource(R.drawable.force_syndicale);
                        break;
                }

                break;
        }

    }

//---------------------------cout des tourelles-------------------------------------------------------------



    public void onClick(MotionEvent motionEvent){
         X = motionEvent.getX();
         Y = motionEvent.getY();
        System.out.println(X +""+Y);

        //spawn tourelle au clic lorsqu'elle est choisi

        switch (choisi){
            case "Force syndicale choisie":
                if(GameView.forceSyndic == true)
                    GameView.forceSyndic = false;
                    GameView.forceSyndicClique = true;

                break;

            case "T1 choisie":

                if (GameView.points >= 25) {
                    if(Y > GameView.dHeight/6) {
                        Tower tower = new Tower(gameView.getContext(), (int) X , (int) Y, 0,1,25);
                        GameView.towers.add(tower);
                    }else{
                        Toast.makeText(getApplicationContext(), "Impossible de construire aussi haut", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(getApplicationContext(), "T1 contruite jeune manifestant", Toast.LENGTH_SHORT).show();
                    GameView.points -= 25;
                } else {
                    Toast.makeText(getApplicationContext(), "Tu n'as pas les sous sous", Toast.LENGTH_SHORT).show();
                }
                break;


            case "T2 choisie":



                if (GameView.points >= 100) {
                    if(Y > GameView.dHeight/6) {
                        mine = new Mine(gameView.getContext(), (int) X, (int) Y,1, 100);
                        System.out.println("constreuir");
                        GameView.mines.add(mine);

                    }
                    Toast.makeText(getApplicationContext(), "T2 contruite jeune manifestant", Toast.LENGTH_SHORT).show();
                    GameView.points -= 60;
                } else {
                    Toast.makeText(getApplicationContext(), "Tu n'as pas les sous sous", Toast.LENGTH_SHORT).show();
                }
                break;




            case "T3 choisie":


                if (GameView.points >= 150) {
                    if(Y > GameView.dHeight/6) {
                        Catapult catapult = new Catapult(gameView.getContext(), (int) X, (int) Y, 0, 1,150 );
                        System.out.println("constreuir");
                        GameView.catapults.add(catapult);

                    }
                    Toast.makeText(getApplicationContext(), "T3 contruite jeune manifestant", Toast.LENGTH_SHORT).show();
                    GameView.points -= 150;
                } else {
                    Toast.makeText(getApplicationContext(), "Tu n'as pas les sous sous", Toast.LENGTH_SHORT).show();
                }
                break;




            case "Destruction choisie" :
                        for(int j=0;j<GameView.towers.size();j++){
                            if(GameView.towers.get(j).Tx - X <= 50 && GameView.towers.get(j).Ty - Y <= 50
                                    && X -GameView.towers.get(j).Tx <= 50 && GameView.towers.get(j).Ty - Y <= 50
                                    && GameView.towers.get(j).Tx - X <= 50 && Y - GameView.towers.get(j).Ty <= 50
                                    && X -GameView.towers.get(j).Tx <= 50 && Y - GameView.towers.get(j).Ty <= 50){
                                GameView.points += (int)(GameView.towers.get(j).cost/2); //on regagne 50% de l'argent dépensé quand on détruit une tourelle

                                GameView.towers.remove(j);

                            }
                        }

                        for(int j=0;j<GameView.mines.size();j++){
                            if(GameView.mines.get(j).x - X <= 50 && GameView.mines.get(j).y - Y <= 50
                                    && X -GameView.mines.get(j).x <= 50 && GameView.mines.get(j).y - Y <= 50
                                    && GameView.mines.get(j).x - X <= 50 && Y - GameView.mines.get(j).y <= 50
                                    && X -GameView.mines.get(j).x <= 50 && Y - GameView.mines.get(j).y <= 50){
                                GameView.points += (int)(GameView.mines.get(j).cost/2); //on regagne 50% de l'argent dépensé quand on détruit une tourelle

                                GameView.mines.remove(j);
                            }
                        }
                        for(int j=0;j<GameView.catapults.size();j++){
                            if(GameView.catapults.get(j).Tx - X <= 50 && GameView.catapults.get(j).Ty - Y <= 50
                                    && X -GameView.catapults.get(j).Tx <= 50 && GameView.catapults.get(j).Ty - Y <= 50
                                    && GameView.catapults.get(j).Tx - X <= 50 && Y - GameView.catapults.get(j).Ty <= 50
                                    && X -GameView.catapults.get(j).Tx <= 50 && Y - GameView.catapults.get(j).Ty <= 50){
                                GameView.points += (int)(GameView.catapults.get(j).cost/2); //on regagne 50% de l'argent dépensé quand on détruit une tourelle

                                GameView.catapults.remove(j);

                            }
                        }
                break;

            case "Amélioration choisie" :

                for(int j=0;j<GameView.towers.size();j++){
                    if(GameView.towers.get(j).Tx - X <= 50 && GameView.towers.get(j).Ty - Y <= 50
                            && X -GameView.towers.get(j).Tx <= 50 && GameView.towers.get(j).Ty - Y <= 50
                            && GameView.towers.get(j).Tx - X <= 50 && Y - GameView.towers.get(j).Ty <= 50
                            && X -GameView.towers.get(j).Tx <= 50 && Y - GameView.towers.get(j).Ty <= 50){




                        switch (GameView.towers.get(j).name){
                            case 1:
                                cost = 50;
                                if (GameView.points < cost) {
                                    Toast.makeText(this, "The cost is too high", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    GameView.points -= cost;

                                    GameView.towers.get(j).name = 2;
                                    GameView.towers.get(j).cost = cost;
                                    GameView.towers.get(j).towerCoolDownLimit = 30;
                                    GameView.towers.get(j).tower[0] = decodeResource(gameView.getContext().getResources(), R.drawable.towerlvl2);
                                    GameView.towers.get(j).setDamage(5);
                                    System.out.println(GameView.towers.get(j).name);
                                    System.out.println(GameView.towers.get(j).towerCoolDownLimit);
                                }
                            break;

                            case 2:
                                cost = 75;

                                if (GameView.points < cost) {
                                    Toast.makeText(this, "The cost is too high", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    GameView.points -= cost;
                                    GameView.towers.get(j).cost = cost;
                                    GameView.towers.get(j).name = 3;
                                    GameView.towers.get(j).towerCoolDownLimit = 10;
                                    GameView.towers.get(j).tower[0] = decodeResource(gameView.getContext().getResources(), R.drawable.towerlvl3);
                                    GameView.towers.get(j).setDamage(5);

                                    System.out.println("Amélioré");
                                }
                                break;
                            case 3:
                                cost = 100;
                                if (GameView.points < cost) {
                                    Toast.makeText(this, "The cost is too high", Toast.LENGTH_SHORT).show();
                                }
                                else {

                                    GameView.points -= cost;


                                    GameView.towers.get(j).name = 4;
                                    GameView.towers.get(j).cost = cost;
                                    GameView.towers.get(j).towerCoolDownLimit = 5;
                                    GameView.towers.get(j).tower[0] = decodeResource(gameView.getContext().getResources(), R.drawable.towerlvl4);
                                    GameView.towers.get(j).setDamage(5);

                                    System.out.println("Amélioré");
                                    System.out.println(GameView.towers.get(j).cost);
                                }
                                break;
                            case 4:



                                Toast.makeText(getApplicationContext(), "Niveau max atteint", Toast.LENGTH_SHORT).show();
                                break;





                        }


                    }
                }
                for(int j=0;j<GameView.mines.size();j++){
                    if(GameView.mines.get(j).x - X <= 50 && GameView.mines.get(j).y - Y <= 50
                            && X -GameView.mines.get(j).x <= 50 && GameView.mines.get(j).y - Y <= 50
                            && GameView.mines.get(j).x - X <= 50 && Y - GameView.mines.get(j).y <= 50
                            && X -GameView.mines.get(j).x <= 50 && Y - GameView.mines.get(j).y <= 50){

                        switch (GameView.mines.get(j).name){
                            case 1:
                                cost = 75;
                                if (GameView.points < cost) {
                                    Toast.makeText(this, "The cost is too high", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    GameView.points -= cost;

                                    GameView.mines.get(j).name = 2;
                                    GameView.mines.get(j).cost = cost;

                                    GameView.mines.get(j).setNewSkin(decodeResource(gameView.getContext().getResources(), R.drawable.mine2_ground));
                                    GameView.mines.get(j).setDamage(70);
                                    System.out.println("Amélioré");
                                    break;
                                }

                            case 2:
                                cost = 150;

                                if (GameView.points < cost) {
                                    Toast.makeText(this, "The cost is too high", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    GameView.points -= cost;


                                    GameView.mines.get(j).name = 3;
                                    GameView.mines.get(j).cost = cost;

                                    GameView.mines.get(j).mine[0] = decodeResource(gameView.getContext().getResources(), R.drawable.mine3_ground);
                                    GameView.mines.get(j).setDamage(90);
                                    System.out.println("Amélioré");
                                    break;
                                }

                            case 3:
                                cost = 400 ;if (GameView.points < cost) {
                                Toast.makeText(this, "The cost is too high", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                GameView.points -= cost;



                                GameView.mines.get(j).name = 4;
                                GameView.mines.get(j).cost = cost;

                                GameView.towers.get(j).cost = cost;

                                GameView.mines.get(j).mine[0] = decodeResource(gameView.getContext().getResources(), R.drawable.mine4_ground);
                                GameView.mines.get(j).setDamage(110);
                                System.out.println("Amélioré");
                                break;
                            }
                            case 4:

                                Toast.makeText(getApplicationContext(), "Niveau max atteint", Toast.LENGTH_SHORT).show();
                                break;



                        }

                    }
                }
                for(int j=0;j<GameView.catapults.size();j++){
                    if(GameView.catapults.get(j).Tx - X <= 50 && GameView.catapults.get(j).Ty - Y <= 50
                            && X -GameView.catapults.get(j).Tx <= 50 && GameView.catapults.get(j).Ty - Y <= 50
                            && GameView.catapults.get(j).Tx - X <= 50 && Y - GameView.catapults.get(j).Ty <= 50
                            && X -GameView.catapults.get(j).Tx <= 50 && Y - GameView.catapults.get(j).Ty <= 50){

                        switch (GameView.catapults.get(j).name){
                            case 1:
                                cost = 350;
                                if (GameView.points < cost) {
                                Toast.makeText(this, "The cost is too high", Toast.LENGTH_SHORT).show();
                            }
                                else {
                                    GameView.points -= cost;



                                    GameView.catapults.get(j).name = 2;
                                    GameView.catapults.get(j).cost = cost;

                                    GameView.catapults.get(j).catapultCoolDownLimit = 110;
                                    GameView.catapults.get(j).setDamage(150);
                                    GameView.catapults.get(j).catapult[0] = decodeResource(gameView.getContext().getResources(), R.drawable.catapultlvl2);
                                    System.out.println("Amélioré");
                                    break;
                                }

                            case 2:
                                cost = 500;
                                if (GameView.points < cost) {
                                    Toast.makeText(this, "The cost is too high", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    GameView.points -= cost;



                                    GameView.catapults.get(j).name = 3;
                                    GameView.catapults.get(j).cost = cost;

                                    GameView.catapults.get(j).setDamage(170);
                                    GameView.catapults.get(j).catapultCoolDownLimit = 80;

                                    GameView.catapults.get(j).catapult[0] = decodeResource(gameView.getContext().getResources(), R.drawable.catapultlvl3);

                                    System.out.println("Amélioré");
                                    break;
                                }

                            case 3:
                                cost = 700;
                                if (GameView.points < cost) {
                                    Toast.makeText(this, "The cost is too high", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    GameView.points -= cost;



                                    GameView.catapults.get(j).name = 4;
                                    GameView.catapults.get(j).cost = cost;

                                    GameView.catapults.get(j).setDamage(190);
                                    GameView.catapults.get(j).catapultCoolDownLimit = 50;

                                    GameView.catapults.get(j).catapult[0] = decodeResource(gameView.getContext().getResources(), R.drawable.catapultlvl4);

                                    break;
                                }
                            case 4:
                                Toast.makeText(getApplicationContext(), "Niveau max atteint", Toast.LENGTH_SHORT).show();

                                break;



                        }

                    }
                }

                break;







        }


    }

}