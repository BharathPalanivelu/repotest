package com.google.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i extends l implements Iterable<l> {

    /* renamed from: a  reason: collision with root package name */
    private final List<l> f8932a;

    public i() {
        this.f8932a = new ArrayList();
    }

    public i(int i) {
        this.f8932a = new ArrayList(i);
    }

    public void a(Number number) {
        this.f8932a.add(number == null ? n.f8933a : new r(number));
    }

    public void a(String str) {
        this.f8932a.add(str == null ? n.f8933a : new r(str));
    }

    public void a(l lVar) {
        if (lVar == null) {
            lVar = n.f8933a;
        }
        this.f8932a.add(lVar);
    }

    public int a() {
        return this.f8932a.size();
    }

    public Iterator<l> iterator() {
        return this.f8932a.iterator();
    }

    public l a(int i) {
        return this.f8932a.get(i);
    }

    public Number b() {
        if (this.f8932a.size() == 1) {
            return this.f8932a.get(0).b();
        }
        throw new IllegalStateException();
    }

    public String c() {
        if (this.f8932a.size() == 1) {
            return this.f8932a.get(0).c();
        }
        throw new IllegalStateException();
    }

    public double d() {
        if (this.f8932a.size() == 1) {
            return this.f8932a.get(0).d();
        }
        throw new IllegalStateException();
    }

    public float e() {
        if (this.f8932a.size() == 1) {
            return this.f8932a.get(0).e();
        }
        throw new IllegalStateException();
    }

    public long f() {
        if (this.f8932a.size() == 1) {
            return this.f8932a.get(0).f();
        }
        throw new IllegalStateException();
    }

    public int g() {
        if (this.f8932a.size() == 1) {
            return this.f8932a.get(0).g();
        }
        throw new IllegalStateException();
    }

    public boolean h() {
        if (this.f8932a.size() == 1) {
            return this.f8932a.get(0).h();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof i) && ((i) obj).f8932a.equals(this.f8932a));
    }

    public int hashCode() {
        return this.f8932a.hashCode();
    }
}
