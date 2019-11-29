package com.airbnb.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.c;
import com.airbnb.lottie.c.c.d;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.d;
import com.airbnb.lottie.f;
import com.airbnb.lottie.j;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

public class b extends a {

    /* renamed from: e  reason: collision with root package name */
    private a<Float, Float> f3616e;

    /* renamed from: f  reason: collision with root package name */
    private final List<a> f3617f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final RectF f3618g = new RectF();
    private final RectF h = new RectF();

    public b(f fVar, d dVar, List<d> list, d dVar2) {
        super(fVar, dVar);
        int i;
        com.airbnb.lottie.c.a.b u = dVar.u();
        if (u != null) {
            this.f3616e = u.a();
            a((a<?, ?>) this.f3616e);
            this.f3616e.a((a.C0069a) this);
        } else {
            this.f3616e = null;
        }
        androidx.b.d dVar3 = new androidx.b.d(dVar2.g().size());
        int size = list.size() - 1;
        a aVar = null;
        while (true) {
            if (size < 0) {
                break;
            }
            d dVar4 = list.get(size);
            a a2 = a.a(dVar4, fVar, dVar2);
            if (a2 != null) {
                dVar3.b(a2.c().e(), a2);
                if (aVar != null) {
                    aVar.a(a2);
                    aVar = null;
                } else {
                    this.f3617f.add(0, a2);
                    int i2 = AnonymousClass1.f3619a[dVar4.l().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        aVar = a2;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < dVar3.b(); i++) {
            a aVar2 = (a) dVar3.a(dVar3.b(i));
            if (aVar2 != null) {
                a aVar3 = (a) dVar3.a(aVar2.c().m());
                if (aVar3 != null) {
                    aVar2.b(aVar3);
                }
            }
        }
    }

    /* renamed from: com.airbnb.lottie.c.c.b$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3619a = new int[d.b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.airbnb.lottie.c.c.d$b[] r0 = com.airbnb.lottie.c.c.d.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3619a = r0
                int[] r0 = f3619a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.airbnb.lottie.c.c.d$b r1 = com.airbnb.lottie.c.c.d.b.Add     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f3619a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.airbnb.lottie.c.c.d$b r1 = com.airbnb.lottie.c.c.d.b.Invert     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.c.b.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Canvas canvas, Matrix matrix, int i) {
        c.c("CompositionLayer#draw");
        canvas.save();
        this.h.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) this.f3607c.h(), (float) this.f3607c.i());
        matrix.mapRect(this.h);
        for (int size = this.f3617f.size() - 1; size >= 0; size--) {
            if (!this.h.isEmpty() ? canvas.clipRect(this.h) : true) {
                this.f3617f.get(size).a(canvas, matrix, i);
            }
        }
        canvas.restore();
        c.d("CompositionLayer#draw");
    }

    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.f3618g.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        for (int size = this.f3617f.size() - 1; size >= 0; size--) {
            this.f3617f.get(size).a(this.f3618g, this.f3605a);
            if (rectF.isEmpty()) {
                rectF.set(this.f3618g);
            } else {
                rectF.set(Math.min(rectF.left, this.f3618g.left), Math.min(rectF.top, this.f3618g.top), Math.max(rectF.right, this.f3618g.right), Math.max(rectF.bottom, this.f3618g.bottom));
            }
        }
    }

    public void a(float f2) {
        super.a(f2);
        if (this.f3616e != null) {
            f2 = ((float) ((long) (this.f3616e.e().floatValue() * 1000.0f))) / this.f3606b.r().c();
        }
        if (this.f3607c.b() != BitmapDescriptorFactory.HUE_RED) {
            f2 /= this.f3607c.b();
        }
        float c2 = f2 - this.f3607c.c();
        for (int size = this.f3617f.size() - 1; size >= 0; size--) {
            this.f3617f.get(size).a(c2);
        }
    }

    /* access modifiers changed from: protected */
    public void b(e eVar, int i, List<e> list, e eVar2) {
        for (int i2 = 0; i2 < this.f3617f.size(); i2++) {
            this.f3617f.get(i2).a(eVar, i, list, eVar2);
        }
    }

    public <T> void a(T t, com.airbnb.lottie.g.c<T> cVar) {
        super.a(t, cVar);
        if (t != j.w) {
            return;
        }
        if (cVar == null) {
            this.f3616e = null;
            return;
        }
        this.f3616e = new p(cVar);
        a((a<?, ?>) this.f3616e);
    }
}
