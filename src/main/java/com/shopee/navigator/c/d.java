package com.shopee.navigator.c;

import android.util.SparseArray;
import java.util.HashSet;
import java.util.Set;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f30130a;

    /* renamed from: b  reason: collision with root package name */
    private SparseArray<Set<c>> f30131b = new SparseArray<>();

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f30130a == null) {
                f30130a = new d();
            }
            dVar = f30130a;
        }
        return dVar;
    }

    public static d b() {
        return f30130a;
    }

    private d() {
    }

    public void a(int i, c cVar) {
        Set set = this.f30131b.get(i);
        if (set == null) {
            set = new HashSet();
        }
        set.add(cVar);
        this.f30131b.put(i, set);
    }

    public b a(a aVar) {
        Set<c> set = this.f30131b.get(aVar.b());
        if (set == null) {
            return null;
        }
        for (c a2 : set) {
            b a3 = a2.a(aVar);
            if (a3 != null) {
                return a3;
            }
        }
        return null;
    }
}
