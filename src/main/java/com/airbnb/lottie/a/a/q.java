package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.c.b.p;
import com.airbnb.lottie.c.c.a;
import com.airbnb.lottie.f;
import com.airbnb.lottie.g.c;
import com.airbnb.lottie.j;

public class q extends a {

    /* renamed from: b  reason: collision with root package name */
    private final a f3453b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3454c;

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.a.b.a<Integer, Integer> f3455d;

    /* renamed from: e  reason: collision with root package name */
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> f3456e;

    public q(f fVar, a aVar, p pVar) {
        super(fVar, aVar, pVar.g().toPaintCap(), pVar.h().toPaintJoin(), pVar.i(), pVar.c(), pVar.d(), pVar.e(), pVar.f());
        this.f3453b = aVar;
        this.f3454c = pVar.a();
        this.f3455d = pVar.b().a();
        this.f3455d.a((a.C0069a) this);
        aVar.a((com.airbnb.lottie.a.b.a<?, ?>) this.f3455d);
    }

    public void a(Canvas canvas, Matrix matrix, int i) {
        this.f3375a.setColor(this.f3455d.e().intValue());
        if (this.f3456e != null) {
            this.f3375a.setColorFilter(this.f3456e.e());
        }
        super.a(canvas, matrix, i);
    }

    public String b() {
        return this.f3454c;
    }

    public <T> void a(T t, c<T> cVar) {
        super.a(t, cVar);
        if (t == j.f3754b) {
            this.f3455d.a(cVar);
        } else if (t != j.x) {
        } else {
            if (cVar == null) {
                this.f3456e = null;
                return;
            }
            this.f3456e = new com.airbnb.lottie.a.b.p(cVar);
            this.f3456e.a((a.C0069a) this);
            this.f3453b.a((com.airbnb.lottie.a.b.a<?, ?>) this.f3455d);
        }
    }
}
