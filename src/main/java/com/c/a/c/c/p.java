package com.c.a.c.c;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private final r f5952a;

    /* renamed from: b  reason: collision with root package name */
    private final a f5953b;

    public p(Pools.a<List<Throwable>> aVar) {
        this(new r(aVar));
    }

    p(r rVar) {
        this.f5953b = new a();
        this.f5952a = rVar;
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<Model, Data> oVar) {
        this.f5952a.a(cls, cls2, oVar);
        this.f5953b.a();
    }

    public synchronized <A> List<n<A, ?>> a(A a2) {
        ArrayList arrayList;
        List b2 = b(b(a2));
        int size = b2.size();
        arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            n nVar = (n) b2.get(i);
            if (nVar.a(a2)) {
                arrayList.add(nVar);
            }
        }
        return arrayList;
    }

    public synchronized List<Class<?>> a(Class<?> cls) {
        return this.f5952a.b(cls);
    }

    private <A> List<n<A, ?>> b(Class<A> cls) {
        List<n<A, ?>> a2 = this.f5953b.a(cls);
        if (a2 != null) {
            return a2;
        }
        List<n<A, ?>> unmodifiableList = Collections.unmodifiableList(this.f5952a.a(cls));
        this.f5953b.a(cls, unmodifiableList);
        return unmodifiableList;
    }

    private static <A> Class<A> b(A a2) {
        return a2.getClass();
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Class<?>, C0105a<?>> f5954a = new HashMap();

        a() {
        }

        public void a() {
            this.f5954a.clear();
        }

        public <Model> void a(Class<Model> cls, List<n<Model, ?>> list) {
            if (this.f5954a.put(cls, new C0105a(list)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }

        public <Model> List<n<Model, ?>> a(Class<Model> cls) {
            C0105a aVar = this.f5954a.get(cls);
            if (aVar == null) {
                return null;
            }
            return aVar.f5955a;
        }

        /* renamed from: com.c.a.c.c.p$a$a  reason: collision with other inner class name */
        private static class C0105a<Model> {

            /* renamed from: a  reason: collision with root package name */
            final List<n<Model, ?>> f5955a;

            public C0105a(List<n<Model, ?>> list) {
                this.f5955a = list;
            }
        }
    }
}
