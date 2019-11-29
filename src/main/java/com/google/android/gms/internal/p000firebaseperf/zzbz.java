package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzep;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbz  reason: invalid package */
public final class zzbz extends zzep<zzbz, zza> implements zzgc {
    private static volatile zzgk<zzbz> zzij;
    /* access modifiers changed from: private */
    public static final zzbz zzjs;
    private int zzie;
    private String zzjm = "";
    private int zzjn;
    private int zzjo;
    private int zzjp;
    private int zzjq;
    private int zzjr;

    private zzbz() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzbz$zza */
    public static final class zza extends zzep.zzb<zzbz, zza> implements zzgc {
        private zza() {
            super(zzbz.zzjs);
        }

        public final zza zzy(String str) {
            zzhn();
            ((zzbz) this.zzqq).zzx(str);
            return this;
        }

        public final zza zzi(int i) {
            zzhn();
            ((zzbz) this.zzqq).zzf(i);
            return this;
        }

        public final zza zzj(int i) {
            zzhn();
            ((zzbz) this.zzqq).zzg(i);
            return this;
        }

        public final zza zzk(int i) {
            zzhn();
            ((zzbz) this.zzqq).zzh(i);
            return this;
        }

        /* synthetic */ zza(zzcb zzcb) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void zzx(String str) {
        if (str != null) {
            this.zzie |= 1;
            this.zzjm = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void zzf(int i) {
        this.zzie |= 8;
        this.zzjp = i;
    }

    public final boolean zzdn() {
        return (this.zzie & 16) != 0;
    }

    /* access modifiers changed from: private */
    public final void zzg(int i) {
        this.zzie |= 16;
        this.zzjq = i;
    }

    /* access modifiers changed from: private */
    public final void zzh(int i) {
        this.zzie |= 32;
        this.zzjr = i;
    }

    public static zza zzdo() {
        return (zza) zzjs.zzhf();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzcb.zzid[i - 1]) {
            case 1:
                return new zzbz();
            case 2:
                return new zza((zzcb) null);
            case 3:
                return zza((zzga) zzjs, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\u0004\u0001\u0003\u0004\u0003\u0004\u0004\u0004\u0005\u0004\u0005\u0006\u0004\u0002", new Object[]{"zzie", "zzjm", "zzjn", "zzjp", "zzjq", "zzjr", "zzjo"});
            case 4:
                return zzjs;
            case 5:
                zzgk<zzbz> zzgk = zzij;
                if (zzgk == null) {
                    synchronized (zzbz.class) {
                        zzgk = zzij;
                        if (zzgk == null) {
                            zzgk = new zzep.zza<>(zzjs);
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

    public static zzbz zzdp() {
        return zzjs;
    }

    static {
        zzbz zzbz = new zzbz();
        zzjs = zzbz;
        zzep.zza(zzbz.class, zzbz);
    }
}
