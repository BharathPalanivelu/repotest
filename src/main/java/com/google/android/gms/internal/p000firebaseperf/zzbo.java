package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzep;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbo  reason: invalid package */
public final class zzbo extends zzep<zzbo, zza> implements zzgc {
    private static volatile zzgk<zzbo> zzij;
    /* access modifiers changed from: private */
    public static final zzbo zzim;
    private int zzie;
    private long zzik;
    private int zzil;

    private zzbo() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzbo$zza */
    public static final class zza extends zzep.zzb<zzbo, zza> implements zzgc {
        private zza() {
            super(zzbo.zzim);
        }

        public final zza zzr(long j) {
            zzhn();
            ((zzbo) this.zzqq).zzq(j);
            return this;
        }

        public final zza zze(int i) {
            zzhn();
            ((zzbo) this.zzqq).zzd(i);
            return this;
        }

        /* synthetic */ zza(zzbp zzbp) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void zzq(long j) {
        this.zzie |= 1;
        this.zzik = j;
    }

    /* access modifiers changed from: private */
    public final void zzd(int i) {
        this.zzie |= 2;
        this.zzil = i;
    }

    public static zza zzcy() {
        return (zza) zzim.zzhf();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbp.zzid[i - 1]) {
            case 1:
                return new zzbo();
            case 2:
                return new zza((zzbp) null);
            case 3:
                return zza((zzga) zzim, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u0004\u0001", new Object[]{"zzie", "zzik", "zzil"});
            case 4:
                return zzim;
            case 5:
                zzgk<zzbo> zzgk = zzij;
                if (zzgk == null) {
                    synchronized (zzbo.class) {
                        zzgk = zzij;
                        if (zzgk == null) {
                            zzgk = new zzep.zza<>(zzim);
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
        zzbo zzbo = new zzbo();
        zzim = zzbo;
        zzep.zza(zzbo.class, zzbo);
    }
}
