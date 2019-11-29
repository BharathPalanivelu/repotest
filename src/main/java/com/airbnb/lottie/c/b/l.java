package com.airbnb.lottie.c.b;

import android.graphics.PointF;
import com.airbnb.lottie.c;
import com.airbnb.lottie.c.a;
import com.airbnb.lottie.f.e;
import java.util.ArrayList;
import java.util.List;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private final List<a> f3574a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private PointF f3575b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3576c;

    public l(PointF pointF, boolean z, List<a> list) {
        this.f3575b = pointF;
        this.f3576c = z;
        this.f3574a.addAll(list);
    }

    public l() {
    }

    private void a(float f2, float f3) {
        if (this.f3575b == null) {
            this.f3575b = new PointF();
        }
        this.f3575b.set(f2, f3);
    }

    public PointF a() {
        return this.f3575b;
    }

    public boolean b() {
        return this.f3576c;
    }

    public List<a> c() {
        return this.f3574a;
    }

    public void a(l lVar, l lVar2, float f2) {
        if (this.f3575b == null) {
            this.f3575b = new PointF();
        }
        this.f3576c = lVar.b() || lVar2.b();
        if (lVar.c().size() != lVar2.c().size()) {
            c.b("Curves must have the same number of control points. Shape 1: " + lVar.c().size() + "\tShape 2: " + lVar2.c().size());
        }
        if (this.f3574a.isEmpty()) {
            int min = Math.min(lVar.c().size(), lVar2.c().size());
            for (int i = 0; i < min; i++) {
                this.f3574a.add(new a());
            }
        }
        PointF a2 = lVar.a();
        PointF a3 = lVar2.a();
        a(e.a(a2.x, a3.x, f2), e.a(a2.y, a3.y, f2));
        for (int size = this.f3574a.size() - 1; size >= 0; size--) {
            a aVar = lVar.c().get(size);
            a aVar2 = lVar2.c().get(size);
            PointF a4 = aVar.a();
            PointF b2 = aVar.b();
            PointF c2 = aVar.c();
            PointF a5 = aVar2.a();
            PointF b3 = aVar2.b();
            PointF c3 = aVar2.c();
            this.f3574a.get(size).a(e.a(a4.x, a5.x, f2), e.a(a4.y, a5.y, f2));
            this.f3574a.get(size).b(e.a(b2.x, b3.x, f2), e.a(b2.y, b3.y, f2));
            this.f3574a.get(size).c(e.a(c2.x, c3.x, f2), e.a(c2.y, c3.y, f2));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f3574a.size() + "closed=" + this.f3576c + '}';
    }
}
