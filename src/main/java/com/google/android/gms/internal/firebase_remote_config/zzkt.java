package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhi;

public final class zzkt {

    public static final class zza extends zzhi<zza, C0205zza> implements zzis {
        private static volatile zziz<zza> zzml;
        /* access modifiers changed from: private */
        public static final zza zzzp = new zza();
        private String zzzo = "";

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.firebase_remote_config.zzkt$zza$zza  reason: collision with other inner class name */
        public static final class C0205zza extends zzhi.zzb<zza, C0205zza> implements zzis {
            private C0205zza() {
                super(zza.zzzp);
            }

            /* synthetic */ C0205zza(zzkv zzkv) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r1v13, types: [com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzkt$zza>, com.google.android.gms.internal.firebase_remote_config.zzhi$zza] */
        /* access modifiers changed from: protected */
        public final Object zzb(int i, Object obj, Object obj2) {
            zziz<zza> zziz;
            switch (zzkv.zzmf[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0205zza((zzkv) null);
                case 3:
                    return zza((zziq) zzzp, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzzo"});
                case 4:
                    return zzzp;
                case 5:
                    zziz<zza> zziz2 = zzml;
                    zziz<zza> zziz3 = zziz2;
                    if (zziz2 == null) {
                        synchronized (zza.class) {
                            zziz<zza> zziz4 = zzml;
                            zziz = zziz4;
                            if (zziz4 == null) {
                                ? zza = new zzhi.zza(zzzp);
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

        static {
            zzhi.zza(zza.class, zzzp);
        }
    }

    public static final class zzb extends zzhi<zzb, zza> implements zzis {
        /* access modifiers changed from: private */
        public static final zzb zzaac = new zzb();
        private static volatile zziz<zzb> zzml;
        private int zzaaa;
        private zzhn<zza> zzaab = zzgt();
        private String zzzo = "";
        private String zzzq = "";
        private long zzzr;
        private String zzzs = "";
        private long zzzt;
        private long zzzu;
        private String zzzv = "";
        private String zzzw = "";
        private String zzzx = "";
        private String zzzy = "";
        private String zzzz = "";

        private zzb() {
        }

        public static final class zza extends zzhi.zzb<zzb, zza> implements zzis {
            private zza() {
                super(zzb.zzaac);
            }

            /* synthetic */ zza(zzkv zzkv) {
                this();
            }
        }

        public final String zzjm() {
            return this.zzzo;
        }

        public final String zzjn() {
            return this.zzzq;
        }

        public final long zzjo() {
            return this.zzzr;
        }

        public final String zzjp() {
            return this.zzzs;
        }

        public final long zzjq() {
            return this.zzzt;
        }

        public final long zzjr() {
            return this.zzzu;
        }

        public static zzb zzg(byte[] bArr) throws zzhq {
            return (zzb) zzhi.zza(zzaac, bArr);
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzkt$zzb>, com.google.android.gms.internal.firebase_remote_config.zzhi$zza] */
        /* access modifiers changed from: protected */
        public final Object zzb(int i, Object obj, Object obj2) {
            zziz<zzb> zziz;
            switch (zzkv.zzmf[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzkv) null);
                case 3:
                    return zza((zziq) zzaac, "\u0000\r\u0000\u0000\u0001\r\r\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004Ȉ\u0005\u0002\u0006\u0002\u0007Ȉ\bȈ\tȈ\nȈ\u000bȈ\f\f\r\u001b", new Object[]{"zzzo", "zzzq", "zzzr", "zzzs", "zzzt", "zzzu", "zzzv", "zzzw", "zzzx", "zzzy", "zzzz", "zzaaa", "zzaab", zza.class});
                case 4:
                    return zzaac;
                case 5:
                    zziz<zzb> zziz2 = zzml;
                    zziz<zzb> zziz3 = zziz2;
                    if (zziz2 == null) {
                        synchronized (zzb.class) {
                            zziz<zzb> zziz4 = zzml;
                            zziz = zziz4;
                            if (zziz4 == null) {
                                ? zza2 = new zzhi.zza(zzaac);
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
            zzhi.zza(zzb.class, zzaac);
        }
    }
}
