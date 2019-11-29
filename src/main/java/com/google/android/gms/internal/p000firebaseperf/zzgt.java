package com.google.android.gms.internal.p000firebaseperf;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzgt  reason: invalid package */
final class zzgt extends zzgz {
    private final /* synthetic */ zzgs zzui;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzgt(zzgs zzgs) {
        super(zzgs, (zzgr) null);
        this.zzui = zzgs;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzgu(this.zzui, (zzgr) null);
    }

    /* synthetic */ zzgt(zzgs zzgs, zzgr zzgr) {
        this(zzgs);
    }
}
