package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzbr;
import com.google.android.gms.internal.p000firebaseperf.zzep;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzcn  reason: invalid package */
public final class zzcn extends zzep<zzcn, zza> implements zzgc {
    private static volatile zzgk<zzcn> zzij;
    /* access modifiers changed from: private */
    public static final zzcn zzll;
    private int zzie;
    private zzbr zzlh;
    private zzda zzli;
    private zzci zzlj;
    private zzcd zzlk;

    private zzcn() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzcn$zza */
    public static final class zza extends zzep.zzb<zzcn, zza> implements zzgc {
        private zza() {
            super(zzcn.zzll);
        }

        public final zza zzb(zzbr.zzb zzb) {
            zzhn();
            ((zzcn) this.zzqq).zza(zzb);
            return this;
        }

        public final zza zzb(zzda zzda) {
            zzhn();
            ((zzcn) this.zzqq).zza(zzda);
            return this;
        }

        public final zza zze(zzci zzci) {
            zzhn();
            ((zzcn) this.zzqq).zzd(zzci);
            return this;
        }

        public final zza zzb(zzcd zzcd) {
            zzhn();
            ((zzcn) this.zzqq).zza(zzcd);
            return this;
        }

        /* synthetic */ zza(zzcp zzcp) {
            this();
        }
    }

    public final boolean zzfa() {
        return (this.zzie & 1) != 0;
    }

    public final zzbr zzfb() {
        zzbr zzbr = this.zzlh;
        return zzbr == null ? zzbr.zzdh() : zzbr;
    }

    /* access modifiers changed from: private */
    public final void zza(zzbr.zzb zzb) {
        this.zzlh = (zzbr) ((zzep) zzb.zzhr());
        this.zzie |= 1;
    }

    public final boolean zzfc() {
        return (this.zzie & 2) != 0;
    }

    public final zzda zzfd() {
        zzda zzda = this.zzli;
        return zzda == null ? zzda.zzfv() : zzda;
    }

    /* access modifiers changed from: private */
    public final void zza(zzda zzda) {
        if (zzda != null) {
            this.zzli = zzda;
            this.zzie |= 2;
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzfe() {
        return (this.zzie & 4) != 0;
    }

    public final zzci zzff() {
        zzci zzci = this.zzlj;
        return zzci == null ? zzci.zzev() : zzci;
    }

    /* access modifiers changed from: private */
    public final void zzd(zzci zzci) {
        if (zzci != null) {
            this.zzlj = zzci;
            this.zzie |= 4;
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzfg() {
        return (this.zzie & 8) != 0;
    }

    public final zzcd zzfh() {
        zzcd zzcd = this.zzlk;
        return zzcd == null ? zzcd.zzdy() : zzcd;
    }

    /* access modifiers changed from: private */
    public final void zza(zzcd zzcd) {
        if (zzcd != null) {
            this.zzlk = zzcd;
            this.zzie |= 8;
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzfi() {
        return (zza) zzll.zzhf();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzcp.zzid[i - 1]) {
            case 1:
                return new zzcn();
            case 2:
                return new zza((zzcp) null);
            case 3:
                return zza((zzga) zzll, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002\u0004\t\u0003", new Object[]{"zzie", "zzlh", "zzli", "zzlj", "zzlk"});
            case 4:
                return zzll;
            case 5:
                zzgk<zzcn> zzgk = zzij;
                if (zzgk == null) {
                    synchronized (zzcn.class) {
                        zzgk = zzij;
                        if (zzgk == null) {
                            zzgk = new zzep.zza<>(zzll);
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
        zzcn zzcn = new zzcn();
        zzll = zzcn;
        zzep.zza(zzcn.class, zzcn);
    }
}
