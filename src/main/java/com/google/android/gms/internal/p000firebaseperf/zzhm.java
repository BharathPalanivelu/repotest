package com.google.android.gms.internal.p000firebaseperf;

import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzhm  reason: invalid package */
final class zzhm implements Iterator<String> {
    private final /* synthetic */ zzhk zzuu;
    private Iterator<String> zzvq = this.zzuu.zzuv.iterator();

    zzhm(zzhk zzhk) {
        this.zzuu = zzhk;
    }

    public final boolean hasNext() {
        return this.zzvq.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.zzvq.next();
    }
}
