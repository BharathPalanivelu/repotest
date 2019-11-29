package com.c.a.c.c;

import androidx.core.util.Pools;
import com.c.a.c.c.n;
import com.c.a.c.j;
import com.c.a.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private static final c f5964a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final n<Object, Object> f5965b = new a();

    /* renamed from: c  reason: collision with root package name */
    private final List<b<?, ?>> f5966c;

    /* renamed from: d  reason: collision with root package name */
    private final c f5967d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<b<?, ?>> f5968e;

    /* renamed from: f  reason: collision with root package name */
    private final Pools.a<List<Throwable>> f5969f;

    public r(Pools.a<List<Throwable>> aVar) {
        this(aVar, f5964a);
    }

    r(Pools.a<List<Throwable>> aVar, c cVar) {
        this.f5966c = new ArrayList();
        this.f5968e = new HashSet();
        this.f5969f = aVar;
        this.f5967d = cVar;
    }

    /* access modifiers changed from: package-private */
    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<Model, Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    private <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<Model, Data> oVar, boolean z) {
        b bVar = new b(cls, cls2, oVar);
        List<b<?, ?>> list = this.f5966c;
        list.add(z ? list.size() : 0, bVar);
    }

    /* access modifiers changed from: package-private */
    public synchronized <Model> List<n<Model, ?>> a(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b next : this.f5966c) {
                if (!this.f5968e.contains(next)) {
                    if (next.a(cls)) {
                        this.f5968e.add(next);
                        arrayList.add(a((b<?, ?>) next));
                        this.f5968e.remove(next);
                    }
                }
            }
        } catch (Throwable th) {
            this.f5968e.clear();
            throw th;
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public synchronized List<Class<?>> b(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b next : this.f5966c) {
            if (!arrayList.contains(next.f5970a) && next.a(cls)) {
                arrayList.add(next.f5970a);
            }
        }
        return arrayList;
    }

    public synchronized <Model, Data> n<Model, Data> a(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b next : this.f5966c) {
                if (this.f5968e.contains(next)) {
                    z = true;
                } else if (next.a(cls, cls2)) {
                    this.f5968e.add(next);
                    arrayList.add(a((b<?, ?>) next));
                    this.f5968e.remove(next);
                }
            }
            if (arrayList.size() > 1) {
                return this.f5967d.a(arrayList, this.f5969f);
            } else if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            } else if (z) {
                return a();
            } else {
                throw new h.c(cls, cls2);
            }
        } catch (Throwable th) {
            this.f5968e.clear();
            throw th;
        }
    }

    private <Model, Data> n<Model, Data> a(b<?, ?> bVar) {
        return (n) com.c.a.i.h.a(bVar.f5971b.a(this));
    }

    private static <Model, Data> n<Model, Data> a() {
        return f5965b;
    }

    private static class b<Model, Data> {

        /* renamed from: a  reason: collision with root package name */
        final Class<Data> f5970a;

        /* renamed from: b  reason: collision with root package name */
        final o<Model, Data> f5971b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<Model> f5972c;

        public b(Class<Model> cls, Class<Data> cls2, o<Model, Data> oVar) {
            this.f5972c = cls;
            this.f5970a = cls2;
            this.f5971b = oVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return a(cls) && this.f5970a.isAssignableFrom(cls2);
        }

        public boolean a(Class<?> cls) {
            return this.f5972c.isAssignableFrom(cls);
        }
    }

    static class c {
        c() {
        }

        public <Model, Data> q<Model, Data> a(List<n<Model, Data>> list, Pools.a<List<Throwable>> aVar) {
            return new q<>(list, aVar);
        }
    }

    private static class a implements n<Object, Object> {
        public n.a<Object> a(Object obj, int i, int i2, j jVar) {
            return null;
        }

        public boolean a(Object obj) {
            return false;
        }

        a() {
        }
    }
}
