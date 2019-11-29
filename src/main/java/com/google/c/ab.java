package com.google.c;

import com.google.c.u;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class ab<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private static final ab f13616a = new ab(Collections.emptyMap());
    private boolean isMutable = true;

    private ab() {
    }

    private ab(Map<K, V> map) {
        super(map);
    }

    static {
        f13616a.a();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public void clear() {
        c();
        clear();
    }

    public V put(K k, V v) {
        c();
        return super.put(k, v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        c();
        super.putAll(map);
    }

    public V remove(Object obj) {
        c();
        return super.remove(obj);
    }

    private static boolean a(Object obj, Object obj2) {
        if (!(obj instanceof byte[]) || !(obj2 instanceof byte[])) {
            return obj.equals(obj2);
        }
        return Arrays.equals((byte[]) obj, (byte[]) obj2);
    }

    static <K, V> boolean a(Map<K, V> map, Map<K, V> map2) {
        if (map == map2) {
            return true;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry next : map.entrySet()) {
            if (!map2.containsKey(next.getKey())) {
                return false;
            }
            if (!a(next.getValue(), (Object) map2.get(next.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Map) && a(this, (ab) (Map) obj);
    }

    private static int a(Object obj) {
        if (obj instanceof byte[]) {
            return u.c((byte[]) obj);
        }
        if (!(obj instanceof u.a)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    static <K, V> int a(Map<K, V> map) {
        int i = 0;
        for (Map.Entry next : map.entrySet()) {
            i += a(next.getValue()) ^ a(next.getKey());
        }
        return i;
    }

    public int hashCode() {
        return a(this);
    }

    public void a() {
        this.isMutable = false;
    }

    public boolean b() {
        return this.isMutable;
    }

    private void c() {
        if (!b()) {
            throw new UnsupportedOperationException();
        }
    }
}
