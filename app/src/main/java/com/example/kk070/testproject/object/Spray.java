package com.example.kk070.testproject.object;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;

import com.example.kk070.testproject.R;

/**
 * Created by kk070 on 2015-10-12.
 */
public class Spray{
    private Bitmap spray;
    private Matrix matrix;
    private int centX;
    private int centY;
    private int currentSelfAngle;
    private float x;
    private float y;
    private int direction;
    private Integer[] ships = {R.drawable.ship_1,R.drawable.ship_2,R.drawable.ship_3,R.drawable.ship_4,R.drawable.ship_5,R.drawable.ship_6,R.drawable.ship_7 };

    public Spray(Context context,int stage){
        spray = BitmapFactory.decodeResource(context.getResources(), ships[stage]);
        spray = Bitmap.createScaledBitmap(spray, 150, 150, true);
    }
    public void set(int w, int h){
        centX = w/2 ;
        centY = h/2 ;
    }

    private void pointOnCircle(int angleInDegrees, int Radius){
        x = (float)(Math.cos(Math.toRadians(angleInDegrees))*Radius) + centX;
        y =  (float)(Math.sin(Math.toRadians(angleInDegrees))*Radius) + centY;
    }

    public void update(Canvas canvas){
        if(direction==0) {
            pointOnCircle(currentSelfAngle++, (int) (centX * 0.8));
        }else{
            pointOnCircle(currentSelfAngle--, (int)(centX * 0.8));
        }
        calculateAngle();
        canvas.drawBitmap(spray, matrix, null);
    }

    private void calculateAngle(){
        matrix = new Matrix();
        float dx = centX - x-spray.getWidth()/2;
        float dy = centY - y-spray.getHeight()/2;
        double rad= Math.atan2(dx, dy);
        double degree = -(rad*180)/Math.PI ;
        if(degree>0){
            degree += 180;
        }else{
            degree -= 180;
        }
        matrix.setRotate((float) degree, spray.getWidth()/2, spray.getHeight()/2);
        matrix.postTranslate(x-spray.getWidth()/2, y-spray.getHeight()/2);
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


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }


    public void setY(int y) {
        this.y = y;
    }

    public Bitmap getSpray() {
        return spray;
    }

    public void setSpray(Bitmap spray) {
        this.spray = spray;
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    public int getCurrentSelfAngle() {
        return currentSelfAngle;
    }

    public void setCurrentSelfAngle(int currentSelfAngle) {
        this.currentSelfAngle = currentSelfAngle;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
