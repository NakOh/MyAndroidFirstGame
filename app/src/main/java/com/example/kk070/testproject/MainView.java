package com.example.kk070.testproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by kk070 on 2015-10-12.
 */
public class MainView extends View {
    private Spray spray;
    private Ball ball;

    public MainView(Context context) {
        super(context);

        ball = new Ball(Color.GREEN);
        spray = new Spray(Color.GRAY);

        this.setFocusableInTouchMode(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        ball.set(canvas);
        spray.set(canvas);

        ball.update();
        spray.update();

        if((ball.getBallX()+ball.getBallRadius() >= spray.getxMin()) && (spray.getyMin() <= ball.getBallY()+ball.getBallRadius()) &&  (ball.getBallY()-ball.getBallRadius() <= spray.getyMin()+ spray.getHeight())){

            ball.setBallSpeedX(-ball.getBallSpeedX());
            if(ball.getBallSpeedY()<0){
                ball.setBallSpeedY(ball.getBallSpeedY() - 1 );

            }else {
                ball.setBallSpeedY(ball.getBallSpeedY() + 1);

            }
        }else if(ball.getBallX()-ball.getBallRadius() >= spray.getxMin()+spray.getWidth()){

            if ((ball.getBallX()-ball.getBallRadius() <= spray.getxMin()+spray.getWidth()) && (spray.getyMin() <= ball.getBallY()+ball.getBallRadius()) &&  (ball.getBallY()-ball.getBallRadius() <= spray.getyMin()+ spray.getHeight())){
                ball.setBallSpeedX(-ball.getBallSpeedX());
                if(ball.getBallSpeedY()<0){
                    ball.setBallSpeedY(ball.getBallSpeedY() -1 );

                }else {
                    ball.setBallSpeedY(ball.getBallSpeedY() + 1);

                }
            }

        }

        invalidate();
    }


    @Override
    public void onSizeChanged(int w, int h, int oldW, int oldH) {
        ball.setXMax(w - 1);
        ball.setYMax(h - 1);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float currentX = event.getX();
        float currentY = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                spray.setSpeedY(currentY);
                break;
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;

    }

}
