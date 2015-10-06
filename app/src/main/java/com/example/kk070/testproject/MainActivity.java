package com.example.kk070.testproject;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GraphicsView(this));

    }

    static public class GraphicsView extends View {

        private Bar bar;
        private Ball ball;
        private BoxBug boxBug;

        public GraphicsView(Context context) {
            super(context);
            ball = new Ball(Color.GREEN);
            bar = new Bar(Color.RED);
            boxBug = new BoxBug(Color.RED);
            this.setFocusableInTouchMode(true);
        }

        @Override
        protected void onDraw(Canvas canvas) {

            ball.set(canvas);
            bar.set(canvas);
            boxBug.set(canvas);

            ball.update();
            bar.update();
            boxBug.update();

            if((ball.getBallX()+ball.getBallRadius() >= bar.getxMin()) && (bar.getyMin() <= ball.getBallY()+ball.getBallRadius()) &&  (ball.getBallY()-ball.getBallRadius() <= bar.getyMin()+ bar.getHeight())){

                ball.setBallSpeedX(-ball.getBallSpeedX());
                if(ball.getBallSpeedY()<0){
                    ball.setBallSpeedY(ball.getBallSpeedY() -1 );
                    bar.changColor();
                }else {
                    ball.setBallSpeedY(ball.getBallSpeedY() + 1);
                    bar.changColor();

                }
            }else if(ball.getBallX()-ball.getBallRadius() >= bar.getxMin()+bar.width){

                if ((ball.getBallX()-ball.getBallRadius() <= bar.getxMin()+bar.width) && (bar.getyMin() <= ball.getBallY()+ball.getBallRadius()) &&  (ball.getBallY()-ball.getBallRadius() <= bar.getyMin()+ bar.getHeight())){
                    ball.setBallSpeedX(-ball.getBallSpeedX());
                    if(ball.getBallSpeedY()<0){
                        ball.setBallSpeedY(ball.getBallSpeedY() -1 );
                        bar.changColor();
                    }else {
                        ball.setBallSpeedY(ball.getBallSpeedY() + 1);
                        bar.changColor();
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
                    bar.setSpeedY(currentY);
                    break;
                case MotionEvent.ACTION_DOWN:
                    break;
                case MotionEvent.ACTION_UP:
                    break;

            }


            return true;

        }


    }
}
