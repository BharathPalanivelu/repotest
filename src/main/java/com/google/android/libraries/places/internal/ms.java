package com.google.android.libraries.places.internal;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class ms<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public List<mz> f12984a;

    /* renamed from: b  reason: collision with root package name */
    public Map<K, V> f12985b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12986c;

    /* renamed from: d  reason: collision with root package name */
    public Map<K, V> f12987d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12988e;

    /* renamed from: f  reason: collision with root package name */
    private volatile nb f12989f;

    /* renamed from: g  reason: collision with root package name */
    private volatile mv f12990g;

    static <FieldDescriptorType extends kq<FieldDescriptorType>> ms<FieldDescriptorType, Object> a(int i) {
        return new mt(i);
    }

    private ms(int i) {
        this.f12988e = i;
        this.f12984a = Collections.emptyList();
        this.f12985b = Collections.emptyMap();
        this.f12987d = Collections.emptyMap();
    }

    public void a() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.f12986c) {
            if (this.f12985b.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f12985b);
            }
            this.f12985b = map;
            if (this.f12987d.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.f12987d);
            }
            this.f12987d = map2;
            this.f12986c = true;
        }
    }

    public final int b() {
        return this.f12984a.size();
    }

    public final Map.Entry<K, V> b(int i) {
        return this.f12984a.get(i);
    }

    public final Iterable<Map.Entry<K, V>> c() {
        if (this.f12985b.isEmpty()) {
            return mw.f12996b;
        }
        return this.f12985b.entrySet();
    }

    public int size() {
        return this.f12984a.size() + this.f12985b.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f12985b.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return this.f12984a.get(a2).getValue();
        }
        return this.f12985b.get(comparable);
    }

    /* renamed from: a */
    public final V put(K k, V v) {
        e();
        int a2 = a(k);
        if (a2 >= 0) {
            return this.f12984a.get(a2).setValue(v);
        }
        e();
        if (this.f12984a.isEmpty() && !(this.f12984a instanceof ArrayList)) {
            this.f12984a = new ArrayList(this.f12988e);
        }
        int i = -(a2 + 1);
        if (i >= this.f12988e) {
            return f().put(k, v);
        }
        int size = this.f12984a.size();
        int i2 = this.f12988e;
        if (size == i2) {
            mz remove = this.f12984a.remove(i2 - 1);
            f().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.f12984a.add(i, new mz(this, k, v));
        return null;
    }

    public void clear() {
        e();
        if (!this.f12984a.isEmpty()) {
            this.f12984a.clear();
        }
        if (!this.f12985b.isEmpty()) {
            this.f12985b.clear();
        }
    }

    public V remove(Object obj) {
        e();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return c(a2);
        }
        if (this.f12985b.isEmpty()) {
            return null;
        }
        return this.f12985b.remove(comparable);
    }

    /* access modifiers changed from: package-private */
    public final V c(int i) {
        e();
        V value = this.f12984a.remove(i).getValue();
        if (!this.f12985b.isEmpty()) {
            Iterator it = f().entrySet().iterator();
            this.f12984a.add(new mz(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private final int a(K k) {
        int size = this.f12984a.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.f12984a.get(size).getKey());
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
            int compareTo2 = k.compareTo((Comparable) this.f12984a.get(i2).getKey());
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
        if (this.f12989f == null) {
            this.f12989f = new nb(this);
        }
        return this.f12989f;
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> d() {
        if (this.f12990g == null) {
            this.f12990g = new mv(this);
        }
        return this.f12990g;
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        if (this.f12986c) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> f() {
        e();
        if (this.f12985b.isEmpty() && !(this.f12985b instanceof TreeMap)) {
            this.f12985b = new TreeMap();
            this.f12987d = ((TreeMap) this.f12985b).descendingMap();
        }
        return (SortedMap) this.f12985b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ms)) {
            return super.equals(obj);
        }
        ms msVar = (ms) obj;
        int size = size();
        if (size != msVar.size()) {
            return false;
        }
        int b2 = b();
        if (b2 != msVar.b()) {
            return entrySet().equals(msVar.entrySet());
        }
        for (int i = 0; i < b2; i++) {
            if (!b(i).equals(msVar.b(i))) {
                return false;
            }
        }
        if (b2 != size) {
            return this.f12985b.equals(msVar.f12985b);
        }
        return true;
    }

    public int hashCode() {
        int b2 = b();
        int i = 0;
        for (int i2 = 0; i2 < b2; i2++) {
            i += this.f12984a.get(i2).hashCode();
        }
        return this.f12985b.size() > 0 ? i + this.f12985b.hashCode() : i;
    }

    /* synthetic */ ms(int i, byte b2) {
        this(i);
    }
}
