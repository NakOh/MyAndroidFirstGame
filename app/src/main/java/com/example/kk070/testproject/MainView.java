package com.example.kk070.testproject;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

import com.example.kk070.testproject.bug.Abug;
import com.example.kk070.testproject.bug.Bugs;
import com.example.kk070.testproject.bug.Cbug;
import com.example.kk070.testproject.bug.NormalBug;
import com.example.kk070.testproject.object.Bullet;
import com.example.kk070.testproject.object.ImageButton;
import com.example.kk070.testproject.object.Spray;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by kk070 on 2015-10-12.
 */
public class MainView extends View {
    private Spray spray;
    private ArrayList<Bullet> bullets;
    private Bullet[] bullet;
    private ImageButton imageButton;
    private ArrayList<Bugs> bugs;
    private Bugs[] bug;
    private int stage;
    private  int bulletCount = 0;
    private Context mContext = null;
    private boolean collision;
    private int index;
    private int w,h;
    public MainView(Context context) {
        super(context);
        this.mContext = context;
        stage = 0;

        spray = new Spray(context, stage);

        bullets = new ArrayList<Bullet>();
        bugs = new ArrayList<Bugs>();

        bullet = new Bullet[15];
        bug = new Bugs[18];

        for(int i = 0;  i < 15 ; i++) {
            bullet[i] = new Bullet(context);
        }

        for(int i = 0; i<17; i++){
            if(i > 11) bug[i] = new NormalBug(context);
            else if(i > 5) bug[i] = new Cbug(context);
            else bug[i] = new Abug(context);
            bugs.add(bug[i]);
        }

        imageButton = new ImageButton(context);

        this.setBackgroundResource(R.drawable.background);
        this.setFocusableInTouchMode(true);
    }

    private void stageUp(){
        spray = new Spray(mContext, stage);

        bullets = new ArrayList<Bullet>();
        bugs = new ArrayList<Bugs>();

        bullet = new Bullet[15];
        bug = new Bugs[18];

        for(int i = 0;  i < 15 ; i++) {
            bullet[i] = new Bullet(mContext);
        }

        for(int i = 0; i<17; i++){
            if(i > 11) bug[i] = new NormalBug(mContext);
            else if(i > 5) bug[i] = new Cbug(mContext);
            else bug[i] = new Abug(mContext);
            bugs.add(bug[i]);
        }

        imageButton = new ImageButton(mContext);

        spray.set(w, h);

        for(int i = 0;  i < 15 ; i++) {
            bullet[i].setCent(w,h);
        }

        for(Bugs bug : bugs){
            int randomX = randomRange(-200, 200);
            int randomY = randomRange(-200, 200);
            int randomW = randomRange(0 , w);
            int randomH = randomRange(0,  h);
            bug.set(w / 2 + randomX, h / 2 + randomY, randomW, randomH);
        }

        this.setBackgroundResource(R.drawable.background);
        this.setFocusableInTouchMode(true);


    }

    @Override
    protected void onDraw(Canvas canvas) {

        if(collision){

        }else {
            bullets.add(bullet[bulletCount]);
            bullet[bulletCount].set(spray.getX(), spray.getY());

            bulletCount++;

            if (bulletCount == 14) {
                bulletCount = 0;
            }

            if (bullets.size() == 15) {
                bullets.remove(0);
            }

            for (Bugs bug : bugs) {
                bug.update(canvas);
            }

            for (Bullet bullet : bullets) {
                bullet.update(canvas);
            }

            spray.update(canvas);
            imageButton.update(canvas);

            if (checkCollision()) {
                ((MainActivity) mContext).dialogSimple();
            }

            if(killBug()){
                bugs.remove(index);
            }

            if(bugs.size()==0){
                if(stage==7){

                }else {
                    stage++;
                    stageUp();
                }
            }
        }
            invalidate();
    }


    @Override
    public void onSizeChanged(int w, int h, int oldW, int oldH) {
        this.w =w;
        this.h =h;
        spray.set(w, h);

        for(int i = 0;  i < 15 ; i++) {
            bullet[i].setCent(w,h);
        }

        for(Bugs bug : bugs){
            int randomX = randomRange(-200, 200);
            int randomY = randomRange(-200, 200);
            int randomW = randomRange(0 , w);
            int randomH = randomRange(0,  h);
            bug.set(w / 2 + randomX, h / 2 + randomY, randomW, randomH);
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float currentX = event.getX();
        float currentY = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_DOWN:
                if(imageButton.getLeftArrowX()<currentX && imageButton.getLeftArrowX()+200 > currentX && 1500<currentY && 1700>currentY){
                    changeDirection(0);
                }
                if(imageButton.getRightArrowX()<currentX && imageButton.getRightArrowX()+200 > currentX && 1500<currentY && 1700>currentY){
                    changeDirection(1);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;

    }

    private boolean checkCollision(){
        for(Bugs bug : bugs){
            if(bug.getX() + bug.getBug().getWidth() >=  spray.getX() && bug.getX() <= spray.getX()+spray.getSpray().getWidth() && bug.getY()+bug.getBug().getHeight()>= spray.getY() && bug.getY() <= spray.getY()+spray.getSpray().getHeight())
            {
                return true;
            }
        }
        return false;
    }

    private boolean killBug(){
        for(Bullet bullet : bullets){
            index = 0;
            for(Bugs bug : bugs) {
                if (bullet.getX() + bullet.getBullet().getWidth() >= bug.getX() && bullet.getX() <= bug.getX() + bug.getBug().getWidth() && bullet.getY() + bullet.getBullet().getHeight() >= bug.getY() && bullet.getY() <= bug.getY() + bug.getBug().getHeight()) {
                    return true;
                }
                index++;
            }
        }
        return false;
    }

    private void changeDirection(int direction){
           spray.setDirection(direction);
    }

    private int randomRange(int n1, int n2) {
        return (int) (Math.random() * (n2 - n1 + 1)) + n1;
    }

    public Spray getSpray() {
        return spray;
    }

    public void setSpray(Spray spray) {
        this.spray = spray;
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(ArrayList<Bullet> bullets) {
        this.bullets = bullets;
    }

    public Bullet[] getBullet() {
        return bullet;
    }

    public void setBullet(Bullet[] bullet) {
        this.bullet = bullet;
    }

    public ImageButton getImageButton() {
        return imageButton;
    }

    public void setImageButton(ImageButton imageButton) {
        this.imageButton = imageButton;
    }

    public ArrayList<Bugs> getBugs() {
        return bugs;
    }

    public void setBugs(ArrayList<Bugs> bugs) {
        this.bugs = bugs;
    }

    public Bugs[] getBug() {
        return bug;
    }

    public void setBug(Bugs[] bug) {
        this.bug = bug;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getBulletCount() {
        return bulletCount;
    }

    public void setBulletCount(int bulletCount) {
        this.bulletCount = bulletCount;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }
}
