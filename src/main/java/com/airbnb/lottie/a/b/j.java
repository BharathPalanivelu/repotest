package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import com.airbnb.lottie.g.a;
import java.util.List;

public class j extends f<PointF> {

    /* renamed from: c  reason: collision with root package name */
    private final PointF f3477c = new PointF();

    public j(List<a<PointF>> list) {
        super(list);
    }

    /* renamed from: b */
    public PointF a(a<PointF> aVar, float f2) {
        if (aVar.f3734a == null || aVar.f3735b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = (PointF) aVar.f3734a;
        PointF pointF2 = (PointF) aVar.f3735b;
        if (this.f3464b != null) {
            PointF pointF3 = (PointF) this.f3464b.a(aVar.f3737d, aVar.f3738e.floatValue(), pointF, pointF2, f2, c(), f());
            if (pointF3 != null) {
                return pointF3;
            }
        }
        this.f3477c.set(pointF.x + ((pointF2.x - pointF.x) * f2), pointF.y + (f2 * (pointF2.y - pointF.y)));
        return this.f3477c;
    }
}
