package com.google.zxing.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private Paint f14446a = new Paint();

    /* renamed from: b  reason: collision with root package name */
    private int f14447b;

    public void b(Canvas canvas, Rect rect) {
    }

    public b(int i) {
        this.f14447b = i;
    }

    public void a(Canvas canvas, Rect rect) {
        this.f14446a.setColor(this.f14447b);
        this.f14446a.setAlpha(255);
        int i = (rect.top + rect.bottom) / 2;
        canvas.drawRect((float) rect.left, (float) (i - 2), (float) rect.right, (float) (i + 2), this.f14446a);
    }
}
