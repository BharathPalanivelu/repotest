package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.c;
import com.airbnb.lottie.c.b.m;
import com.airbnb.lottie.f.e;
import com.airbnb.lottie.j;
import java.util.ArrayList;
import java.util.List;

public class f implements d, j, a.C0069a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f3398a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Paint f3399b = new Paint(1);

    /* renamed from: c  reason: collision with root package name */
    private final com.airbnb.lottie.c.c.a f3400c;

    /* renamed from: d  reason: collision with root package name */
    private final String f3401d;

    /* renamed from: e  reason: collision with root package name */
    private final List<l> f3402e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final a<Integer, Integer> f3403f;

    /* renamed from: g  reason: collision with root package name */
    private final a<Integer, Integer> f3404g;
    private a<ColorFilter, ColorFilter> h;
    private final com.airbnb.lottie.f i;

    public f(com.airbnb.lottie.f fVar, com.airbnb.lottie.c.c.a aVar, m mVar) {
        this.f3400c = aVar;
        this.f3401d = mVar.a();
        this.i = fVar;
        if (mVar.b() == null || mVar.c() == null) {
            this.f3403f = null;
            this.f3404g = null;
            return;
        }
        this.f3398a.setFillType(mVar.d());
        this.f3403f = mVar.b().a();
        this.f3403f.a((a.C0069a) this);
        aVar.a((a<?, ?>) this.f3403f);
        this.f3404g = mVar.c().a();
        this.f3404g.a((a.C0069a) this);
        aVar.a((a<?, ?>) this.f3404g);
    }

    public void a() {
        this.i.invalidateSelf();
    }

    public void a(List<b> list, List<b> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            b bVar = list2.get(i2);
            if (bVar instanceof l) {
                this.f3402e.add((l) bVar);
            }
        }
    }

    public String b() {
        return this.f3401d;
    }

    public void a(Canvas canvas, Matrix matrix, int i2) {
        c.c("FillContent#draw");
        this.f3399b.setColor(this.f3403f.e().intValue());
        this.f3399b.setAlpha(e.a((int) ((((((float) i2) / 255.0f) * ((float) this.f3404g.e().intValue())) / 100.0f) * 255.0f), 0, 255));
        a<ColorFilter, ColorFilter> aVar = this.h;
        if (aVar != null) {
            this.f3399b.setColorFilter(aVar.e());
        }
        this.f3398a.reset();
        for (int i3 = 0; i3 < this.f3402e.size(); i3++) {
            this.f3398a.addPath(this.f3402e.get(i3).e(), matrix);
        }
        canvas.drawPath(this.f3398a, this.f3399b);
        c.d("FillContent#draw");
    }

    public void a(RectF rectF, Matrix matrix) {
        this.f3398a.reset();
        for (int i2 = 0; i2 < this.f3402e.size(); i2++) {
            this.f3398a.addPath(this.f3402e.get(i2).e(), matrix);
        }
        this.f3398a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public void a(com.airbnb.lottie.c.e eVar, int i2, List<com.airbnb.lottie.c.e> list, com.airbnb.lottie.c.e eVar2) {
        e.a(eVar, i2, list, eVar2, this);
    }

    public <T> void a(T t, com.airbnb.lottie.g.c<T> cVar) {
        if (t == j.f3753a) {
            this.f3403f.a(cVar);
        } else if (t == j.f3756d) {
            this.f3404g.a(cVar);
        } else if (t != j.x) {
        } else {
            if (cVar == null) {
                this.h = null;
                return;
            }
            this.h = new p(cVar);
            this.h.a((a.C0069a) this);
            this.f3400c.a((a<?, ?>) this.h);
        }
    }
}
