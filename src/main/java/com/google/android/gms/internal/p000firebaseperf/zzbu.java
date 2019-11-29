package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzep;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbu  reason: invalid package */
public final class zzbu extends zzep<zzbu, zza> implements zzgc {
    private static volatile zzgk<zzbu> zzij;
    /* access modifiers changed from: private */
    public static final zzbu zzje;
    private int zzie;
    private long zzik;
    private long zzjc;
    private long zzjd;

    private zzbu() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzbu$zza */
    public static final class zza extends zzep.zzb<zzbu, zza> implements zzgc {
        private zza() {
            super(zzbu.zzje);
        }

        public final zza zzu(long j) {
            zzhn();
            ((zzbu) this.zzqq).zzq(j);
            return this;
        }

        public final zza zzv(long j) {
            zzhn();
            ((zzbu) this.zzqq).zzs(j);
            return this;
        }

        public final zza zzw(long j) {
            zzhn();
            ((zzbu) this.zzqq).zzt(j);
            return this;
        }

        /* synthetic */ zza(zzbw zzbw) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void zzq(long j) {
        this.zzie |= 1;
        this.zzik = j;
    }

    /* access modifiers changed from: private */
    public final void zzs(long j) {
        this.zzie |= 2;
        this.zzjc = j;
    }

    /* access modifiers changed from: private */
    public final void zzt(long j) {
        this.zzie |= 4;
        this.zzjd = j;
    }

    public static zza zzdl() {
        return (zza) zzje.zzhf();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbw.zzid[i - 1]) {
            case 1:
                return new zzbu();
            case 2:
                return new zza((zzbw) null);
            case 3:
                return zza((zzga) zzje, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u0002\u0001\u0003\u0002\u0002", new Object[]{"zzie", "zzik", "zzjc", "zzjd"});
            case 4:
                return zzje;
            case 5:
                zzgk<zzbu> zzgk = zzij;
                if (zzgk == null) {
                    synchronized (zzbu.class) {
                        zzgk = zzij;
                        if (zzgk == null) {
                            zzgk = new zzep.zza<>(zzje);
                            zzij = zzgk;
                        }
                    }
                }
                return zzgk;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        zzbu zzbu = new zzbu();
        zzje = zzbu;
        zzep.zza(zzbu.class, zzbu);
    }
}
