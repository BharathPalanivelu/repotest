package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.c.b.j;
import com.airbnb.lottie.c.b.q;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.f;
import com.airbnb.lottie.g.c;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;

public class n implements j, l, a.C0069a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f3433a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f3434b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    private final String f3435c;

    /* renamed from: d  reason: collision with root package name */
    private final f f3436d;

    /* renamed from: e  reason: collision with root package name */
    private final a<?, PointF> f3437e;

    /* renamed from: f  reason: collision with root package name */
    private final a<?, PointF> f3438f;

    /* renamed from: g  reason: collision with root package name */
    private final a<?, Float> f3439g;
    private r h;
    private boolean i;

    public <T> void a(T t, c<T> cVar) {
    }

    public n(f fVar, com.airbnb.lottie.c.c.a aVar, j jVar) {
        this.f3435c = jVar.a();
        this.f3436d = fVar;
        this.f3437e = jVar.d().a();
        this.f3438f = jVar.c().a();
        this.f3439g = jVar.b().a();
        aVar.a((a<?, ?>) this.f3437e);
        aVar.a((a<?, ?>) this.f3438f);
        aVar.a((a<?, ?>) this.f3439g);
        this.f3437e.a((a.C0069a) this);
        this.f3438f.a((a.C0069a) this);
        this.f3439g.a((a.C0069a) this);
    }

    public String b() {
        return this.f3435c;
    }

    public void a() {
        c();
    }

    private void c() {
        this.i = false;
        this.f3436d.invalidateSelf();
    }

    public void a(List<b> list, List<b> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.c() == q.a.Simultaneously) {
                    this.h = rVar;
                    this.h.a(this);
                }
            }
        }
    }

    public Path e() {
        if (this.i) {
            return this.f3433a;
        }
        this.f3433a.reset();
        PointF e2 = this.f3438f.e();
        float f2 = e2.x / 2.0f;
        float f3 = e2.y / 2.0f;
        a<?, Float> aVar = this.f3439g;
        float floatValue = aVar == null ? BitmapDescriptorFactory.HUE_RED : aVar.e().floatValue();
        float min = Math.min(f2, f3);
        if (floatValue > min) {
            floatValue = min;
        }
        PointF e3 = this.f3437e.e();
        this.f3433a.moveTo(e3.x + f2, (e3.y - f3) + floatValue);
        this.f3433a.lineTo(e3.x + f2, (e3.y + f3) - floatValue);
        if (floatValue > BitmapDescriptorFactory.HUE_RED) {
            float f4 = floatValue * 2.0f;
            this.f3434b.set((e3.x + f2) - f4, (e3.y + f3) - f4, e3.x + f2, e3.y + f3);
            this.f3433a.arcTo(this.f3434b, BitmapDescriptorFactory.HUE_RED, 90.0f, false);
        }
        this.f3433a.lineTo((e3.x - f2) + floatValue, e3.y + f3);
        if (floatValue > BitmapDescriptorFactory.HUE_RED) {
            float f5 = floatValue * 2.0f;
            this.f3434b.set(e3.x - f2, (e3.y + f3) - f5, (e3.x - f2) + f5, e3.y + f3);
            this.f3433a.arcTo(this.f3434b, 90.0f, 90.0f, false);
        }
        this.f3433a.lineTo(e3.x - f2, (e3.y - f3) + floatValue);
        if (floatValue > BitmapDescriptorFactory.HUE_RED) {
            float f6 = floatValue * 2.0f;
            this.f3434b.set(e3.x - f2, e3.y - f3, (e3.x - f2) + f6, (e3.y - f3) + f6);
            this.f3433a.arcTo(this.f3434b, 180.0f, 90.0f, false);
        }
        this.f3433a.lineTo((e3.x + f2) - floatValue, e3.y - f3);
        if (floatValue > BitmapDescriptorFactory.HUE_RED) {
            float f7 = floatValue * 2.0f;
            this.f3434b.set((e3.x + f2) - f7, e3.y - f3, e3.x + f2, (e3.y - f3) + f7);
            this.f3433a.arcTo(this.f3434b, 270.0f, 90.0f, false);
        }
        this.f3433a.close();
        com.airbnb.lottie.f.f.a(this.f3433a, this.h);
        this.i = true;
        return this.f3433a;
    }

    public void a(e eVar, int i2, List<e> list, e eVar2) {
        com.airbnb.lottie.f.e.a(eVar, i2, list, eVar2, this);
    }
}
