package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.zzdo;

public final class zzal {

    public static final class zza extends zzdo<zza, C0206zza> implements zzez {
        /* access modifiers changed from: private */
        public static final zza zzbb = new zza();
        private static volatile zzfh<zza> zzbc;
        private zzdx<zzb> zzba = zzbp();

        public static final class zzb extends zzdo<zzb, C0207zza> implements zzez {
            private static volatile zzfh<zzb> zzbc;
            /* access modifiers changed from: private */
            public static final zzb zzbh = new zzb();
            private int zzbd;
            private String zzbe = "";
            private String zzbf = "";
            private int zzbg;

            private zzb() {
            }

            /* renamed from: com.google.android.gms.internal.icing.zzal$zza$zzb$zza  reason: collision with other inner class name */
            public static final class C0207zza extends zzdo.zzb<zzb, C0207zza> implements zzez {
                private C0207zza() {
                    super(zzb.zzbh);
                }

                public final C0207zza zze(String str) {
                    zzbt();
                    ((zzb) this.zzjy).zzg(str);
                    return this;
                }

                public final C0207zza zzf(String str) {
                    zzbt();
                    ((zzb) this.zzjy).zzh(str);
                    return this;
                }

                public final C0207zza zzd(int i) {
                    zzbt();
                    ((zzb) this.zzjy).zze(i);
                    return this;
                }

                /* synthetic */ C0207zza(zzak zzak) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zzg(String str) {
                if (str != null) {
                    this.zzbd |= 1;
                    this.zzbe = str;
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public final void zzh(String str) {
                if (str != null) {
                    this.zzbd |= 2;
                    this.zzbf = str;
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public final void zze(int i) {
                this.zzbd |= 4;
                this.zzbg = i;
            }

            public static C0207zza zzh() {
                return (C0207zza) zzbh.zzbk();
            }

            /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.icing.zzdo$zza, com.google.android.gms.internal.icing.zzfh<com.google.android.gms.internal.icing.zzal$zza$zzb>] */
            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                zzfh<zzb> zzfh;
                switch (zzak.zzaz[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C0207zza((zzak) null);
                    case 3:
                        return zza((zzex) zzbh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0004\u0002", new Object[]{"zzbd", "zzbe", "zzbf", "zzbg"});
                    case 4:
                        return zzbh;
                    case 5:
                        zzfh<zzb> zzfh2 = zzbc;
                        zzfh<zzb> zzfh3 = zzfh2;
                        if (zzfh2 == null) {
                            synchronized (zzb.class) {
                                zzfh<zzb> zzfh4 = zzbc;
                                zzfh = zzfh4;
                                if (zzfh4 == null) {
                                    ? zza = new zzdo.zza(zzbh);
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
                zzdo.zza(zzb.class, zzbh);
            }
        }

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.icing.zzal$zza$zza  reason: collision with other inner class name */
        public static final class C0206zza extends zzdo.zzb<zza, C0206zza> implements zzez {
            private C0206zza() {
                super(zza.zzbb);
            }

            public final C0206zza zza(Iterable<? extends zzb> iterable) {
                zzbt();
                ((zza) this.zzjy).zzb(iterable);
                return this;
            }

            /* synthetic */ C0206zza(zzak zzak) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzb(Iterable<? extends zzb> iterable) {
            if (!this.zzba.zzag()) {
                this.zzba = zzdo.zza(this.zzba);
            }
            zzcd.zza(iterable, this.zzba);
        }

        public static C0206zza zzf() {
            return (C0206zza) zzbb.zzbk();
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.icing.zzdo$zza, com.google.android.gms.internal.icing.zzfh<com.google.android.gms.internal.icing.zzal$zza>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzfh<zza> zzfh;
            switch (zzak.zzaz[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0206zza((zzak) null);
                case 3:
                    return zza((zzex) zzbb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzba", zzb.class});
                case 4:
                    return zzbb;
                case 5:
                    zzfh<zza> zzfh2 = zzbc;
                    zzfh<zza> zzfh3 = zzfh2;
                    if (zzfh2 == null) {
                        synchronized (zza.class) {
                            zzfh<zza> zzfh4 = zzbc;
                            zzfh = zzfh4;
                            if (zzfh4 == null) {
                                ? zza = new zzdo.zza(zzbb);
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
            zzdo.zza(zza.class, zzbb);
        }
    }
}
