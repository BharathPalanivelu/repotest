package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.g.a;
import java.util.List;

public class i extends f<PointF> {

    /* renamed from: c  reason: collision with root package name */
    private final PointF f3473c = new PointF();

    /* renamed from: d  reason: collision with root package name */
    private final float[] f3474d = new float[2];

    /* renamed from: e  reason: collision with root package name */
    private h f3475e;

    /* renamed from: f  reason: collision with root package name */
    private PathMeasure f3476f;

    public i(List<? extends a<PointF>> list) {
        super(list);
    }

    /* renamed from: b */
    public PointF a(a<PointF> aVar, float f2) {
        h hVar = (h) aVar;
        Path a2 = hVar.a();
        if (a2 == null) {
            return (PointF) aVar.f3734a;
        }
        if (this.f3464b != null) {
            PointF pointF = (PointF) this.f3464b.a(hVar.f3737d, hVar.f3738e.floatValue(), hVar.f3734a, hVar.f3735b, c(), f2, f());
            if (pointF != null) {
                return pointF;
            }
        }
        if (this.f3475e != hVar) {
            this.f3476f = new PathMeasure(a2, false);
            this.f3475e = hVar;
        }
        PathMeasure pathMeasure = this.f3476f;
        pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.f3474d, (float[]) null);
        PointF pointF2 = this.f3473c;
        float[] fArr = this.f3474d;
        pointF2.set(fArr[0], fArr[1]);
        return this.f3473c;
    }
}
