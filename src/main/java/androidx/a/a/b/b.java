package androidx.a.a.b;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    c<K, V> f508a;

    /* renamed from: b  reason: collision with root package name */
    private c<K, V> f509b;

    /* renamed from: c  reason: collision with root package name */
    private WeakHashMap<f<K, V>, Boolean> f510c = new WeakHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private int f511d = 0;

    interface f<K, V> {
        void a_(c<K, V> cVar);
    }

    /* access modifiers changed from: protected */
    public c<K, V> a(K k) {
        c<K, V> cVar = this.f508a;
        while (cVar != null && !cVar.f512a.equals(k)) {
            cVar = cVar.f514c;
        }
        return cVar;
    }

    public V a(K k, V v) {
        c a2 = a(k);
        if (a2 != null) {
            return a2.f513b;
        }
        b(k, v);
        return null;
    }

    /* access modifiers changed from: protected */
    public c<K, V> b(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.f511d++;
        c<K, V> cVar2 = this.f509b;
        if (cVar2 == null) {
            this.f508a = cVar;
            this.f509b = this.f508a;
            return cVar;
        }
        cVar2.f514c = cVar;
        cVar.f515d = cVar2;
        this.f509b = cVar;
        return cVar;
    }

    public V b(K k) {
        c a2 = a(k);
        if (a2 == null) {
            return null;
        }
        this.f511d--;
        if (!this.f510c.isEmpty()) {
            for (f<K, V> a_ : this.f510c.keySet()) {
                a_.a_(a2);
            }
        }
        if (a2.f515d != null) {
            a2.f515d.f514c = a2.f514c;
        } else {
            this.f508a = a2.f514c;
        }
        if (a2.f514c != null) {
            a2.f514c.f515d = a2.f515d;
        } else {
            this.f509b = a2.f515d;
        }
        a2.f514c = null;
        a2.f515d = null;
        return a2.f513b;
    }

    public int a() {
        return this.f511d;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f508a, this.f509b);
        this.f510c.put(aVar, false);
        return aVar;
    }

    public Iterator<Map.Entry<K, V>> b() {
        C0011b bVar = new C0011b(this.f509b, this.f508a);
        this.f510c.put(bVar, false);
        return bVar;
    }

    public b<K, V>.d c() {
        b<K, V>.d dVar = new d();
        this.f510c.put(dVar, false);
        return dVar;
    }

    public Map.Entry<K, V> d() {
        return this.f508a;
    }

    public Map.Entry<K, V> e() {
        return this.f509b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (a() != bVar.a()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Map.Entry) it.next()).hashCode();
        }
        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static abstract class e<K, V> implements f<K, V>, Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        c<K, V> f519a;

        /* renamed from: b  reason: collision with root package name */
        c<K, V> f520b;

        /* access modifiers changed from: package-private */
        public abstract c<K, V> a(c<K, V> cVar);

        /* access modifiers changed from: package-private */
        public abstract c<K, V> b(c<K, V> cVar);

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f519a = cVar2;
            this.f520b = cVar;
        }

        public boolean hasNext() {
            return this.f520b != null;
        }

        public void a_(c<K, V> cVar) {
            if (this.f519a == cVar && cVar == this.f520b) {
                this.f520b = null;
                this.f519a = null;
            }
            c<K, V> cVar2 = this.f519a;
            if (cVar2 == cVar) {
                this.f519a = b(cVar2);
            }
            if (this.f520b == cVar) {
                this.f520b = b();
            }
        }

        private c<K, V> b() {
            c<K, V> cVar = this.f520b;
            c<K, V> cVar2 = this.f519a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return a(cVar);
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f520b;
            this.f520b = b();
            return cVar;
        }
    }

    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public c<K, V> a(c<K, V> cVar) {
            return cVar.f514c;
        }

        /* access modifiers changed from: package-private */
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f515d;
        }
    }

    /* renamed from: androidx.a.a.b.b$b  reason: collision with other inner class name */
    private static class C0011b<K, V> extends e<K, V> {
        C0011b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public c<K, V> a(c<K, V> cVar) {
            return cVar.f515d;
        }

        /* access modifiers changed from: package-private */
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f514c;
        }
    }

    private class d implements f<K, V>, Iterator<Map.Entry<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        private c<K, V> f517b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f518c = true;

        d() {
        }

        public void a_(c<K, V> cVar) {
            c<K, V> cVar2 = this.f517b;
            if (cVar == cVar2) {
                this.f517b = cVar2.f515d;
                this.f518c = this.f517b == null;
            }
        }

        public boolean hasNext() {
            if (!this.f518c) {
                c<K, V> cVar = this.f517b;
                if (cVar == null || cVar.f514c == null) {
                    return false;
                }
                return true;
            } else if (b.this.f508a != null) {
                return true;
            } else {
                return false;
            }
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (this.f518c) {
                this.f518c = false;
                this.f517b = b.this.f508a;
            } else {
                c<K, V> cVar = this.f517b;
                this.f517b = cVar != null ? cVar.f514c : null;
            }
            return this.f517b;
        }
    }

    static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f512a;

        /* renamed from: b  reason: collision with root package name */
        final V f513b;

        /* renamed from: c  reason: collision with root package name */
        c<K, V> f514c;

        /* renamed from: d  reason: collision with root package name */
        c<K, V> f515d;

        c(K k, V v) {
            this.f512a = k;
            this.f513b = v;
        }

        public K getKey() {
            return this.f512a;
        }

        public V getValue() {
            return this.f513b;
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f512a + SimpleComparison.EQUAL_TO_OPERATION + this.f513b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!this.f512a.equals(cVar.f512a) || !this.f513b.equals(cVar.f513b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f512a.hashCode() ^ this.f513b.hashCode();
        }
    }
}
