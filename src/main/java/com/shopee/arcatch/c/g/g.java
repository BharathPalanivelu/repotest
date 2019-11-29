package com.shopee.arcatch.c.g;

import androidx.core.util.Pools;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private Pools.SimplePool<f> f26891a = new Pools.SimplePool<>(55);

    public Pools.SimplePool<f> a() {
        return this.f26891a;
    }

    public f b() {
        try {
            f acquire = a().acquire();
            return acquire == null ? new f() : acquire;
        } catch (Exception unused) {
            return new f();
        }
    }

    public void a(f fVar) {
        try {
            a().release(fVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
