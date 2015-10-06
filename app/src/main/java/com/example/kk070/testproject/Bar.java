package com.example.kk070.testproject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by kk070 on 2015-09-21.
 */
public class Bar {
    private Paint paint;
    private Rect bounds;
    int width = 20;


    int height = 110;
    int speedX= 0;
    float speedY;
    int i =0;

    int x;
    int y;

    public int getxMin() {
        return xMin;
    }

    public void setxMin(int xMin) {
        this.xMin = xMin;
    }

    public int getyMin() {
        return yMin;
    }

    public void setyMin(int yMin) {
        this.yMin = yMin;
    }

    private int xMin=1000,yMin=300;

    private Integer[] colorArray = {Color.YELLOW,Color.BLUE,Color.GREEN, Color.RED, Color.MAGENTA, Color.CYAN};

    public Bar(int color){
        paint = new Paint();
        paint.setColor(color);
        bounds = new Rect();
    }

    public void set( Canvas canvas){
        bounds.set(xMin, yMin, xMin + width, yMin + height);
        canvas.drawRect(bounds, paint);
    }

    public void update(){
        yMin =(int) speedY;
        if(yMin<0){
            yMin = 0;
        }
        if(yMin>1600){
            yMin = 1600;
        }
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
