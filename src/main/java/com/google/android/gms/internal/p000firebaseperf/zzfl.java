package com.google.android.gms.internal.p000firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzfl  reason: invalid package */
final class zzfl extends zzfk {
    private zzfl() {
        super();
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, long j) {
        zzb(obj, j).zzgf();
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzex zzb = zzb(obj, j);
        zzex zzb2 = zzb(obj2, j);
        int size = zzb.size();
        int size2 = zzb2.size();
        if (size > 0 && size2 > 0) {
            if (!zzb.zzge()) {
                zzb = zzb.zzao(size2 + size);
            }
            zzb.addAll(zzb2);
        }
        if (size > 0) {
            zzb2 = zzb;
        }
        zzhl.zza(obj, j, (Object) zzb2);
    }

    private static <E> zzex<E> zzb(Object obj, long j) {
        return (zzex) zzhl.zzo(obj, j);
    }
}
