package com.example.kk070.testproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by kk070 on 2015-10-13.
 */
public class Bullet {
    private Bitmap bullet;
    private int x;
    private int y;
    private int centX;
    private int centY;
    private float speedX;
    private float speedY;

    public Bullet(Context context){
        bullet = BitmapFactory.decodeResource(context.getResources(), R.drawable.fireball);
        bullet = Bitmap.createScaledBitmap(bullet, 10, 10, true);
    }

    public void set(int x, int y){
        this.x = x;
        this.y = y;
        speedX = (float)((centX - x)/Math.sqrt(((centX - x) * (centX - x)) + ((centY - y) *(centY - y ))));
        speedY = (float)((centY - y)/Math.sqrt(((centY - y) * (centY - y)) + ((centX - x) *(centX - x ))));
    }

    public void setCent(int centX, int centY){
        this.centX = centX/2;
        this.centY = centY/2;
    }

    public void update(Canvas canvas){
        canvas.drawBitmap(bullet,x+speedX*70,y+speedY*70,null);
        x += speedX * 20;
        y += speedY * 20;
    }

    public void pointOnCircle(int angleInDegrees, int Radius){

    }
}
