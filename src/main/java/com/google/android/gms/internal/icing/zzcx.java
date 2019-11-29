package com.google.android.gms.internal.icing;

public abstract class zzcx {
    private int zzgg;
    private int zzgh;
    private boolean zzgi;

    static zzcx zza(byte[] bArr, int i, int i2, boolean z) {
        zzcz zzcz = new zzcz(bArr, 0, i2, false);
        try {
            zzcz.zzn(i2);
            return zzcz;
        } catch (zzdw e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public abstract int zzaq();

    public abstract int zzn(int i) throws zzdw;

    private zzcx() {
        this.zzgg = 100;
        this.zzgh = Integer.MAX_VALUE;
        this.zzgi = false;
    }
}
