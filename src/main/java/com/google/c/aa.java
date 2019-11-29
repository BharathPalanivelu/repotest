package com.google.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class aa<K, V> implements ai {

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f13603b;

    /* renamed from: c  reason: collision with root package name */
    private volatile c f13604c;

    /* renamed from: d  reason: collision with root package name */
    private b<K, V> f13605d;

    /* renamed from: e  reason: collision with root package name */
    private List<ac> f13606e;

    /* renamed from: f  reason: collision with root package name */
    private final a<K, V> f13607f;

    private interface a<K, V> {
        ac a();

        ac a(K k, V v);

        void a(ac acVar, Map<K, V> map);
    }

    private enum c {
        MAP,
        LIST,
        BOTH
    }

    private ac a(K k, V v) {
        return this.f13607f.a(k, v);
    }

    private void a(ac acVar, Map<K, V> map) {
        this.f13607f.a(acVar, map);
    }

    private List<ac> a(b<K, V> bVar) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : bVar.entrySet()) {
            arrayList.add(a(next.getKey(), next.getValue()));
        }
        return arrayList;
    }

    private b<K, V> a(List<ac> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (ac a2 : list) {
            a(a2, linkedHashMap);
        }
        return new b<>(this, linkedHashMap);
    }

    public Map<K, V> a() {
        if (this.f13604c == c.LIST) {
            synchronized (this) {
                if (this.f13604c == c.LIST) {
                    this.f13605d = a(this.f13606e);
                    this.f13604c = c.BOTH;
                }
            }
        }
        return Collections.unmodifiableMap(this.f13605d);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof aa)) {
            return false;
        }
        return ab.a(a(), ((aa) obj).a());
    }

    public int hashCode() {
        return ab.a(a());
    }

    /* access modifiers changed from: package-private */
    public List<ac> b() {
        if (this.f13604c == c.MAP) {
            synchronized (this) {
                if (this.f13604c == c.MAP) {
                    this.f13606e = a(this.f13605d);
                    this.f13604c = c.BOTH;
                }
            }
        }
        return Collections.unmodifiableList(this.f13606e);
    }

    /* access modifiers changed from: package-private */
    public List<ac> c() {
        if (this.f13604c != c.LIST) {
            if (this.f13604c == c.MAP) {
                this.f13606e = a(this.f13605d);
            }
            this.f13605d = null;
            this.f13604c = c.LIST;
        }
        return this.f13606e;
    }

    /* access modifiers changed from: package-private */
    public ac d() {
        return this.f13607f.a();
    }

    public boolean e() {
        return this.f13603b;
    }

    public void f() {
        if (!e()) {
            throw new UnsupportedOperationException();
        }
    }

    private static class b<K, V> implements Map<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private final ai f13608a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<K, V> f13609b;

        b(ai aiVar, Map<K, V> map) {
            this.f13608a = aiVar;
            this.f13609b = map;
        }

        public int size() {
            return this.f13609b.size();
        }

        public boolean isEmpty() {
            return this.f13609b.isEmpty();
        }

        public boolean containsKey(Object obj) {
            return this.f13609b.containsKey(obj);
        }

        public boolean containsValue(Object obj) {
            return this.f13609b.containsValue(obj);
        }

        public V get(Object obj) {
            return this.f13609b.get(obj);
        }

        public V put(K k, V v) {
            this.f13608a.f();
            return this.f13609b.put(k, v);
        }

        public V remove(Object obj) {
            this.f13608a.f();
            return this.f13609b.remove(obj);
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            this.f13608a.f();
            this.f13609b.putAll(map);
        }

        public void clear() {
            this.f13608a.f();
            this.f13609b.clear();
        }

        public Set<K> keySet() {
            return new c(this.f13608a, this.f13609b.keySet());
        }

        public Collection<V> values() {
            return new a(this.f13608a, this.f13609b.values());
        }

        public Set<Map.Entry<K, V>> entrySet() {
            return new c(this.f13608a, this.f13609b.entrySet());
        }

        public boolean equals(Object obj) {
            return this.f13609b.equals(obj);
        }

        public int hashCode() {
            return this.f13609b.hashCode();
        }

        public String toString() {
            return this.f13609b.toString();
        }

        private static class a<E> implements Collection<E> {

            /* renamed from: a  reason: collision with root package name */
            private final ai f13610a;

            /* renamed from: b  reason: collision with root package name */
            private final Collection<E> f13611b;

            a(ai aiVar, Collection<E> collection) {
                this.f13610a = aiVar;
                this.f13611b = collection;
            }

            public int size() {
                return this.f13611b.size();
            }

            public boolean isEmpty() {
                return this.f13611b.isEmpty();
            }

            public boolean contains(Object obj) {
                return this.f13611b.contains(obj);
            }

            public Iterator<E> iterator() {
                return new C0224b(this.f13610a, this.f13611b.iterator());
            }

            public Object[] toArray() {
                return this.f13611b.toArray();
            }

            public <T> T[] toArray(T[] tArr) {
                return this.f13611b.toArray(tArr);
            }

            public boolean add(E e2) {
                throw new UnsupportedOperationException();
            }

            public boolean remove(Object obj) {
                this.f13610a.f();
                return this.f13611b.remove(obj);
            }

            public boolean containsAll(Collection<?> collection) {
                return this.f13611b.containsAll(collection);
            }

            public boolean addAll(Collection<? extends E> collection) {
                throw new UnsupportedOperationException();
            }

            public boolean removeAll(Collection<?> collection) {
                this.f13610a.f();
                return this.f13611b.removeAll(collection);
            }

            public boolean retainAll(Collection<?> collection) {
                this.f13610a.f();
                return this.f13611b.retainAll(collection);
            }

            public void clear() {
                this.f13610a.f();
                this.f13611b.clear();
            }

            public boolean equals(Object obj) {
                return this.f13611b.equals(obj);
            }

            public int hashCode() {
                return this.f13611b.hashCode();
            }

            public String toString() {
                return this.f13611b.toString();
            }
        }

        private static class c<E> implements Set<E> {

            /* renamed from: a  reason: collision with root package name */
            private final ai f13614a;

            /* renamed from: b  reason: collision with root package name */
            private final Set<E> f13615b;

            c(ai aiVar, Set<E> set) {
                this.f13614a = aiVar;
                this.f13615b = set;
            }

            public int size() {
                return this.f13615b.size();
            }

            public boolean isEmpty() {
                return this.f13615b.isEmpty();
            }

            public boolean contains(Object obj) {
                return this.f13615b.contains(obj);
            }

            public Iterator<E> iterator() {
                return new C0224b(this.f13614a, this.f13615b.iterator());
            }

            public Object[] toArray() {
                return this.f13615b.toArray();
            }

            public <T> T[] toArray(T[] tArr) {
                return this.f13615b.toArray(tArr);
            }

            public boolean add(E e2) {
                this.f13614a.f();
                return this.f13615b.add(e2);
            }

            public boolean remove(Object obj) {
                this.f13614a.f();
                return this.f13615b.remove(obj);
            }

            public boolean containsAll(Collection<?> collection) {
                return this.f13615b.containsAll(collection);
            }

            public boolean addAll(Collection<? extends E> collection) {
                this.f13614a.f();
                return this.f13615b.addAll(collection);
            }

            public boolean retainAll(Collection<?> collection) {
                this.f13614a.f();
                return this.f13615b.retainAll(collection);
            }

            public boolean removeAll(Collection<?> collection) {
                this.f13614a.f();
                return this.f13615b.removeAll(collection);
            }

            public void clear() {
                this.f13614a.f();
                this.f13615b.clear();
            }

            public boolean equals(Object obj) {
                return this.f13615b.equals(obj);
            }

            public int hashCode() {
                return this.f13615b.hashCode();
            }

            public String toString() {
                return this.f13615b.toString();
            }
        }

        /* renamed from: com.google.c.aa$b$b  reason: collision with other inner class name */
        private static class C0224b<E> implements Iterator<E> {

            /* renamed from: a  reason: collision with root package name */
            private final ai f13612a;

            /* renamed from: b  reason: collision with root package name */
            private final Iterator<E> f13613b;

            C0224b(ai aiVar, Iterator<E> it) {
                this.f13612a = aiVar;
                this.f13613b = it;
            }

            public boolean hasNext() {
                return this.f13613b.hasNext();
            }

            public E next() {
                return this.f13613b.next();
            }

            public void remove() {
                this.f13612a.f();
                this.f13613b.remove();
            }

            public boolean equals(Object obj) {
                return this.f13613b.equals(obj);
            }

            public int hashCode() {
                return this.f13613b.hashCode();
            }

            public String toString() {
                return this.f13613b.toString();
            }
        }
    }
}
