package com.google.c;

import com.google.c.q;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class ao<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final int f13635a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public List<ao<K, V>.b> f13636b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Map<K, V> f13637c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f13638d;

    /* renamed from: e  reason: collision with root package name */
    private volatile ao<K, V>.d f13639e;

    static <FieldDescriptorType extends q.a<FieldDescriptorType>> ao<FieldDescriptorType, Object> a(int i) {
        return new ao<FieldDescriptorType, Object>(i) {
            public /* synthetic */ Object put(Object obj, Object obj2) {
                return ao.super.put((q.a) obj, obj2);
            }

            public void a() {
                if (!b()) {
                    for (int i = 0; i < c(); i++) {
                        Map.Entry b2 = b(i);
                        if (((q.a) b2.getKey()).p()) {
                            b2.setValue(Collections.unmodifiableList((List) b2.getValue()));
                        }
                    }
                    for (Map.Entry entry : e()) {
                        if (((q.a) entry.getKey()).p()) {
                            entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                        }
                    }
                }
                ao.super.a();
            }
        };
    }

    private ao(int i) {
        this.f13635a = i;
        this.f13636b = Collections.emptyList();
        this.f13637c = Collections.emptyMap();
    }

    public void a() {
        Map<K, V> map;
        if (!this.f13638d) {
            if (this.f13637c.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f13637c);
            }
            this.f13637c = map;
            this.f13638d = true;
        }
    }

    public boolean b() {
        return this.f13638d;
    }

    public int c() {
        return this.f13636b.size();
    }

    public Map.Entry<K, V> b(int i) {
        return this.f13636b.get(i);
    }

    public int d() {
        return this.f13637c.size();
    }

    public Iterable<Map.Entry<K, V>> e() {
        if (this.f13637c.isEmpty()) {
            return a.a();
        }
        return this.f13637c.entrySet();
    }

    public int size() {
        return this.f13636b.size() + this.f13637c.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f13637c.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return this.f13636b.get(a2).getValue();
        }
        return this.f13637c.get(comparable);
    }

    /* renamed from: a */
    public V put(K k, V v) {
        f();
        int a2 = a(k);
        if (a2 >= 0) {
            return this.f13636b.get(a2).setValue(v);
        }
        h();
        int i = -(a2 + 1);
        if (i >= this.f13635a) {
            return g().put(k, v);
        }
        int size = this.f13636b.size();
        int i2 = this.f13635a;
        if (size == i2) {
            b remove = this.f13636b.remove(i2 - 1);
            g().put(remove.getKey(), remove.getValue());
        }
        this.f13636b.add(i, new b(k, v));
        return null;
    }

    public void clear() {
        f();
        if (!this.f13636b.isEmpty()) {
            this.f13636b.clear();
        }
        if (!this.f13637c.isEmpty()) {
            this.f13637c.clear();
        }
    }

    public V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return c(a2);
        }
        if (this.f13637c.isEmpty()) {
            return null;
        }
        return this.f13637c.remove(comparable);
    }

    /* access modifiers changed from: private */
    public V c(int i) {
        f();
        V value = this.f13636b.remove(i).getValue();
        if (!this.f13637c.isEmpty()) {
            Iterator it = g().entrySet().iterator();
            this.f13636b.add(new b(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private int a(K k) {
        int size = this.f13636b.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo(this.f13636b.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo(this.f13636b.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f13639e == null) {
            this.f13639e = new d();
        }
        return this.f13639e;
    }

    /* access modifiers changed from: private */
    public void f() {
        if (this.f13638d) {
            throw new UnsupportedOperationException();
        }
    }

    private SortedMap<K, V> g() {
        f();
        if (this.f13637c.isEmpty() && !(this.f13637c instanceof TreeMap)) {
            this.f13637c = new TreeMap();
        }
        return (SortedMap) this.f13637c;
    }

    private void h() {
        f();
        if (this.f13636b.isEmpty() && !(this.f13636b instanceof ArrayList)) {
            this.f13636b = new ArrayList(this.f13635a);
        }
    }

    private class b implements Comparable<ao<K, V>.b>, Map.Entry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        private final K f13643b;

        /* renamed from: c  reason: collision with root package name */
        private V f13644c;

        b(ao aoVar, Map.Entry<K, V> entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        b(K k, V v) {
            this.f13643b = k;
            this.f13644c = v;
        }

        /* renamed from: a */
        public K getKey() {
            return this.f13643b;
        }

        public V getValue() {
            return this.f13644c;
        }

        /* renamed from: a */
        public int compareTo(ao<K, V>.b bVar) {
            return getKey().compareTo(bVar.getKey());
        }

        public V setValue(V v) {
            ao.this.f();
            V v2 = this.f13644c;
            this.f13644c = v;
            return v2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!a(this.f13643b, entry.getKey()) || !a(this.f13644c, entry.getValue())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            K k = this.f13643b;
            int i = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f13644c;
            if (v != null) {
                i = v.hashCode();
            }
            return hashCode ^ i;
        }

        public String toString() {
            return this.f13643b + SimpleComparison.EQUAL_TO_OPERATION + this.f13644c;
        }

        private boolean a(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }
    }

    private class d extends AbstractSet<Map.Entry<K, V>> {
        private d() {
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new c();
        }

        public int size() {
            return ao.this.size();
        }

        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = ao.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            ao.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            ao.this.remove(entry.getKey());
            return true;
        }

        public void clear() {
            ao.this.clear();
        }
    }

    private class c implements Iterator<Map.Entry<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        private int f13646b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f13647c;

        /* renamed from: d  reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f13648d;

        private c() {
            this.f13646b = -1;
        }

        public boolean hasNext() {
            if (this.f13646b + 1 < ao.this.f13636b.size() || b().hasNext()) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            this.f13647c = true;
            int i = this.f13646b + 1;
            this.f13646b = i;
            if (i < ao.this.f13636b.size()) {
                return (Map.Entry) ao.this.f13636b.get(this.f13646b);
            }
            return (Map.Entry) b().next();
        }

        public void remove() {
            if (this.f13647c) {
                this.f13647c = false;
                ao.this.f();
                if (this.f13646b < ao.this.f13636b.size()) {
                    ao aoVar = ao.this;
                    int i = this.f13646b;
                    this.f13646b = i - 1;
                    Object unused = aoVar.c(i);
                    return;
                }
                b().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        private Iterator<Map.Entry<K, V>> b() {
            if (this.f13648d == null) {
                this.f13648d = ao.this.f13637c.entrySet().iterator();
            }
            return this.f13648d;
        }
    }

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final Iterator<Object> f13640a = new Iterator<Object>() {
            public boolean hasNext() {
                return false;
            }

            public Object next() {
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final Iterable<Object> f13641b = new Iterable<Object>() {
            public Iterator<Object> iterator() {
                return a.f13640a;
            }
        };

        static <T> Iterable<T> a() {
            return f13641b;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ao)) {
            return super.equals(obj);
        }
        ao aoVar = (ao) obj;
        int size = size();
        if (size != aoVar.size()) {
            return false;
        }
        int c2 = c();
        if (c2 != aoVar.c()) {
            return entrySet().equals(aoVar.entrySet());
        }
        for (int i = 0; i < c2; i++) {
            if (!b(i).equals(aoVar.b(i))) {
                return false;
            }
        }
        if (c2 != size) {
            return this.f13637c.equals(aoVar.f13637c);
        }
        return true;
    }

    public int hashCode() {
        int c2 = c();
        int i = 0;
        for (int i2 = 0; i2 < c2; i2++) {
            i += this.f13636b.get(i2).hashCode();
        }
        return d() > 0 ? i + this.f13637c.hashCode() : i;
    }
}
