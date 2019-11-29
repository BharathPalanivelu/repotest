package com.google.android.gms.internal.icing;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class zzfw extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzfp zznn;

    private zzfw(zzfp zzfp) {
        this.zznn = zzfp;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new zzfx(this.zznn, (zzfo) null);
    }

    public int size() {
        return this.zznn.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zznn.get(entry.getKey());
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
        this.zznn.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zznn.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zznn.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zzfw(zzfp zzfp, zzfo zzfo) {
        this(zzfp);
    }
}
