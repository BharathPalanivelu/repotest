package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzep;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzci  reason: invalid package */
public final class zzci extends zzep<zzci, zza> implements zzgc {
    private static volatile zzgk<zzci> zzij;
    /* access modifiers changed from: private */
    public static final zzci zzks;
    private int zzie;
    private zzfu<String, String> zzit = zzfu.zzid();
    private String zzkg = "";
    private int zzkh;
    private long zzki;
    private long zzkj;
    private int zzkk;
    private int zzkl;
    private String zzkm = "";
    private long zzkn;
    private long zzko;
    private long zzkp;
    private long zzkq;
    private zzex<zzcr> zzkr = zzhj();

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzci$zzb */
    public enum zzb implements zzeu {
        HTTP_METHOD_UNKNOWN(0),
        GET(1),
        PUT(2),
        POST(3),
        DELETE(4),
        HEAD(5),
        PATCH(6),
        OPTIONS(7),
        TRACE(8),
        CONNECT(9);
        
        private static final zzet<zzb> zzja = null;
        private final int value;

        public final int zzdj() {
            return this.value;
        }

        public static zzb zzm(int i) {
            switch (i) {
                case 0:
                    return HTTP_METHOD_UNKNOWN;
                case 1:
                    return GET;
                case 2:
                    return PUT;
                case 3:
                    return POST;
                case 4:
                    return DELETE;
                case 5:
                    return HEAD;
                case 6:
                    return PATCH;
                case 7:
                    return OPTIONS;
                case 8:
                    return TRACE;
                case 9:
                    return CONNECT;
                default:
                    return null;
            }
        }

        public static zzew zzdk() {
            return zzck.zzjf;
        }

        public final String toString() {
            return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
        }

        private zzb(int i) {
            this.value = i;
        }

