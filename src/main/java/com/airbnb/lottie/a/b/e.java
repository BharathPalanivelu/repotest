package com.airbnb.lottie.a.b;

import com.airbnb.lottie.g.a;
import java.util.List;

public class e extends f<Integer> {
    public e(List<a<Integer>> list) {
        super(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Integer a(a<Integer> aVar, float f2) {
        if (aVar.f3734a == null || aVar.f3735b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.f3464b != null) {
            Integer num = (Integer) this.f3464b.a(aVar.f3737d, aVar.f3738e.floatValue(), aVar.f3734a, aVar.f3735b, f2, c(), f());
            if (num != null) {
                return num;
            }
        }
        return Integer.valueOf(com.airbnb.lottie.f.e.a(((Integer) aVar.f3734a).intValue(), ((Integer) aVar.f3735b).intValue(), f2));
    }
}
