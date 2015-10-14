package com.example.kk070.testproject.bug;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by kk070 on 2015-10-12.
 */
public interface Bugs {
    void set(int x, int y, int w, int h);
    void update(Canvas canvas);
    void algorithm();
    float getX();
    float getY();
    Bitmap getBug() ;
}
