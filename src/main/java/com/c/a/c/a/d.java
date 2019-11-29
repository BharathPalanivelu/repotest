package com.c.a.c.a;

import com.c.a.c.a.c;
import com.c.a.i.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class d {

    /* renamed from: b  reason: collision with root package name */
    private static final c.a<?> f5655b = new c.a<Object>() {
        public c<Object> a(Object obj) {
            return new a(obj);
        }

        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, c.a<?>> f5656a = new HashMap();

    public synchronized void a(c.a<?> aVar) {
        this.f5656a.put(aVar.a(), aVar);
    }

    public synchronized <T> c<T> a(T t) {
        c.a<?> aVar;
        h.a(t);
        aVar = this.f5656a.get(t.getClass());
        if (aVar == null) {
            Iterator<c.a<?>> it = this.f5656a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c.a<?> next = it.next();
                if (next.a().isAssignableFrom(t.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f5655b;
        }
        return aVar.a(t);
    }

    private static class a implements c<Object> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f5657a;

        public void b() {
        }

        public a(Object obj) {
            this.f5657a = obj;
        }

        public Object a() {
            return this.f5657a;
        }
    }
}
