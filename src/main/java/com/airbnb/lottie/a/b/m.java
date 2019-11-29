package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import com.airbnb.lottie.a.b.a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Collections;

public class m extends a<PointF, PointF> {

    /* renamed from: c  reason: collision with root package name */
    private final PointF f3480c = new PointF();

    /* renamed from: d  reason: collision with root package name */
    private final a<Float, Float> f3481d;

    /* renamed from: e  reason: collision with root package name */
    private final a<Float, Float> f3482e;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f3481d = aVar;
        this.f3482e = aVar2;
        a(f());
    }

    public void a(float f2) {
        this.f3481d.a(f2);
        this.f3482e.a(f2);
        this.f3480c.set(this.f3481d.e().floatValue(), this.f3482e.e().floatValue());
        for (int i = 0; i < this.f3463a.size(); i++) {
            ((a.C0069a) this.f3463a.get(i)).a();
        }
    }

    /* renamed from: g */
    public PointF e() {
        return a((com.airbnb.lottie.g.a<PointF>) null, BitmapDescriptorFactory.HUE_RED);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public PointF a(com.airbnb.lottie.g.a<PointF> aVar, float f2) {
        return this.f3480c;
    }
}
