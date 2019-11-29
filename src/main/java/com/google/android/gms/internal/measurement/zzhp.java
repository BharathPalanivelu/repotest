package com.google.android.gms.internal.measurement;

import java.io.IOException;

abstract class zzhp<T, B> {
    zzhp() {
    }

    /* access modifiers changed from: package-private */
    public abstract void zza(B b2, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b2, int i, zzdp zzdp);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b2, int i, T t);

    /* access modifiers changed from: package-private */
    public abstract void zza(T t, zzim zzim) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract boolean zza(zzgy zzgy);

    /* access modifiers changed from: package-private */
    public abstract void zzb(B b2, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzc(B b2, int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void zzc(T t, zzim zzim) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zze(Object obj, T t);

    /* access modifiers changed from: package-private */
    public abstract void zzf(Object obj, B b2);

    /* access modifiers changed from: package-private */
    public abstract T zzg(T t, T t2);

    /* access modifiers changed from: package-private */
    public abstract void zzj(Object obj);

    /* access modifiers changed from: package-private */
    public abstract T zzp(B b2);

    /* access modifiers changed from: package-private */
    public abstract int zzt(T t);

    /* access modifiers changed from: package-private */
    public abstract B zzwp();

    /* access modifiers changed from: package-private */
    public abstract T zzx(Object obj);

    /* access modifiers changed from: package-private */
    public abstract B zzy(Object obj);

    /* access modifiers changed from: package-private */
    public abstract int zzz(T t);

    /* access modifiers changed from: package-private */
    public final boolean zza(B b2, zzgy zzgy) throws IOException {
        int tag = zzgy.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            zza(b2, i, zzgy.zzsi());
            return true;
        } else if (i2 == 1) {
            zzb(b2, i, zzgy.zzsk());
            return true;
        } else if (i2 == 2) {
            zza(b2, i, zzgy.zzso());
            return true;
        } else if (i2 == 3) {
            Object zzwp = zzwp();
            int i3 = 4 | (i << 3);
            while (zzgy.zzsy() != Integer.MAX_VALUE) {
                if (!zza(zzwp, zzgy)) {
                    break;
                }
            }
            if (i3 == zzgy.getTag()) {
                zza(b2, i, zzp(zzwp));
                return true;
            }
            throw zzfi.zzux();
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzc(b2, i, zzgy.zzsl());
                return true;
            }
            throw zzfi.zzuy();
        }
    }
}
