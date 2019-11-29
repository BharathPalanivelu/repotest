package com.c.a.i;

import java.util.LinkedHashMap;
import java.util.Map;

public class e<T, Y> {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<T, Y> f6249a = new LinkedHashMap<>(100, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    private final int f6250b;

    /* renamed from: c  reason: collision with root package name */
    private int f6251c;

    /* renamed from: d  reason: collision with root package name */
    private int f6252d = 0;

    /* access modifiers changed from: protected */
    public int a(Y y) {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void a(T t, Y y) {
    }

    public e(int i) {
        this.f6250b = i;
        this.f6251c = i;
    }

    public synchronized int b() {
        return this.f6252d;
    }

    public synchronized Y b(T t) {
        return this.f6249a.get(t);
    }

    public synchronized Y b(T t, Y y) {
        if (a(y) >= this.f6251c) {
            a(t, y);
            return null;
        }
        Y put = this.f6249a.put(t, y);
        if (y != null) {
            this.f6252d += a(y);
        }
        if (put != null) {
            this.f6252d -= a(put);
        }
        c();
        return put;
    }

    public synchronized Y c(T t) {
        Y remove;
        remove = this.f6249a.remove(t);
        if (remove != null) {
            this.f6252d -= a(remove);
        }
        return remove;
    }

    public void a() {
        b(0);
    }

    /* access modifiers changed from: protected */
    public synchronized void b(int i) {
        while (this.f6252d > i) {
            Map.Entry next = this.f6249a.entrySet().iterator().next();
            Object value = next.getValue();
            this.f6252d -= a(value);
            Object key = next.getKey();
            this.f6249a.remove(key);
            a(key, value);
        }
    }

    private void c() {
        b(this.f6251c);
    }
}
