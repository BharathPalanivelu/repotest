package com.google.android.gms.internal.icing;

import java.util.Iterator;
import java.util.Map;

final class zzfx implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzfp zznn;
    private Iterator<Map.Entry<K, V>> zzno;
    private boolean zzns;

    private zzfx(zzfp zzfp) {
        this.zznn = zzfp;
        this.pos = -1;
    }

    public final boolean hasNext() {
        if (this.pos + 1 < this.zznn.zzni.size() || (!this.zznn.zznj.isEmpty() && zzdj().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.zzns) {
            this.zzns = false;
            this.zznn.zzdh();
            if (this.pos < this.zznn.zzni.size()) {
                zzfp zzfp = this.zznn;
                int i = this.pos;
                this.pos = i - 1;
                Object unused = zzfp.zzak(i);
                return;
            }
            zzdj().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Map.Entry<K, V>> zzdj() {
        if (this.zzno == null) {
            this.zzno = this.zznn.zznj.entrySet().iterator();
        }
        return this.zzno;
    }

    public final /* synthetic */ Object next() {
        this.zzns = true;
        int i = this.pos + 1;
        this.pos = i;
        if (i < this.zznn.zzni.size()) {
            return (Map.Entry) this.zznn.zzni.get(this.pos);
        }
        return (Map.Entry) zzdj().next();
    }

    /* synthetic */ zzfx(zzfp zzfp, zzfo zzfo) {
        this(zzfp);
    }
}
