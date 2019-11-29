package com.google.android.gms.internal.icing;

import java.util.Iterator;

final class zzgj implements Iterator<String> {
    private final /* synthetic */ zzgh zznz;
    private Iterator<String> zzov = this.zznz.zzoa.iterator();

    zzgj(zzgh zzgh) {
        this.zznz = zzgh;
    }

    public final boolean hasNext() {
        return this.zzov.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.zzov.next();
    }
}
