package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzbn;
import com.google.android.gms.internal.p000firebaseperf.zzep;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbr  reason: invalid package */
public final class zzbr extends zzep<zzbr, zzb> implements zzgc {
    private static volatile zzgk<zzbr> zzij;
    /* access modifiers changed from: private */
    public static final zzbr zziu;
    private int zzie;
    private String zzin = "";
    private String zzio = "";
    private zzbn zzip;
    private zzce zziq;
    private zzdf zzir;
    private int zzis;
    private zzfu<String, String> zzit = zzfu.zzid();

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzbr$zza */
    static final class zza {
        static final zzfs<String, String> zziv = zzfs.zza(zzht.STRING, "", zzht.STRING, "");
    }

    private zzbr() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzbr$zzb */
    public static final class zzb extends zzep.zzb<zzbr, zzb> implements zzgc {
        private zzb() {
            super(zzbr.zziu);
        }

        public final zzb zzv(String str) {
            zzhn();
            ((zzbr) this.zzqq).zzt(str);
            return this;
        }

        public final boolean zzdb() {
            return ((zzbr) this.zzqq).zzdb();
        }

        public final zzb zzw(String str) {
            zzhn();
            ((zzbr) this.zzqq).zzu(str);
            return this;
        }

        public final zzb zzb(zzbn.zza zza) {
            zzhn();
            ((zzbr) this.zzqq).zza(zza);
            return this;
        }

        public final zzb zzf(zzbt zzbt) {
            zzhn();
            ((zzbr) this.zzqq).zze(zzbt);
            return this;
        }

        public final zzb zzc(Map<String, String> map) {
            zzhn();
            ((zzbr) this.zzqq).zzdf().putAll(map);
            return this;
        }

        /* synthetic */ zzb(zzbq zzbq) {
            this();
        }
    }

    public final boolean zzda() {
        return (this.zzie & 1) != 0;
    }

    /* access modifiers changed from: private */
    public final void zzt(String str) {
        if (str != null) {
            this.zzie |= 1;
            this.zzin = str;
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzdb() {
        return (this.zzie & 2) != 0;
    }

    /* access modifiers changed from: private */
    public final void zzu(String str) {
        if (str != null) {
            this.zzie |= 2;
            this.zzio = str;
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzdc() {
        return (this.zzie & 4) != 0;
    }

    public final zzbn zzdd() {
        zzbn zzbn = this.zzip;
        return zzbn == null ? zzbn.zzcw() : zzbn;
    }

    /* access modifiers changed from: private */
    public final void zza(zzbn.zza zza2) {
        this.zzip = (zzbn) ((zzep) zza2.zzhr());
        this.zzie |= 4;
    }

    public final boolean zzde() {
        return (this.zzie & 32) != 0;
    }

    /* access modifiers changed from: private */
    public final void zze(zzbt zzbt) {
        if (zzbt != null) {
            this.zzie |= 32;
            this.zzis = zzbt.zzdj();
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final Map<String, String> zzdf() {
        if (!this.zzit.isMutable()) {
            this.zzit = this.zzit.zzie();
        }
        return this.zzit;
    }

    public static zzb zzdg() {
        return (zzb) zziu.zzhf();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbq.zzid[i - 1]) {
            case 1:
                return new zzbr();
            case 2:
                return new zzb((zzbq) null);
            case 3:
                return zza((zzga) zziu, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0001\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\t\u0002\u0004\t\u0003\u0005\f\u0005\u00062\u0007\t\u0004", new Object[]{"zzie", "zzin", "zzio", "zzip", "zziq", "zzis", zzbt.zzdk(), "zzit", zza.zziv, "zzir"});
            case 4:
                return zziu;
            case 5:
                zzgk<zzbr> zzgk = zzij;
                if (zzgk == null) {
                    synchronized (zzbr.class) {
                        zzgk = zzij;
                        if (zzgk == null) {
                            zzgk = new zzep.zza<>(zziu);
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

    public static zzbr zzdh() {
        return zziu;
    }

    static {
        zzbr zzbr = new zzbr();
        zziu = zzbr;
        zzep.zza(zzbr.class, zzbr);
    }
}
