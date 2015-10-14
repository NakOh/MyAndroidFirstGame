package com.example.kk070.testproject.bug;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.example.kk070.testproject.R;

/**
 * Created by kk070 on 2015-10-12.
 */
public class NormalBug implements Bugs {
    private Bitmap normalBug;
    private float x;
    private float y;
    private float speedX;
    private float speedY;


    public NormalBug(Context context){
        normalBug = BitmapFactory.decodeResource(context.getResources(), R.drawable.normalbug);
        normalBug = Bitmap.createScaledBitmap(normalBug, 50, 50, true);
    }

    @Override
    public void set(int x, int y, int w, int h){

        this.x = x;
        this.y = y;

        speedX = (float)((w - x)/Math.sqrt(((w - x) * (w - x)) + ((h - y) *(h - y ))));
        speedY = (float)((h - y)/Math.sqrt(((h - y) * (h - y)) + ((w - x) *(w - x ))));


    }

    @Override
    public void update(Canvas canvas){
        algorithm();
        canvas.drawBitmap(normalBug, x, y, null);
    }

    @Override
    public void algorithm() {
        x += speedX;
        y += speedY;
    }

    @Override
    public Bitmap getBug() {
        return normalBug;
    }

    public void setNormalBug(Bitmap normalBug) {
        this.normalBug = normalBug;
    }

    @Override
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
    @Override
    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeedX() {
        return speedX;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }
}
