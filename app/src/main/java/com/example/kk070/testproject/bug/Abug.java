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
public class Abug implements Bugs {
    private Bitmap aBug;
    private float x;
    private float y;
    private float speedX;
    private float speedY;
    private float positionX;
    private float positionY;
    private float directionX;
    private float directionY;
    private int localAngle;
    private int radius;


    public Abug(Context context){
        aBug = BitmapFactory.decodeResource(context.getResources(), R.drawable.abug);
        aBug = Bitmap.createScaledBitmap(aBug, 50, 50, true);
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
    }

    @Override
    public void update(Canvas canvas){
        algorithm();
        canvas.drawBitmap(aBug, x, y, null);
    }

    @Override
    public void algorithm() {
        pointOnCircle(localAngle,radius);
        localAngle++;
    }

    private int getDistance(float x, float y, float x1, float y1){
        return (int)Math.sqrt(Math.pow(Math.abs(x1-x), 2) + Math.pow(Math.abs(y1-y), 2));
    }

    private void pointOnCircle(int angleInDegrees, int Radius){
        x = (float)(Math.cos(Math.toRadians(angleInDegrees))*Radius) + directionX;
        y =  (float)(Math.sin(Math.toRadians(angleInDegrees))*Radius) + directionY;
        if(speedX<0){
            directionX--;
        }else {
            directionX++;
        }
        if(speedY<0){
            directionY--;
        }else {
            directionY++;
        }
    }

    @Override
    public Bitmap getBug() {
        return aBug;
    }

    public void setaBug(Bitmap aBug) {
        this.aBug = aBug;
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

    public float getPositionX() {
        return positionX;
    }

    public void setPositionX(float positionX) {
        this.positionX = positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public void setPositionY(float positionY) {
        this.positionY = positionY;
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

    public int getLocalAngle() {
        return localAngle;
    }

    public void setLocalAngle(int localAngle) {
        this.localAngle = localAngle;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