        static {
            zzja = new zzcl();
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzci$zzc */
    static final class zzc {
        static final zzfs<String, String> zziv = zzfs.zza(zzht.STRING, "", zzht.STRING, "");
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzci$zzd */
    public enum zzd implements zzeu {
        NETWORK_CLIENT_ERROR_REASON_UNKNOWN(0),
        GENERIC_CLIENT_ERROR(1);
        
        private static final zzet<zzd> zzja = null;
        private final int value;

        public final int zzdj() {
            return this.value;
        }

        public static zzew zzdk() {
            return zzco.zzjf;
        }

        public final String toString() {
            return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
        }

        private zzd(int i) {
            this.value = i;
        }

        static {
            zzja = new zzcm();
        }
    }

    private zzci() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzci$zza */
    public static final class zza extends zzep.zzb<zzci, zza> implements zzgc {
        private zza() {
            super(zzci.zzks);
        }

        public final zza zzab(String str) {
            zzhn();
            ((zzci) this.zzqq).setUrl(str);
            return this;
        }

        public final zza zzb(zzb zzb) {
            zzhn();
            ((zzci) this.zzqq).zza(zzb);
            return this;
        }

        public final zza zzad(long j) {
            zzhn();
            ((zzci) this.zzqq).zzx(j);
            return this;
        }

        public final zza zzae(long j) {
            zzhn();
            ((zzci) this.zzqq).zzy(j);
            return this;
        }

        public final zza zzb(zzd zzd) {
            zzhn();
            ((zzci) this.zzqq).zza(zzd);
            return this;
        }

        public final boolean zzaf() {
            return ((zzci) this.zzqq).zzaf();
        }

        public final zza zzl(int i) {
            zzhn();
            ((zzci) this.zzqq).setHttpResponseCode(i);
            return this;
        }

        public final zza zzac(String str) {
            zzhn();
            ((zzci) this.zzqq).setResponseContentType(str);
            return this;
        }

        public final zza zzex() {
            zzhn();
            ((zzci) this.zzqq).zzej();
            return this;
        }

        public final boolean zzek() {
            return ((zzci) this.zzqq).zzek();
        }

        public final zza zzaf(long j) {
            zzhn();
            ((zzci) this.zzqq).zzz(j);
            return this;
        }

        public final zza zzag(long j) {
            zzhn();
            ((zzci) this.zzqq).zzaa(j);
            return this;
        }

        public final long zzep() {
            return ((zzci) this.zzqq).zzep();
        }

        public final zza zzah(long j) {
            zzhn();
            ((zzci) this.zzqq).zzab(j);
            return this;
        }

        public final boolean zzeq() {
            return ((zzci) this.zzqq).zzeq();
        }

        public final zza zzai(long j) {
            zzhn();
            ((zzci) this.zzqq).zzac(j);
            return this;
        }

        public final zza zzey() {
            zzhn();
            ((zzci) this.zzqq).zzdf().clear();
            return this;
        }

        public final zza zzd(Map<String, String> map) {
            zzhn();
            ((zzci) this.zzqq).zzdf().putAll(map);
            return this;
        }

        public final zza zzc(Iterable<? extends zzcr> iterable) {
            zzhn();
            ((zzci) this.zzqq).zzb(iterable);
            return this;
        }

        public final zza zzez() {
            zzhn();
            ((zzci) this.zzqq).zzet();
            return this;
        }

        /* synthetic */ zza(zzcj zzcj) {
            this();
        }
    }

    public final String getUrl() {
        return this.zzkg;
    }

    /* access modifiers changed from: private */
    public final void setUrl(String str) {
        if (str != null) {
            this.zzie |= 1;
            this.zzkg = str;
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzec() {
        return (this.zzie & 2) != 0;
    }

    public final zzb zzed() {
        zzb zzm = zzb.zzm(this.zzkh);
        return zzm == null ? zzb.HTTP_METHOD_UNKNOWN : zzm;
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        if (zzb2 != null) {
            this.zzie |= 2;
            this.zzkh = zzb2.zzdj();
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzee() {
        return (this.zzie & 4) != 0;
    }

    public final long zzef() {
        return this.zzki;
    }

    /* access modifiers changed from: private */
    public final void zzx(long j) {
        this.zzie |= 4;
        this.zzki = j;
    }

    public final boolean zzeg() {
        return (this.zzie & 8) != 0;
    }

    public final long zzeh() {
        return this.zzkj;
    }

    /* access modifiers changed from: private */
    public final void zzy(long j) {
        this.zzie |= 8;
        this.zzkj = j;
    }

    /* access modifiers changed from: private */
    public final void zza(zzd zzd2) {
        if (zzd2 != null) {
            this.zzie |= 16;
            this.zzkk = zzd2.zzdj();
            return;
        }
        throw new NullPointerException();
    }

    public final boolean zzaf() {
        return (this.zzie & 32) != 0;
    }

    public final int zzei() {
        return this.zzkl;
    }

    /* access modifiers changed from: private */
    public final void setHttpResponseCode(int i) {
        this.zzie |= 32;
        this.zzkl = i;
    }

    /* access modifiers changed from: private */
    public final void setResponseContentType(String str) {
        if (str != null) {
            this.zzie |= 64;
            this.zzkm = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void zzej() {
        this.zzie &= -65;
        this.zzkm = zzks.zzkm;
    }

    public final boolean zzek() {
        return (this.zzie & 128) != 0;
    }

    public final long zzel() {
        return this.zzkn;
    }

    /* access modifiers changed from: private */
    public final void zzz(long j) {
        this.zzie |= 128;
        this.zzkn = j;
    }

    public final boolean zzem() {
        return (this.zzie & 256) != 0;
    }

    public final long zzen() {
        return this.zzko;
    }

    /* access modifiers changed from: private */
    public final void zzaa(long j) {
        this.zzie |= 256;
        this.zzko = j;
    }

    public final boolean zzeo() {
        return (this.zzie & 512) != 0;
    }

    public final long zzep() {
        return this.zzkp;
    }

    /* access modifiers changed from: private */
    public final void zzab(long j) {
        this.zzie |= 512;
        this.zzkp = j;
    }

    public final boolean zzeq() {
        return (this.zzie & 1024) != 0;
    }

    public final long zzer() {
        return this.zzkq;
    }

    /* access modifiers changed from: private */
    public final void zzac(long j) {
        this.zzie |= 1024;
        this.zzkq = j;
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

    /* access modifiers changed from: private */
    public final void zzb(Iterable<? extends zzcr> iterable) {
        if (!this.zzkr.zzge()) {
            this.zzkr = zzep.zza(this.zzkr);
        }
        zzdg.zza(iterable, this.zzkr);
    }

    /* access modifiers changed from: private */
    public final void zzet() {
        this.zzkr = zzhj();
    }

    public static zza zzeu() {
        return (zza) zzks.zzhf();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzcj.zzid[i - 1]) {
            case 1:
                return new zzci();
            case 2:
                return new zza((zzcj) null);
            case 3:
                return zza((zzga) zzks, "\u0001\r\u0000\u0001\u0001\r\r\u0001\u0001\u0000\u0001\b\u0000\u0002\f\u0001\u0003\u0002\u0002\u0004\u0002\u0003\u0005\u0004\u0005\u0006\b\u0006\u0007\u0002\u0007\b\u0002\b\t\u0002\t\n\u0002\n\u000b\f\u0004\f2\r\u001b", new Object[]{"zzie", "zzkg", "zzkh", zzb.zzdk(), "zzki", "zzkj", "zzkl", "zzkm", "zzkn", "zzko", "zzkp", "zzkq", "zzkk", zzd.zzdk(), "zzit", zzc.zziv, "zzkr", zzcr.class});
            case 4:
                return zzks;
            case 5:
                zzgk<zzci> zzgk = zzij;
                if (zzgk == null) {
                    synchronized (zzci.class) {
                        zzgk = zzij;
                        if (zzgk == null) {
                            zzgk = new zzep.zza<>(zzks);
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

    public static zzci zzev() {
        return zzks;
    }

    static {
        zzci zzci = new zzci();
        zzks = zzci;
        zzep.zza(zzci.class, zzci);
    }
}
