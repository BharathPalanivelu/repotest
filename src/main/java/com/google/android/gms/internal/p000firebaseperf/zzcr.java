package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzep;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzcr  reason: invalid package */
public final class zzcr extends zzep<zzcr, zza> implements zzgc {
    private static volatile zzgk<zzcr> zzij;
    private static final zzey<Integer, zzcv> zzln = new zzcq();
    /* access modifiers changed from: private */
    public static final zzcr zzlo;
    private int zzie;
    private String zzjt = "";
    private zzev zzlm = zzhi();

    private zzcr() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzcr$zza */
    public static final class zza extends zzep.zzb<zzcr, zza> implements zzgc {
        private zza() {
            super(zzcr.zzlo);
        }

        public final zza zzad(String str) {
            zzhn();
            ((zzcr) this.zzqq).zzz(str);
            return this;
        }

        public final zza zzb(zzcv zzcv) {
            zzhn();
            ((zzcr) this.zzqq).zza(zzcv);
            return this;
        }

        /* synthetic */ zza(zzcq zzcq) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void zzz(String str) {
        if (str != null) {
            this.zzie |= 1;
            this.zzjt = str;
            return;
        }
        throw new NullPointerException();
    }

    public final int zzfk() {
        return this.zzlm.size();
    }

    public final zzcv zzn(int i) {
        return zzln.convert(Integer.valueOf(this.zzlm.getInt(0)));
    }

    /* access modifiers changed from: private */
    public final void zza(zzcv zzcv) {
        if (zzcv != null) {
            if (!this.zzlm.zzge()) {
                zzev zzev = this.zzlm;
                int size = zzev.size();
                this.zzlm = zzev.zzak(size == 0 ? 10 : size << 1);
            }
            this.zzlm.zzal(zzcv.zzdj());
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzfl() {
        return (zza) zzlo.zzhf();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzcs.zzid[i - 1]) {
            case 1:
                return new zzcr();
            case 2:
                return new zza((zzcq) null);
            case 3:
                return zza((zzga) zzlo, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\b\u0000\u0002\u001e", new Object[]{"zzie", "zzjt", "zzlm", zzcv.zzdk()});
            case 4:
                return zzlo;
            case 5:
                zzgk<zzcr> zzgk = zzij;
                if (zzgk == null) {
                    synchronized (zzcr.class) {
                        zzgk = zzij;
                        if (zzgk == null) {
                            zzgk = new zzep.zza<>(zzlo);
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
        zzcr zzcr = new zzcr();
        zzlo = zzcr;
        zzep.zza(zzcr.class, zzcr);
    }
}
