package com.airpay.paysdk.common.net.tcp.a;

import com.airpay.paysdk.common.net.tcp.c.d;
import java.util.concurrent.atomic.AtomicInteger;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public AtomicInteger f4017a = new AtomicInteger();

    /* renamed from: b  reason: collision with root package name */
    private d f4018b;

    public b(d dVar) {
        this.f4018b = dVar;
    }

    public boolean a() {
        return this.f4017a.get() > this.f4018b.a();
    }

    public void b() {
        this.f4017a.incrementAndGet();
    }

    public void c() {
        this.f4017a.set(0);
    }

    public void d() {
        this.f4017a.set(0);
    }

    public int e() {
        return this.f4018b.a(this.f4017a.get());
    }
}
