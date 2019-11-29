package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.c.b.q;
import com.airbnb.lottie.f;
import com.airbnb.lottie.g.c;
import com.airbnb.lottie.j;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;

public class e implements j, l, a.C0069a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f3391a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f3392b;

    /* renamed from: c  reason: collision with root package name */
    private final f f3393c;

    /* renamed from: d  reason: collision with root package name */
    private final a<?, PointF> f3394d;

    /* renamed from: e  reason: collision with root package name */
    private final a<?, PointF> f3395e;

    /* renamed from: f  reason: collision with root package name */
    private final com.airbnb.lottie.c.b.a f3396f;

    /* renamed from: g  reason: collision with root package name */
    private r f3397g;
    private boolean h;

    public e(f fVar, com.airbnb.lottie.c.c.a aVar, com.airbnb.lottie.c.b.a aVar2) {
        this.f3392b = aVar2.a();
        this.f3393c = fVar;
        this.f3394d = aVar2.c().a();
        this.f3395e = aVar2.b().a();
        this.f3396f = aVar2;
        aVar.a((a<?, ?>) this.f3394d);
        aVar.a((a<?, ?>) this.f3395e);
        this.f3394d.a((a.C0069a) this);
        this.f3395e.a((a.C0069a) this);
    }

    public void a() {
        c();
    }

    private void c() {
        this.h = false;
        this.f3393c.invalidateSelf();
    }

    public void a(List<b> list, List<b> list2) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.c() == q.a.Simultaneously) {
                    this.f3397g = rVar;
                    this.f3397g.a(this);
                }
            }
        }
    }

    public String b() {
        return this.f3392b;
    }

    public Path e() {
        if (this.h) {
            return this.f3391a;
        }
        this.f3391a.reset();
        PointF e2 = this.f3394d.e();
        float f2 = e2.x / 2.0f;
        float f3 = e2.y / 2.0f;
        float f4 = f2 * 0.55228f;
        float f5 = 0.55228f * f3;
        this.f3391a.reset();
        if (this.f3396f.d()) {
            float f6 = -f3;
            this.f3391a.moveTo(BitmapDescriptorFactory.HUE_RED, f6);
            Path path = this.f3391a;
            float f7 = BitmapDescriptorFactory.HUE_RED - f4;
            float f8 = -f2;
            float f9 = BitmapDescriptorFactory.HUE_RED - f5;
            path.cubicTo(f7, f6, f8, f9, f8, BitmapDescriptorFactory.HUE_RED);
            Path path2 = this.f3391a;
            float f10 = f5 + BitmapDescriptorFactory.HUE_RED;
            float f11 = f6;
            path2.cubicTo(f8, f10, f7, f3, BitmapDescriptorFactory.HUE_RED, f3);
            Path path3 = this.f3391a;
            float f12 = f4 + BitmapDescriptorFactory.HUE_RED;
            path3.cubicTo(f12, f3, f2, f10, f2, BitmapDescriptorFactory.HUE_RED);
            this.f3391a.cubicTo(f2, f9, f12, f11, BitmapDescriptorFactory.HUE_RED, f11);
        } else {
            float f13 = -f3;
            this.f3391a.moveTo(BitmapDescriptorFactory.HUE_RED, f13);
            Path path4 = this.f3391a;
            float f14 = f4 + BitmapDescriptorFactory.HUE_RED;
            float f15 = BitmapDescriptorFactory.HUE_RED - f5;
            path4.cubicTo(f14, f13, f2, f15, f2, BitmapDescriptorFactory.HUE_RED);
            Path path5 = this.f3391a;
            float f16 = f5 + BitmapDescriptorFactory.HUE_RED;
            path5.cubicTo(f2, f16, f14, f3, BitmapDescriptorFactory.HUE_RED, f3);
            Path path6 = this.f3391a;
            float f17 = BitmapDescriptorFactory.HUE_RED - f4;
            float f18 = -f2;
            path6.cubicTo(f17, f3, f18, f16, f18, BitmapDescriptorFactory.HUE_RED);
            float f19 = f13;
            this.f3391a.cubicTo(f18, f15, f17, f19, BitmapDescriptorFactory.HUE_RED, f19);
        }
        PointF e3 = this.f3395e.e();
        this.f3391a.offset(e3.x, e3.y);
        this.f3391a.close();
        com.airbnb.lottie.f.f.a(this.f3391a, this.f3397g);
        this.h = true;
        return this.f3391a;
    }

    public void a(com.airbnb.lottie.c.e eVar, int i, List<com.airbnb.lottie.c.e> list, com.airbnb.lottie.c.e eVar2) {
        com.airbnb.lottie.f.e.a(eVar, i, list, eVar2, this);
    }

    public <T> void a(T t, c<T> cVar) {
        if (t == j.f3759g) {
            this.f3394d.a(cVar);
        } else if (t == j.h) {
            this.f3395e.a(cVar);
        }
    }
}
