package fr.castorflex.android.smoothprogressbar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.Shape;

public class a extends Shape {

    /* renamed from: a  reason: collision with root package name */
    private float f33010a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f33011b;

    public a(float f2, int[] iArr) {
        this.f33010a = f2;
        this.f33011b = iArr;
    }

    public void draw(Canvas canvas, Paint paint) {
        float length = 1.0f / ((float) this.f33011b.length);
        paint.setStrokeWidth(this.f33010a);
        int i = 0;
        for (int color : this.f33011b) {
            paint.setColor(color);
            i++;
            canvas.drawLine(((float) i) * length * getWidth(), getHeight() / 2.0f, ((float) i) * length * getWidth(), getHeight() / 2.0f, paint);
        }
    }
}
