package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.c;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.d;
import com.airbnb.lottie.c.b.q;
import com.airbnb.lottie.f;
import com.airbnb.lottie.f.e;
import com.airbnb.lottie.j;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

public abstract class a implements d, j, a.C0069a {

    /* renamed from: a  reason: collision with root package name */
    final Paint f3375a = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    private final PathMeasure f3376b = new PathMeasure();

    /* renamed from: c  reason: collision with root package name */
    private final Path f3377c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final Path f3378d = new Path();

    /* renamed from: e  reason: collision with root package name */
    private final RectF f3379e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    private final f f3380f;

    /* renamed from: g  reason: collision with root package name */
    private final com.airbnb.lottie.c.c.a f3381g;
    private final List<C0068a> h = new ArrayList();
    private final float[] i;
    private final com.airbnb.lottie.a.b.a<?, Float> j;
    private final com.airbnb.lottie.a.b.a<?, Integer> k;
    private final List<com.airbnb.lottie.a.b.a<?, Float>> l;
    private final com.airbnb.lottie.a.b.a<?, Float> m;
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> n;

    a(f fVar, com.airbnb.lottie.c.c.a aVar, Paint.Cap cap, Paint.Join join, float f2, d dVar, b bVar, List<b> list, b bVar2) {
        this.f3380f = fVar;
        this.f3381g = aVar;
        this.f3375a.setStyle(Paint.Style.STROKE);
        this.f3375a.setStrokeCap(cap);
        this.f3375a.setStrokeJoin(join);
        this.f3375a.setStrokeMiter(f2);
        this.k = dVar.a();
        this.j = bVar.a();
        if (bVar2 == null) {
            this.m = null;
        } else {
            this.m = bVar2.a();
        }
        this.l = new ArrayList(list.size());
        this.i = new float[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.l.add(list.get(i2).a());
        }
        aVar.a((com.airbnb.lottie.a.b.a<?, ?>) this.k);
        aVar.a((com.airbnb.lottie.a.b.a<?, ?>) this.j);
        for (int i3 = 0; i3 < this.l.size(); i3++) {
            aVar.a((com.airbnb.lottie.a.b.a<?, ?>) this.l.get(i3));
        }
        com.airbnb.lottie.a.b.a<?, Float> aVar2 = this.m;
        if (aVar2 != null) {
            aVar.a((com.airbnb.lottie.a.b.a<?, ?>) aVar2);
        }
        this.k.a((a.C0069a) this);
        this.j.a((a.C0069a) this);
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.l.get(i4).a((a.C0069a) this);
        }
        com.airbnb.lottie.a.b.a<?, Float> aVar3 = this.m;
        if (aVar3 != null) {
            aVar3.a((a.C0069a) this);
        }
    }

    public void a() {
        this.f3380f.invalidateSelf();
    }

    public void a(List<b> list, List<b> list2) {
        r rVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            b bVar = list.get(size);
            if (bVar instanceof r) {
                r rVar2 = (r) bVar;
                if (rVar2.c() == q.a.Individually) {
                    rVar = rVar2;
                }
            }
        }
        if (rVar != null) {
            rVar.a(this);
        }
        C0068a aVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            b bVar2 = list2.get(size2);
            if (bVar2 instanceof r) {
                r rVar3 = (r) bVar2;
                if (rVar3.c() == q.a.Individually) {
                    if (aVar != null) {
                        this.h.add(aVar);
                    }
                    aVar = new C0068a(rVar3);
                    rVar3.a(this);
                }
            }
            if (bVar2 instanceof l) {
                if (aVar == null) {
                    aVar = new C0068a(rVar);
                }
                aVar.f3382a.add((l) bVar2);
            }
        }
        if (aVar != null) {
            this.h.add(aVar);
        }
    }

    public void a(Canvas canvas, Matrix matrix, int i2) {
        c.c("StrokeContent#draw");
        this.f3375a.setAlpha(e.a((int) ((((((float) i2) / 255.0f) * ((float) this.k.e().intValue())) / 100.0f) * 255.0f), 0, 255));
        this.f3375a.setStrokeWidth(this.j.e().floatValue() * com.airbnb.lottie.f.f.a(matrix));
        if (this.f3375a.getStrokeWidth() <= BitmapDescriptorFactory.HUE_RED) {
            c.d("StrokeContent#draw");
            return;
        }
        a(matrix);
        com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.n;
        if (aVar != null) {
            this.f3375a.setColorFilter(aVar.e());
        }
        for (int i3 = 0; i3 < this.h.size(); i3++) {
            C0068a aVar2 = this.h.get(i3);
            if (aVar2.f3383b != null) {
                a(canvas, aVar2, matrix);
            } else {
                c.c("StrokeContent#buildPath");
                this.f3377c.reset();
                for (int size = aVar2.f3382a.size() - 1; size >= 0; size--) {
                    this.f3377c.addPath(((l) aVar2.f3382a.get(size)).e(), matrix);
                }
                c.d("StrokeContent#buildPath");
                c.c("StrokeContent#drawPath");
                canvas.drawPath(this.f3377c, this.f3375a);
                c.d("StrokeContent#drawPath");
            }
        }
        c.d("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0068a aVar, Matrix matrix) {
        c.c("StrokeContent#applyTrimPath");
        if (aVar.f3383b == null) {
            c.d("StrokeContent#applyTrimPath");
            return;
        }
        this.f3377c.reset();
        for (int size = aVar.f3382a.size() - 1; size >= 0; size--) {
            this.f3377c.addPath(((l) aVar.f3382a.get(size)).e(), matrix);
        }
        this.f3376b.setPath(this.f3377c, false);
        float length = this.f3376b.getLength();
        while (this.f3376b.nextContour()) {
            length += this.f3376b.getLength();
        }
        float floatValue = (aVar.f3383b.f().e().floatValue() * length) / 360.0f;
        float floatValue2 = ((aVar.f3383b.d().e().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((aVar.f3383b.e().e().floatValue() * length) / 100.0f) + floatValue;
        float f2 = BitmapDescriptorFactory.HUE_RED;
        for (int size2 = aVar.f3382a.size() - 1; size2 >= 0; size2--) {
            this.f3378d.set(((l) aVar.f3382a.get(size2)).e());
            this.f3378d.transform(matrix);
            this.f3376b.setPath(this.f3378d, false);
            float length2 = this.f3376b.getLength();
            float f3 = 1.0f;
            if (floatValue3 > length) {
                float f4 = floatValue3 - length;
                if (f4 < f2 + length2 && f2 < f4) {
                    com.airbnb.lottie.f.f.a(this.f3378d, floatValue2 > length ? (floatValue2 - length) / length2 : BitmapDescriptorFactory.HUE_RED, Math.min(f4 / length2, 1.0f), (float) BitmapDescriptorFactory.HUE_RED);
                    canvas.drawPath(this.f3378d, this.f3375a);
                    f2 += length2;
                }
            }
            float f5 = f2 + length2;
            if (f5 >= floatValue2 && f2 <= floatValue3) {
                if (f5 > floatValue3 || floatValue2 >= f2) {
                    float f6 = floatValue2 < f2 ? BitmapDescriptorFactory.HUE_RED : (floatValue2 - f2) / length2;
                    if (floatValue3 <= f5) {
                        f3 = (floatValue3 - f2) / length2;
                    }
                    com.airbnb.lottie.f.f.a(this.f3378d, f6, f3, (float) BitmapDescriptorFactory.HUE_RED);
                    canvas.drawPath(this.f3378d, this.f3375a);
                } else {
                    canvas.drawPath(this.f3378d, this.f3375a);
                }
            }
            f2 += length2;
        }
        c.d("StrokeContent#applyTrimPath");
    }

    public void a(RectF rectF, Matrix matrix) {
        c.c("StrokeContent#getBounds");
        this.f3377c.reset();
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            C0068a aVar = this.h.get(i2);
            for (int i3 = 0; i3 < aVar.f3382a.size(); i3++) {
                this.f3377c.addPath(((l) aVar.f3382a.get(i3)).e(), matrix);
            }
        }
        this.f3377c.computeBounds(this.f3379e, false);
        float floatValue = this.j.e().floatValue();
        RectF rectF2 = this.f3379e;
        float f2 = floatValue / 2.0f;
        rectF2.set(rectF2.left - f2, this.f3379e.top - f2, this.f3379e.right + f2, this.f3379e.bottom + f2);
        rectF.set(this.f3379e);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        c.d("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        c.c("StrokeContent#applyDashPattern");
        if (this.l.isEmpty()) {
            c.d("StrokeContent#applyDashPattern");
            return;
        }
        float a2 = com.airbnb.lottie.f.f.a(matrix);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            this.i[i2] = ((Float) this.l.get(i2).e()).floatValue();
            if (i2 % 2 == 0) {
                float[] fArr = this.i;
                if (fArr[i2] < 1.0f) {
                    fArr[i2] = 1.0f;
                }
            } else {
                float[] fArr2 = this.i;
                if (fArr2[i2] < 0.1f) {
                    fArr2[i2] = 0.1f;
                }
            }
            float[] fArr3 = this.i;
            fArr3[i2] = fArr3[i2] * a2;
        }
        com.airbnb.lottie.a.b.a<?, Float> aVar = this.m;
        this.f3375a.setPathEffect(new DashPathEffect(this.i, aVar == null ? BitmapDescriptorFactory.HUE_RED : aVar.e().floatValue()));
        c.d("StrokeContent#applyDashPattern");
    }

    public void a(com.airbnb.lottie.c.e eVar, int i2, List<com.airbnb.lottie.c.e> list, com.airbnb.lottie.c.e eVar2) {
        e.a(eVar, i2, list, eVar2, this);
    }

    public <T> void a(T t, com.airbnb.lottie.g.c<T> cVar) {
        if (t == j.f3756d) {
            this.k.a(cVar);
        } else if (t == j.k) {
            this.j.a(cVar);
        } else if (t != j.x) {
        } else {
            if (cVar == null) {
                this.n = null;
                return;
            }
            this.n = new p(cVar);
            this.n.a((a.C0069a) this);
            this.f3381g.a((com.airbnb.lottie.a.b.a<?, ?>) this.n);
        }
    }

    /* renamed from: com.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    private static final class C0068a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final List<l> f3382a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final r f3383b;

        private C0068a(r rVar) {
            this.f3382a = new ArrayList();
            this.f3383b = rVar;
        }
    }
}
