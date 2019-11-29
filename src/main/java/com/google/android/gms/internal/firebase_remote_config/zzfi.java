package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhi;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class zzfi {

    public static final class zza extends zzhi<zza, C0204zza> implements zzis {
        /* access modifiers changed from: private */
        public static final zza zzmk = new zza();
        private static volatile zziz<zza> zzml;
        private int zzmg;
        private zzhn<zzd> zzmh = zzgt();
        private long zzmi;
        private zzhn<zzfx> zzmj = zzgt();

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.firebase_remote_config.zzfi$zza$zza  reason: collision with other inner class name */
        public static final class C0204zza extends zzhi.zzb<zza, C0204zza> implements zzis {
            private C0204zza() {
                super(zza.zzmk);
            }

            /* synthetic */ C0204zza(zzfh zzfh) {
                this();
            }
        }

        public final List<zzd> zzdk() {
            return this.zzmh;
        }

        public final long getTimestamp() {
            return this.zzmi;
        }

        public final List<zzfx> zzdl() {
            return this.zzmj;
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzfi$zza>, com.google.android.gms.internal.firebase_remote_config.zzhi$zza] */
        /* access modifiers changed from: protected */
        public final Object zzb(int i, Object obj, Object obj2) {
            zziz<zza> zziz;
            switch (zzfh.zzmf[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0204zza((zzfh) null);
                case 3:
                    return zza((zziq) zzmk, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u001b\u0002\u0005\u0000\u0003\u001c", new Object[]{"zzmg", "zzmh", zzd.class, "zzmi", "zzmj"});
                case 4:
                    return zzmk;
                case 5:
                    zziz<zza> zziz2 = zzml;
                    zziz<zza> zziz3 = zziz2;
                    if (zziz2 == null) {
                        synchronized (zza.class) {
                            zziz<zza> zziz4 = zzml;
                            zziz = zziz4;
                            if (zziz4 == null) {
                                ? zza = new zzhi.zza(zzmk);
                                zzml = zza;
                                zziz = zza;
                            }
                        }
                        zziz3 = zziz;
                    }
                    return zziz3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zza zzdm() {
            return zzmk;
        }

        static {
            zzhi.zza(zza.class, zzmk);
        }
    }

    public static final class zzb extends zzhi<zzb, zza> implements zzis {
        private static volatile zziz<zzb> zzml;
        /* access modifiers changed from: private */
        public static final zzb zzmo = new zzb();
        private int zzmg;
        private String zzmm = "";
        private zzfx zzmn = zzfx.zzov;

        private zzb() {
        }

        public static final class zza extends zzhi.zzb<zzb, zza> implements zzis {
            private zza() {
                super(zzb.zzmo);
            }

            /* synthetic */ zza(zzfh zzfh) {
                this();
            }
        }

        public final String getKey() {
            return this.zzmm;
        }

        public final zzfx zzdo() {
            return this.zzmn;
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzfi$zzb>, com.google.android.gms.internal.firebase_remote_config.zzhi$zza] */
        /* access modifiers changed from: protected */
        public final Object zzb(int i, Object obj, Object obj2) {
            zziz<zzb> zziz;
            switch (zzfh.zzmf[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzfh) null);
                case 3:
                    return zza((zziq) zzmo, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\n\u0001", new Object[]{"zzmg", "zzmm", "zzmn"});
                case 4:
                    return zzmo;
                case 5:
                    zziz<zzb> zziz2 = zzml;
                    zziz<zzb> zziz3 = zziz2;
                    if (zziz2 == null) {
                        synchronized (zzb.class) {
                            zziz<zzb> zziz4 = zzml;
                            zziz = zziz4;
                            if (zziz4 == null) {
                                ? zza2 = new zzhi.zza(zzmo);
                                zzml = zza2;
                                zziz = zza2;
                            }
                        }
                        zziz3 = zziz;
                    }
                    return zziz3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzhi.zza(zzb.class, zzmo);
        }
    }

    public static final class zzc extends zzhi<zzc, zza> implements zzis {
        private static volatile zziz<zzc> zzml;
        /* access modifiers changed from: private */
        public static final zzc zzms = new zzc();
        private int zzmg;
        private int zzmp;
        private boolean zzmq;
        private long zzmr;

        private zzc() {
        }

        public static final class zza extends zzhi.zzb<zzc, zza> implements zzis {
            private zza() {
                super(zzc.zzms);
            }

            /* synthetic */ zza(zzfh zzfh) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzfi$zzc>, com.google.android.gms.internal.firebase_remote_config.zzhi$zza] */
        /* access modifiers changed from: protected */
        public final Object zzb(int i, Object obj, Object obj2) {
            zziz<zzc> zziz;
            switch (zzfh.zzmf[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzfh) null);
                case 3:
                    return zza((zziq) zzms, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0007\u0001\u0003\u0005\u0002", new Object[]{"zzmg", "zzmp", "zzmq", "zzmr"});
                case 4:
                    return zzms;
                case 5:
                    zziz<zzc> zziz2 = zzml;
                    zziz<zzc> zziz3 = zziz2;
                    if (zziz2 == null) {
                        synchronized (zzc.class) {
                            zziz<zzc> zziz4 = zzml;
                            zziz = zziz4;
                            if (zziz4 == null) {
                                ? zza2 = new zzhi.zza(zzms);
                                zzml = zza2;
                                zziz = zza2;
                            }
                        }
                        zziz3 = zziz;
                    }
                    return zziz3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzhi.zza(zzc.class, zzms);
        }
    }

    public static final class zzd extends zzhi<zzd, zza> implements zzis {
        private static volatile zziz<zzd> zzml;
        /* access modifiers changed from: private */
        public static final zzd zzmv = new zzd();
        private int zzmg;
        private String zzmt = "";
        private zzhn<zzb> zzmu = zzgt();

        private zzd() {
        }

        public static final class zza extends zzhi.zzb<zzd, zza> implements zzis {
            private zza() {
                super(zzd.zzmv);
            }

            /* synthetic */ zza(zzfh zzfh) {
                this();
            }
        }

        public final String getNamespace() {
            return this.zzmt;
        }

        public final List<zzb> zzdr() {
            return this.zzmu;
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzfi$zzd>, com.google.android.gms.internal.firebase_remote_config.zzhi$zza] */
        /* access modifiers changed from: protected */
        public final Object zzb(int i, Object obj, Object obj2) {
            zziz<zzd> zziz;
            switch (zzfh.zzmf[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza((zzfh) null);
                case 3:
                    return zza((zziq) zzmv, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\b\u0000\u0002\u001b", new Object[]{"zzmg", "zzmt", "zzmu", zzb.class});
                case 4:
                    return zzmv;
                case 5:
                    zziz<zzd> zziz2 = zzml;
                    zziz<zzd> zziz3 = zziz2;
                    if (zziz2 == null) {
                        synchronized (zzd.class) {
                            zziz<zzd> zziz4 = zzml;
                            zziz = zziz4;
                            if (zziz4 == null) {
                                ? zza2 = new zzhi.zza(zzmv);
                                zzml = zza2;
                                zziz = zza2;
                            }
                        }
                        zziz3 = zziz;
                    }
                    return zziz3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzhi.zza(zzd.class, zzmv);
        }
    }

    public static final class zze extends zzhi<zze, zza> implements zzis {
        private static volatile zziz<zze> zzml;
        /* access modifiers changed from: private */
        public static final zze zznb = new zze();
        private int zzmg;
        private zza zzmw;
        private zza zzmx;
        private zza zzmy;
        private zzc zzmz;
        private zzhn<zzf> zzna = zzgt();

        private zze() {
        }

        public static final class zza extends zzhi.zzb<zze, zza> implements zzis {
            private zza() {
                super(zze.zznb);
            }

            /* synthetic */ zza(zzfh zzfh) {
                this();
            }
        }

        public final zza zzdt() {
            zza zza2 = this.zzmw;
            return zza2 == null ? zza.zzdm() : zza2;
        }

        public final zza zzdu() {
            zza zza2 = this.zzmx;
            return zza2 == null ? zza.zzdm() : zza2;
        }

        public final zza zzdv() {
            zza zza2 = this.zzmy;
            return zza2 == null ? zza.zzdm() : zza2;
        }

        public static zze zzb(InputStream inputStream) throws IOException {
            return (zze) zzhi.zza(zznb, inputStream);
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzfi$zze>, com.google.android.gms.internal.firebase_remote_config.zzhi$zza] */
        /* access modifiers changed from: protected */
        public final Object zzb(int i, Object obj, Object obj2) {
            zziz<zze> zziz;
            switch (zzfh.zzmf[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((zzfh) null);
                case 3:
                    return zza((zziq) zznb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002\u0004\t\u0003\u0005\u001b", new Object[]{"zzmg", "zzmw", "zzmx", "zzmy", "zzmz", "zzna", zzf.class});
                case 4:
                    return zznb;
                case 5:
                    zziz<zze> zziz2 = zzml;
                    zziz<zze> zziz3 = zziz2;
                    if (zziz2 == null) {
                        synchronized (zze.class) {
                            zziz<zze> zziz4 = zzml;
                            zziz = zziz4;
                            if (zziz4 == null) {
                                ? zza2 = new zzhi.zza(zznb);
                                zzml = zza2;
                                zziz = zza2;
                            }
                        }
                        zziz3 = zziz;
                    }
                    return zziz3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzhi.zza(zze.class, zznb);
        }
    }

    public static final class zzf extends zzhi<zzf, zza> implements zzis {
        private static volatile zziz<zzf> zzml;
        /* access modifiers changed from: private */
        public static final zzf zzne = new zzf();
        private int zzmg;
        private String zzmt = "";
        private int zznc;
        private long zznd;

        private zzf() {
        }

        public static final class zza extends zzhi.zzb<zzf, zza> implements zzis {
            private zza() {
                super(zzf.zzne);
            }

            /* synthetic */ zza(zzfh zzfh) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase_remote_config.zzhi$zza, com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzfi$zzf>] */
        /* access modifiers changed from: protected */
        public final Object zzb(int i, Object obj, Object obj2) {
            zziz<zzf> zziz;
            switch (zzfh.zzmf[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((zzfh) null);
                case 3:
                    return zza((zziq) zzne, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0005\u0001\u0003\b\u0002", new Object[]{"zzmg", "zznc", "zznd", "zzmt"});
                case 4:
                    return zzne;
                case 5:
                    zziz<zzf> zziz2 = zzml;
                    zziz<zzf> zziz3 = zziz2;
                    if (zziz2 == null) {
                        synchronized (zzf.class) {
                            zziz<zzf> zziz4 = zzml;
                            zziz = zziz4;
                            if (zziz4 == null) {
                                ? zza2 = new zzhi.zza(zzne);
                                zzml = zza2;
                                zziz = zza2;
                            }
                        }
                        zziz3 = zziz;
                    }
                    return zziz3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzhi.zza(zzf.class, zzne);
        }
    }
}
