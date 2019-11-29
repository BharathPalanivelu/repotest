package com.google.a;

import com.google.a.b.a.b;
import com.google.a.b.a.e;
import com.google.a.b.a.g;
import com.google.a.b.a.h;
import com.google.a.b.a.i;
import com.google.a.b.a.j;
import com.google.a.b.a.k;
import com.google.a.b.a.n;
import com.google.a.b.c;
import com.google.a.b.d;
import com.google.a.b.l;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class f {
    private static final com.google.a.c.a<?> r = com.google.a.c.a.get(Object.class);

    /* renamed from: a  reason: collision with root package name */
    final List<x> f8913a;

    /* renamed from: b  reason: collision with root package name */
    final d f8914b;

    /* renamed from: c  reason: collision with root package name */
    final e f8915c;

    /* renamed from: d  reason: collision with root package name */
    final Map<Type, h<?>> f8916d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f8917e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f8918f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f8919g;
    final boolean h;
    final boolean i;
    final boolean j;
    final boolean k;
    final String l;
    final int m;
    final int n;
    final v o;
    final List<x> p;
    final List<x> q;
    private final ThreadLocal<Map<com.google.a.c.a<?>, a<?>>> s;
    private final Map<com.google.a.c.a<?>, w<?>> t;
    private final c u;
    private final com.google.a.b.a.d v;

    public f() {
        this(d.f8856a, d.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, v.DEFAULT, (String) null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    f(d dVar, e eVar, Map<Type, h<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, v vVar, String str, int i2, int i3, List<x> list, List<x> list2, List<x> list3) {
        boolean z8 = z7;
        this.s = new ThreadLocal<>();
        this.t = new ConcurrentHashMap();
        this.f8914b = dVar;
        this.f8915c = eVar;
        this.f8916d = map;
        this.u = new c(map);
        this.f8917e = z;
        this.f8918f = z2;
        this.f8919g = z3;
        this.h = z4;
        this.i = z5;
        this.j = z6;
        this.k = z8;
        this.o = vVar;
        this.l = str;
        this.m = i2;
        this.n = i3;
        this.p = list;
        this.q = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(n.Y);
        arrayList.add(h.f8763a);
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(n.D);
        arrayList.add(n.m);
        arrayList.add(n.f8806g);
        arrayList.add(n.i);
        arrayList.add(n.k);
        w<Number> a2 = a(vVar);
        arrayList.add(n.a(Long.TYPE, Long.class, a2));
        arrayList.add(n.a(Double.TYPE, Double.class, a(z8)));
        arrayList.add(n.a(Float.TYPE, Float.class, b(z8)));
        arrayList.add(n.x);
        arrayList.add(n.o);
        arrayList.add(n.q);
        arrayList.add(n.a(AtomicLong.class, a(a2)));
        arrayList.add(n.a(AtomicLongArray.class, b(a2)));
        arrayList.add(n.s);
        arrayList.add(n.z);
        arrayList.add(n.F);
        arrayList.add(n.H);
        arrayList.add(n.a(BigDecimal.class, n.B));
        arrayList.add(n.a(BigInteger.class, n.C));
        arrayList.add(n.J);
        arrayList.add(n.L);
        arrayList.add(n.P);
        arrayList.add(n.R);
        arrayList.add(n.W);
        arrayList.add(n.N);
        arrayList.add(n.f8803d);
        arrayList.add(com.google.a.b.a.c.f8743a);
        arrayList.add(n.U);
        arrayList.add(k.f8782a);
        arrayList.add(j.f8780a);
        arrayList.add(n.S);
        arrayList.add(com.google.a.b.a.a.f8736a);
        arrayList.add(n.f8801b);
        arrayList.add(new b(this.u));
        arrayList.add(new g(this.u, z2));
        this.v = new com.google.a.b.a.d(this.u);
        arrayList.add(this.v);
        arrayList.add(n.Z);
        arrayList.add(new i(this.u, eVar, dVar, this.v));
        this.f8913a = Collections.unmodifiableList(arrayList);
    }

    private w<Number> a(boolean z) {
        if (z) {
            return n.v;
        }
        return new w<Number>() {
            /* renamed from: a */
            public Double read(com.google.a.d.a aVar) throws IOException {
                if (aVar.f() != com.google.a.d.b.NULL) {
                    return Double.valueOf(aVar.k());
                }
                aVar.j();
                return null;
            }

            /* renamed from: a */
            public void write(com.google.a.d.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.f();
                    return;
                }
                f.a(number.doubleValue());
                cVar.a(number);
            }
        };
    }

    private w<Number> b(boolean z) {
        if (z) {
            return n.u;
        }
        return new w<Number>() {
            /* renamed from: a */
            public Float read(com.google.a.d.a aVar) throws IOException {
                if (aVar.f() != com.google.a.d.b.NULL) {
                    return Float.valueOf((float) aVar.k());
                }
                aVar.j();
                return null;
            }

            /* renamed from: a */
            public void write(com.google.a.d.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.f();
                    return;
                }
                f.a((double) number.floatValue());
                cVar.a(number);
            }
        };
    }

    static void a(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static w<Number> a(v vVar) {
        if (vVar == v.DEFAULT) {
            return n.t;
        }
        return new w<Number>() {
            /* renamed from: a */
            public Number read(com.google.a.d.a aVar) throws IOException {
                if (aVar.f() != com.google.a.d.b.NULL) {
                    return Long.valueOf(aVar.l());
                }
                aVar.j();
                return null;
            }

            /* renamed from: a */
            public void write(com.google.a.d.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.f();
                } else {
                    cVar.b(number.toString());
                }
            }
        };
    }

    private static w<AtomicLong> a(final w<Number> wVar) {
        return new w<AtomicLong>() {
            /* renamed from: a */
            public void write(com.google.a.d.c cVar, AtomicLong atomicLong) throws IOException {
                wVar.write(cVar, Long.valueOf(atomicLong.get()));
            }

            /* renamed from: a */
            public AtomicLong read(com.google.a.d.a aVar) throws IOException {
                return new AtomicLong(((Number) wVar.read(aVar)).longValue());
            }
        }.nullSafe();
    }

    private static w<AtomicLongArray> b(final w<Number> wVar) {
        return new w<AtomicLongArray>() {
            /* renamed from: a */
            public void write(com.google.a.d.c cVar, AtomicLongArray atomicLongArray) throws IOException {
                cVar.b();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    wVar.write(cVar, Long.valueOf(atomicLongArray.get(i)));
                }
                cVar.c();
            }

            /* renamed from: a */
            public AtomicLongArray read(com.google.a.d.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(Long.valueOf(((Number) wVar.read(aVar)).longValue()));
                }
                aVar.b();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
            }
        }.nullSafe();
    }

    public <T> w<T> a(com.google.a.c.a<T> aVar) {
        w<T> wVar = this.t.get(aVar == null ? r : aVar);
        if (wVar != null) {
            return wVar;
        }
        Map map = this.s.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap();
            this.s.set(map);
            z = true;
        }
        a aVar2 = (a) map.get(aVar);
        if (aVar2 != null) {
            return aVar2;
        }
        try {
            a aVar3 = new a();
            map.put(aVar, aVar3);
            for (x create : this.f8913a) {
                w<T> create2 = create.create(this, aVar);
                if (create2 != null) {
                    aVar3.a(create2);
                    this.t.put(aVar, create2);
                    return create2;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.5) cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z) {
                this.s.remove();
            }
        }
    }

    public <T> w<T> a(x xVar, com.google.a.c.a<T> aVar) {
        if (!this.f8913a.contains(xVar)) {
            xVar = this.v;
        }
        boolean z = false;
        for (x next : this.f8913a) {
            if (z) {
                w<T> create = next.create(this, aVar);
                if (create != null) {
                    return create;
                }
            } else if (next == xVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public <T> w<T> a(Class<T> cls) {
        return a(com.google.a.c.a.get(cls));
    }

    public l a(Object obj) {
        if (obj == null) {
            return n.f8933a;
        }
        return a(obj, (Type) obj.getClass());
    }

    public l a(Object obj, Type type) {
        com.google.a.b.a.f fVar = new com.google.a.b.a.f();
        a(obj, type, (com.google.a.d.c) fVar);
        return fVar.a();
    }

    public String b(Object obj) {
        if (obj == null) {
            return a((l) n.f8933a);
        }
        return b(obj, obj.getClass());
    }

    public String b(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public void a(Object obj, Type type, Appendable appendable) throws m {
        try {
            a(obj, type, a(l.a(appendable)));
        } catch (IOException e2) {
            throw new m((Throwable) e2);
        }
    }

    public void a(Object obj, Type type, com.google.a.d.c cVar) throws m {
        w<?> a2 = a(com.google.a.c.a.get(type));
        boolean g2 = cVar.g();
        cVar.b(true);
        boolean h2 = cVar.h();
        cVar.c(this.h);
        boolean i2 = cVar.i();
        cVar.d(this.f8917e);
        try {
            a2.write(cVar, obj);
            cVar.b(g2);
            cVar.c(h2);
            cVar.d(i2);
        } catch (IOException e2) {
            throw new m((Throwable) e2);
        } catch (AssertionError e3) {
            throw new AssertionError("AssertionError (GSON 2.8.5): " + e3.getMessage(), e3);
        } catch (Throwable th) {
            cVar.b(g2);
            cVar.c(h2);
            cVar.d(i2);
            throw th;
        }
    }

    public String a(l lVar) {
        StringWriter stringWriter = new StringWriter();
        a(lVar, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public void a(l lVar, Appendable appendable) throws m {
        try {
            a(lVar, a(l.a(appendable)));
        } catch (IOException e2) {
            throw new m((Throwable) e2);
        }
    }

    public com.google.a.d.c a(Writer writer) throws IOException {
        if (this.f8919g) {
            writer.write(")]}'\n");
        }
        com.google.a.d.c cVar = new com.google.a.d.c(writer);
        if (this.i) {
            cVar.c("  ");
        }
        cVar.d(this.f8917e);
        return cVar;
    }

    public com.google.a.d.a a(Reader reader) {
        com.google.a.d.a aVar = new com.google.a.d.a(reader);
        aVar.a(this.j);
        return aVar;
    }

    public void a(l lVar, com.google.a.d.c cVar) throws m {
        boolean g2 = cVar.g();
        cVar.b(true);
        boolean h2 = cVar.h();
        cVar.c(this.h);
        boolean i2 = cVar.i();
        cVar.d(this.f8917e);
        try {
            l.a(lVar, cVar);
            cVar.b(g2);
            cVar.c(h2);
            cVar.d(i2);
        } catch (IOException e2) {
            throw new m((Throwable) e2);
        } catch (AssertionError e3) {
            throw new AssertionError("AssertionError (GSON 2.8.5): " + e3.getMessage(), e3);
        } catch (Throwable th) {
            cVar.b(g2);
            cVar.c(h2);
            cVar.d(i2);
            throw th;
        }
    }

    public <T> T a(String str, Class<T> cls) throws u {
        return com.google.a.b.k.a(cls).cast(a(str, (Type) cls));
    }

    public <T> T a(String str, Type type) throws u {
        if (str == null) {
            return null;
        }
        return a((Reader) new StringReader(str), type);
    }

    public <T> T a(Reader reader, Class<T> cls) throws u, m {
        com.google.a.d.a a2 = a(reader);
        T a3 = a(a2, (Type) cls);
        a((Object) a3, a2);
        return com.google.a.b.k.a(cls).cast(a3);
    }

    public <T> T a(Reader reader, Type type) throws m, u {
        com.google.a.d.a a2 = a(reader);
        T a3 = a(a2, type);
        a((Object) a3, a2);
        return a3;
    }

    private static void a(Object obj, com.google.a.d.a aVar) {
        if (obj != null) {
            try {
                if (aVar.f() != com.google.a.d.b.END_DOCUMENT) {
                    throw new m("JSON document was not fully consumed.");
                }
            } catch (com.google.a.d.d e2) {
                throw new u((Throwable) e2);
            } catch (IOException e3) {
                throw new m((Throwable) e3);
            }
        }
    }

    public <T> T a(com.google.a.d.a aVar, Type type) throws m, u {
        boolean q2 = aVar.q();
        aVar.a(true);
        try {
            aVar.f();
            T read = a(com.google.a.c.a.get(type)).read(aVar);
            aVar.a(q2);
            return read;
        } catch (EOFException e2) {
            if (1 != 0) {
                aVar.a(q2);
                return null;
            }
            throw new u((Throwable) e2);
        } catch (IllegalStateException e3) {
            throw new u((Throwable) e3);
        } catch (IOException e4) {
            throw new u((Throwable) e4);
        } catch (AssertionError e5) {
            throw new AssertionError("AssertionError (GSON 2.8.5): " + e5.getMessage(), e5);
        } catch (Throwable th) {
            aVar.a(q2);
            throw th;
        }
    }

    public <T> T a(l lVar, Class<T> cls) throws u {
        return com.google.a.b.k.a(cls).cast(a(lVar, (Type) cls));
    }

    public <T> T a(l lVar, Type type) throws u {
        if (lVar == null) {
            return null;
        }
        return a((com.google.a.d.a) new e(lVar), type);
    }

    static class a<T> extends w<T> {

        /* renamed from: a  reason: collision with root package name */
        private w<T> f8924a;

        a() {
        }

        public void a(w<T> wVar) {
            if (this.f8924a == null) {
                this.f8924a = wVar;
                return;
            }
            throw new AssertionError();
        }

        public T read(com.google.a.d.a aVar) throws IOException {
            w<T> wVar = this.f8924a;
            if (wVar != null) {
                return wVar.read(aVar);
            }
            throw new IllegalStateException();
        }

        public void write(com.google.a.d.c cVar, T t) throws IOException {
            w<T> wVar = this.f8924a;
            if (wVar != null) {
                wVar.write(cVar, t);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f8917e + ",factories:" + this.f8913a + ",instanceCreators:" + this.u + "}";
    }
}
