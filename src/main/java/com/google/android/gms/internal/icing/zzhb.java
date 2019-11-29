package com.google.android.gms.internal.icing;

public final class zzhb implements zzbx<zzha> {
    private static zzhb zzqu = new zzhb();
    private final zzbx<zzha> zzqv;

    public static boolean zzec() {
        return ((zzha) zzqu.get()).zzec();
    }

    private zzhb(zzbx<zzha> zzbx) {
        this.zzqv = zzca.zza(zzbx);
    }

    public zzhb() {
        this(zzca.zzc(new zzhd()));
    }

    public final /* synthetic */ Object get() {
        return this.zzqv.get();
    }
}
