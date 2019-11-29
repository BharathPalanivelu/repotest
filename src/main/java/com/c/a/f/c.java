package com.c.a.f;

import androidx.b.a;
import com.c.a.c.b.q;
import com.c.a.i.g;
import java.util.concurrent.atomic.AtomicReference;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final a<g, q<?, ?, ?>> f6167a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<g> f6168b = new AtomicReference<>();

    public boolean a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        boolean containsKey;
        g c2 = c(cls, cls2, cls3);
        synchronized (this.f6167a) {
            containsKey = this.f6167a.containsKey(c2);
        }
        this.f6168b.set(c2);
        return containsKey;
    }

    public <Data, TResource, Transcode> q<Data, TResource, Transcode> b(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        q<Data, TResource, Transcode> qVar;
        g c2 = c(cls, cls2, cls3);
        synchronized (this.f6167a) {
            qVar = this.f6167a.get(c2);
        }
        this.f6168b.set(c2);
        return qVar;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, q<?, ?, ?> qVar) {
        synchronized (this.f6167a) {
            this.f6167a.put(new g(cls, cls2, cls3), qVar);
        }
    }

    private g c(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        g andSet = this.f6168b.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new g();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }
}
