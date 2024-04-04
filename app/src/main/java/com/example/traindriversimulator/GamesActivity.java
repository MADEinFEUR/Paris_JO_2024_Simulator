package com.example.traindriversimulator;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Canvas;
import android.graphics.BitmapFactory;
import android.graphics.Paint;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

@RequiresApi(api = Build.VERSION_CODES.R)
public class GamesActivity extends AppCompatActivity {


    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.games_activity);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


    }

    public int GetmapX() {
        return (int) findViewById(R.id.view).getWidth();
    }


    public int GetmapY() {
        return (int) findViewById(R.id.view).getHeight();
    }

    public int boutonjeux = 1;

    WindowManager.LayoutParams ds = new WindowManager.LayoutParams(1,2);

    public void launchgame(View view) {

        findViewById(R.id.start).setEnabled(false);
        findViewById(R.id.start).setVisibility(View.INVISIBLE);

        GameView gameView = new GameView(this);
        setContentView(gameView, ds);
        /*
        Game game = new Game();
        game.game(GetmapX(), GetmapY(), 100);
        game.spawn();
        game.startgame();
        */


        ///zizizi
    }


    public void Armes(View view) {

        boutonjeux = 1;
        Button t1 = findViewById(R.id.button4);
        t1.setText("T1");
        Button t2 = findViewById(R.id.button6);
        t2.setText("T2");
        Button t3 = findViewById(R.id.button5);
        t3.setText("T3");


    }

    public void Outils(View view) {

        boutonjeux = 2;
        Button repa = findViewById(R.id.button4);
        repa.setText("Réparation");
        repa.bringToFront();
        Button up = findViewById(R.id.button6);
        up.setText("Amélioration");
        Button destru = findViewById(R.id.button5);
        destru.setText("Destruction");


    }

    public void Power(View view) {

        boutonjeux = 3;
        Button synd = findViewById(R.id.button4);
        synd.setText("Force Syndicale");
        Button lbd = findViewById(R.id.button6);
        lbd.setText("Lanceur LBD");
        Button lacry = findViewById(R.id.button5);
        lacry.setText("Lacrymogène");


    }

    ///_________________________________bouton___________________________________________________
    public void bouton1jeu(View v) {
        TextView txt = findViewById(R.id.textView);

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

    public void bouton2jeu(View v) {
        TextView txt = findViewById(R.id.textView);

        switch (boutonjeux) {
            case 1:
                txt.setText("T2 choisie");
                break;
            case 2:
                txt.setText("Destruction choisie");
                break;
            case 3:
                txt.setText("Lacrymogène choisie");
                break;
        }

    }

    public void bouton3jeu(View v) {
        TextView txt = findViewById(R.id.textView);

        switch (boutonjeux) {
            case 1:
                txt.setText("T3 choisie");
                break;
            case 2:
                txt.setText("Réparation choisie");
                break;
            case 3:
                txt.setText("Lanceur LBD choisie");
                break;
        }

    }

    public void test(View v) {
        System.out.println(GetmapX() + "et" + GetmapY());
    }

//_________________________________________________________________________Gestion graphique du jeu _________________________________________________________


}