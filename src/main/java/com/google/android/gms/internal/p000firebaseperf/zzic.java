package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzep;
import com.j256.ormlite.stmt.query.SimpleComparison;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzic  reason: invalid package */
public final class zzic {

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzic$zza */
    public static final class zza extends zzep<zza, C0203zza> implements zzgc {
        private static volatile zzgk<zza> zzij;
        /* access modifiers changed from: private */
        public static final zza zzxa;
        private int zzie;
        private int zzwy = -1;
        private int zzwz;

        /* renamed from: com.google.android.gms.internal.firebase-perf.zzic$zza$zzb */
        public enum zzb implements zzeu {
            UNKNOWN_MOBILE_SUBTYPE(0),
            GPRS(1),
            EDGE(2),
            UMTS(3),
            CDMA(4),
            EVDO_0(5),
            EVDO_A(6),
            RTT(7),
            HSDPA(8),
            HSUPA(9),
            HSPA(10),
            IDEN(11),
            EVDO_B(12),
            LTE(13),
            EHRPD(14),
            HSPAP(15),
            GSM(16),
            TD_SCDMA(17),
            IWLAN(18),
            LTE_CA(19),
            COMBINED(100);
            
            private static final zzet<zzb> zzja = null;
            private final int value;

            public final int zzdj() {
                return this.value;
            }

            public static zzew zzdk() {
                return zzie.zzjf;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private zzb(int i) {
                this.value = i;
            }

            static {
                zzja = new zzid();
            }
        }

        /* renamed from: com.google.android.gms.internal.firebase-perf.zzic$zza$zzc */
        public enum zzc implements zzeu {
            NONE(-1),
            MOBILE(0),
            WIFI(1),
            MOBILE_MMS(2),
            MOBILE_SUPL(3),
            MOBILE_DUN(4),
            MOBILE_HIPRI(5),
            WIMAX(6),
            BLUETOOTH(7),
            DUMMY(8),
            ETHERNET(9),
            MOBILE_FOTA(10),
            MOBILE_IMS(11),
            MOBILE_CBS(12),
            WIFI_P2P(13),
            MOBILE_IA(14),
            MOBILE_EMERGENCY(15),
            PROXY(16),
            VPN(17);
            
            private static final zzet<zzc> zzja = null;
            private final int value;

            public final int zzdj() {
                return this.value;
            }

            public static zzew zzdk() {
                return zzif.zzjf;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private zzc(int i) {
                this.value = i;
            }

            static {
                zzja = new zzig();
            }
        }

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.firebase-perf.zzic$zza$zza  reason: collision with other inner class name */
        public static final class C0203zza extends zzep.zzb<zza, C0203zza> implements zzgc {
            private C0203zza() {
                super(zza.zzxa);
            }

            /* synthetic */ C0203zza(zzib zzib) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzib.zzid[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0203zza((zzib) null);
                case 3:
                    return zza((zzga) zzxa, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001", new Object[]{"zzie", "zzwy", zzc.zzdk(), "zzwz", zzb.zzdk()});
                case 4:
                    return zzxa;
                case 5:
                    zzgk<zza> zzgk = zzij;
                    if (zzgk == null) {
                        synchronized (zza.class) {
                            zzgk = zzij;
                            if (zzgk == null) {
                                zzgk = new zzep.zza<>(zzxa);
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
            zza zza = new zza();
            zzxa = zza;
            zzep.zza(zza.class, zza);
        }
    }
}
