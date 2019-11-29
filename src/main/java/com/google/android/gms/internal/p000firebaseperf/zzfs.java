package com.google.android.gms.internal.p000firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzfs  reason: invalid package */
public final class zzfs<K, V> {
    private final V value;
    private final zzfr<K, V> zzsu;
    private final K zzsv;

    private zzfs(zzht zzht, K k, zzht zzht2, V v) {
        this.zzsu = new zzfr<>(zzht, k, zzht2, v);
        this.zzsv = k;
        this.value = v;
    }

    public static <K, V> zzfs<K, V> zza(zzht zzht, K k, zzht zzht2, V v) {
        return new zzfs<>(zzht, k, zzht2, v);
    }

    static <K, V> int zza(zzfr<K, V> zzfr, K k, V v) {
        return zzek.zza(zzfr.zzsq, 1, k) + zzek.zza(zzfr.zzss, 2, v);
    }

    public final int zzb(int i, K k, V v) {
        return zzec.zzy(i) + zzec.zzaf(zza(this.zzsu, k, v));
    }

    /* access modifiers changed from: package-private */
    public final zzfr<K, V> zzic() {
        return this.zzsu;
    }
}
