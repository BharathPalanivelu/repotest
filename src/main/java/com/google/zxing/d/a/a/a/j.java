package com.google.zxing.d.a.a.a;

import com.google.zxing.c.a;
import com.google.zxing.m;
import com.google.zxing.q;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    private final a f14538a;

    /* renamed from: b  reason: collision with root package name */
    private final s f14539b;

    public abstract String a() throws q, m;

    j(a aVar) {
        this.f14538a = aVar;
        this.f14539b = new s(aVar);
    }

    /* access modifiers changed from: protected */
    public final a b() {
        return this.f14538a;
    }

    /* access modifiers changed from: protected */
    public final s c() {
        return this.f14539b;
    }

    public static j a(a aVar) {
        if (aVar.a(1)) {
            return new g(aVar);
        }
        if (!aVar.a(2)) {
            return new k(aVar);
        }
        int a2 = s.a(aVar, 1, 4);
        if (a2 == 4) {
            return new a(aVar);
        }
        if (a2 == 5) {
            return new b(aVar);
        }
        int a3 = s.a(aVar, 1, 5);
        if (a3 == 12) {
            return new c(aVar);
        }
        if (a3 == 13) {
            return new d(aVar);
        }
        switch (s.a(aVar, 1, 7)) {
            case 56:
                return new e(aVar, "310", "11");
            case 57:
                return new e(aVar, "320", "11");
            case 58:
                return new e(aVar, "310", "13");
            case 59:
                return new e(aVar, "320", "13");
            case 60:
                return new e(aVar, "310", "15");
            case 61:
                return new e(aVar, "320", "15");
            case 62:
                return new e(aVar, "310", "17");
            case 63:
                return new e(aVar, "320", "17");
            default:
                throw new IllegalStateException("unknown decoder: " + aVar);
        }
    }
}
