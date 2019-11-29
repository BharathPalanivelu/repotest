package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.c.a.l;
import com.airbnb.lottie.c.c.a;
import com.airbnb.lottie.g.c;
import com.airbnb.lottie.g.d;
import com.airbnb.lottie.j;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class o {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f3483a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final a<PointF, PointF> f3484b;

    /* renamed from: c  reason: collision with root package name */
    private final a<?, PointF> f3485c;

    /* renamed from: d  reason: collision with root package name */
    private final a<d, d> f3486d;

    /* renamed from: e  reason: collision with root package name */
    private final a<Float, Float> f3487e;

    /* renamed from: f  reason: collision with root package name */
    private final a<Integer, Integer> f3488f;

    /* renamed from: g  reason: collision with root package name */
    private final a<?, Float> f3489g;
    private final a<?, Float> h;

    public o(l lVar) {
        this.f3484b = lVar.a().a();
        this.f3485c = lVar.b().a();
        this.f3486d = lVar.c().a();
        this.f3487e = lVar.d().a();
        this.f3488f = lVar.e().a();
        if (lVar.f() != null) {
            this.f3489g = lVar.f().a();
        } else {
            this.f3489g = null;
        }
        if (lVar.g() != null) {
            this.h = lVar.g().a();
        } else {
            this.h = null;
        }
    }

    public void a(a aVar) {
        aVar.a((a<?, ?>) this.f3484b);
        aVar.a((a<?, ?>) this.f3485c);
        aVar.a((a<?, ?>) this.f3486d);
        aVar.a((a<?, ?>) this.f3487e);
        aVar.a((a<?, ?>) this.f3488f);
        a<?, Float> aVar2 = this.f3489g;
        if (aVar2 != null) {
            aVar.a((a<?, ?>) aVar2);
        }
        a<?, Float> aVar3 = this.h;
        if (aVar3 != null) {
            aVar.a((a<?, ?>) aVar3);
        }
    }

    public void a(a.C0069a aVar) {
        this.f3484b.a(aVar);
        this.f3485c.a(aVar);
        this.f3486d.a(aVar);
        this.f3487e.a(aVar);
        this.f3488f.a(aVar);
        a<?, Float> aVar2 = this.f3489g;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
        a<?, Float> aVar3 = this.h;
        if (aVar3 != null) {
            aVar3.a(aVar);
        }
    }

    public void a(float f2) {
        this.f3484b.a(f2);
        this.f3485c.a(f2);
        this.f3486d.a(f2);
        this.f3487e.a(f2);
        this.f3488f.a(f2);
        a<?, Float> aVar = this.f3489g;
        if (aVar != null) {
            aVar.a(f2);
        }
        a<?, Float> aVar2 = this.h;
        if (aVar2 != null) {
            aVar2.a(f2);
        }
    }

    public a<?, Integer> a() {
        return this.f3488f;
    }

    public a<?, Float> b() {
        return this.f3489g;
    }

    public a<?, Float> c() {
        return this.h;
    }

    public Matrix d() {
        this.f3483a.reset();
        PointF e2 = this.f3485c.e();
        if (!(e2.x == BitmapDescriptorFactory.HUE_RED && e2.y == BitmapDescriptorFactory.HUE_RED)) {
            this.f3483a.preTranslate(e2.x, e2.y);
        }
        float floatValue = this.f3487e.e().floatValue();
        if (floatValue != BitmapDescriptorFactory.HUE_RED) {
            this.f3483a.preRotate(floatValue);
        }
        d e3 = this.f3486d.e();
        if (!(e3.a() == 1.0f && e3.b() == 1.0f)) {
            this.f3483a.preScale(e3.a(), e3.b());
        }
        PointF e4 = this.f3484b.e();
        if (!(e4.x == BitmapDescriptorFactory.HUE_RED && e4.y == BitmapDescriptorFactory.HUE_RED)) {
            this.f3483a.preTranslate(-e4.x, -e4.y);
        }
        return this.f3483a;
    }

    public Matrix b(float f2) {
        PointF e2 = this.f3485c.e();
        PointF e3 = this.f3484b.e();
        d e4 = this.f3486d.e();
        float floatValue = this.f3487e.e().floatValue();
        this.f3483a.reset();
        this.f3483a.preTranslate(e2.x * f2, e2.y * f2);
        double d2 = (double) f2;
        this.f3483a.preScale((float) Math.pow((double) e4.a(), d2), (float) Math.pow((double) e4.b(), d2));
        this.f3483a.preRotate(floatValue * f2, e3.x, e3.y);
        return this.f3483a;
    }

    public <T> boolean a(T t, c<T> cVar) {
        if (t == j.f3757e) {
            this.f3484b.a(cVar);
            return true;
        } else if (t == j.f3758f) {
            this.f3485c.a(cVar);
            return true;
        } else if (t == j.i) {
            this.f3486d.a(cVar);
            return true;
        } else if (t == j.j) {
            this.f3487e.a(cVar);
            return true;
        } else if (t == j.f3755c) {
            this.f3488f.a(cVar);
            return true;
        } else {
            if (t == j.u) {
                a<?, Float> aVar = this.f3489g;
                if (aVar != null) {
                    aVar.a((c<Float>) cVar);
                    return true;
                }
            }
            if (t != j.v) {
                return false;
            }
            a<?, Float> aVar2 = this.h;
            if (aVar2 == null) {
                return false;
            }
            aVar2.a((c<Float>) cVar);
            return true;
        }
    }
}
