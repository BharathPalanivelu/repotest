package com.airbnb.lottie.a.b;

import com.airbnb.lottie.c.b.c;
import com.airbnb.lottie.g.a;
import java.util.List;

public class d extends f<c> {

    /* renamed from: c  reason: collision with root package name */
    private final c f3469c;

    public d(List<a<c>> list) {
        super(list);
        int i = 0;
        c cVar = (c) list.get(0).f3734a;
        i = cVar != null ? cVar.c() : i;
        this.f3469c = new c(new float[i], new int[i]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public c a(a<c> aVar, float f2) {
        this.f3469c.a((c) aVar.f3734a, (c) aVar.f3735b, f2);
        return this.f3469c;
    }
}
