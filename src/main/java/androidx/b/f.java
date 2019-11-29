package androidx.b;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

abstract class f<K, V> {

    /* renamed from: b  reason: collision with root package name */
    f<K, V>.b f1290b;

    /* renamed from: c  reason: collision with root package name */
    f<K, V>.c f1291c;

    /* renamed from: d  reason: collision with root package name */
    f<K, V>.e f1292d;

    /* access modifiers changed from: protected */
    public abstract int a();

    /* access modifiers changed from: protected */
    public abstract int a(Object obj);

    /* access modifiers changed from: protected */
    public abstract Object a(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract V a(int i, V v);

    /* access modifiers changed from: protected */
    public abstract void a(int i);

    /* access modifiers changed from: protected */
    public abstract void a(K k, V v);

    /* access modifiers changed from: protected */
    public abstract int b(Object obj);

    /* access modifiers changed from: protected */
    public abstract Map<K, V> b();

    /* access modifiers changed from: protected */
    public abstract void c();

    f() {
    }

    final class a<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        final int f1293a;

        /* renamed from: b  reason: collision with root package name */
        int f1294b;

        /* renamed from: c  reason: collision with root package name */
        int f1295c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1296d = false;

        a(int i) {
            this.f1293a = i;
            this.f1294b = f.this.a();
        }

        public boolean hasNext() {
            return this.f1295c < this.f1294b;
        }

        public T next() {
            if (hasNext()) {
                T a2 = f.this.a(this.f1295c, this.f1293a);
                this.f1295c++;
                this.f1296d = true;
                return a2;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f1296d) {
                this.f1295c--;
                this.f1294b--;
                this.f1296d = false;
                f.this.a(this.f1295c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        int f1300a;

        /* renamed from: b  reason: collision with root package name */
        int f1301b;

        /* renamed from: c  reason: collision with root package name */
        boolean f1302c = false;

        d() {
            this.f1300a = f.this.a() - 1;
            this.f1301b = -1;
        }

        public boolean hasNext() {
            return this.f1301b < this.f1300a;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.f1301b++;
                this.f1302c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f1302c) {
                f.this.a(this.f1301b);
                this.f1301b--;
                this.f1300a--;
                this.f1302c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public K getKey() {
            if (this.f1302c) {
                return f.this.a(this.f1301b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f1302c) {
                return f.this.a(this.f1301b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V setValue(V v) {
            if (this.f1302c) {
                return f.this.a(this.f1301b, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean equals(Object obj) {
            if (!this.f1302c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                if (!c.a(entry.getKey(), f.this.a(this.f1301b, 0)) || !c.a(entry.getValue(), f.this.a(this.f1301b, 1))) {
                    return false;
                }
                return true;
            }
        }

        public int hashCode() {
            int i;
            if (this.f1302c) {
                int i2 = 0;
                Object a2 = f.this.a(this.f1301b, 0);
                Object a3 = f.this.a(this.f1301b, 1);
                if (a2 == null) {
                    i = 0;
                } else {
                    i = a2.hashCode();
                }
                if (a3 != null) {
                    i2 = a3.hashCode();
                }
                return i ^ i2;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + SimpleComparison.EQUAL_TO_OPERATION + getValue();
        }
    }

    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int a2 = f.this.a();
            for (Map.Entry entry : collection) {
                f.this.a(entry.getKey(), entry.getValue());
            }
            return a2 != f.this.a();
        }

        public void clear() {
            f.this.c();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int a2 = f.this.a(entry.getKey());
            if (a2 < 0) {
                return false;
            }
            return c.a(f.this.a(a2, 1), entry.getValue());
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return f.this.a() == 0;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return f.this.a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public boolean equals(Object obj) {
            return f.a(this, obj);
        }

        public int hashCode() {
            int i;
            int i2;
            int i3 = 0;
            for (int a2 = f.this.a() - 1; a2 >= 0; a2--) {
                Object a3 = f.this.a(a2, 0);
                Object a4 = f.this.a(a2, 1);
                if (a3 == null) {
                    i = 0;
                } else {
                    i = a3.hashCode();
                }
                if (a4 == null) {
                    i2 = 0;
                } else {
                    i2 = a4.hashCode();
                }
                i3 += i ^ i2;
            }
            return i3;
        }
    }

    final class c implements Set<K> {
        c() {
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            f.this.c();
        }

        public boolean contains(Object obj) {
            return f.this.a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return f.a(f.this.b(), collection);
        }

        public boolean isEmpty() {
            return f.this.a() == 0;
        }

        public Iterator<K> iterator() {
            return new a(0);
        }

        public boolean remove(Object obj) {
            int a2 = f.this.a(obj);
            if (a2 < 0) {
                return false;
            }
            f.this.a(a2);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return f.b(f.this.b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return f.c(f.this.b(), collection);
        }

        public int size() {
            return f.this.a();
        }

        public Object[] toArray() {
            return f.this.b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return f.this.a(tArr, 0);
        }

        public boolean equals(Object obj) {
            return f.a(this, obj);
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            for (int a2 = f.this.a() - 1; a2 >= 0; a2--) {
                Object a3 = f.this.a(a2, 0);
                if (a3 == null) {
                    i = 0;
                } else {
                    i = a3.hashCode();
                }
                i2 += i;
            }
            return i2;
        }
    }

    final class e implements Collection<V> {
        e() {
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            f.this.c();
        }

        public boolean contains(Object obj) {
            return f.this.b(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return f.this.a() == 0;
        }

        public Iterator<V> iterator() {
            return new a(1);
        }

        public boolean remove(Object obj) {
            int b2 = f.this.b(obj);
            if (b2 < 0) {
                return false;
            }
            f.this.a(b2);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int a2 = f.this.a();
            int i = 0;
            boolean z = false;
            while (i < a2) {
                if (collection.contains(f.this.a(i, 1))) {
                    f.this.a(i);
                    i--;
                    a2--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int a2 = f.this.a();
            int i = 0;
            boolean z = false;
            while (i < a2) {
                if (!collection.contains(f.this.a(i, 1))) {
                    f.this.a(i);
                    i--;
                    a2--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return f.this.a();
        }

        public Object[] toArray() {
            return f.this.b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return f.this.a(tArr, 1);
        }
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Object[] b(int i) {
        int a2 = a();
        Object[] objArr = new Object[a2];
        for (int i2 = 0; i2 < a2; i2++) {
            objArr[i2] = a(i2, i);
        }
        return objArr;
    }

    public <T> T[] a(T[] tArr, int i) {
        int a2 = a();
        if (tArr.length < a2) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a2);
        }
        for (int i2 = 0; i2 < a2; i2++) {
            tArr[i2] = a(i2, i);
        }
        if (tArr.length > a2) {
            tArr[a2] = null;
        }
        return tArr;
    }

    public static <T> boolean a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public Set<Map.Entry<K, V>> d() {
        if (this.f1290b == null) {
            this.f1290b = new b();
        }
        return this.f1290b;
    }

    public Set<K> e() {
        if (this.f1291c == null) {
            this.f1291c = new c();
        }
        return this.f1291c;
    }

    public Collection<V> f() {
        if (this.f1292d == null) {
            this.f1292d = new e();
        }
        return this.f1292d;
    }
}
