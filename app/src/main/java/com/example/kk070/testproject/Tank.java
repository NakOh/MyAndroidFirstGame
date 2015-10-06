package com.example.kk070.testproject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Random;

/**
 * Created by kk070 on 2015-10-02.
 */
public class Tank {

    private Paint paint;
    private Rect bounds;
    private Rect bulletBounds;
    int width = 20;
    int height = 110;
    int halfwidth = width/2;
    int halfHeight = height/2;
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

    public Tank(int color){
        paint = new Paint();
        paint.setColor(color);
        bounds = new Rect();
        bulletBounds = new Rect();
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

    public void changColor(){
        Random random = new Random();
        int a = randomRange(0, 5);
        paint.setColor(colorArray[a]);
    }

    private static int randomRange(int n1, int n2) {
        return (int) (Math.random() * (n2 - n1 + 1)) + n1;
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
