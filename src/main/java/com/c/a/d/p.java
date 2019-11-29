package com.c.a.d;

import com.c.a.g.a.e;
import com.c.a.i.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class p implements i {

    /* renamed from: a  reason: collision with root package name */
    private final Set<e<?>> f6154a = Collections.newSetFromMap(new WeakHashMap());

    public void a(e<?> eVar) {
        this.f6154a.add(eVar);
    }

    public void b(e<?> eVar) {
        this.f6154a.remove(eVar);
    }

    public void c() {
        for (T c2 : i.a(this.f6154a)) {
            c2.c();
        }
    }

    public void d() {
        for (T d2 : i.a(this.f6154a)) {
            d2.d();
        }
    }

    public void e() {
        for (T e2 : i.a(this.f6154a)) {
            e2.e();
        }
    }

    public List<e<?>> a() {
        return new ArrayList(this.f6154a);
    }

    public void b() {
        this.f6154a.clear();
    }
}
