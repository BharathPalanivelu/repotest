package com.google.android.gms.internal.p000firebaseperf;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzgu  reason: invalid package */
final class zzgu implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzgs zzui;
    private Iterator<Map.Entry<K, V>> zzuj;

    private zzgu(zzgs zzgs) {
        this.zzui = zzgs;
        this.pos = this.zzui.zzud.size();
    }

    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zzui.zzud.size()) || zzje().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> zzje() {
        if (this.zzuj == null) {
            this.zzuj = this.zzui.zzug.entrySet().iterator();
        }
        return this.zzuj;
    }

    public final /* synthetic */ Object next() {
        if (zzje().hasNext()) {
            return (Map.Entry) zzje().next();
        }
        List zzb = this.zzui.zzud;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) zzb.get(i);
    }

    /* synthetic */ zzgu(zzgs zzgs, zzgr zzgr) {
        this(zzgs);
    }
}
