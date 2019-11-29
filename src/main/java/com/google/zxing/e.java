package com.google.zxing;

import com.google.zxing.c.a;
import com.google.zxing.c.b;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final d f14638a;

    /* renamed from: b  reason: collision with root package name */
    private b f14639b;

    public e(d dVar) {
        if (dVar != null) {
            this.f14638a = dVar;
            return;
        }
        throw new IllegalArgumentException("Binarizer must be non-null.");
    }

    public int a() {
        return this.f14638a.c();
    }

    public int b() {
        return this.f14638a.d();
    }

    public a a(int i, a aVar) throws q {
        return this.f14638a.a(i, aVar);
    }

    public b c() throws q {
        if (this.f14639b == null) {
            this.f14639b = this.f14638a.b();
        }
        return this.f14639b;
    }

    public boolean d() {
        return this.f14638a.a().d();
    }

    public e e() {
        return new e(this.f14638a.a(this.f14638a.a().e()));
    }

    public String toString() {
        try {
            return c().toString();
        } catch (q unused) {
            return "";
        }
    }
}
