package com.google.android.gms.internal.p000firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzfp  reason: invalid package */
final class zzfp implements zzfx {
    private zzfx[] zzsp;

    zzfp(zzfx... zzfxArr) {
        this.zzsp = zzfxArr;
    }

    public final boolean zzb(Class<?> cls) {
        for (zzfx zzb : this.zzsp) {
            if (zzb.zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzfy zzc(Class<?> cls) {
        for (zzfx zzfx : this.zzsp) {
            if (zzfx.zzb(cls)) {
                return zzfx.zzc(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
