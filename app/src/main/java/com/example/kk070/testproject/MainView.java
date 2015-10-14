package com.example.kk070.testproject;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.kk070.testproject.spray.Spray;

import java.util.ArrayList;

/**
 * Created by kk070 on 2015-10-12.
 */
public class MainView extends View {
    private Spray spray;
    private ArrayList<Bullet> bullets;
    private Bullet[] bullet;
    private com.example.kk070.testproject.ImageButton imageButton;
    private  int bulletCount = 0;

    public MainView(Context context) {
        super(context);
        spray = new Spray(context);
        bullets = new ArrayList<Bullet>();
        bullet = new Bullet[20];
        for(int i = 0;  i < 20 ; i++) {
            bullet[i] = new Bullet(context);
        }
        imageButton = new com.example.kk070.testproject.ImageButton(context);
        this.setBackgroundResource(R.drawable.background);
        this.setFocusableInTouchMode(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        bullets.add(bullet[bulletCount]);
        bullet[bulletCount].set(spray.getX(), spray.getY());

        bulletCount++;

        if(bulletCount ==19){
            bulletCount = 0;
        }

        if(bullets.size() == 20){
            bullets.remove(0);
        }

        for(Bullet bullet : bullets){
            bullet.update(canvas);
        }
        spray.update(canvas);
        imageButton.update(canvas);

        invalidate();
    }


    @Override
    public void onSizeChanged(int w, int h, int oldW, int oldH) {
        spray.set(w, h);
        for(int i = 0;  i < 20 ; i++) {
            bullet[i].setCent(w,h);
        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float currentX = event.getX();
        float currentY = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_DOWN:
                if(imageButton.getLeftArrowX()<currentX && imageButton.getLeftArrowX()+200 > currentX && 1500<currentY && 1700>currentY){
                    changeDirection(0);
                }
                if(imageButton.getRightArrowX()<currentX && imageButton.getRightArrowX()+200 > currentX && 1500<currentY && 1700>currentY){
                    changeDirection(1);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;

    }

    private void changeDirection(int direction){
           spray.setDirection(direction);
    }


}
