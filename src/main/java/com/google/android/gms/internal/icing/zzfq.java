package com.google.android.gms.internal.icing;

import java.util.Iterator;
import java.util.Map;

final class zzfq extends zzfw {
    private final /* synthetic */ zzfp zznn;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzfq(zzfp zzfp) {
        super(zzfp, (zzfo) null);
        this.zznn = zzfp;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzfr(this.zznn, (zzfo) null);
    }

    /* synthetic */ zzfq(zzfp zzfp, zzfo zzfo) {
        this(zzfp);
    }
}
