package com.example.kk070.testproject.object;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.example.kk070.testproject.R;

/**
 * Created by kk070 on 2015-10-13.
 */
public class ImageButton {
    private Bitmap leftArrow;
    private Bitmap rightArrow;
    private int leftArrowX = 100;
    private int rightArrowX = 800;

    public ImageButton(Context context){
        leftArrow = BitmapFactory.decodeResource(context.getResources(), R.drawable.left_arrow);
        rightArrow = BitmapFactory.decodeResource(context.getResources(), R.drawable.right_arrow);
        leftArrow = Bitmap.createScaledBitmap(leftArrow, 200, 200, true);
        rightArrow = Bitmap.createScaledBitmap(rightArrow, 200, 200, true);
    }

    public void update(Canvas canvas){
        canvas.drawBitmap(leftArrow,100,1500,null);
        canvas.drawBitmap(rightArrow,800,1500,null);
    }

    public Bitmap getLeftArrow() {
        return leftArrow;
    }

    public void setLeftArrow(Bitmap leftArrow) {
        this.leftArrow = leftArrow;
    }

    public Bitmap getRightArrow() {
        return rightArrow;
    }

    public void setRightArrow(Bitmap rightArrow) {
        this.rightArrow = rightArrow;
    }

    public int getLeftArrowX() {
        return leftArrowX;
    }

    public void setLeftArrowX(int leftArrowX) {
        this.leftArrowX = leftArrowX;
    }

    public int getRightArrowX() {
        return rightArrowX;
    }

    public void setRightArrowX(int rightArrowX) {
        this.rightArrowX = rightArrowX;
    }
}
