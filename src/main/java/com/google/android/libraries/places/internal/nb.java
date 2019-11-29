package com.google.android.libraries.places.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class nb extends AbstractSet<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ms f13005a;

    nb(ms msVar) {
        this.f13005a = msVar;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new na(this.f13005a);
    }

    public int size() {
        return this.f13005a.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f13005a.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.f13005a.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.f13005a.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f13005a.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }
}
