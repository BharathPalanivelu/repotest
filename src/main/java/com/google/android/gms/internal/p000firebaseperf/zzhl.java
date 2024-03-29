package com.google.android.gms.internal.p000firebaseperf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzhl  reason: invalid package */
final class zzhl {
    private static final Logger logger = Logger.getLogger(zzhl.class.getName());
    private static final Class<?> zzmq = zzdj.zzgd();
    private static final boolean zznh = zzjm();
    private static final Unsafe zzte = zzjl();
    private static final boolean zzuw = zzj(Long.TYPE);
    private static final boolean zzux = zzj(Integer.TYPE);
    private static final zzd zzuy;
    private static final boolean zzuz = zzjn();
    private static final long zzva = ((long) zzh(byte[].class));
    private static final long zzvb = ((long) zzh(boolean[].class));
    private static final long zzvc = ((long) zzi(boolean[].class));
    private static final long zzvd = ((long) zzh(int[].class));
    private static final long zzve = ((long) zzi(int[].class));
    private static final long zzvf = ((long) zzh(long[].class));
    private static final long zzvg = ((long) zzi(long[].class));
    private static final long zzvh = ((long) zzh(float[].class));
    private static final long zzvi = ((long) zzi(float[].class));
    private static final long zzvj = ((long) zzh(double[].class));
    private static final long zzvk = ((long) zzi(double[].class));
    private static final long zzvl = ((long) zzh(Object[].class));
    private static final long zzvm = ((long) zzi(Object[].class));
    private static final long zzvn;
    private static final int zzvo = ((int) (zzva & 7));
    static final boolean zzvp = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);

    private zzhl() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzhl$zza */
    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzx(Object obj, long j) {
            if (zzhl.zzvp) {
                return zzhl.zzp(obj, j);
            }
            return zzhl.zzq(obj, j);
        }

        public final void zze(Object obj, long j, byte b2) {
            if (zzhl.zzvp) {
                zzhl.zza(obj, j, b2);
            } else {
                zzhl.zzb(obj, j, b2);
            }
        }

        public final boolean zzl(Object obj, long j) {
            if (zzhl.zzvp) {
                return zzhl.zzr(obj, j);
            }
            return zzhl.zzs(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzhl.zzvp) {
                zzhl.zzb(obj, j, z);
            } else {
                zzhl.zzc(obj, j, z);
            }
        }

        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        public final void zza(Object obj, long j, float f2) {
            zza(obj, j, Float.floatToIntBits(f2));
        }

        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        public final void zza(Object obj, long j, double d2) {
            zza(obj, j, Double.doubleToLongBits(d2));
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzhl$zzb */
    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzx(Object obj, long j) {
            return this.zzvs.getByte(obj, j);
        }

        public final void zze(Object obj, long j, byte b2) {
            this.zzvs.putByte(obj, j, b2);
        }

        public final boolean zzl(Object obj, long j) {
            return this.zzvs.getBoolean(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzvs.putBoolean(obj, j, z);
        }

        public final float zzm(Object obj, long j) {
            return this.zzvs.getFloat(obj, j);
        }

        public final void zza(Object obj, long j, float f2) {
            this.zzvs.putFloat(obj, j, f2);
        }

        public final double zzn(Object obj, long j) {
            return this.zzvs.getDouble(obj, j);
        }

        public final void zza(Object obj, long j, double d2) {
            this.zzvs.putDouble(obj, j, d2);
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzhl$zzc */
    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzx(Object obj, long j) {
            if (zzhl.zzvp) {
                return zzhl.zzp(obj, j);
            }
            return zzhl.zzq(obj, j);
        }

        public final void zze(Object obj, long j, byte b2) {
            if (zzhl.zzvp) {
                zzhl.zza(obj, j, b2);
            } else {
                zzhl.zzb(obj, j, b2);
            }
        }

        public final boolean zzl(Object obj, long j) {
            if (zzhl.zzvp) {
                return zzhl.zzr(obj, j);
            }
            return zzhl.zzs(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzhl.zzvp) {
                zzhl.zzb(obj, j, z);
            } else {
                zzhl.zzc(obj, j, z);
            }
        }

        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        public final void zza(Object obj, long j, float f2) {
            zza(obj, j, Float.floatToIntBits(f2));
        }

        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        public final void zza(Object obj, long j, double d2) {
            zza(obj, j, Double.doubleToLongBits(d2));
        }
    }

    static boolean zzjj() {
        return zznh;
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzhl$zzd */
    static abstract class zzd {
        Unsafe zzvs;

        zzd(Unsafe unsafe) {
            this.zzvs = unsafe;
        }

        public abstract void zza(Object obj, long j, double d2);

        public abstract void zza(Object obj, long j, float f2);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zze(Object obj, long j, byte b2);

        public abstract boolean zzl(Object obj, long j);

        public abstract float zzm(Object obj, long j);

        public abstract double zzn(Object obj, long j);

        public abstract byte zzx(Object obj, long j);

        public final int zzj(Object obj, long j) {
            return this.zzvs.getInt(obj, j);
        }

        public final void zza(Object obj, long j, int i) {
            this.zzvs.putInt(obj, j, i);
        }

        public final long zzk(Object obj, long j) {
            return this.zzvs.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzvs.putLong(obj, j, j2);
        }
    }

    static boolean zzjk() {
        return zzuz;
    }

    static <T> T zzg(Class<T> cls) {
        try {
            return zzte.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int zzh(Class<?> cls) {
        if (zznh) {
            return zzuy.zzvs.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzi(Class<?> cls) {
        if (zznh) {
            return zzuy.zzvs.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzj(Object obj, long j) {
        return zzuy.zzj(obj, j);
    }

    static void zza(Object obj, long j, int i) {
        zzuy.zza(obj, j, i);
    }

    static long zzk(Object obj, long j) {
        return zzuy.zzk(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzuy.zza(obj, j, j2);
    }

    static boolean zzl(Object obj, long j) {
        return zzuy.zzl(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzuy.zza(obj, j, z);
    }

    static float zzm(Object obj, long j) {
        return zzuy.zzm(obj, j);
    }

    static void zza(Object obj, long j, float f2) {
        zzuy.zza(obj, j, f2);
    }

    static double zzn(Object obj, long j) {
        return zzuy.zzn(obj, j);
    }

    static void zza(Object obj, long j, double d2) {
        zzuy.zza(obj, j, d2);
    }

    static Object zzo(Object obj, long j) {
        return zzuy.zzvs.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzuy.zzvs.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzuy.zzx(bArr, zzva + j);
    }

    static void zza(byte[] bArr, long j, byte b2) {
        zzuy.zze(bArr, zzva + j, b2);
    }

    static Unsafe zzjl() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzhn());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzjm() {
        Unsafe unsafe = zzte;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (zzdj.zzgc()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzjn() {
        Unsafe unsafe = zzte;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (zzjo() == null) {
                return false;
            }
            if (zzdj.zzgc()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzj(Class<?> cls) {
        if (!zzdj.zzgc()) {
            return false;
        }
        try {
            Class<?> cls2 = zzmq;
            cls2.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls2.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls2.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls2.getMethod("peekByte", new Class[]{cls});
            cls2.getMethod("pokeByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            cls2.getMethod("peekByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field zzjo() {
        if (zzdj.zzgc()) {
            Field zzb2 = zzb(Buffer.class, "effectiveDirectAddress");
            if (zzb2 != null) {
                return zzb2;
            }
        }
        Field zzb3 = zzb(Buffer.class, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static byte zzp(Object obj, long j) {
        return (byte) (zzj(obj, -4 & j) >>> ((int) (((j ^ -1) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzj(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b2) {
        long j2 = -4 & j;
        int i = ((((int) j) ^ -1) & 3) << 3;
        zza(obj, j2, ((255 & b2) << i) | (zzj(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b2) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b2) << i) | (zzj(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    public static boolean zzr(Object obj, long j) {
        return zzp(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00fe  */
    static {
        /*
            java.lang.Class<com.google.android.gms.internal.firebase-perf.zzhl> r0 = com.google.android.gms.internal.p000firebaseperf.zzhl.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            logger = r0
            sun.misc.Unsafe r0 = zzjl()
            zzte = r0
            java.lang.Class r0 = com.google.android.gms.internal.p000firebaseperf.zzdj.zzgd()
            zzmq = r0
            java.lang.Class r0 = java.lang.Long.TYPE
            boolean r0 = zzj(r0)
            zzuw = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            boolean r0 = zzj(r0)
            zzux = r0
            sun.misc.Unsafe r0 = zzte
            r1 = 0
            if (r0 != 0) goto L_0x002e
            goto L_0x0053
        L_0x002e:
            boolean r0 = com.google.android.gms.internal.p000firebaseperf.zzdj.zzgc()
            if (r0 == 0) goto L_0x004c
            boolean r0 = zzuw
            if (r0 == 0) goto L_0x0040
            com.google.android.gms.internal.firebase-perf.zzhl$zzc r1 = new com.google.android.gms.internal.firebase-perf.zzhl$zzc
            sun.misc.Unsafe r0 = zzte
            r1.<init>(r0)
            goto L_0x0053
        L_0x0040:
            boolean r0 = zzux
            if (r0 == 0) goto L_0x0053
            com.google.android.gms.internal.firebase-perf.zzhl$zza r1 = new com.google.android.gms.internal.firebase-perf.zzhl$zza
            sun.misc.Unsafe r0 = zzte
            r1.<init>(r0)
            goto L_0x0053
        L_0x004c:
            com.google.android.gms.internal.firebase-perf.zzhl$zzb r1 = new com.google.android.gms.internal.firebase-perf.zzhl$zzb
            sun.misc.Unsafe r0 = zzte
            r1.<init>(r0)
        L_0x0053:
            zzuy = r1
            boolean r0 = zzjn()
            zzuz = r0
            boolean r0 = zzjm()
            zznh = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzva = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzvb = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzvc = r0
            java.lang.Class<int[]> r0 = int[].class
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzvd = r0
            java.lang.Class<int[]> r0 = int[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzve = r0
            java.lang.Class<long[]> r0 = long[].class
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzvf = r0
            java.lang.Class<long[]> r0 = long[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzvg = r0
            java.lang.Class<float[]> r0 = float[].class
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzvh = r0
            java.lang.Class<float[]> r0 = float[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzvi = r0
            java.lang.Class<double[]> r0 = double[].class
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzvj = r0
            java.lang.Class<double[]> r0 = double[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzvk = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzvl = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzvm = r0
            java.lang.reflect.Field r0 = zzjo()
            if (r0 == 0) goto L_0x00e8
            com.google.android.gms.internal.firebase-perf.zzhl$zzd r1 = zzuy
            if (r1 != 0) goto L_0x00e1
            goto L_0x00e8
        L_0x00e1:
            sun.misc.Unsafe r1 = r1.zzvs
            long r0 = r1.objectFieldOffset(r0)
            goto L_0x00ea
        L_0x00e8:
            r0 = -1
        L_0x00ea:
            zzvn = r0
            long r0 = zzva
            r2 = 7
            long r0 = r0 & r2
            int r1 = (int) r0
            zzvo = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x00fe
            r0 = 1
            goto L_0x00ff
        L_0x00fe:
            r0 = 0
        L_0x00ff:
            zzvp = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000firebaseperf.zzhl.<clinit>():void");
    }
}
