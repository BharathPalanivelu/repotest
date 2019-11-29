package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.kq;
import com.google.android.libraries.places.internal.kv;
import java.io.IOException;
import java.util.Map;

class kn<T extends kq<T>> {
    kn() {
    }

    /* access modifiers changed from: package-private */
    public boolean a(ma maVar) {
        return maVar instanceof kv.b;
    }

    /* access modifiers changed from: package-private */
    public kp<kv.c> a(Object obj) {
        return ((kv.b) obj).f12907a;
    }

    /* access modifiers changed from: package-private */
    public kp<kv.c> b(Object obj) {
        kv.b bVar = (kv.b) obj;
        if (bVar.f12907a.f12886b) {
            bVar.f12907a = (kp) bVar.f12907a.clone();
        }
        return bVar.f12907a;
    }

    /* access modifiers changed from: package-private */
    public void c(Object obj) {
        a(obj).a();
    }

    /* access modifiers changed from: package-private */
    public int a(Map.Entry<?, ?> entry) {
        kv.c cVar = (kv.c) entry.getKey();
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public void a(nt ntVar, Map.Entry<?, ?> entry) throws IOException {
        kv.c cVar = (kv.c) entry.getKey();
        throw new NoSuchMethodError();
    }

    kn(byte b2) {
        this();
    }
}
