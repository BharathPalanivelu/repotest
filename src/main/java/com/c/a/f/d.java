package com.c.a.f;

import androidx.b.a;
import com.c.a.i.g;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<g> f6169a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final a<g, List<Class<?>>> f6170b = new a<>();

    public List<Class<?>> a(Class<?> cls, Class<?> cls2) {
        List<Class<?>> list;
        g andSet = this.f6169a.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new g(cls, cls2);
        } else {
            andSet.a(cls, cls2);
        }
        synchronized (this.f6170b) {
            list = this.f6170b.get(andSet);
        }
        this.f6169a.set(andSet);
        return list;
    }

    public void a(Class<?> cls, Class<?> cls2, List<Class<?>> list) {
        synchronized (this.f6170b) {
            this.f6170b.put(new g(cls, cls2), list);
        }
    }
}
