package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzep;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzfn  reason: invalid package */
final class zzfn implements zzgq {
    private static final zzfx zzsm = new zzfq();
    private final zzfx zzsl;

    public zzfn() {
        this(new zzfp(zzeq.zzhm(), zzib()));
    }

    private zzfn(zzfx zzfx) {
        this.zzsl = (zzfx) zzer.zza(zzfx, "messageInfoFactory");
    }

    public final <T> zzgn<T> zzd(Class<T> cls) {
        zzgp.zzf((Class<?>) cls);
        zzfy zzc = this.zzsl.zzc(cls);
        if (zzc.zzik()) {
            if (zzep.class.isAssignableFrom(cls)) {
                return zzgd.zza(zzgp.zziw(), zzeh.zzgx(), zzc.zzil());
            }
            return zzgd.zza(zzgp.zziu(), zzeh.zzgy(), zzc.zzil());
        } else if (zzep.class.isAssignableFrom(cls)) {
            if (zza(zzc)) {
                return zzge.zza(cls, zzc, zzgh.zzio(), zzfk.zzia(), zzgp.zziw(), zzeh.zzgx(), zzfv.zzih());
            }
            return zzge.zza(cls, zzc, zzgh.zzio(), zzfk.zzia(), zzgp.zziw(), (zzef<?>) null, zzfv.zzih());
        } else if (zza(zzc)) {
            return zzge.zza(cls, zzc, zzgh.zzin(), zzfk.zzhz(), zzgp.zziu(), zzeh.zzgy(), zzfv.zzig());
        } else {
            return zzge.zza(cls, zzc, zzgh.zzin(), zzfk.zzhz(), zzgp.zziv(), (zzef<?>) null, zzfv.zzig());
        }
    }

    private static boolean zza(zzfy zzfy) {
        return zzfy.zzij() == zzep.zzc.zzra;
    }

    private static zzfx zzib() {
        try {
            return (zzfx) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zzsm;
        }
    }
}
