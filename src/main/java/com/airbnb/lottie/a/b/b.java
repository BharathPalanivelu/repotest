package com.airbnb.lottie.a.b;

import com.airbnb.lottie.g.a;
import java.util.List;

public class b extends f<Integer> {
    public b(List<a<Integer>> list) {
        super(list);
    }

    /* renamed from: b */
    public Integer a(a<Integer> aVar, float f2) {
        if (aVar.f3734a == null || aVar.f3735b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = ((Integer) aVar.f3734a).intValue();
        int intValue2 = ((Integer) aVar.f3735b).intValue();
        if (this.f3464b != null) {
            Integer num = (Integer) this.f3464b.a(aVar.f3737d, aVar.f3738e.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f2, c(), f());
            if (num != null) {
                return num;
            }
        }
        return Integer.valueOf(com.airbnb.lottie.f.b.a(f2, intValue, intValue2));
    }
}
