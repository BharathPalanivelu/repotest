package com.google.android.gms.internal.places;

public abstract class zzai {
    private int zzeo;
    private int zzep;
    private boolean zzeq;

    public static long zzb(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    static zzai zzb(byte[] bArr, int i, int i2, boolean z) {
        zzak zzak = new zzak(bArr, 0, i2, false);
        try {
            zzak.zzl(i2);
            return zzak;
        } catch (zzbk e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int zzm(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract int zzaj();

    public abstract int zzl(int i) throws zzbk;

    private zzai() {
        this.zzeo = 100;
        this.zzep = Integer.MAX_VALUE;
        this.zzeq = false;
    }
}
