package com.airbnb.lottie.c.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.f;
import com.airbnb.lottie.j;

public class c extends a {

    /* renamed from: e  reason: collision with root package name */
    private final Paint f3620e = new Paint(3);

    /* renamed from: f  reason: collision with root package name */
    private final Rect f3621f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    private final Rect f3622g = new Rect();
    private a<ColorFilter, ColorFilter> h;

    c(f fVar, d dVar) {
        super(fVar, dVar);
    }

    public void b(Canvas canvas, Matrix matrix, int i) {
        Bitmap f2 = f();
        if (f2 != null && !f2.isRecycled()) {
            float a2 = com.airbnb.lottie.f.f.a();
            this.f3620e.setAlpha(i);
            a<ColorFilter, ColorFilter> aVar = this.h;
            if (aVar != null) {
                this.f3620e.setColorFilter(aVar.e());
            }
            canvas.save();
            canvas.concat(matrix);
            this.f3621f.set(0, 0, f2.getWidth(), f2.getHeight());
            this.f3622g.set(0, 0, (int) (((float) f2.getWidth()) * a2), (int) (((float) f2.getHeight()) * a2));
            canvas.drawBitmap(f2, this.f3621f, this.f3622g, this.f3620e);
            canvas.restore();
        }
    }

    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        Bitmap f2 = f();
        if (f2 != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, (float) f2.getWidth()), Math.min(rectF.bottom, (float) f2.getHeight()));
            this.f3605a.mapRect(rectF);
        }
    }

    private Bitmap f() {
        return this.f3606b.b(this.f3607c.g());
    }

    public <T> void a(T t, com.airbnb.lottie.g.c<T> cVar) {
        super.a(t, cVar);
        if (t != j.x) {
            return;
        }
        if (cVar == null) {
            this.h = null;
        } else {
            this.h = new p(cVar);
        }
    }
}
