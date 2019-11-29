package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.kv;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class me<T> implements mp<T> {

    /* renamed from: a  reason: collision with root package name */
    private final ma f12962a;

    /* renamed from: b  reason: collision with root package name */
    private final nf<?, ?> f12963b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f12964c;

    /* renamed from: d  reason: collision with root package name */
    private final kn<?> f12965d;

    private me(nf<?, ?> nfVar, kn<?> knVar, ma maVar) {
        this.f12963b = nfVar;
        this.f12964c = knVar.a(maVar);
        this.f12965d = knVar;
        this.f12962a = maVar;
    }

    static <T> me<T> a(nf<?, ?> nfVar, kn<?> knVar, ma maVar) {
        return new me<>(nfVar, knVar, maVar);
    }

    public final boolean a(T t, T t2) {
        if (!this.f12963b.a((Object) t).equals(this.f12963b.a((Object) t2))) {
            return false;
        }
        if (this.f12964c) {
            return this.f12965d.a((Object) t).equals(this.f12965d.a((Object) t2));
        }
        return true;
    }

    public final int a(T t) {
        int hashCode = this.f12963b.a((Object) t).hashCode();
        return this.f12964c ? (hashCode * 53) + this.f12965d.a((Object) t).hashCode() : hashCode;
    }

    public final void b(T t, T t2) {
        mr.a(this.f12963b, t, t2);
        if (this.f12964c) {
            mr.a(this.f12965d, t, t2);
        }
    }

    public final void a(T t, nt ntVar) throws IOException {
        Iterator<Map.Entry<kv.c, Object>> b2 = this.f12965d.a((Object) t).b();
        while (b2.hasNext()) {
            Map.Entry next = b2.next();
            kq kqVar = (kq) next.getKey();
            if (kqVar.c() != ns.MESSAGE || kqVar.d() || kqVar.e()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof lh) {
                ntVar.a(kqVar.a(), (Object) ((lh) next).f12930a.getValue().b());
            } else {
                ntVar.a(kqVar.a(), next.getValue());
            }
        }
        nf<?, ?> nfVar = this.f12963b;
        nfVar.b(nfVar.a((Object) t), ntVar);
    }

    public final void c(T t) {
        this.f12963b.b((Object) t);
        this.f12965d.c(t);
    }

    public final boolean d(T t) {
        return this.f12965d.a((Object) t).c();
    }

    public final int b(T t) {
        nf<?, ?> nfVar = this.f12963b;
        int c2 = nfVar.c(nfVar.a((Object) t)) + 0;
        if (!this.f12964c) {
            return c2;
        }
        kp<kv.c> a2 = this.f12965d.a((Object) t);
        int i = 0;
        for (int i2 = 0; i2 < a2.f12885a.b(); i2++) {
            i += kp.b(a2.f12885a.b(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> b2 : a2.f12885a.c()) {
            i += kp.b(b2);
        }
        return c2 + i;
    }
}
