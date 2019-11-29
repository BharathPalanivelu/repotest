package com.google.android.gms.internal.places;

import java.util.Iterator;

final class zzdv implements Iterator<String> {
    private Iterator<String> zzmk = this.zzml.zzmj.iterator();
    private final /* synthetic */ zzdt zzml;

    zzdv(zzdt zzdt) {
        this.zzml = zzdt;
    }

    public final boolean hasNext() {
        return this.zzmk.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.zzmk.next();
    }
}
