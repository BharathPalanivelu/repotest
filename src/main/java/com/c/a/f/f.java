package com.c.a.f;

import com.c.a.c.l;
import java.util.ArrayList;
import java.util.List;

public class f {

    /* renamed from: a  reason: collision with root package name */
    final List<a<?>> f6176a = new ArrayList();

    public synchronized <Z> void a(Class<Z> cls, l<Z> lVar) {
        this.f6176a.add(new a(cls, lVar));
    }

    public synchronized <Z> l<Z> a(Class<Z> cls) {
        int size = this.f6176a.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.f6176a.get(i);
            if (aVar.a(cls)) {
                return aVar.f6177a;
            }
        }
        return null;
    }

    private static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        final l<T> f6177a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f6178b;

        a(Class<T> cls, l<T> lVar) {
            this.f6178b = cls;
            this.f6177a = lVar;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Class<?> cls) {
            return this.f6178b.isAssignableFrom(cls);
        }
    }
}
