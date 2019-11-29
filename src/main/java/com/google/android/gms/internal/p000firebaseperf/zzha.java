package com.google.android.gms.internal.p000firebaseperf;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzha  reason: invalid package */
final class zzha implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzgs zzui;
    private Iterator<Map.Entry<K, V>> zzuj;
    private boolean zzun;

    private zzha(zzgs zzgs) {
        this.zzui = zzgs;
        this.pos = -1;
    }

    public final boolean hasNext() {
        if (this.pos + 1 < this.zzui.zzud.size() || (!this.zzui.zzue.isEmpty() && zzje().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.zzun) {
            this.zzun = false;
            this.zzui.zzjc();
            if (this.pos < this.zzui.zzud.size()) {
                zzgs zzgs = this.zzui;
                int i = this.pos;
                this.pos = i - 1;
                Object unused = zzgs.zzav(i);
                return;
            }
            zzje().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Map.Entry<K, V>> zzje() {
        if (this.zzuj == null) {
            this.zzuj = this.zzui.zzue.entrySet().iterator();
        }
        return this.zzuj;
    }

    public final /* synthetic */ Object next() {
        this.zzun = true;
        int i = this.pos + 1;
        this.pos = i;
        if (i < this.zzui.zzud.size()) {
            return (Map.Entry) this.zzui.zzud.get(this.pos);
        }
        return (Map.Entry) zzje().next();
    }

    /* synthetic */ zzha(zzgs zzgs, zzgr zzgr) {
        this(zzgs);
    }
}
