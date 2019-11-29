package com.airbnb.lottie.c.a;

import android.graphics.PointF;
import com.airbnb.lottie.a.b.i;
import com.airbnb.lottie.a.b.j;
import com.airbnb.lottie.g.a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Collections;
import java.util.List;

public class e implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<PointF>> f3512a;

    public e() {
        this.f3512a = Collections.singletonList(new a(new PointF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED)));
    }

    public e(List<a<PointF>> list) {
        this.f3512a = list;
    }

    public com.airbnb.lottie.a.b.a<PointF, PointF> a() {
        if (this.f3512a.get(0).d()) {
            return new j(this.f3512a);
        }
        return new i(this.f3512a);
    }
}
