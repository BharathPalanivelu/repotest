package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzcr;

final class zzdm implements zzeo {
    private static final zzdw zzmu = new zzdn();
    private final zzdw zzmt;

    public zzdm() {
        this(new zzdo(zzcq.zzbs(), zzco()));
    }

    private zzdm(zzdw zzdw) {
        this.zzmt = (zzdw) zzct.zza(zzdw, "messageInfoFactory");
    }

    private static boolean zza(zzdv zzdv) {
        return zzdv.zzcv() == zzcr.zzd.zzlg;
    }

    private static zzdw zzco() {
        try {
            return (zzdw) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zzmu;
        }
    }

    public final <T> zzen<T> zzd(Class<T> cls) {
        zzep.zzf((Class<?>) cls);
        zzdv zzb = this.zzmt.zzb(cls);
        if (zzb.zzcw()) {
            return zzcr.class.isAssignableFrom(cls) ? zzed.zza(zzep.zzdi(), zzci.zzbi(), zzb.zzcx()) : zzed.zza(zzep.zzdg(), zzci.zzbj(), zzb.zzcx());
        }
        if (zzcr.class.isAssignableFrom(cls)) {
            if (zza(zzb)) {
                return zzeb.zza(cls, zzb, zzeh.zzda(), zzdh.zzcn(), zzep.zzdi(), zzci.zzbi(), zzdu.zzct());
            }
            return zzeb.zza(cls, zzb, zzeh.zzda(), zzdh.zzcn(), zzep.zzdi(), (zzcg<?>) null, zzdu.zzct());
        } else if (zza(zzb)) {
            return zzeb.zza(cls, zzb, zzeh.zzcz(), zzdh.zzcm(), zzep.zzdg(), zzci.zzbj(), zzdu.zzcs());
        } else {
            return zzeb.zza(cls, zzb, zzeh.zzcz(), zzdh.zzcm(), zzep.zzdh(), (zzcg<?>) null, zzdu.zzcs());
        }
    }
}
