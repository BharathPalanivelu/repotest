package com.google.a.b;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class h<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f8871a = (!h.class.desiredAssertionStatus());

    /* renamed from: b  reason: collision with root package name */
    private static final Comparator<Comparable> f8872b = new Comparator<Comparable>() {
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    Comparator<? super K> comparator;
    private h<K, V>.a entrySet;
    final d<K, V> header;
    private h<K, V>.b keySet;
    int modCount;
    d<K, V> root;
    int size;

    public h() {
        this(f8872b);
    }

    public h(Comparator<? super K> comparator2) {
        this.size = 0;
        this.modCount = 0;
        this.header = new d<>();
        this.comparator = comparator2 == null ? f8872b : comparator2;
    }

    public int size() {
        return this.size;
    }

    public V get(Object obj) {
        d a2 = a(obj);
        if (a2 != null) {
            return a2.f8887g;
        }
        return null;
    }

    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    public V put(K k, V v) {
        if (k != null) {
            d a2 = a(k, true);
            V v2 = a2.f8887g;
            a2.f8887g = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        d<K, V> dVar = this.header;
        dVar.f8885e = dVar;
        dVar.f8884d = dVar;
    }

    public V remove(Object obj) {
        d b2 = b(obj);
        if (b2 != null) {
            return b2.f8887g;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public d<K, V> a(K k, boolean z) {
        int i;
        d<K, V> dVar;
        d<K, V> dVar2;
        Comparator<? super K> comparator2 = this.comparator;
        d<K, V> dVar3 = this.root;
        if (dVar3 != null) {
            Comparable comparable = comparator2 == f8872b ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    i = comparable.compareTo(dVar3.f8886f);
                } else {
                    i = comparator2.compare(k, dVar3.f8886f);
                }
                if (i == 0) {
                    return dVar3;
                }
                if (i < 0) {
                    dVar2 = dVar3.f8882b;
                } else {
                    dVar2 = dVar3.f8883c;
                }
                if (dVar2 == null) {
                    break;
                }
                dVar3 = dVar2;
            }
        } else {
            i = 0;
        }
        if (!z) {
            return null;
        }
        d<K, V> dVar4 = this.header;
        if (dVar3 != null) {
            dVar = new d<>(dVar3, k, dVar4, dVar4.f8885e);
            if (i < 0) {
                dVar3.f8882b = dVar;
            } else {
                dVar3.f8883c = dVar;
            }
            b(dVar3, true);
        } else if (comparator2 != f8872b || (k instanceof Comparable)) {
            dVar = new d<>(dVar3, k, dVar4, dVar4.f8885e);
            this.root = dVar;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        this.size++;
        this.modCount++;
        return dVar;
    }

    /* access modifiers changed from: package-private */
    public d<K, V> a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return a(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public d<K, V> a(Map.Entry<?, ?> entry) {
        d<K, V> a2 = a((Object) entry.getKey());
        if (a2 != null && a((Object) a2.f8887g, (Object) entry.getValue())) {
            return a2;
        }
        return null;
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* access modifiers changed from: package-private */
    public void a(d<K, V> dVar, boolean z) {
        int i;
        if (z) {
            dVar.f8885e.f8884d = dVar.f8884d;
            dVar.f8884d.f8885e = dVar.f8885e;
        }
        d<K, V> dVar2 = dVar.f8882b;
        d<K, V> dVar3 = dVar.f8883c;
        d<K, V> dVar4 = dVar.f8881a;
        int i2 = 0;
        if (dVar2 == null || dVar3 == null) {
            if (dVar2 != null) {
                a(dVar, dVar2);
                dVar.f8882b = null;
            } else if (dVar3 != null) {
                a(dVar, dVar3);
                dVar.f8883c = null;
            } else {
                a(dVar, (d<K, V>) null);
            }
            b(dVar4, false);
            this.size--;
            this.modCount++;
            return;
        }
        d<K, V> b2 = dVar2.h > dVar3.h ? dVar2.b() : dVar3.a();
        a(b2, false);
        d<K, V> dVar5 = dVar.f8882b;
        if (dVar5 != null) {
            i = dVar5.h;
            b2.f8882b = dVar5;
            dVar5.f8881a = b2;
            dVar.f8882b = null;
        } else {
            i = 0;
        }
        d<K, V> dVar6 = dVar.f8883c;
        if (dVar6 != null) {
            i2 = dVar6.h;
            b2.f8883c = dVar6;
            dVar6.f8881a = b2;
            dVar.f8883c = null;
        }
        b2.h = Math.max(i, i2) + 1;
        a(dVar, b2);
    }

    /* access modifiers changed from: package-private */
    public d<K, V> b(Object obj) {
        d<K, V> a2 = a(obj);
        if (a2 != null) {
            a(a2, true);
        }
        return a2;
    }

    private void a(d<K, V> dVar, d<K, V> dVar2) {
        d<K, V> dVar3 = dVar.f8881a;
        dVar.f8881a = null;
        if (dVar2 != null) {
            dVar2.f8881a = dVar3;
        }
        if (dVar3 == null) {
            this.root = dVar2;
        } else if (dVar3.f8882b == dVar) {
            dVar3.f8882b = dVar2;
        } else if (f8871a || dVar3.f8883c == dVar) {
            dVar3.f8883c = dVar2;
        } else {
            throw new AssertionError();
        }
    }

    private void b(d<K, V> dVar, boolean z) {
        while (dVar != null) {
            d<K, V> dVar2 = dVar.f8882b;
            d<K, V> dVar3 = dVar.f8883c;
            int i = 0;
            int i2 = dVar2 != null ? dVar2.h : 0;
            int i3 = dVar3 != null ? dVar3.h : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                d<K, V> dVar4 = dVar3.f8882b;
                d<K, V> dVar5 = dVar3.f8883c;
                int i5 = dVar5 != null ? dVar5.h : 0;
                if (dVar4 != null) {
                    i = dVar4.h;
                }
                int i6 = i - i5;
                if (i6 == -1 || (i6 == 0 && !z)) {
                    a(dVar);
                } else if (f8871a || i6 == 1) {
                    b(dVar3);
                    a(dVar);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                d<K, V> dVar6 = dVar2.f8882b;
                d<K, V> dVar7 = dVar2.f8883c;
                int i7 = dVar7 != null ? dVar7.h : 0;
                if (dVar6 != null) {
                    i = dVar6.h;
                }
                int i8 = i - i7;
                if (i8 == 1 || (i8 == 0 && !z)) {
                    b(dVar);
                } else if (f8871a || i8 == -1) {
                    a(dVar2);
                    b(dVar);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                dVar.h = i2 + 1;
                if (z) {
                    return;
                }
            } else if (f8871a || i4 == -1 || i4 == 1) {
                dVar.h = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            } else {
                throw new AssertionError();
            }
            dVar = dVar.f8881a;
        }
    }

    private void a(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f8882b;
        d<K, V> dVar3 = dVar.f8883c;
        d<K, V> dVar4 = dVar3.f8882b;
        d<K, V> dVar5 = dVar3.f8883c;
        dVar.f8883c = dVar4;
        if (dVar4 != null) {
            dVar4.f8881a = dVar;
        }
        a(dVar, dVar3);
        dVar3.f8882b = dVar;
        dVar.f8881a = dVar3;
        int i = 0;
        dVar.h = Math.max(dVar2 != null ? dVar2.h : 0, dVar4 != null ? dVar4.h : 0) + 1;
        int i2 = dVar.h;
        if (dVar5 != null) {
            i = dVar5.h;
        }
        dVar3.h = Math.max(i2, i) + 1;
    }

    private void b(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f8882b;
        d<K, V> dVar3 = dVar.f8883c;
        d<K, V> dVar4 = dVar2.f8882b;
        d<K, V> dVar5 = dVar2.f8883c;
        dVar.f8882b = dVar5;
        if (dVar5 != null) {
            dVar5.f8881a = dVar;
        }
        a(dVar, dVar2);
        dVar2.f8883c = dVar;
        dVar.f8881a = dVar2;
        int i = 0;
        dVar.h = Math.max(dVar3 != null ? dVar3.h : 0, dVar5 != null ? dVar5.h : 0) + 1;
        int i2 = dVar.h;
        if (dVar4 != null) {
            i = dVar4.h;
        }
        dVar2.h = Math.max(i2, i) + 1;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.a aVar = this.entrySet;
        if (aVar != null) {
            return aVar;
        }
        h<K, V>.a aVar2 = new a();
        this.entrySet = aVar2;
        return aVar2;
    }

    public Set<K> keySet() {
        h<K, V>.b bVar = this.keySet;
        if (bVar != null) {
            return bVar;
        }
        h<K, V>.b bVar2 = new b();
        this.keySet = bVar2;
        return bVar2;
    }

    static final class d<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        d<K, V> f8881a;

        /* renamed from: b  reason: collision with root package name */
        d<K, V> f8882b;

        /* renamed from: c  reason: collision with root package name */
        d<K, V> f8883c;

        /* renamed from: d  reason: collision with root package name */
        d<K, V> f8884d;

        /* renamed from: e  reason: collision with root package name */
        d<K, V> f8885e;

        /* renamed from: f  reason: collision with root package name */
        final K f8886f;

        /* renamed from: g  reason: collision with root package name */
        V f8887g;
        int h;

        d() {
            this.f8886f = null;
            this.f8885e = this;
            this.f8884d = this;
        }

        d(d<K, V> dVar, K k, d<K, V> dVar2, d<K, V> dVar3) {
            this.f8881a = dVar;
            this.f8886f = k;
            this.h = 1;
            this.f8884d = dVar2;
            this.f8885e = dVar3;
            dVar3.f8884d = this;
            dVar2.f8885e = this;
        }

        public K getKey() {
            return this.f8886f;
        }

        public V getValue() {
            return this.f8887g;
        }

        public V setValue(V v) {
            V v2 = this.f8887g;
            this.f8887g = v;
            return v2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0031 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 == 0) goto L_0x0032
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                K r0 = r3.f8886f
                if (r0 != 0) goto L_0x0012
                java.lang.Object r0 = r4.getKey()
                if (r0 != 0) goto L_0x0032
                goto L_0x001c
            L_0x0012:
                java.lang.Object r2 = r4.getKey()
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x0032
            L_0x001c:
                V r0 = r3.f8887g
                if (r0 != 0) goto L_0x0027
                java.lang.Object r4 = r4.getValue()
                if (r4 != 0) goto L_0x0032
                goto L_0x0031
            L_0x0027:
                java.lang.Object r4 = r4.getValue()
                boolean r4 = r0.equals(r4)
                if (r4 == 0) goto L_0x0032
            L_0x0031:
                r1 = 1
            L_0x0032:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.h.d.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            K k = this.f8886f;
            int i = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f8887g;
            if (v != null) {
                i = v.hashCode();
            }
            return hashCode ^ i;
        }

        public String toString() {
            return this.f8886f + SimpleComparison.EQUAL_TO_OPERATION + this.f8887g;
        }

        public d<K, V> a() {
            d<K, V> dVar = this;
            for (d<K, V> dVar2 = this.f8882b; dVar2 != null; dVar2 = dVar2.f8882b) {
                dVar = dVar2;
            }
            return dVar;
        }

        public d<K, V> b() {
            d<K, V> dVar = this;
            for (d<K, V> dVar2 = this.f8883c; dVar2 != null; dVar2 = dVar2.f8883c) {
                dVar = dVar2;
            }
            return dVar;
        }
    }

    private abstract class c<T> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        d<K, V> f8877b = h.this.header.f8884d;

        /* renamed from: c  reason: collision with root package name */
        d<K, V> f8878c = null;

        /* renamed from: d  reason: collision with root package name */
        int f8879d = h.this.modCount;

        c() {
        }

        public final boolean hasNext() {
            return this.f8877b != h.this.header;
        }

        /* access modifiers changed from: package-private */
        public final d<K, V> b() {
            d<K, V> dVar = this.f8877b;
            if (dVar == h.this.header) {
                throw new NoSuchElementException();
            } else if (h.this.modCount == this.f8879d) {
                this.f8877b = dVar.f8884d;
                this.f8878c = dVar;
                return dVar;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final void remove() {
            d<K, V> dVar = this.f8878c;
            if (dVar != null) {
                h.this.a(dVar, true);
                this.f8878c = null;
                this.f8879d = h.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    class a extends AbstractSet<Map.Entry<K, V>> {
        a() {
        }

        public int size() {
            return h.this.size;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new h<K, V>.c<Map.Entry<K, V>>() {
                {
                    h hVar = h.this;
                }

                /* renamed from: a */
                public Map.Entry<K, V> next() {
                    return b();
                }
            };
        }

        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && h.this.a((Map.Entry<?, ?>) (Map.Entry) obj) != null;
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            d a2 = h.this.a((Map.Entry<?, ?>) (Map.Entry) obj);
            if (a2 == null) {
                return false;
            }
            h.this.a(a2, true);
            return true;
        }

        public void clear() {
            h.this.clear();
        }
    }

    final class b extends AbstractSet<K> {
        b() {
        }

        public int size() {
            return h.this.size;
        }

        public Iterator<K> iterator() {
            return new h<K, V>.c<K>() {
                {
                    h hVar = h.this;
                }

                public K next() {
                    return b().f8886f;
                }
            };
        }

        public boolean contains(Object obj) {
            return h.this.containsKey(obj);
        }

        public boolean remove(Object obj) {
            return h.this.b(obj) != null;
        }

        public void clear() {
            h.this.clear();
        }
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }
}
