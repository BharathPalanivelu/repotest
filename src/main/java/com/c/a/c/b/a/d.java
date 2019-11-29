package com.c.a.c.b.a;

import com.c.a.c.b.a.m;
import com.c.a.i.i;
import java.util.Queue;

abstract class d<T extends m> {

    /* renamed from: a  reason: collision with root package name */
    private final Queue<T> f5689a = i.a(20);

    /* access modifiers changed from: protected */
    public abstract T b();

    d() {
    }

    /* access modifiers changed from: protected */
    public T c() {
        T t = (m) this.f5689a.poll();
        return t == null ? b() : t;
    }

    public void a(T t) {
        if (this.f5689a.size() < 20) {
            this.f5689a.offer(t);
        }
    }
}
