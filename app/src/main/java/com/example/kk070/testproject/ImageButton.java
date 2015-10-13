package com.example.kk070.testproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

/**
 * Created by kk070 on 2015-10-13.
 */
public class ImageButton {
    private Bitmap leftArrow;
    private Bitmap rightArrow;

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


}
