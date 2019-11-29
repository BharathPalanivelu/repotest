package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzep;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzdf  reason: invalid package */
public final class zzdf extends zzep<zzdf, zza> implements zzgc {
    private static volatile zzgk<zzdf> zzij;
    /* access modifiers changed from: private */
    public static final zzdf zzmn;
    private int zzie;
    private String zzig = "";
    private String zzmj = "";
    private int zzmk;
    private int zzml;
    private int zzmm;

    private zzdf() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzdf$zza */
    public static final class zza extends zzep.zzb<zzdf, zza> implements zzgc {
        private zza() {
            super(zzdf.zzmn);
        }

        /* synthetic */ zza(zzde zzde) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzde.zzid[i - 1]) {
            case 1:
                return new zzdf();
            case 2:
                return new zza((zzde) null);
            case 3:
                return zza((zzga) zzmn, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\f\u0002\u0004\f\u0003\u0005\f\u0004", new Object[]{"zzie", "zzig", "zzmj", "zzmk", zzcu.zzdk(), "zzml", zzdb.zzdk(), "zzmm", zzby.zzdk()});
            case 4:
                return zzmn;
            case 5:
                zzgk<zzdf> zzgk = zzij;
                if (zzgk == null) {
                    synchronized (zzdf.class) {
                        zzgk = zzij;
                        if (zzgk == null) {
                            zzgk = new zzep.zza<>(zzmn);
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
        zzdf zzdf = new zzdf();
        zzmn = zzdf;
        zzep.zza(zzdf.class, zzdf);
    }
}
