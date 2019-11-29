package com.bca.xco.widget.d.b;

import java.util.concurrent.TimeUnit;

public class j extends s {

    /* renamed from: a  reason: collision with root package name */
    private s f5222a;

    public j(s sVar) {
        if (sVar != null) {
            this.f5222a = sVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final s a() {
        return this.f5222a;
    }

    public final j a(s sVar) {
        if (sVar != null) {
            this.f5222a = sVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public s a(long j, TimeUnit timeUnit) {
        return this.f5222a.a(j, timeUnit);
    }

    public long c_() {
        return this.f5222a.c_();
    }

    public boolean d_() {
        return this.f5222a.d_();
    }

    public long e_() {
        return this.f5222a.e_();
    }

    public s a(long j) {
        return this.f5222a.a(j);
    }

    public s e() {
        return this.f5222a.e();
    }

    public s f() {
        return this.f5222a.f();
    }

    public void g() {
        this.f5222a.g();
    }
}
