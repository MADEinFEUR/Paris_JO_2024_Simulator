package com.example.traindriversimulator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
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

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

@RequiresApi(api = Build.VERSION_CODES.R)
public class GamesActivity extends AppCompatActivity {

    FrameLayout gameActivity;
    RelativeLayout GameButtons;
    GameView gameView;
    private Context context;


    public int boutonjeux = 1;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;

    private TextView txt;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameView=new GameView(this);
        gameActivity = new FrameLayout(this);
        GameButtons = new RelativeLayout(this);


        txt = new TextView(this);
        txt.setId(50);

        LinearLayout linearLayout1 = new LinearLayout(this);
        linearLayout1.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(LinearLayout.VERTICAL);

        button1 = new Button(this);
        button2 = new Button(this);
        button3 = new Button(this);
        button4 = new Button(this);
        button5 = new Button(this);
        button6 = new Button(this);



        //bouton
        button1.setText("T1");

        button1.setId(1);
        button1.setWidth(200);
        button1.setHeight(50);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bouton1jeu();
            }
        });

        button2.setText("T2");
        button2.setId(2);
        button2.setWidth(200);
        button2.setHeight(50);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bouton3jeu();
            }
        });


        button3.setText("T3");
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
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Power();
            }
        });


        ViewGroup.LayoutParams b1= new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        ((RelativeLayout.LayoutParams) b1).addRule(RelativeLayout.RIGHT_OF,RelativeLayout.TRUE);
        ((RelativeLayout.LayoutParams) b1).addRule(RelativeLayout.ALIGN_TOP,RelativeLayout.TRUE);
        button1.setLayoutParams(b1);

        ViewGroup.LayoutParams b2= new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        ((RelativeLayout.LayoutParams) b2).addRule(RelativeLayout.RIGHT_OF,RelativeLayout.TRUE);
        ((RelativeLayout.LayoutParams) b2).addRule(RelativeLayout.ALIGN_TOP,RelativeLayout.TRUE);
        button2.setLayoutParams(b2);

        ViewGroup.LayoutParams b3= new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        ((RelativeLayout.LayoutParams) b3).addRule(RelativeLayout.RIGHT_OF,RelativeLayout.TRUE);
        ((RelativeLayout.LayoutParams) b3).addRule(RelativeLayout.ALIGN_TOP,RelativeLayout.TRUE);
        button3.setLayoutParams(b3);



        ViewGroup.LayoutParams b4= new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        ((RelativeLayout.LayoutParams) b4).addRule(RelativeLayout.RIGHT_OF,RelativeLayout.TRUE);
        ((RelativeLayout.LayoutParams) b4).addRule(RelativeLayout.ALIGN_TOP,RelativeLayout.TRUE);
        button4.setLayoutParams(b4);

        ViewGroup.LayoutParams b5= new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        ((RelativeLayout.LayoutParams) b5).addRule(RelativeLayout.RIGHT_OF,RelativeLayout.TRUE);
        ((RelativeLayout.LayoutParams) b5).addRule(RelativeLayout.ALIGN_TOP,RelativeLayout.TRUE);
        button5.setLayoutParams(b5);

        ViewGroup.LayoutParams b6= new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        ((RelativeLayout.LayoutParams) b6).addRule(RelativeLayout.RIGHT_OF,RelativeLayout.TRUE);
        ((RelativeLayout.LayoutParams) b6).addRule(RelativeLayout.ALIGN_TOP,RelativeLayout.TRUE);
        button6.setLayoutParams(b6);

        ViewGroup.LayoutParams t1= new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        ((RelativeLayout.LayoutParams) t1).addRule(RelativeLayout.RIGHT_OF,RelativeLayout.TRUE);
        ((RelativeLayout.LayoutParams) t1).addRule(RelativeLayout.ALIGN_TOP,RelativeLayout.TRUE);
        txt.setLayoutParams(b6);




        //ScrollView

        HorizontalScrollView viewCapacite = new HorizontalScrollView(this);
        viewCapacite.setId(100);

        HorizontalScrollView viewBoutton = new HorizontalScrollView(this);
        viewBoutton.setId(101);

        ViewGroup.LayoutParams SV1= new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        ((RelativeLayout.LayoutParams) SV1).addRule(RelativeLayout.ALIGN_PARENT_LEFT,RelativeLayout.TRUE);
        ((RelativeLayout.LayoutParams) SV1).addRule(RelativeLayout.ALIGN_TOP,RelativeLayout.TRUE);
        viewCapacite.setLayoutParams(SV1);

        ViewGroup.LayoutParams SV2= new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        ((RelativeLayout.LayoutParams) SV2).addRule(RelativeLayout.ALIGN_PARENT_LEFT,RelativeLayout.TRUE);
        ((RelativeLayout.LayoutParams) SV2).addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        viewBoutton.setLayoutParams(SV2);








        //param
        ViewGroup.LayoutParams params= new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);







        GameButtons.setLayoutParams(params);
        GameButtons.addView(linearLayout3);
        GameButtons.addView(txt);



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

        linearLayout3.setY(GameView.dHeight - GameView.dHeight/9);
        linearLayout3.setX(GameView.dWidth - 6*GameView.dWidth/7);











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
        button1.setText("T1");
        button2.setText("T2");
        button3.setText("T3");


    }

    public void Outils() {

        boutonjeux = 2;
        button1.setText("Réparation");
        button2.setText("Amélioration");
        button3.setText("Destruction");


    }

    public void Power() {

        boutonjeux = 3;
        button1.setText("Force Syndicale");
        button2.setText("Lanceur LBD");
        button3.setText("Lacrymogène");


    }

    ///_________________________________bouton___________________________________________________
    public void bouton1jeu() {

        switch (boutonjeux) {
            case 1:
                txt.setText("T1 choisie");
                break;
            case 2:
                txt.setText("Réparation choisie");
                break;
            case 3:
                txt.setText("Force syndicale choisie");


                break;
        }

    }

    public void bouton2jeu() {

        switch (boutonjeux) {
            case 1:
                txt.setText("T3 choisie");
                break;
            case 2:
                txt.setText("Destruction choisie");
                break;
            case 3:
                txt.setText("Lacrymogène choisie");
                break;
        }

    }

    public void bouton3jeu() {

        switch (boutonjeux) {
            case 1:
                txt.setText("T2 choisie");
                break;
            case 2:
                txt.setText("Amélioration choisie");
                break;
            case 3:
                txt.setText("Lanceur LBD choisie");
                break;
        }

    }

}