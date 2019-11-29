package com.google.android.gms.internal.icing;

import java.util.NoSuchElementException;

final class zzck extends zzcm {
    private final int limit = this.zzfx.size();
    private int position = 0;
    private final /* synthetic */ zzcl zzfx;

    zzck(zzcl zzcl) {
        this.zzfx = zzcl;
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final byte nextByte() {
        int i = this.position;
        if (i < this.limit) {
            this.position = i + 1;
            return this.zzfx.zzl(i);
        }
        throw new NoSuchElementException();
    }
}
