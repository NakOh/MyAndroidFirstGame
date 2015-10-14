package com.example.kk070.testproject.bug;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.example.kk070.testproject.MainActivity;
import com.example.kk070.testproject.R;

/**
 * Created by kk070 on 2015-10-12.
 */
public class Cbug implements Bugs {
    private Bitmap cBug;
    private float x;
    private float y;
    private float w;
    private float h;
    private float speedX;
    private float speedY;
    private float directionX;
    private float directionY;
    private int radius;
    private int count = 0;
    private double degree;
    private double angle;

    public Cbug(Context context){
        cBug = BitmapFactory.decodeResource(context.getResources(), R.drawable.cbug);
        cBug = Bitmap.createScaledBitmap(cBug, 50, 50, true);
    }

    @Override
    public void set(int x, int y,int w, int h){
        this.x = x;
        this.y = y;

        speedX = (float)((w - x)/Math.sqrt(((w - x) * (w - x)) + ((h - y) *(h - y ))));
        speedY = (float)((h - y)/Math.sqrt(((h - y) * (h - y)) + ((w - x) *(w - x ))));

        directionX = x+(speedX*50);
        directionY = y+(speedY*50);

        radius = getDistance(x,y,directionX, directionY);
        float dx = directionX- x-cBug.getWidth()/2;
        float dy = directionY- y-cBug.getHeight()/2;
        double rad= Math.atan2(dx, dy);
        degree = (rad*180)/Math.PI ;
        angle = degree;
    }

    @Override
    public void update(Canvas canvas){
        algorithm();
        canvas.drawBitmap(cBug, x, y, null);

    }
    @Override
    public void algorithm() {
        pointOnCircle(angle, radius);

        if(angle>0){
             angle++;
             count++;
        }
        else{
            angle--;
            count++;
        }
        if(count == 180){
            directionX = x+(speedX*50);
            directionY = y+(speedY*50);
            angle = degree;
            count = 0;
        }
    }

    private int getDistance(float x, float y, float x1, float y1){
        return (int)Math.sqrt(Math.pow(Math.abs(x1-x), 2) + Math.pow(Math.abs(y1-y), 2));
    }

    private void pointOnCircle(double angleInDegrees, int Radius){
        while(true) {
            float newX = (float) (Math.cos(Math.toRadians(angleInDegrees)) * Radius) + directionX;
            float newY = (float) (Math.sin(Math.toRadians(angleInDegrees)) * Radius) + directionY;
            if(x-5<newX && newX<x+5 && y-5<newY && newY<y+5){
                x = newX;
                y = newY;
                break;
            }else{
                if(angleInDegrees>0) {
                    angleInDegrees++;
                }else{
                    angleInDegrees--;
                }
            }
        }
    }

    @Override
    public Bitmap getBug() {
        return cBug;
    }

    public void setcBug(Bitmap cBug) {
        this.cBug = cBug;
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

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }

    public float getH() {
        return h;
    }

    public void setH(float h) {
        this.h = h;
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

    public float getDirectionX() {
        return directionX;
    }

    public void setDirectionX(float directionX) {
        this.directionX = directionX;
    }

    public float getDirectionY() {
        return directionY;
    }

    public void setDirectionY(float directionY) {
        this.directionY = directionY;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
}
