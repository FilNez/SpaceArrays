package ru.samsung.itschool.spacearrays;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Star {
    Paint paint = new Paint();
    int x, y, alpha;

    Star(int x, int y, int alpha) {
        this.x = x;
        this.y = y;
        this.alpha = alpha;
    }


    void draw(Canvas canvas) {
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(2);

        paint.setAlpha(alpha);
        alpha += (int)(Math.random() * 11) - 5;

        if (alpha > 255) alpha = 255;
        if (alpha < 0) alpha = 0;

        canvas.drawCircle(x, y, 3, paint);
    }
}
