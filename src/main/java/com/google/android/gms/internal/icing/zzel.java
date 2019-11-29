package com.google.android.gms.internal.icing;

final class zzel extends zzeg {
    private zzel() {
        super();
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, long j) {
        zzc(obj, j).zzah();
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzdx zzc = zzc(obj, j);
        zzdx zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzag()) {
                zzc = zzc.zzj(size2 + size);
            }
            zzc.addAll(zzc2);
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzgi.zza(obj, j, (Object) zzc2);
    }

    private static <E> zzdx<E> zzc(Object obj, long j) {
        return (zzdx) zzgi.zzo(obj, j);
    }
}
