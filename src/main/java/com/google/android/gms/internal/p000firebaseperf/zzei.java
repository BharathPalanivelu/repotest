package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzep;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzei  reason: invalid package */
final class zzei extends zzef<Object> {
    zzei() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zze(zzga zzga) {
        return zzga instanceof zzep.zzd;
    }

    /* access modifiers changed from: package-private */
    public final zzek<Object> zzc(Object obj) {
        return ((zzep.zzd) obj).zzrg;
    }

    /* access modifiers changed from: package-private */
    public final zzek<Object> zzd(Object obj) {
        zzep.zzd zzd = (zzep.zzd) obj;
        if (zzd.zzrg.isImmutable()) {
            zzd.zzrg = (zzek) zzd.zzrg.clone();
        }
        return zzd.zzrg;
    }

    /* access modifiers changed from: package-private */
    public final void zze(Object obj) {
        zzc(obj).zzgf();
    }

    /* access modifiers changed from: package-private */
    public final int zzb(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzhz zzhz, Map.Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }
}
