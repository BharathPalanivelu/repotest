package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzep;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzda  reason: invalid package */
public final class zzda extends zzep<zzda, zzb> implements zzgc {
    private static volatile zzgk<zzda> zzij;
    /* access modifiers changed from: private */
    public static final zzda zzmc;
    private int zzie;
    private zzfu<String, String> zzit = zzfu.zzid();
    private long zzkn;
    private zzex<zzcr> zzkr = zzhj();
    private String zzlx = "";
    private boolean zzly;
    private long zzlz;
    private zzfu<String, Long> zzma = zzfu.zzid();
    private zzex<zzda> zzmb = zzhj();

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzda$zza */
    static final class zza {
        static final zzfs<String, Long> zziv = zzfs.zza(zzht.STRING, "", zzht.INT64, 0L);
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzda$zzc */
    static final class zzc {
        static final zzfs<String, String> zziv = zzfs.zza(zzht.STRING, "", zzht.STRING, "");
    }

    private zzda() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzda$zzb */
    public static final class zzb extends zzep.zzb<zzda, zzb> implements zzgc {
        private zzb() {
            super(zzda.zzmc);
        }

        public final zzb zzae(String str) {
            zzhn();
            ((zzda) this.zzqq).setName(str);
            return this;
        }

        public final zzb zzak(long j) {
            zzhn();
            ((zzda) this.zzqq).zzz(j);
            return this;
        }

        public final zzb zzal(long j) {
            zzhn();
            ((zzda) this.zzqq).zzaj(j);
            return this;
        }

        public final zzb zzd(String str, long j) {
            if (str != null) {
                zzhn();
                ((zzda) this.zzqq).zzfp().put(str, Long.valueOf(j));
                return this;
            }
            throw new NullPointerException();
        }

        public final zzb zze(Map<String, Long> map) {
            zzhn();
            ((zzda) this.zzqq).zzfp().putAll(map);
            return this;
        }

        public final zzb zzg(zzda zzda) {
            zzhn();
            ((zzda) this.zzqq).zzc(zzda);
            return this;
        }

        public final zzb zze(Iterable<? extends zzda> iterable) {
            zzhn();
            ((zzda) this.zzqq).zzd(iterable);
            return this;
        }

        public final zzb zzf(Map<String, String> map) {
            zzhn();
            ((zzda) this.zzqq).zzdf().putAll(map);
            return this;
        }

        public final zzb zzb(zzcr zzcr) {
            zzhn();
            ((zzda) this.zzqq).zza(zzcr);
            return this;
        }

        public final zzb zzf(Iterable<? extends zzcr> iterable) {
            zzhn();
            ((zzda) this.zzqq).zzb(iterable);
            return this;
        }

        public final zzb zzfx() {
            zzhn();
            ((zzda) this.zzqq).zzet();
            return this;
        }

        /* synthetic */ zzb(zzcz zzcz) {
            this();
        }
    }

    public final String getName() {
        return this.zzlx;
    }

    /* access modifiers changed from: private */
    public final void setName(String str) {
        if (str != null) {
            this.zzie |= 1;
            this.zzlx = str;
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzek() {
        return (this.zzie & 4) != 0;
    }

    /* access modifiers changed from: private */
    public final void zzz(long j) {
        this.zzie |= 4;
        this.zzkn = j;
    }

    public final long getDurationUs() {
        return this.zzlz;
    }

    /* access modifiers changed from: private */
    public final void zzaj(long j) {
        this.zzie |= 8;
        this.zzlz = j;
    }

    public final int zzfn() {
        return this.zzma.size();
    }

    public final Map<String, Long> zzfo() {
        return Collections.unmodifiableMap(this.zzma);
    }

    /* access modifiers changed from: private */
    public final Map<String, Long> zzfp() {
        if (!this.zzma.isMutable()) {
            this.zzma = this.zzma.zzie();
        }
        return this.zzma;
    }

    public final List<zzda> zzfq() {
        return this.zzmb;
    }

    private final void zzfr() {
        if (!this.zzmb.zzge()) {
            this.zzmb = zzep.zza(this.zzmb);
        }
    }

    /* access modifiers changed from: private */
    public final void zzc(zzda zzda) {
        if (zzda != null) {
            zzfr();
            this.zzmb.add(zzda);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void zzd(Iterable<? extends zzda> iterable) {
        zzfr();
        zzdg.zza(iterable, this.zzmb);
    }

    public final Map<String, String> zzfs() {
        return Collections.unmodifiableMap(this.zzit);
    }

    /* access modifiers changed from: private */
    public final Map<String, String> zzdf() {
        if (!this.zzit.isMutable()) {
            this.zzit = this.zzit.zzie();
        }
        return this.zzit;
    }

    public final List<zzcr> zzes() {
        return this.zzkr;
    }

    private final void zzft() {
        if (!this.zzkr.zzge()) {
            this.zzkr = zzep.zza(this.zzkr);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zzcr zzcr) {
        if (zzcr != null) {
            zzft();
            this.zzkr.add(zzcr);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void zzb(Iterable<? extends zzcr> iterable) {
        zzft();
        zzdg.zza(iterable, this.zzkr);
    }

    /* access modifiers changed from: private */
    public final void zzet() {
        this.zzkr = zzhj();
    }

    public static zzb zzfu() {
        return (zzb) zzmc.zzhf();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzcz.zzid[i - 1]) {
            case 1:
                return new zzda();
            case 2:
                return new zzb((zzcz) null);
            case 3:
                return zza((zzga) zzmc, "\u0001\b\u0000\u0001\u0001\t\b\u0002\u0002\u0000\u0001\b\u0000\u0002\u0007\u0001\u0004\u0002\u0002\u0005\u0002\u0003\u00062\u0007\u001b\b2\t\u001b", new Object[]{"zzie", "zzlx", "zzly", "zzkn", "zzlz", "zzma", zza.zziv, "zzmb", zzda.class, "zzit", zzc.zziv, "zzkr", zzcr.class});
            case 4:
                return zzmc;
            case 5:
                zzgk<zzda> zzgk = zzij;
                if (zzgk == null) {
                    synchronized (zzda.class) {
                        zzgk = zzij;
                        if (zzgk == null) {
                            zzgk = new zzep.zza<>(zzmc);
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

    public static zzda zzfv() {
        return zzmc;
    }

    static {
        zzda zzda = new zzda();
        zzmc = zzda;
        zzep.zza(zzda.class, zzda);
    }
}
