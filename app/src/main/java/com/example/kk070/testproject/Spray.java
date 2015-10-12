package com.example.kk070.testproject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Random;

/**
 * Created by kk070 on 2015-10-12.
 */
public class Spray {
    private Paint paint;
    private Rect bounds;

    private int width = 20;
    private int height = 110;

    private float speedX;
    private float speedY;

    private int centX;
    private int centY;
    private float currentSelfAngle;


    private int x;

    private int y;


    private int xMin=30,yMin=500;

    public Spray(int color){
        paint = new Paint();
        paint.setColor(color);
        bounds = new Rect();
    }

    public void set( Canvas canvas){
        bounds.set(xMin, yMin, xMin + width, yMin + height);

        centX = bounds.centerX();
        centY = bounds.centerY();
        pointOnCircle(10, 300);
        canvas.rotate(currentSelfAngle,centX, centY);
        canvas.drawRect(bounds, paint);
        currentSelfAngle++;

    }

    public void pointOnCircle(int angleInDegrees, int Radius){
        x =(int) (Math.cos(Math.toRadians(angleInDegrees))*Radius) + centX;
        y = (int) (Math.sin(Math.toRadians(angleInDegrees))*Radius) + centY;
        centX = x;
        centY= y;
    }

    public void update(){
        /*
        yMin =(int) speedY;
        if(yMin<0){
            yMin = 0;
        }
        if(yMin>1600){
            yMin = 1600;
        }
        */
    }



    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public Rect getBounds() {
        return bounds;
    }

    public void setBounds(Rect bounds) {
        this.bounds = bounds;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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

    public int getCentX() {
        return centX;
    }

    public void setCentX(int centX) {
        this.centX = centX;
    }

    public int getCentY() {
        return centY;
    }

    public void setCentY(int centY) {
        this.centY = centY;
    }

    public float getCurrentSelfAngle() {
        return currentSelfAngle;
    }

    public void setCurrentSelfAngle(float currentSelfAngle) {
        this.currentSelfAngle = currentSelfAngle;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

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

}
