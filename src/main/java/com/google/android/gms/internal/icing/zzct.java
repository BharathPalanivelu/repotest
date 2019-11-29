package com.google.android.gms.internal.icing;

final class zzct {
    private final byte[] buffer;
    private final zzcy zzge;

    private zzct(int i) {
        this.buffer = new byte[i];
        this.zzge = zzcy.zzb(this.buffer);
    }

    public final zzcl zzao() {
        this.zzge.zzas();
        return new zzcv(this.buffer);
    }

    public final zzcy zzap() {
        return this.zzge;
    }

    /* synthetic */ zzct(int i, zzck zzck) {
        this(i);
    }
}
