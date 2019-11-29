package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzep;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzcd  reason: invalid package */
public final class zzcd extends zzep<zzcd, zza> implements zzgc {
    private static volatile zzgk<zzcd> zzij;
    /* access modifiers changed from: private */
    public static final zzcd zzjy;
    private int zzie;
    private String zzjt = "";
    private zzbz zzju;
    private zzex<zzbu> zzjv = zzhj();
    private zzex<zzbo> zzjw = zzhj();
    private zzex<zzch> zzjx = zzhj();

    private zzcd() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzcd$zza */
    public static final class zza extends zzep.zzb<zzcd, zza> implements zzgc {
        private zza() {
            super(zzcd.zzjy);
        }

        public final zza zzaa(String str) {
            zzhn();
            ((zzcd) this.zzqq).zzz(str);
            return this;
        }

        public final zza zzb(zzbz zzbz) {
            zzhn();
            ((zzcd) this.zzqq).zza(zzbz);
            return this;
        }

        public final zza zzb(zzbu zzbu) {
            zzhn();
            ((zzcd) this.zzqq).zza(zzbu);
            return this;
        }

        public final zza zzb(zzbo zzbo) {
            zzhn();
            ((zzcd) this.zzqq).zza(zzbo);
            return this;
        }

        /* synthetic */ zza(zzcc zzcc) {
            this();
        }
    }

    public final boolean zzdr() {
        return (this.zzie & 1) != 0;
    }

    public final String zzds() {
        return this.zzjt;
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

    public final boolean zzdt() {
        return (this.zzie & 2) != 0;
    }

    public final zzbz zzdu() {
        zzbz zzbz = this.zzju;
        return zzbz == null ? zzbz.zzdp() : zzbz;
    }

    /* access modifiers changed from: private */
    public final void zza(zzbz zzbz) {
        if (zzbz != null) {
            this.zzju = zzbz;
            this.zzie |= 2;
            return;
        }
        throw new NullPointerException();
    }

    public final int zzdv() {
        return this.zzjv.size();
    }

    /* access modifiers changed from: private */
    public final void zza(zzbu zzbu) {
        if (zzbu != null) {
            if (!this.zzjv.zzge()) {
                this.zzjv = zzep.zza(this.zzjv);
            }
            this.zzjv.add(zzbu);
            return;
        }
        throw new NullPointerException();
    }

    public final int zzdw() {
        return this.zzjw.size();
    }

    /* access modifiers changed from: private */
    public final void zza(zzbo zzbo) {
        if (zzbo != null) {
            if (!this.zzjw.zzge()) {
                this.zzjw = zzep.zza(this.zzjw);
            }
            this.zzjw.add(zzbo);
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzdx() {
        return (zza) zzjy.zzhf();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzcc.zzid[i - 1]) {
            case 1:
                return new zzcd();
            case 2:
                return new zza((zzcc) null);
            case 3:
                return zza((zzga) zzjy, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001\b\u0000\u0002\u001b\u0003\t\u0001\u0004\u001b\u0005\u001b", new Object[]{"zzie", "zzjt", "zzjv", zzbu.class, "zzju", "zzjw", zzbo.class, "zzjx", zzch.class});
            case 4:
                return zzjy;
            case 5:
                zzgk<zzcd> zzgk = zzij;
                if (zzgk == null) {
                    synchronized (zzcd.class) {
                        zzgk = zzij;
                        if (zzgk == null) {
                            zzgk = new zzep.zza<>(zzjy);
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

    public static zzcd zzdy() {
        return zzjy;
    }

    static {
        zzcd zzcd = new zzcd();
        zzjy = zzcd;
        zzep.zza(zzcd.class, zzcd);
    }
}
