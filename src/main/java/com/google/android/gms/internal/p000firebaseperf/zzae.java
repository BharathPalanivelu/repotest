package com.google.android.gms.internal.p000firebaseperf;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzae  reason: invalid package */
final class zzae<K> extends zzx<K> {
    private final transient zzv<K, ?> zzag;
    private final transient zzr<K> zzs;

    zzae(zzv<K, ?> zzv, zzr<K> zzr) {
        this.zzag = zzv;
        this.zzs = zzr;
    }

    public final zzaf<K> zzb() {
        return (zzaf) zzf().iterator();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return zzf().zza(objArr, i);
    }

    public final zzr<K> zzf() {
        return this.zzs;
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.zzag.get(obj) != null;
    }

    public final int size() {
        return this.zzag.size();
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
