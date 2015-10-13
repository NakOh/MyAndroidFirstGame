package com.example.kk070.testproject.bug;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by kk070 on 2015-10-12.
 */
public class Cbug implements Bugs {


    private int xMin = 0;
    private int xMax;
    private int yMin = 1600;
    private int yMax;

    private float ballRadius = 17;


    private float ballX = ballRadius + 200;
    private float ballY = ballRadius + 330;


    private float ballSpeedX = 30;
    private float ballSpeedY = 1;
    private float previousX;
    private float previousY;
    private RectF ballBounds;
    private Paint paint;

    public Cbug(int color){
        ballBounds = new RectF();
        paint = new Paint();
        paint.setColor(color);
    }

    public void set(Canvas canvas){
        ballBounds.set(ballX - ballRadius, ballY - ballRadius, ballX + ballRadius, ballY + ballRadius);
        canvas.drawOval(ballBounds, paint);
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public void update(){
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        if (ballX + ballRadius > xMax) {
            ballSpeedX = -ballSpeedX;
            ballX = xMax - ballRadius;
        } else if (ballX - ballRadius < xMin) {
            ballSpeedX = -ballSpeedX;
            ballX = xMin + ballRadius;
        }

        if (ballY + ballRadius > yMin) {
            ballSpeedY = -ballSpeedY;
            ballY = yMin - ballRadius;
        } else if (ballY - ballRadius < yMax) {
            ballSpeedY = -ballSpeedY;
            ballY = yMax + ballRadius;
        }

    }
}
