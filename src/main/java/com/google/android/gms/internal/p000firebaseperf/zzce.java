package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzep;
import com.google.android.gms.internal.p000firebaseperf.zzic;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzce  reason: invalid package */
public final class zzce extends zzep<zzce, zza> implements zzgc {
    private static volatile zzgk<zzce> zzij;
    /* access modifiers changed from: private */
    public static final zzce zzkc;
    private int zzie;
    private String zzig = "";
    private String zzjz = "";
    private String zzka = "";
    private zzic.zza zzkb;

    private zzce() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzce$zza */
    public static final class zza extends zzep.zzb<zzce, zza> implements zzgc {
        private zza() {
            super(zzce.zzkc);
        }

        /* synthetic */ zza(zzcf zzcf) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzcf.zzid[i - 1]) {
            case 1:
                return new zzce();
            case 2:
                return new zza((zzcf) null);
            case 3:
                return zza((zzga) zzkc, "\u0001\u0004\u0000\u0001\u0002\u0005\u0004\u0000\u0000\u0000\u0002\b\u0000\u0003\b\u0001\u0004\b\u0002\u0005\t\u0003", new Object[]{"zzie", "zzig", "zzjz", "zzka", "zzkb"});
            case 4:
                return zzkc;
            case 5:
                zzgk<zzce> zzgk = zzij;
                if (zzgk == null) {
                    synchronized (zzce.class) {
                        zzgk = zzij;
                        if (zzgk == null) {
                            zzgk = new zzep.zza<>(zzkc);
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
        zzce zzce = new zzce();
        zzkc = zzce;
        zzep.zza(zzce.class, zzce);
    }
}
