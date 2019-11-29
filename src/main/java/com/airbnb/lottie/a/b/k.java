package com.airbnb.lottie.a.b;

import com.airbnb.lottie.f.e;
import com.airbnb.lottie.g.a;
import com.airbnb.lottie.g.d;
import java.util.List;

public class k extends f<d> {
    public k(List<a<d>> list) {
        super(list);
    }

    /* renamed from: b */
    public d a(a<d> aVar, float f2) {
        if (aVar.f3734a == null || aVar.f3735b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        d dVar = (d) aVar.f3734a;
        d dVar2 = (d) aVar.f3735b;
        if (this.f3464b != null) {
            d dVar3 = (d) this.f3464b.a(aVar.f3737d, aVar.f3738e.floatValue(), dVar, dVar2, f2, c(), f());
            if (dVar3 != null) {
                return dVar3;
            }
        }
        return new d(e.a(dVar.a(), dVar2.a(), f2), e.a(dVar.b(), dVar2.b(), f2));
    }
}
