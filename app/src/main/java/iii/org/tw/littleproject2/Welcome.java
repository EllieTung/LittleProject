package iii.org.tw.littleproject2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

/**
 * Created by YunHua on 9/24/16.
 */
public class Welcome extends Activity{
    private ImageView title,welcome_pacman;
    private ObjectAnimator anim1,anim2,anim3,anim4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        title=(ImageView)findViewById(R.id.title);
        welcome_pacman=(ImageView)findViewById(R.id.welcome_pacman);
        init();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent().setClass(Welcome.this,Menu.class));
                finish();
            } }, 3600);

    }
    private void init(){
        anim1=ObjectAnimator.ofFloat(title,"scaleX",0,1.5f);
        anim2=ObjectAnimator.ofFloat(title,"scaleY",0,1.5f);
        anim3=ObjectAnimator.ofFloat(welcome_pacman,"x",300,1300);
        anim4=ObjectAnimator.ofFloat(welcome_pacman,"rotation",0f,359);
        anim4.setRepeatCount(2);


        AnimatorSet set=new AnimatorSet();
        set.playTogether(anim1,anim2,anim3,anim4);
        set.setDuration(3000);
        set.start();

    }

}
