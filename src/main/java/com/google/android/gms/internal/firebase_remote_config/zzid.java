package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhi;

final class zzid implements zzji {
    private static final zzin zzve = new zzig();
    private final zzin zzvd;

    public zzid() {
        this(new zzif(zzhj.zzgx(), zzhu()));
    }

    private zzid(zzin zzin) {
        this.zzvd = (zzin) zzhm.zza(zzin, "messageInfoFactory");
    }

    public final <T> zzjf<T> zzj(Class<T> cls) {
        zzjh.zzl(cls);
        zzio zzi = this.zzvd.zzi(cls);
        if (zzi.zzic()) {
            if (zzhi.class.isAssignableFrom(cls)) {
                return zziw.zza(zzjh.zzio(), zzhb.zzgl(), zzi.zzid());
            }
            return zziw.zza(zzjh.zzim(), zzhb.zzgm(), zzi.zzid());
        } else if (zzhi.class.isAssignableFrom(cls)) {
            if (zza(zzi)) {
                return zziu.zza(cls, zzi, zzja.zzig(), zzia.zzht(), zzjh.zzio(), zzhb.zzgl(), zzil.zzhz());
            }
            return zziu.zza(cls, zzi, zzja.zzig(), zzia.zzht(), zzjh.zzio(), (zzgz<?>) null, zzil.zzhz());
        } else if (zza(zzi)) {
            return zziu.zza(cls, zzi, zzja.zzif(), zzia.zzhs(), zzjh.zzim(), zzhb.zzgm(), zzil.zzhy());
        } else {
            return zziu.zza(cls, zzi, zzja.zzif(), zzia.zzhs(), zzjh.zzin(), (zzgz<?>) null, zzil.zzhy());
        }
    }

    private static boolean zza(zzio zzio) {
        return zzio.zzib() == zzhi.zze.zztu;
    }

    private static zzin zzhu() {
        try {
            return (zzin) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zzve;
        }
    }
}
