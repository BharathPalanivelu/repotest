package com.google.android.libraries.places.internal;

import java.io.IOException;

class nf<T, B> {
    nf() {
    }

    /* access modifiers changed from: package-private */
    public /* bridge */ /* synthetic */ void a(Object obj, T t) {
        a(obj, (ng) t);
    }

    /* access modifiers changed from: package-private */
    public /* synthetic */ T a(Object obj) {
        return e(obj);
    }

    /* access modifiers changed from: package-private */
    public void b(Object obj) {
        e(obj).f13019f = false;
    }

    /* access modifiers changed from: package-private */
    public /* synthetic */ void a(T t, nt ntVar) throws IOException {
        ((ng) t).a(ntVar);
    }

    /* access modifiers changed from: package-private */
    public /* synthetic */ void b(T t, nt ntVar) throws IOException {
        ng ngVar = (ng) t;
        if (ntVar.a() == nu.DESCENDING) {
            for (int i = ngVar.f13015b - 1; i >= 0; i--) {
                ntVar.a(ngVar.f13016c[i] >>> 3, ngVar.f13017d[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < ngVar.f13015b; i2++) {
            ntVar.a(ngVar.f13016c[i2] >>> 3, ngVar.f13017d[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public /* synthetic */ T b(T t, T t2) {
        return a((ng) t, (ng) t2);
    }

    /* access modifiers changed from: package-private */
    public /* synthetic */ int c(T t) {
        return b((ng) t);
    }

    /* access modifiers changed from: package-private */
    public /* synthetic */ int d(T t) {
        return a((ng) t);
    }

    nf(byte b2) {
        this();
    }

    static void a(Object obj, ng ngVar) {
        ((kv) obj).r = ngVar;
    }

    static ng e(Object obj) {
        return ((kv) obj).r;
    }

    static ng a(ng ngVar, ng ngVar2) {
        if (ngVar2.equals(ng.f13014a)) {
            return ngVar;
        }
        return ng.a(ngVar, ngVar2);
    }

    static int a(ng ngVar) {
        return ngVar.a();
    }

    static int b(ng ngVar) {
        int i = ngVar.f13018e;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < ngVar.f13015b; i3++) {
            i2 += kk.d(ngVar.f13016c[i3] >>> 3, (kc) ngVar.f13017d[i3]);
        }
        ngVar.f13018e = i2;
        return i2;
    }
}
