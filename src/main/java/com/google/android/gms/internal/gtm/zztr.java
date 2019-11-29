package com.google.android.gms.internal.gtm;

import java.io.IOException;

abstract class zztr<T, B> {
    zztr() {
    }

    /* access modifiers changed from: package-private */
    public abstract void zza(B b2, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b2, int i, zzps zzps);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b2, int i, T t);

    /* access modifiers changed from: package-private */
    public abstract void zza(T t, zzum zzum) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract boolean zza(zzsy zzsy);

    /* access modifiers changed from: package-private */
    public abstract T zzaa(B b2);

    /* access modifiers changed from: package-private */
    public abstract int zzad(T t);

    /* access modifiers changed from: package-private */
    public abstract T zzag(Object obj);

    /* access modifiers changed from: package-private */
    public abstract B zzah(Object obj);

    /* access modifiers changed from: package-private */
    public abstract int zzai(T t);

    /* access modifiers changed from: package-private */
    public abstract void zzb(B b2, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzc(B b2, int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void zzc(T t, zzum zzum) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzf(Object obj, T t);

    /* access modifiers changed from: package-private */
    public abstract void zzg(Object obj, B b2);

    /* access modifiers changed from: package-private */
    public abstract T zzh(T t, T t2);

    /* access modifiers changed from: package-private */
    public abstract B zzri();

    /* access modifiers changed from: package-private */
    public abstract void zzt(Object obj);

    /* access modifiers changed from: package-private */
    public final boolean zza(B b2, zzsy zzsy) throws IOException {
        int tag = zzsy.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            zza(b2, i, zzsy.zznk());
            return true;
        } else if (i2 == 1) {
            zzb(b2, i, zzsy.zznm());
            return true;
        } else if (i2 == 2) {
            zza(b2, i, zzsy.zznq());
            return true;
        } else if (i2 == 3) {
            Object zzri = zzri();
            int i3 = 4 | (i << 3);
            while (zzsy.zzog() != Integer.MAX_VALUE) {
                if (!zza(zzri, zzsy)) {
                    break;
                }
            }
            if (i3 == zzsy.getTag()) {
                zza(b2, i, zzaa(zzri));
                return true;
            }
            throw zzrk.zzps();
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzc(b2, i, zzsy.zznn());
                return true;
            }
            throw zzrk.zzpt();
        }
    }
}
