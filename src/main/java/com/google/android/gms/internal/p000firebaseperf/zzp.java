package com.google.android.gms.internal.p000firebaseperf;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzp  reason: invalid package */
class zzp<E> extends zzs<E> {
    int size = 0;
    Object[] zzo = new Object[4];
    boolean zzp;

    zzp(int i) {
        zzo.zza(4, "initialCapacity");
    }

    public zzp<E> zzb(E e2) {
        zzf.checkNotNull(e2);
        int i = this.size + 1;
        Object[] objArr = this.zzo;
        if (objArr.length < i) {
            this.zzo = Arrays.copyOf(objArr, zzd(objArr.length, i));
            this.zzp = false;
        } else if (this.zzp) {
            this.zzo = (Object[]) objArr.clone();
            this.zzp = false;
        }
        Object[] objArr2 = this.zzo;
        int i2 = this.size;
        this.size = i2 + 1;
        objArr2[i2] = e2;
        return this;
    }
}
