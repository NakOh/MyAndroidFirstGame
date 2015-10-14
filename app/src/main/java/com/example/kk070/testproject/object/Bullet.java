package com.example.kk070.testproject.object;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.kk070.testproject.R;

/**
 * Created by kk070 on 2015-10-13.
 */
public class Bullet {
    private Bitmap bullet;
    private float x;
    private float y;
    private int centX;
    private int centY;
    private float speedX;
    private float speedY;
    private float random;
    private Integer[] bullets = {R.drawable.fireball, R.drawable.waterball, R.drawable.energyball, R.drawable.lazer };

    public Bullet(Context context){
        random = randomRange(0, 3);
        bullet = BitmapFactory.decodeResource(context.getResources(), bullets[(int) random]);
        bullet = Bitmap.createScaledBitmap(bullet, 10, 10, true);
    }

    public void set(float x, float y){
        this.x = x;
        this.y = y;
        speedX = (float)((centX - x)/Math.sqrt(((centX - x) * (centX - x)) + ((centY - y) *(centY - y ))));
        speedY = (float)((centY - y)/Math.sqrt(((centY - y) * (centY - y)) + ((centX - x) *(centX - x ))));
        random = randomRange(-5, 5);
        speedX += random / 10;
        random = randomRange(-5, 5);
        speedY += random / 10;
    }


    public void setCent(int centX, int centY){
        this.centX = centX/2;
        this.centY = centY/2;
    }

    public void update(Canvas canvas){
        canvas.drawBitmap(bullet, x, y, null);
        x += speedX * 15;
        y += speedY * 15;
    }

    private int randomRange(int n1, int n2) {
        return (int) (Math.random() * (n2 - n1 + 1)) + n1;
    }

    public Bitmap getBullet() {
        return bullet;
    }

    public void setBullet(Bitmap bullet) {
        this.bullet = bullet;
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

    public float getRandom() {
        return random;
    }

    public void setRandom(float random) {
        this.random = random;
    }

    public Integer[] getBullets() {
        return bullets;
    }

    public void setBullets(Integer[] bullets) {
        this.bullets = bullets;
    }
}
