package com.google.android.gms.internal.p000firebaseperf;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzfg  reason: invalid package */
final class zzfg<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzse;

    public zzfg(Iterator<Map.Entry<K, Object>> it) {
        this.zzse = it;
    }

    public final boolean hasNext() {
        return this.zzse.hasNext();
    }

    public final void remove() {
        this.zzse.remove();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzse.next();
        return next.getValue() instanceof zzfb ? new zzfd(next) : next;
    }
}
