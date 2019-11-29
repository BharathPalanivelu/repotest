package com.c.a.d;

import com.c.a.g.c;
import com.c.a.i.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private final Set<c> f6144a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final List<c> f6145b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f6146c;

    public void a(c cVar) {
        this.f6144a.add(cVar);
        if (!this.f6146c) {
            cVar.a();
        } else {
            this.f6145b.add(cVar);
        }
    }

    public boolean b(c cVar) {
        boolean z = false;
        if (cVar == null) {
            return false;
        }
        boolean remove = this.f6144a.remove(cVar);
        if (this.f6145b.remove(cVar) || remove) {
            z = true;
        }
        if (z) {
            cVar.c();
            cVar.i();
        }
        return z;
    }

    public void a() {
        this.f6146c = true;
        for (T t : i.a(this.f6144a)) {
            if (t.d()) {
                t.b();
                this.f6145b.add(t);
            }
        }
    }

    public void b() {
        this.f6146c = false;
        for (T t : i.a(this.f6144a)) {
            if (!t.e() && !t.g() && !t.d()) {
                t.a();
            }
        }
        this.f6145b.clear();
    }

    public void c() {
        for (T b2 : i.a(this.f6144a)) {
            b(b2);
        }
        this.f6145b.clear();
    }

    public void d() {
        for (T t : i.a(this.f6144a)) {
            if (!t.e() && !t.g()) {
                t.b();
                if (!this.f6146c) {
                    t.a();
                } else {
                    this.f6145b.add(t);
                }
            }
        }
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f6144a.size() + ", isPaused=" + this.f6146c + "}";
    }
}
