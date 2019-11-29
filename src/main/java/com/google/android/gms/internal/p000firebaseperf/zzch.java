package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzep;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzch  reason: invalid package */
public final class zzch extends zzep<zzch, zza> implements zzgc {
    private static volatile zzgk<zzch> zzij;
    /* access modifiers changed from: private */
    public static final zzch zzkf;
    private int zzie;
    private long zzik;
    private int zzkd;
    private int zzke;

    private zzch() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzch$zza */
    public static final class zza extends zzep.zzb<zzch, zza> implements zzgc {
        private zza() {
            super(zzch.zzkf);
        }

        /* synthetic */ zza(zzcg zzcg) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzcg.zzid[i - 1]) {
            case 1:
                return new zzch();
            case 2:
                return new zza((zzcg) null);
            case 3:
                return zza((zzga) zzkf, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u0004\u0001\u0003\u0004\u0002", new Object[]{"zzie", "zzik", "zzkd", "zzke"});
            case 4:
                return zzkf;
            case 5:
                zzgk<zzch> zzgk = zzij;
                if (zzgk == null) {
                    synchronized (zzch.class) {
                        zzgk = zzij;
                        if (zzgk == null) {
                            zzgk = new zzep.zza<>(zzkf);
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
        zzch zzch = new zzch();
        zzkf = zzch;
        zzep.zza(zzch.class, zzch);
    }
}
