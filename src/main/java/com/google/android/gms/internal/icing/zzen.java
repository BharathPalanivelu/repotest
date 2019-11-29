package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.zzdo;

final class zzen implements zzfn {
    private static final zzeu zzlx = new zzem();
    private final zzeu zzlw;

    public zzen() {
        this(new zzep(zzdp.zzbs(), zzci()));
    }

    private zzen(zzeu zzeu) {
        this.zzlw = (zzeu) zzdq.zza(zzeu, "messageInfoFactory");
    }

    public final <T> zzfk<T> zzd(Class<T> cls) {
        zzfm.zzf((Class<?>) cls);
        zzev zzc = this.zzlw.zzc(cls);
        if (zzc.zzcp()) {
            if (zzdo.class.isAssignableFrom(cls)) {
                return zzfa.zza(zzfm.zzdb(), zzdg.zzbb(), zzc.zzcq());
            }
            return zzfa.zza(zzfm.zzcz(), zzdg.zzbc(), zzc.zzcq());
        } else if (zzdo.class.isAssignableFrom(cls)) {
            if (zza(zzc)) {
                return zzfb.zza(cls, zzc, zzfe.zzct(), zzeg.zzcg(), zzfm.zzdb(), zzdg.zzbb(), zzes.zzcm());
            }
            return zzfb.zza(cls, zzc, zzfe.zzct(), zzeg.zzcg(), zzfm.zzdb(), (zzde<?>) null, zzes.zzcm());
        } else if (zza(zzc)) {
            return zzfb.zza(cls, zzc, zzfe.zzcs(), zzeg.zzcf(), zzfm.zzcz(), zzdg.zzbc(), zzes.zzcl());
        } else {
            return zzfb.zza(cls, zzc, zzfe.zzcs(), zzeg.zzcf(), zzfm.zzda(), (zzde<?>) null, zzes.zzcl());
        }
    }

    private static boolean zza(zzev zzev) {
        return zzev.zzco() == zzdo.zzc.zzki;
    }

    private static zzeu zzci() {
        try {
            return (zzeu) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zzlx;
        }
    }
}
