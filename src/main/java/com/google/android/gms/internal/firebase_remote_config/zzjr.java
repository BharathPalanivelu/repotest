package com.google.android.gms.internal.firebase_remote_config;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class zzjr extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzjk zzwy;

    private zzjr(zzjk zzjk) {
        this.zzwy = zzjk;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new zzjs(this.zzwy, (zzjj) null);
    }

    public int size() {
        return this.zzwy.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzwy.get(entry.getKey());
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
        this.zzwy.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zzwy.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzwy.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zzjr(zzjk zzjk, zzjj zzjj) {
        this(zzjk);
    }
}
