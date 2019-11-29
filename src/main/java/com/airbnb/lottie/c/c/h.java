package com.airbnb.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.n;
import com.airbnb.lottie.c.a.k;
import com.airbnb.lottie.c.b;
import com.airbnb.lottie.c.d;
import com.airbnb.lottie.f;
import com.airbnb.lottie.j;
import com.airbnb.lottie.p;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class h extends a {

    /* renamed from: e  reason: collision with root package name */
    private final char[] f3634e = new char[1];

    /* renamed from: f  reason: collision with root package name */
    private final RectF f3635f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private final Matrix f3636g = new Matrix();
    private final Paint h = new Paint(1) {
        {
            setStyle(Paint.Style.FILL);
        }
    };
    private final Paint i = new Paint(1) {
        {
            setStyle(Paint.Style.STROKE);
        }
    };
    private final Map<d, List<c>> j = new HashMap();
    private final n k;
    private final f l;
    private final com.airbnb.lottie.d m;
    private a<Integer, Integer> n;
    private a<Integer, Integer> o;
    private a<Float, Float> p;
    private a<Float, Float> q;

    h(f fVar, d dVar) {
        super(fVar, dVar);
        this.l = fVar;
        this.m = dVar.a();
        this.k = dVar.s().a();
        this.k.a((a.C0069a) this);
        a((a<?, ?>) this.k);
        k t = dVar.t();
        if (!(t == null || t.f3515a == null)) {
            this.n = t.f3515a.a();
            this.n.a((a.C0069a) this);
            a((a<?, ?>) this.n);
        }
        if (!(t == null || t.f3516b == null)) {
            this.o = t.f3516b.a();
            this.o.a((a.C0069a) this);
            a((a<?, ?>) this.o);
        }
        if (!(t == null || t.f3517c == null)) {
            this.p = t.f3517c.a();
            this.p.a((a.C0069a) this);
            a((a<?, ?>) this.p);
        }
        if (t != null && t.f3518d != null) {
            this.q = t.f3518d.a();
            this.q.a((a.C0069a) this);
            a((a<?, ?>) this.q);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Canvas canvas, Matrix matrix, int i2) {
        canvas.save();
        if (!this.l.p()) {
            canvas.setMatrix(matrix);
        }
        b bVar = (b) this.k.e();
        com.airbnb.lottie.c.c cVar = this.m.i().get(bVar.f3528b);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        a<Integer, Integer> aVar = this.n;
        if (aVar != null) {
            this.h.setColor(aVar.e().intValue());
        } else {
            this.h.setColor(bVar.h);
        }
        a<Integer, Integer> aVar2 = this.o;
        if (aVar2 != null) {
            this.i.setColor(aVar2.e().intValue());
        } else {
            this.i.setColor(bVar.i);
        }
        int intValue = (this.f3608d.a().e().intValue() * 255) / 100;
        this.h.setAlpha(intValue);
        this.i.setAlpha(intValue);
        a<Float, Float> aVar3 = this.p;
        if (aVar3 != null) {
            this.i.setStrokeWidth(aVar3.e().floatValue());
        } else {
            float a2 = com.airbnb.lottie.f.f.a(matrix);
            Paint paint = this.i;
            double d2 = bVar.j;
            double a3 = (double) com.airbnb.lottie.f.f.a();
            Double.isNaN(a3);
            double d3 = d2 * a3;
            double d4 = (double) a2;
            Double.isNaN(d4);
            paint.setStrokeWidth((float) (d3 * d4));
        }
        if (this.l.p()) {
            a(bVar, matrix, cVar, canvas);
        } else {
            a(bVar, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(b bVar, Matrix matrix, com.airbnb.lottie.c.c cVar, Canvas canvas) {
        float f2 = ((float) bVar.f3529c) / 100.0f;
        float a2 = com.airbnb.lottie.f.f.a(matrix);
        String str = bVar.f3527a;
        for (int i2 = 0; i2 < str.length(); i2++) {
            d a3 = this.m.h().a(d.a(str.charAt(i2), cVar.a(), cVar.c()));
            if (a3 != null) {
                a(a3, matrix, f2, bVar, canvas);
                float b2 = ((float) a3.b()) * f2 * com.airbnb.lottie.f.f.a() * a2;
                float f3 = ((float) bVar.f3531e) / 10.0f;
                a<Float, Float> aVar = this.q;
                if (aVar != null) {
                    f3 += aVar.e().floatValue();
                }
                canvas.translate(b2 + (f3 * a2), BitmapDescriptorFactory.HUE_RED);
            }
        }
    }

    private void a(b bVar, com.airbnb.lottie.c.c cVar, Matrix matrix, Canvas canvas) {
        float a2 = com.airbnb.lottie.f.f.a(matrix);
        Typeface a3 = this.l.a(cVar.a(), cVar.c());
        if (a3 != null) {
            String str = bVar.f3527a;
            p o2 = this.l.o();
            if (o2 != null) {
                str = o2.a(str);
            }
            this.h.setTypeface(a3);
            Paint paint = this.h;
            double d2 = bVar.f3529c;
            double a4 = (double) com.airbnb.lottie.f.f.a();
            Double.isNaN(a4);
            paint.setTextSize((float) (d2 * a4));
            this.i.setTypeface(this.h.getTypeface());
            this.i.setTextSize(this.h.getTextSize());
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                a(charAt, bVar, canvas);
                char[] cArr = this.f3634e;
                cArr[0] = charAt;
                float measureText = this.h.measureText(cArr, 0, 1);
                float f2 = ((float) bVar.f3531e) / 10.0f;
                a<Float, Float> aVar = this.q;
                if (aVar != null) {
                    f2 += aVar.e().floatValue();
                }
                canvas.translate(measureText + (f2 * a2), BitmapDescriptorFactory.HUE_RED);
            }
        }
    }

    private void a(d dVar, Matrix matrix, float f2, b bVar, Canvas canvas) {
        List<c> a2 = a(dVar);
        for (int i2 = 0; i2 < a2.size(); i2++) {
            Path e2 = a2.get(i2).e();
            e2.computeBounds(this.f3635f, false);
            this.f3636g.set(matrix);
            this.f3636g.preTranslate(BitmapDescriptorFactory.HUE_RED, ((float) (-bVar.f3533g)) * com.airbnb.lottie.f.f.a());
            this.f3636g.preScale(f2, f2);
            e2.transform(this.f3636g);
            if (bVar.k) {
                a(e2, this.h, canvas);
                a(e2, this.i, canvas);
            } else {
                a(e2, this.i, canvas);
                a(e2, this.h, canvas);
            }
        }
    }

    private void a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != BitmapDescriptorFactory.HUE_RED) {
                canvas.drawPath(path, paint);
            }
        }
    }

    private void a(char c2, b bVar, Canvas canvas) {
        this.f3634e[0] = c2;
        if (bVar.k) {
            a(this.f3634e, this.h, canvas);
            a(this.f3634e, this.i, canvas);
            return;
        }
        a(this.f3634e, this.i, canvas);
        a(this.f3634e, this.h, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != BitmapDescriptorFactory.HUE_RED) {
                canvas.drawText(cArr, 0, 1, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, paint);
            }
        }
    }

    private List<c> a(d dVar) {
        if (this.j.containsKey(dVar)) {
            return this.j.get(dVar);
        }
        List<com.airbnb.lottie.c.b.n> a2 = dVar.a();
        int size = a2.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new c(this.l, this, a2.get(i2)));
        }
        this.j.put(dVar, arrayList);
        return arrayList;
    }

    public <T> void a(T t, com.airbnb.lottie.g.c<T> cVar) {
        super.a(t, cVar);
        if (t == j.f3753a) {
            a<Integer, Integer> aVar = this.n;
            if (aVar != null) {
                aVar.a((com.airbnb.lottie.g.c<Integer>) cVar);
                return;
            }
        }
        if (t == j.f3754b) {
            a<Integer, Integer> aVar2 = this.o;
            if (aVar2 != null) {
                aVar2.a((com.airbnb.lottie.g.c<Integer>) cVar);
                return;
            }
        }
        if (t == j.k) {
            a<Float, Float> aVar3 = this.p;
            if (aVar3 != null) {
                aVar3.a((com.airbnb.lottie.g.c<Float>) cVar);
                return;
            }
        }
        if (t == j.l) {
            a<Float, Float> aVar4 = this.q;
            if (aVar4 != null) {
                aVar4.a((com.airbnb.lottie.g.c<Float>) cVar);
            }
        }
    }
}
