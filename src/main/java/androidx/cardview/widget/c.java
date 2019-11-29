package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.cardview.widget.g;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

class c implements e {

    /* renamed from: a  reason: collision with root package name */
    final RectF f1347a = new RectF();

    public void g(d dVar) {
    }

    c() {
    }

    public void a() {
        g.f1356a = new g.a() {
            public void a(Canvas canvas, RectF rectF, float f2, Paint paint) {
                Canvas canvas2 = canvas;
                RectF rectF2 = rectF;
                float f3 = 2.0f * f2;
                float width = (rectF.width() - f3) - 1.0f;
                float height = (rectF.height() - f3) - 1.0f;
                if (f2 >= 1.0f) {
                    float f4 = f2 + 0.5f;
                    float f5 = -f4;
                    c.this.f1347a.set(f5, f5, f4, f4);
                    int save = canvas.save();
                    canvas2.translate(rectF2.left + f4, rectF2.top + f4);
                    Paint paint2 = paint;
                    canvas.drawArc(c.this.f1347a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(width, BitmapDescriptorFactory.HUE_RED);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(c.this.f1347a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(height, BitmapDescriptorFactory.HUE_RED);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(c.this.f1347a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(width, BitmapDescriptorFactory.HUE_RED);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(c.this.f1347a, 180.0f, 90.0f, true, paint2);
                    canvas2.restoreToCount(save);
                    canvas.drawRect((rectF2.left + f4) - 1.0f, rectF2.top, (rectF2.right - f4) + 1.0f, rectF2.top + f4, paint2);
                    canvas.drawRect((rectF2.left + f4) - 1.0f, rectF2.bottom - f4, (rectF2.right - f4) + 1.0f, rectF2.bottom, paint2);
                }
                canvas.drawRect(rectF2.left, rectF2.top + f2, rectF2.right, rectF2.bottom - f2, paint);
            }
        };
    }

    public void a(d dVar, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        g a2 = a(context, colorStateList, f2, f3, f4);
        a2.a(dVar.b());
        dVar.a(a2);
        f(dVar);
    }

    private g a(Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        return new g(context.getResources(), colorStateList, f2, f3, f4);
    }

    public void f(d dVar) {
        Rect rect = new Rect();
        j(dVar).a(rect);
        dVar.a((int) Math.ceil((double) b(dVar)), (int) Math.ceil((double) c(dVar)));
        dVar.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void h(d dVar) {
        j(dVar).a(dVar.b());
        f(dVar);
    }

    public void a(d dVar, ColorStateList colorStateList) {
        j(dVar).a(colorStateList);
    }

    public ColorStateList i(d dVar) {
        return j(dVar).f();
    }

    public void a(d dVar, float f2) {
        j(dVar).a(f2);
        f(dVar);
    }

    public float d(d dVar) {
        return j(dVar).a();
    }

    public void c(d dVar, float f2) {
        j(dVar).b(f2);
    }

    public float e(d dVar) {
        return j(dVar).b();
    }

    public void b(d dVar, float f2) {
        j(dVar).c(f2);
        f(dVar);
    }

    public float a(d dVar) {
        return j(dVar).c();
    }

    public float b(d dVar) {
        return j(dVar).d();
    }

    public float c(d dVar) {
        return j(dVar).e();
    }

    private g j(d dVar) {
        return (g) dVar.c();
    }
}
