package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.zzdo;

public final class zzhc {

    public static final class zza extends zzdo<zza, C0209zza> implements zzez {
        private static volatile zzfh<zza> zzbc;
        /* access modifiers changed from: private */
        public static final zza zzrr = new zza();
        private int zzbd;
        private String zzqi = "";
        private zzc zzrq;

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.icing.zzhc$zza$zza  reason: collision with other inner class name */
        public static final class C0209zza extends zzdo.zzb<zza, C0209zza> implements zzez {
            private C0209zza() {
                super(zza.zzrr);
            }

            public final C0209zza zzu(String str) {
                zzbt();
                ((zza) this.zzjy).setName(str);
                return this;
            }

            public final C0209zza zzb(zzc zzc) {
                zzbt();
                ((zza) this.zzjy).zza(zzc);
                return this;
            }

            /* synthetic */ C0209zza(zzhe zzhe) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void setName(String str) {
            if (str != null) {
                this.zzbd |= 1;
                this.zzqi = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzc zzc) {
            if (zzc != null) {
                this.zzrq = zzc;
                this.zzbd |= 2;
                return;
            }
            throw new NullPointerException();
        }

        public static C0209zza zzed() {
            return (C0209zza) zzrr.zzbk();
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.icing.zzdo$zza, com.google.android.gms.internal.icing.zzfh<com.google.android.gms.internal.icing.zzhc$zza>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzfh<zza> zzfh;
            switch (zzhe.zzaz[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0209zza((zzhe) null);
                case 3:
                    return zza((zzex) zzrr, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\t\u0001", new Object[]{"zzbd", "zzqi", "zzrq"});
                case 4:
                    return zzrr;
                case 5:
                    zzfh<zza> zzfh2 = zzbc;
                    zzfh<zza> zzfh3 = zzfh2;
                    if (zzfh2 == null) {
                        synchronized (zza.class) {
                            zzfh<zza> zzfh4 = zzbc;
                            zzfh = zzfh4;
                            if (zzfh4 == null) {
                                ? zza = new zzdo.zza(zzrr);
                                zzbc = zza;
                                zzfh = zza;
                            }
                        }
                        zzfh3 = zzfh;
                    }
                    return zzfh3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzdo.zza(zza.class, zzrr);
        }
    }

    public static final class zzb extends zzdo<zzb, zza> implements zzez {
        private static volatile zzfh<zzb> zzbc;
        /* access modifiers changed from: private */
        public static final zzb zzrt = new zzb();
        private int zzbd;
        private String zzqq = "";
        private zzdx<zza> zzrs = zzbp();

        private zzb() {
        }

        public static final class zza extends zzdo.zzb<zzb, zza> implements zzez {
            private zza() {
                super(zzb.zzrt);
            }

            public final zza zzw(String str) {
                zzbt();
                ((zzb) this.zzjy).zzt(str);
                return this;
            }

            public final zza zzb(zza zza) {
                zzbt();
                ((zzb) this.zzjy).zza(zza);
                return this;
            }

            /* synthetic */ zza(zzhe zzhe) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzt(String str) {
            if (str != null) {
                this.zzbd |= 1;
                this.zzqq = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zza zza2) {
            if (zza2 != null) {
                if (!this.zzrs.zzag()) {
                    this.zzrs = zzdo.zza(this.zzrs);
                }
                this.zzrs.add(zza2);
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzef() {
            return (zza) zzrt.zzbk();
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.icing.zzdo$zza, com.google.android.gms.internal.icing.zzfh<com.google.android.gms.internal.icing.zzhc$zzb>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzfh<zzb> zzfh;
            switch (zzhe.zzaz[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzhe) null);
                case 3:
                    return zza((zzex) zzrt, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\b\u0000\u0002\u001b", new Object[]{"zzbd", "zzqq", "zzrs", zza.class});
                case 4:
                    return zzrt;
                case 5:
                    zzfh<zzb> zzfh2 = zzbc;
                    zzfh<zzb> zzfh3 = zzfh2;
                    if (zzfh2 == null) {
                        synchronized (zzb.class) {
                            zzfh<zzb> zzfh4 = zzbc;
                            zzfh = zzfh4;
                            if (zzfh4 == null) {
                                ? zza2 = new zzdo.zza(zzrt);
                                zzbc = zza2;
                                zzfh = zza2;
                            }
                        }
                        zzfh3 = zzfh;
                    }
                    return zzfh3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzdo.zza(zzb.class, zzrt);
        }
    }

    public static final class zzc extends zzdo<zzc, zza> implements zzez {
        private static volatile zzfh<zzc> zzbc;
        /* access modifiers changed from: private */
        public static final zzc zzrz = new zzc();
        private int zzbd;
        private boolean zzru;
        private String zzrv = "";
        private long zzrw;
        private double zzrx;
        private zzb zzry;

        private zzc() {
        }

        public static final class zza extends zzdo.zzb<zzc, zza> implements zzez {
            private zza() {
                super(zzc.zzrz);
            }

            public final zza zzj(boolean z) {
                zzbt();
                ((zzc) this.zzjy).zzi(z);
                return this;
            }

            public final zza zzx(String str) {
                zzbt();
                ((zzc) this.zzjy).zzv(str);
                return this;
            }

            public final zza zzb(zzb zzb) {
                zzbt();
                ((zzc) this.zzjy).zza(zzb);
                return this;
            }

            /* synthetic */ zza(zzhe zzhe) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzi(boolean z) {
            this.zzbd |= 1;
            this.zzru = z;
        }

        /* access modifiers changed from: private */
        public final void zzv(String str) {
            if (str != null) {
                this.zzbd |= 2;
                this.zzrv = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzb zzb) {
            if (zzb != null) {
                this.zzry = zzb;
                this.zzbd |= 16;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzeh() {
            return (zza) zzrz.zzbk();
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.icing.zzdo$zza, com.google.android.gms.internal.icing.zzfh<com.google.android.gms.internal.icing.zzhc$zzc>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzfh<zzc> zzfh;
            switch (zzhe.zzaz[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzhe) null);
                case 3:
                    return zza((zzex) zzrz, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0007\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0000\u0003\u0005\t\u0004", new Object[]{"zzbd", "zzru", "zzrv", "zzrw", "zzrx", "zzry"});
                case 4:
                    return zzrz;
                case 5:
                    zzfh<zzc> zzfh2 = zzbc;
                    zzfh<zzc> zzfh3 = zzfh2;
                    if (zzfh2 == null) {
                        synchronized (zzc.class) {
                            zzfh<zzc> zzfh4 = zzbc;
                            zzfh = zzfh4;
                            if (zzfh4 == null) {
                                ? zza2 = new zzdo.zza(zzrz);
                                zzbc = zza2;
                                zzfh = zza2;
                            }
                        }
                        zzfh3 = zzfh;
                    }
                    return zzfh3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzdo.zza(zzc.class, zzrz);
        }
    }
}
