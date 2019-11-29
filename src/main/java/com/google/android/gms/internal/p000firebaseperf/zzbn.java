package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzep;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbn  reason: invalid package */
public final class zzbn extends zzep<zzbn, zza> implements zzgc {
    /* access modifiers changed from: private */
    public static final zzbn zzii;
    private static volatile zzgk<zzbn> zzij;
    private int zzie;
    private String zzif = "";
    private String zzig = "";
    private String zzih = "";

    private zzbn() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzbn$zza */
    public static final class zza extends zzep.zzb<zzbn, zza> implements zzgc {
        private zza() {
            super(zzbn.zzii);
        }

        public final zza zzq(String str) {
            zzhn();
            ((zzbn) this.zzqq).zzn(str);
            return this;
        }

        public final zza zzr(String str) {
            zzhn();
            ((zzbn) this.zzqq).zzo(str);
            return this;
        }

        public final zza zzs(String str) {
            zzhn();
            ((zzbn) this.zzqq).zzp(str);
            return this;
        }

        /* synthetic */ zza(zzbm zzbm) {
            this();
        }
    }

    public final boolean zzct() {
        return (this.zzie & 1) != 0;
    }

    /* access modifiers changed from: private */
    public final void zzn(String str) {
        if (str != null) {
            this.zzie |= 1;
            this.zzif = str;
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzcu() {
        return (this.zzie & 2) != 0;
    }

    /* access modifiers changed from: private */
    public final void zzo(String str) {
        if (str != null) {
            this.zzie |= 2;
            this.zzig = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void zzp(String str) {
        if (str != null) {
            this.zzie |= 4;
            this.zzih = str;
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzcv() {
        return (zza) zzii.zzhf();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbm.zzid[i - 1]) {
            case 1:
                return new zzbn();
            case 2:
                return new zza((zzbm) null);
            case 3:
                return zza((zzga) zzii, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002", new Object[]{"zzie", "zzif", "zzig", "zzih"});
            case 4:
                return zzii;
            case 5:
                zzgk<zzbn> zzgk = zzij;
                if (zzgk == null) {
                    synchronized (zzbn.class) {
                        zzgk = zzij;
                        if (zzgk == null) {
                            zzgk = new zzep.zza<>(zzii);
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

    public static zzbn zzcw() {
        return zzii;
    }

    static {
        zzbn zzbn = new zzbn();
        zzii = zzbn;
        zzep.zza(zzbn.class, zzbn);
    }
}
