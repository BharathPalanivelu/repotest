package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.c.a.l;
import com.airbnb.lottie.c.b.k;
import com.airbnb.lottie.f;
import com.airbnb.lottie.f.e;
import com.airbnb.lottie.g.c;
import com.airbnb.lottie.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class o implements d, i, j, l, a.C0069a {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f3440a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Path f3441b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final f f3442c;

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.c.c.a f3443d;

    /* renamed from: e  reason: collision with root package name */
    private final String f3444e;

    /* renamed from: f  reason: collision with root package name */
    private final a<Float, Float> f3445f;

    /* renamed from: g  reason: collision with root package name */
    private final a<Float, Float> f3446g;
    private final com.airbnb.lottie.a.b.o h;
    private c i;

    public o(f fVar, com.airbnb.lottie.c.c.a aVar, k kVar) {
        this.f3442c = fVar;
        this.f3443d = aVar;
        this.f3444e = kVar.a();
        this.f3445f = kVar.b().a();
        aVar.a((a<?, ?>) this.f3445f);
        this.f3445f.a((a.C0069a) this);
        this.f3446g = kVar.c().a();
        aVar.a((a<?, ?>) this.f3446g);
        this.f3446g.a((a.C0069a) this);
        this.h = kVar.d().h();
        this.h.a(aVar);
        this.h.a((a.C0069a) this);
    }

    public void a(ListIterator<b> listIterator) {
        if (this.i == null) {
            while (listIterator.hasPrevious()) {
                if (listIterator.previous() == this) {
                    break;
                }
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.i = new c(this.f3442c, this.f3443d, "Repeater", arrayList, (l) null);
        }
    }

    public String b() {
        return this.f3444e;
    }

    public void a(List<b> list, List<b> list2) {
        this.i.a(list, list2);
    }

    public Path e() {
        Path e2 = this.i.e();
        this.f3441b.reset();
        float floatValue = this.f3445f.e().floatValue();
        float floatValue2 = this.f3446g.e().floatValue();
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.f3440a.set(this.h.b(((float) i2) + floatValue2));
            this.f3441b.addPath(e2, this.f3440a);
        }
        return this.f3441b;
    }

    public void a(Canvas canvas, Matrix matrix, int i2) {
        float floatValue = this.f3445f.e().floatValue();
        float floatValue2 = this.f3446g.e().floatValue();
        float floatValue3 = this.h.b().e().floatValue() / 100.0f;
        float floatValue4 = this.h.c().e().floatValue() / 100.0f;
        for (int i3 = ((int) floatValue) - 1; i3 >= 0; i3--) {
            this.f3440a.set(matrix);
            float f2 = (float) i3;
            this.f3440a.preConcat(this.h.b(f2 + floatValue2));
            this.i.a(canvas, this.f3440a, (int) (((float) i2) * e.a(floatValue3, floatValue4, f2 / floatValue)));
        }
    }

    public void a(RectF rectF, Matrix matrix) {
        this.i.a(rectF, matrix);
    }

    public void a() {
        this.f3442c.invalidateSelf();
    }

    public void a(com.airbnb.lottie.c.e eVar, int i2, List<com.airbnb.lottie.c.e> list, com.airbnb.lottie.c.e eVar2) {
        e.a(eVar, i2, list, eVar2, this);
    }

    public <T> void a(T t, c<T> cVar) {
        if (!this.h.a(t, cVar)) {
            if (t == j.m) {
                this.f3445f.a(cVar);
            } else if (t == j.n) {
                this.f3446g.a(cVar);
            }
        }
    }
}
