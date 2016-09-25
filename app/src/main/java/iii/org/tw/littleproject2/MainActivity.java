package iii.org.tw.littleproject2;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private Button goleft,goright,goup,godown;
    private YellowMan pacman;
    private int levelindex;
    public static final int level[]={  R.raw.level0,R.raw.level1,R.raw.level2,R.raw.level3,R.raw.level4,
                                        R.raw.level5,R.raw.level6,R.raw.level7,R.raw.level8,R.raw.level9,
                                        R.raw.level10,R.raw.level11,R.raw.level12,R.raw.level13,R.raw.level14};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();

        Intent intent=getIntent();
        levelindex=intent.getIntExtra("levelindex",0);



        goleft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    goLeft();
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    stop();
                }
                return true;
            }
        });

        goright.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    goRight();
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    stop();
                }
                return true;
            }
        });
        goup.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    goUp();
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    stop();
                }
                return true;
            }
        });
        godown.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    goDown();
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    stop();
                }
                return true;
            }
        });
    }
    private void findId(){
        pacman=(YellowMan)findViewById(R.id.pacman);
        goleft=(Button)findViewById(R.id.goleft);
        goright=(Button)findViewById(R.id.goright);
        goup=(Button)findViewById(R.id.goup);
        godown=(Button)findViewById(R.id.godown);
    }

    private void loadLevel(int levelindex){
        BufferedReader bf=new BufferedReader(new InputStreamReader(getResources().openRawResource(level[levelindex])));



    }

    private void goRight(){
        pacman.currentDirect=1;
        if (pacman.dx < 30)
            pacman.dx += 10;
        else
            pacman.dx =30;

    }
    private void goLeft(){
        pacman.currentDirect=3;
        if(pacman.dx>-30)
            pacman.dx-=10;
        else
            pacman.dx=-30;

    }

    private void goUp(){
        pacman.currentDirect=2;
        if(pacman.dy>-30)
            pacman.dy-=10;
        else
            pacman.dy=-30;

    }
    private void goDown(){
        pacman.currentDirect=4;
        if(pacman.dy<30)
            pacman.dy+=10;
        else
            pacman.dy=30;

    }
    private void stop(){
        pacman.dx=0;
        pacman.dy=0;

    }

}
