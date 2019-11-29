package com.c.a.c.d.f;

import java.util.ArrayList;
import java.util.List;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?, ?>> f6102a = new ArrayList();

    public synchronized <Z, R> void a(Class<Z> cls, Class<R> cls2, d<Z, R> dVar) {
        this.f6102a.add(new a(cls, cls2, dVar));
    }

    public synchronized <Z, R> d<Z, R> a(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return f.a();
        }
        for (a next : this.f6102a) {
            if (next.a(cls, cls2)) {
                return next.f6103a;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a<?, ?> a2 : this.f6102a) {
            if (a2.a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    private static final class a<Z, R> {

        /* renamed from: a  reason: collision with root package name */
        final d<Z, R> f6103a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<Z> f6104b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<R> f6105c;

        a(Class<Z> cls, Class<R> cls2, d<Z, R> dVar) {
            this.f6104b = cls;
            this.f6105c = cls2;
            this.f6103a = dVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f6104b.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f6105c);
        }
    }
}
