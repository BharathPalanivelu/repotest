package com.google.a.b.a;

import com.google.a.d.c;
import com.google.a.f;
import com.google.a.j;
import com.google.a.k;
import com.google.a.p;
import com.google.a.s;
import com.google.a.t;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.lang.reflect.Type;

public final class l<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    final f f8784a;

    /* renamed from: b  reason: collision with root package name */
    private final t<T> f8785b;

    /* renamed from: c  reason: collision with root package name */
    private final k<T> f8786c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.a.c.a<T> f8787d;

    /* renamed from: e  reason: collision with root package name */
    private final x f8788e;

    /* renamed from: f  reason: collision with root package name */
    private final l<T>.a f8789f = new a();

    /* renamed from: g  reason: collision with root package name */
    private w<T> f8790g;

    public l(t<T> tVar, k<T> kVar, f fVar, com.google.a.c.a<T> aVar, x xVar) {
        this.f8785b = tVar;
        this.f8786c = kVar;
        this.f8784a = fVar;
        this.f8787d = aVar;
        this.f8788e = xVar;
    }

    public T read(com.google.a.d.a aVar) throws IOException {
        if (this.f8786c == null) {
            return a().read(aVar);
        }
        com.google.a.l a2 = com.google.a.b.l.a(aVar);
        if (a2.l()) {
            return null;
        }
        return this.f8786c.deserialize(a2, this.f8787d.getType(), this.f8789f);
    }

    public void write(c cVar, T t) throws IOException {
        t<T> tVar = this.f8785b;
        if (tVar == null) {
            a().write(cVar, t);
        } else if (t == null) {
            cVar.f();
        } else {
            com.google.a.b.l.a(tVar.serialize(t, this.f8787d.getType(), this.f8789f), cVar);
        }
    }

    private w<T> a() {
        w<T> wVar = this.f8790g;
        if (wVar != null) {
            return wVar;
        }
        w<T> a2 = this.f8784a.a(this.f8788e, this.f8787d);
        this.f8790g = a2;
        return a2;
    }

    public static x a(com.google.a.c.a<?> aVar, Object obj) {
        return new b(obj, aVar, aVar.getType() == aVar.getRawType(), (Class<?>) null);
    }

    public static x a(Class<?> cls, Object obj) {
        return new b(obj, (com.google.a.c.a<?>) null, false, cls);
    }

    private static final class b implements x {

        /* renamed from: a  reason: collision with root package name */
        private final com.google.a.c.a<?> f8792a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f8793b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<?> f8794c;

        /* renamed from: d  reason: collision with root package name */
        private final t<?> f8795d;

        /* renamed from: e  reason: collision with root package name */
        private final k<?> f8796e;

        b(Object obj, com.google.a.c.a<?> aVar, boolean z, Class<?> cls) {
            k<?> kVar = null;
            this.f8795d = obj instanceof t ? (t) obj : null;
            this.f8796e = obj instanceof k ? (k) obj : kVar;
            com.google.a.b.a.a((this.f8795d == null && this.f8796e == null) ? false : true);
            this.f8792a = aVar;
            this.f8793b = z;
            this.f8794c = cls;
        }

        public <T> w<T> create(f fVar, com.google.a.c.a<T> aVar) {
            boolean z;
            com.google.a.c.a<?> aVar2 = this.f8792a;
            if (aVar2 != null) {
                z = aVar2.equals(aVar) || (this.f8793b && this.f8792a.getType() == aVar.getRawType());
            } else {
                z = this.f8794c.isAssignableFrom(aVar.getRawType());
            }
            if (z) {
                return new l(this.f8795d, this.f8796e, fVar, aVar, this);
            }
            return null;
        }
    }

    private final class a implements j, s {
        private a() {
        }

        public com.google.a.l a(Object obj) {
            return l.this.f8784a.a(obj);
        }

        public com.google.a.l a(Object obj, Type type) {
            return l.this.f8784a.a(obj, type);
        }

        public <R> R a(com.google.a.l lVar, Type type) throws p {
            return l.this.f8784a.a(lVar, type);
        }
    }
}
