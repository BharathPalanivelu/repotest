package com.c.a.i.a;

import android.util.Log;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final d<Object> f6235a = new d<Object>() {
        public void a(Object obj) {
        }
    };

    /* renamed from: com.c.a.i.a.a$a  reason: collision with other inner class name */
    public interface C0112a<T> {
        T b();
    }

    public interface c {
        b f_();
    }

    public interface d<T> {
        void a(T t);
    }

    public static <T extends c> Pools.a<T> a(int i, C0112a<T> aVar) {
        return a(new Pools.SimplePool(i), aVar);
    }

    public static <T extends c> Pools.a<T> b(int i, C0112a<T> aVar) {
        return a(new Pools.b(i), aVar);
    }

    public static <T> Pools.a<List<T>> a() {
        return a(20);
    }

    public static <T> Pools.a<List<T>> a(int i) {
        return a(new Pools.b(i), new C0112a<List<T>>() {
            /* renamed from: a */
            public List<T> b() {
                return new ArrayList();
            }
        }, new d<List<T>>() {
            public void a(List<T> list) {
                list.clear();
            }
        });
    }

    private static <T extends c> Pools.a<T> a(Pools.a<T> aVar, C0112a<T> aVar2) {
        return a(aVar, aVar2, b());
    }

    private static <T> Pools.a<T> a(Pools.a<T> aVar, C0112a<T> aVar2, d<T> dVar) {
        return new b(aVar, aVar2, dVar);
    }

    private static <T> d<T> b() {
        return f6235a;
    }

    private static final class b<T> implements Pools.a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final C0112a<T> f6236a;

        /* renamed from: b  reason: collision with root package name */
        private final d<T> f6237b;

        /* renamed from: c  reason: collision with root package name */
        private final Pools.a<T> f6238c;

        b(Pools.a<T> aVar, C0112a<T> aVar2, d<T> dVar) {
            this.f6238c = aVar;
            this.f6236a = aVar2;
            this.f6237b = dVar;
        }

        public T acquire() {
            T acquire = this.f6238c.acquire();
            if (acquire == null) {
                acquire = this.f6236a.b();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + acquire.getClass());
                }
            }
            if (acquire instanceof c) {
                ((c) acquire).f_().a(false);
            }
            return acquire;
        }

        public boolean release(T t) {
            if (t instanceof c) {
                ((c) t).f_().a(true);
            }
            this.f6237b.a(t);
            return this.f6238c.release(t);
        }
    }
}
