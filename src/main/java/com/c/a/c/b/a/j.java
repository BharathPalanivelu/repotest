package com.c.a.c.b.a;

import android.util.Log;
import com.c.a.i.h;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class j implements b {

    /* renamed from: a  reason: collision with root package name */
    private final h<a, Object> f5696a;

    /* renamed from: b  reason: collision with root package name */
    private final b f5697b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f5698c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, a<?>> f5699d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5700e;

    /* renamed from: f  reason: collision with root package name */
    private int f5701f;

    public j() {
        this.f5696a = new h<>();
        this.f5697b = new b();
        this.f5698c = new HashMap();
        this.f5699d = new HashMap();
        this.f5700e = 4194304;
    }

    public j(int i) {
        this.f5696a = new h<>();
        this.f5697b = new b();
        this.f5698c = new HashMap();
        this.f5699d = new HashMap();
        this.f5700e = i;
    }

    public synchronized <T> void a(T t, Class<T> cls) {
        a<T> b2 = b(cls);
        int a2 = b2.a(t);
        int b3 = b2.b() * a2;
        if (b(b3)) {
            a a3 = this.f5697b.a(a2, cls);
            this.f5696a.a(a3, t);
            NavigableMap<Integer, Integer> a4 = a((Class<?>) cls);
            Integer num = (Integer) a4.get(Integer.valueOf(a3.f5702a));
            Integer valueOf = Integer.valueOf(a3.f5702a);
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            a4.put(valueOf, Integer.valueOf(i));
            this.f5701f += b3;
            c();
        }
    }

    public <T> T a(int i, Class<T> cls) {
        a aVar;
        T a2;
        a<T> b2 = b(cls);
        synchronized (this) {
            Integer ceilingKey = a((Class<?>) cls).ceilingKey(Integer.valueOf(i));
            if (a(i, ceilingKey)) {
                aVar = this.f5697b.a(ceilingKey.intValue(), cls);
            } else {
                aVar = this.f5697b.a(i, cls);
            }
            a2 = a(aVar);
            if (a2 != null) {
                this.f5701f -= b2.a(a2) * b2.b();
                b(b2.a(a2), cls);
            }
        }
        if (a2 != null) {
            return a2;
        }
        if (Log.isLoggable(b2.a(), 2)) {
            Log.v(b2.a(), "Allocated " + i + " bytes");
        }
        return b2.a(i);
    }

    private <T> T a(a aVar) {
        return this.f5696a.a(aVar);
    }

    private boolean b(int i) {
        return i <= this.f5700e / 2;
    }

    private boolean a(int i, Integer num) {
        return num != null && (b() || num.intValue() <= i * 8);
    }

    private boolean b() {
        int i = this.f5701f;
        return i == 0 || this.f5700e / i >= 2;
    }

    public synchronized void a() {
        c(0);
    }

    public synchronized void a(int i) {
        if (i >= 40) {
            try {
                a();
            } catch (Throwable th) {
                throw th;
            }
        } else if (i >= 20) {
            c(this.f5700e / 2);
        }
    }

    private void c() {
        c(this.f5700e);
    }

    private void c(int i) {
        while (this.f5701f > i) {
            Object a2 = this.f5696a.a();
            h.a(a2);
            a a3 = a(a2);
            this.f5701f -= a3.a(a2) * a3.b();
            b(a3.a(a2), a2.getClass());
            if (Log.isLoggable(a3.a(), 2)) {
                Log.v(a3.a(), "evicted: " + a3.a(a2));
            }
        }
    }

    private void b(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> a2 = a(cls);
        Integer num = (Integer) a2.get(Integer.valueOf(i));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
        } else if (num.intValue() == 1) {
            a2.remove(Integer.valueOf(i));
        } else {
            a2.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    private NavigableMap<Integer, Integer> a(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f5698c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f5698c.put(cls, treeMap);
        return treeMap;
    }

    private <T> a<T> a(T t) {
        return b(t.getClass());
    }

    private <T> a<T> b(Class<T> cls) {
        a<T> aVar = this.f5699d.get(cls);
        if (aVar == null) {
            if (cls.equals(int[].class)) {
                aVar = new i();
            } else if (cls.equals(byte[].class)) {
                aVar = new g();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f5699d.put(cls, aVar);
        }
        return aVar;
    }

    private static final class b extends d<a> {
        b() {
        }

        /* access modifiers changed from: package-private */
        public a a(int i, Class<?> cls) {
            a aVar = (a) c();
            aVar.a(i, cls);
            return aVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b() {
            return new a(this);
        }
    }

    private static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        int f5702a;

        /* renamed from: b  reason: collision with root package name */
        private final b f5703b;

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f5704c;

        a(b bVar) {
            this.f5703b = bVar;
        }

        /* access modifiers changed from: package-private */
        public void a(int i, Class<?> cls) {
            this.f5702a = i;
            this.f5704c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f5702a == aVar.f5702a && this.f5704c == aVar.f5704c) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "Key{size=" + this.f5702a + "array=" + this.f5704c + '}';
        }

        public void a() {
            this.f5703b.a(this);
        }

        public int hashCode() {
            int i = this.f5702a * 31;
            Class<?> cls = this.f5704c;
            return i + (cls != null ? cls.hashCode() : 0);
        }
    }
}
