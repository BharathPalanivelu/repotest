package com.airbnb.lottie.a.b;

import com.airbnb.lottie.f.e;
import com.airbnb.lottie.g.a;
import java.util.List;

public class c extends f<Float> {
    public c(List<a<Float>> list) {
        super(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Float a(a<Float> aVar, float f2) {
        if (aVar.f3734a == null || aVar.f3735b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.f3464b != null) {
            Float f3 = (Float) this.f3464b.a(aVar.f3737d, aVar.f3738e.floatValue(), aVar.f3734a, aVar.f3735b, f2, c(), f());
            if (f3 != null) {
                return f3;
            }
        }
        return Float.valueOf(e.a(((Float) aVar.f3734a).floatValue(), ((Float) aVar.f3735b).floatValue(), f2));
    }
}
