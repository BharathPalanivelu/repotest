package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

abstract class zzjx<T, B> {
    zzjx() {
    }

    /* access modifiers changed from: package-private */
    public abstract void zza(B b2, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b2, int i, zzfx zzfx);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b2, int i, T t);

    /* access modifiers changed from: package-private */
    public abstract void zza(T t, zzku zzku) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract boolean zza(zzjg zzjg);

    /* access modifiers changed from: package-private */
    public abstract T zzaa(Object obj);

    /* access modifiers changed from: package-private */
    public abstract B zzab(Object obj);

    /* access modifiers changed from: package-private */
    public abstract int zzac(T t);

    /* access modifiers changed from: package-private */
    public abstract void zzb(B b2, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzc(B b2, int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void zzc(T t, zzku zzku) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzg(Object obj, T t);

    /* access modifiers changed from: package-private */
    public abstract void zzh(Object obj, B b2);

    /* access modifiers changed from: package-private */
    public abstract T zzi(T t, T t2);

    /* access modifiers changed from: package-private */
    public abstract B zziz();

    /* access modifiers changed from: package-private */
    public abstract void zzm(Object obj);

    /* access modifiers changed from: package-private */
    public abstract T zzs(B b2);

    /* access modifiers changed from: package-private */
    public abstract int zzw(T t);

    /* access modifiers changed from: package-private */
    public final boolean zza(B b2, zzjg zzjg) throws IOException {
        int tag = zzjg.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            zza(b2, i, zzjg.zzfd());
            return true;
        } else if (i2 == 1) {
            zzb(b2, i, zzjg.zzff());
            return true;
        } else if (i2 == 2) {
            zza(b2, i, zzjg.zzfj());
            return true;
        } else if (i2 == 3) {
            Object zziz = zziz();
            int i3 = 4 | (i << 3);
            while (zzjg.zzfz() != Integer.MAX_VALUE) {
                if (!zza(zziz, zzjg)) {
                    break;
                }
            }
            if (i3 == zzjg.getTag()) {
                zza(b2, i, zzs(zziz));
                return true;
            }
            throw zzhq.zzhi();
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzc(b2, i, zzjg.zzfg());
                return true;
            }
            throw zzhq.zzhj();
        }
    }
}
