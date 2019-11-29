package com.c.a.f;

import com.c.a.c.d;
import java.util.ArrayList;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<C0109a<?>> f6163a = new ArrayList();

    public synchronized <T> d<T> a(Class<T> cls) {
        for (C0109a next : this.f6163a) {
            if (next.a(cls)) {
                return next.f6164a;
            }
        }
        return null;
    }

    public synchronized <T> void a(Class<T> cls, d<T> dVar) {
        this.f6163a.add(new C0109a(cls, dVar));
    }

    /* renamed from: com.c.a.f.a$a  reason: collision with other inner class name */
    private static final class C0109a<T> {

        /* renamed from: a  reason: collision with root package name */
        final d<T> f6164a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f6165b;

        public C0109a(Class<T> cls, d<T> dVar) {
            this.f6165b = cls;
            this.f6164a = dVar;
        }

        public boolean a(Class<?> cls) {
            return this.f6165b.isAssignableFrom(cls);
        }
    }
}
