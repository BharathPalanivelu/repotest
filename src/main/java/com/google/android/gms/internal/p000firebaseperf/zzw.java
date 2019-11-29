package com.google.android.gms.internal.p000firebaseperf;

import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzw  reason: invalid package */
final class zzw extends zzr<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzr zzx;

    zzw(zzr zzr, int i, int i2) {
        this.zzx = zzr;
        this.offset = i;
        this.length = i2;
    }

    public final int size() {
        return this.length;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzc() {
        return this.zzx.zzc();
    }

    /* access modifiers changed from: package-private */
    public final int zzd() {
        return this.zzx.zzd() + this.offset;
    }

    /* access modifiers changed from: package-private */
    public final int zze() {
        return this.zzx.zzd() + this.offset + this.length;
    }

    public final E get(int i) {
        zzf.zza(i, this.length);
        return this.zzx.get(i + this.offset);
    }

    public final zzr<E> zzc(int i, int i2) {
        zzf.zza(i, i2, this.length);
        zzr zzr = this.zzx;
        int i3 = this.offset;
        return (zzr) zzr.subList(i + i3, i2 + i3);
    }

    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
