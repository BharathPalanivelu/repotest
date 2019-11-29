package com.google.android.gms.internal.p000firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzdx  reason: invalid package */
public abstract class zzdx {
    private int zznb;
    private int zznc;
    private boolean zznd;

    static zzdx zza(byte[] bArr, int i, int i2, boolean z) {
        zzdz zzdz = new zzdz(bArr, 0, i2, false);
        try {
            zzdz.zzt(i2);
            return zzdz;
        } catch (zzfa e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public abstract int zzgn();

    public abstract int zzt(int i) throws zzfa;

    private zzdx() {
        this.zznb = 100;
        this.zznc = Integer.MAX_VALUE;
        this.zznd = false;
    }
}
