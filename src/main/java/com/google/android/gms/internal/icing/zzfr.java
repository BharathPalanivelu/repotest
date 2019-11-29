package com.google.android.gms.internal.icing;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzfr implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzfp zznn;
    private Iterator<Map.Entry<K, V>> zzno;

    private zzfr(zzfp zzfp) {
        this.zznn = zzfp;
        this.pos = this.zznn.zzni.size();
    }

    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zznn.zzni.size()) || zzdj().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> zzdj() {
        if (this.zzno == null) {
            this.zzno = this.zznn.zznl.entrySet().iterator();
        }
        return this.zzno;
    }

    public final /* synthetic */ Object next() {
        if (zzdj().hasNext()) {
            return (Map.Entry) zzdj().next();
        }
        List zzb = this.zznn.zzni;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) zzb.get(i);
    }

    /* synthetic */ zzfr(zzfp zzfp, zzfo zzfo) {
        this(zzfp);
    }
}
