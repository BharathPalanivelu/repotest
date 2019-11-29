package com.google.zxing;

import com.google.zxing.c.a;
import com.google.zxing.c.b;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private final n f14523a;

    public abstract a a(int i, a aVar) throws q;

    public abstract d a(n nVar);

    public abstract b b() throws q;

    protected d(n nVar) {
        this.f14523a = nVar;
    }

    public final n a() {
        return this.f14523a;
    }

    public final int c() {
        return this.f14523a.b();
    }

    public final int d() {
        return this.f14523a.c();
    }
}
