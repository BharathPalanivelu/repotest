package com.google.android.gms.internal.p000firebaseperf;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzgz  reason: invalid package */
class zzgz extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzgs zzui;

    private zzgz(zzgs zzgs) {
        this.zzui = zzgs;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new zzha(this.zzui, (zzgr) null);
    }

    public int size() {
        return this.zzui.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzui.get(entry.getKey());
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
        this.zzui.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zzui.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzui.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zzgz(zzgs zzgs, zzgr zzgr) {
        this(zzgs);
    }
}
