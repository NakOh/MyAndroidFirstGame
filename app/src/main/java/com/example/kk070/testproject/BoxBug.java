package com.example.kk070.testproject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import java.util.Random;

/**
 * Created by kk070 on 2015-10-05.
 */
public class BoxBug {
    private Paint paint;
    private Rect bounds;
    int width = 20;


    int height = 110;
    int speedX= 0;
    float speedY;

    int centX;
    int centY;
    float currentSelfAngle;
    int i =0;

    int x;
    int y;


    private int xMin=1000,yMin=300;

    private Integer[] colorArray = {Color.YELLOW,Color.BLUE,Color.GREEN, Color.RED, Color.MAGENTA, Color.CYAN};
    public BoxBug(int color){
        paint = new Paint();
        paint.setColor(color);
        bounds = new Rect();
    }

    public void set(Canvas canvas){
        bounds.set(centX*2-width/2, centY-height/2 , centX * 2, centY*height/2);
       centX = bounds.centerX();
        centY = bounds.centerY();
        canvas.rotate(currentSelfAngle,centX, centY);
      //  canvas.translate(1.0f, 1.0f);
        canvas.drawRect(bounds, paint);
        currentSelfAngle++;
        centX++;
        centY++;
    }


    public void pointOnCircle(float angleInDegrees, float Radius){
        x =(int) (Math.cos(Math.toRadians(angleInDegrees))*Radius) + centX;
        y = (int) (Math.sin(Math.toRadians(angleInDegrees))*Radius) + centY;
        centX = x;
        centY= y;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public void update(){


    }
}
