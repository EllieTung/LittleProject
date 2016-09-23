package iii.org.tw.littleproject2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button goleft,goright,goup,godown;
    private YellowMan pacman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();
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
