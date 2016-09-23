package iii.org.tw.littleproject2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by YunHua on 9/23/16.
 */
public class YellowMan extends View{
    private Bitmap bmpImage,pmr,pmr2,pml,pml2,pmu,pmu2,pmd,pmd2,bmpBlock;
    private Resources res;
    private Matrix matrix;
    public float viewW,viewH,pmW,pmH,pmX,pmY,blockW,blockH,dx,dy;
    private boolean isInit;
    public int currentDirect,turningNumber;
    private Timer timer;
    private int wall[][]={  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
                            {1,0,0,1,0,1,0,0,1,0,1,0,1,0,0,0},
                            {1,0,0,1,0,1,0,0,1,0,1,0,1,0,0,0},
                            {1,0,0,1,0,1,0,0,1,0,1,0,1,0,0,0},
                            {1,0,0,1,0,1,0,0,1,0,1,0,1,0,0,0},
                            {1,0,0,1,0,1,0,0,1,0,1,0,1,0,0,0},
                            {1,0,0,1,0,1,0,0,0,0,1,0,1,0,0,0},
                            {1,0,0,1,0,1,0,0,0,0,1,0,1,0,0,0},
                            {1,0,0,1,0,0,0,0,1,0,1,0,1,0,0,0},
                            {1,0,0,1,0,1,0,0,1,0,0,0,1,0,0,0},
                            {1,0,0,1,0,1,0,0,1,0,1,0,1,0,0,0},
                            {1,0,0,1,0,1,0,0,1,0,1,0,1,0,0,0},
                            {1,0,0,1,0,1,0,0,0,0,1,0,1,0,0,0},
                            {1,0,0,1,0,1,0,0,0,0,1,0,1,0,0,0},
                            {1,0,0,1,0,1,0,0,1,0,1,0,1,0,0,0},
                            {1,0,0,1,0,1,0,0,1,0,1,0,1,0,0,0},
                            {0,0,0,1,0,1,0,0,1,0,1,0,1,0,0,0},
                            {0,0,0,1,0,0,0,0,1,0,1,0,1,0,0,0},
                            {0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},};

    public YellowMan(Context context, AttributeSet attrs) {
        super(context, attrs);
        res=context.getResources();
        matrix=new Matrix();
        timer=new Timer();
        turningNumber=1;
    }
    Timer getTimer(){
        return timer;
    }
    private void init(){
        viewH=getHeight();
        viewW=getWidth();
        blockH=viewH/16f;
        blockW=viewW/22f;
        pmH=viewH/18f;
        pmW=viewW/24f;
        pmr= BitmapFactory.decodeResource(res,R.drawable.pmr);
        pmr=resizer(pmr,pmW,pmH,0);
        pmr2=BitmapFactory.decodeResource(res,R.drawable.pmr2);
        pmr2=resizer(pmr2,pmW,pmH,0);
        pml=BitmapFactory.decodeResource(res,R.drawable.pml);
        pml=resizer(pml,pmW,pmH,0);
        pml2=BitmapFactory.decodeResource(res,R.drawable.pml2);
        pml2=resizer(pml2,pmW,pmH,0);
        pmu=resizer(pmr,pmW,pmH,270);
        pmu2=resizer(pmr2,pmW,pmH,270);
        pmd=resizer(pmr,pmW,pmH,90);
        pmd2=resizer(pmr2,pmW,pmH,90);
        bmpBlock=BitmapFactory.decodeResource(res,R.drawable.block);
        bmpBlock=resizer(bmpBlock,blockW,blockH,0);

        timer.schedule(new YMTask(),0,100);

        isInit=true;



    }
    private Bitmap resizer(Bitmap bmp,float newW,float newH,float theta){
        matrix.reset();
        matrix.postScale(newW/bmp.getWidth(),newH/bmp.getHeight());
        matrix.postRotate(theta);
        bmpImage=Bitmap.createBitmap(bmp,0,0,bmp.getWidth(),bmp.getHeight(),matrix,true);
        return bmpImage;

    }
    private Bitmap turningImage(int currentDirect){
        switch (currentDirect) {
            case 1:
                if (turningNumber == 1) {
                    turningNumber = 2;
                    return pmr;
                } else {
                    turningNumber = 1;
                    return pmr2;
                }

            case 2:
                if (turningNumber == 1) {
                    turningNumber = 2;
                    return pmu;
                } else {
                    turningNumber = 1;
                    return pmu2;
                }
            case 3:
                if (turningNumber == 1) {
                    turningNumber = 2;
                    return pml;
                } else {
                    turningNumber = 1;
                    return pml2;
                }
            case 4:
                if (turningNumber == 1) {
                    turningNumber = 2;
                    return pmd;
                } else {
                    turningNumber = 1;
                    return pmd2;
                }
            default:
                return pmr;
        }

    }
    private boolean walkable(float pmX,float pmY){



        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(!isInit)init();



        for(int i=0;i<wall.length;i++){
            for(int j=0;j<wall[i].length;j++){
                if(wall[i][j]==1){
                    canvas.drawBitmap(bmpBlock,i*blockW,j*blockH,null);
                }
            }
        }


        canvas.drawBitmap(turningImage(currentDirect),pmX,pmY,null);




    }
    private class YMTask extends TimerTask{
        @Override
        public void run() {
            pmX+=dx;
            pmY+=dy;
            postInvalidate();
        }
    }

}