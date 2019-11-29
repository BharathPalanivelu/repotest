package com.google.android.gms.internal.firebase_remote_config;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzkd {
    private static final Logger logger = Logger.getLogger(zzkd.class.getName());
    private static final Class<?> zzon = zzfu.zzev();
    private static final boolean zzpv = zzjg();
    private static final Unsafe zzvq = zzjf();
    private static final boolean zzxm = zzp(Long.TYPE);
    private static final boolean zzxn = zzp(Integer.TYPE);
    private static final zzd zzxo;
    private static final boolean zzxp = zzjh();
    private static final long zzxq = ((long) zzn(byte[].class));
    private static final long zzxr = ((long) zzn(boolean[].class));
    private static final long zzxs = ((long) zzo(boolean[].class));
    private static final long zzxt = ((long) zzn(int[].class));
    private static final long zzxu = ((long) zzo(int[].class));
    private static final long zzxv = ((long) zzn(long[].class));
    private static final long zzxw = ((long) zzo(long[].class));
    private static final long zzxx = ((long) zzn(float[].class));
    private static final long zzxy = ((long) zzo(float[].class));
    private static final long zzxz = ((long) zzn(double[].class));
    private static final long zzya = ((long) zzo(double[].class));
    private static final long zzyb = ((long) zzn(Object[].class));
    private static final long zzyc = ((long) zzo(Object[].class));
    private static final long zzyd;
    private static final int zzye = ((int) (zzxq & 7));
    static final boolean zzyf = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);

    private zzkd() {
    }

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            if (zzkd.zzyf) {
                return zzkd.zzq(obj, j);
            }
            return zzkd.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b2) {
            if (zzkd.zzyf) {
                zzkd.zza(obj, j, b2);
            } else {
                zzkd.zzb(obj, j, b2);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zzkd.zzyf) {
                return zzkd.zzs(obj, j);
            }
            return zzkd.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzkd.zzyf) {
                zzkd.zzb(obj, j, z);
            } else {
                zzkd.zzc(obj, j, z);
            }
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final void zza(Object obj, long j, float f2) {
            zzb(obj, j, Float.floatToIntBits(f2));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final void zza(Object obj, long j, double d2) {
            zza(obj, j, Double.doubleToLongBits(d2));
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            return this.zzyi.getByte(obj, j);
        }

        public final void zze(Object obj, long j, byte b2) {
            this.zzyi.putByte(obj, j, b2);
        }

        public final boolean zzm(Object obj, long j) {
            return this.zzyi.getBoolean(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzyi.putBoolean(obj, j, z);
        }

        public final float zzn(Object obj, long j) {
            return this.zzyi.getFloat(obj, j);
        }

        public final void zza(Object obj, long j, float f2) {
            this.zzyi.putFloat(obj, j, f2);
        }

        public final double zzo(Object obj, long j) {
            return this.zzyi.getDouble(obj, j);
        }

        public final void zza(Object obj, long j, double d2) {
            this.zzyi.putDouble(obj, j, d2);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            if (zzkd.zzyf) {
                return zzkd.zzq(obj, j);
            }
            return zzkd.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b2) {
            if (zzkd.zzyf) {
                zzkd.zza(obj, j, b2);
            } else {
                zzkd.zzb(obj, j, b2);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zzkd.zzyf) {
                return zzkd.zzs(obj, j);
            }
            return zzkd.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzkd.zzyf) {
                zzkd.zzb(obj, j, z);
            } else {
                zzkd.zzc(obj, j, z);
            }
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final void zza(Object obj, long j, float f2) {
            zzb(obj, j, Float.floatToIntBits(f2));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final void zza(Object obj, long j, double d2) {
            zza(obj, j, Double.doubleToLongBits(d2));
        }
    }

    static boolean zzjd() {
        return zzpv;
    }

    static abstract class zzd {
        Unsafe zzyi;

        zzd(Unsafe unsafe) {
            this.zzyi = unsafe;
        }

        public abstract void zza(Object obj, long j, double d2);

        public abstract void zza(Object obj, long j, float f2);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zze(Object obj, long j, byte b2);

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);

        public final int zzk(Object obj, long j) {
            return this.zzyi.getInt(obj, j);
        }

        public final void zzb(Object obj, long j, int i) {
            this.zzyi.putInt(obj, j, i);
        }

        public final long zzl(Object obj, long j) {
            return this.zzyi.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzyi.putLong(obj, j, j2);
        }
    }

    static boolean zzje() {
        return zzxp;
    }

    static <T> T zzm(Class<T> cls) {
        try {
            return zzvq.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int zzn(Class<?> cls) {
        if (zzpv) {
            return zzxo.zzyi.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzo(Class<?> cls) {
        if (zzpv) {
            return zzxo.zzyi.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzk(Object obj, long j) {
        return zzxo.zzk(obj, j);
    }

    static void zzb(Object obj, long j, int i) {
        zzxo.zzb(obj, j, i);
    }

    static long zzl(Object obj, long j) {
        return zzxo.zzl(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzxo.zza(obj, j, j2);
    }

    static boolean zzm(Object obj, long j) {
        return zzxo.zzm(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzxo.zza(obj, j, z);
    }

    static float zzn(Object obj, long j) {
        return zzxo.zzn(obj, j);
    }

    static void zza(Object obj, long j, float f2) {
        zzxo.zza(obj, j, f2);
    }

    static double zzo(Object obj, long j) {
        return zzxo.zzo(obj, j);
    }

    static void zza(Object obj, long j, double d2) {
        zzxo.zza(obj, j, d2);
    }

    static Object zzp(Object obj, long j) {
        return zzxo.zzyi.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzxo.zzyi.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzxo.zzy(bArr, zzxq + j);
    }

    static void zza(byte[] bArr, long j, byte b2) {
        zzxo.zze(bArr, zzxq + j, b2);
    }

    static Unsafe zzjf() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzkf());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzjg() {
        Unsafe unsafe = zzvq;
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
            if (zzfu.zzeu()) {
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

    private static boolean zzjh() {
        Unsafe unsafe = zzvq;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (zzji() == null) {
                return false;
            }
            if (zzfu.zzeu()) {
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

    private static boolean zzp(Class<?> cls) {
        if (!zzfu.zzeu()) {
            return false;
        }
        try {
            Class<?> cls2 = zzon;
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

    private static Field zzji() {
        if (zzfu.zzeu()) {
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
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) (((j ^ -1) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b2) {
        long j2 = -4 & j;
        int i = ((((int) j) ^ -1) & 3) << 3;
        zzb(obj, j2, ((255 & b2) << i) | (zzk(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b2) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zzb(obj, j2, ((255 & b2) << i) | (zzk(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
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
            java.lang.Class<com.google.android.gms.internal.firebase_remote_config.zzkd> r0 = com.google.android.gms.internal.firebase_remote_config.zzkd.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            logger = r0
            sun.misc.Unsafe r0 = zzjf()
            zzvq = r0
            java.lang.Class r0 = com.google.android.gms.internal.firebase_remote_config.zzfu.zzev()
            zzon = r0
            java.lang.Class r0 = java.lang.Long.TYPE
            boolean r0 = zzp(r0)
            zzxm = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            boolean r0 = zzp(r0)
            zzxn = r0
            sun.misc.Unsafe r0 = zzvq
            r1 = 0
            if (r0 != 0) goto L_0x002e
            goto L_0x0053
        L_0x002e:
            boolean r0 = com.google.android.gms.internal.firebase_remote_config.zzfu.zzeu()
            if (r0 == 0) goto L_0x004c
            boolean r0 = zzxm
            if (r0 == 0) goto L_0x0040
            com.google.android.gms.internal.firebase_remote_config.zzkd$zzc r1 = new com.google.android.gms.internal.firebase_remote_config.zzkd$zzc
            sun.misc.Unsafe r0 = zzvq
            r1.<init>(r0)
            goto L_0x0053
        L_0x0040:
            boolean r0 = zzxn
            if (r0 == 0) goto L_0x0053
            com.google.android.gms.internal.firebase_remote_config.zzkd$zza r1 = new com.google.android.gms.internal.firebase_remote_config.zzkd$zza
            sun.misc.Unsafe r0 = zzvq
            r1.<init>(r0)
            goto L_0x0053
        L_0x004c:
            com.google.android.gms.internal.firebase_remote_config.zzkd$zzb r1 = new com.google.android.gms.internal.firebase_remote_config.zzkd$zzb
            sun.misc.Unsafe r0 = zzvq
            r1.<init>(r0)
        L_0x0053:
            zzxo = r1
            boolean r0 = zzjh()
            zzxp = r0
            boolean r0 = zzjg()
            zzpv = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = zzn(r0)
            long r0 = (long) r0
            zzxq = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = zzn(r0)
            long r0 = (long) r0
            zzxr = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = zzo(r0)
            long r0 = (long) r0
            zzxs = r0
            java.lang.Class<int[]> r0 = int[].class
            int r0 = zzn(r0)
            long r0 = (long) r0
            zzxt = r0
            java.lang.Class<int[]> r0 = int[].class
            int r0 = zzo(r0)
            long r0 = (long) r0
            zzxu = r0
            java.lang.Class<long[]> r0 = long[].class
            int r0 = zzn(r0)
            long r0 = (long) r0
            zzxv = r0
            java.lang.Class<long[]> r0 = long[].class
            int r0 = zzo(r0)
            long r0 = (long) r0
            zzxw = r0
            java.lang.Class<float[]> r0 = float[].class
            int r0 = zzn(r0)
            long r0 = (long) r0
            zzxx = r0
            java.lang.Class<float[]> r0 = float[].class
            int r0 = zzo(r0)
            long r0 = (long) r0
            zzxy = r0
            java.lang.Class<double[]> r0 = double[].class
            int r0 = zzn(r0)
            long r0 = (long) r0
            zzxz = r0
            java.lang.Class<double[]> r0 = double[].class
            int r0 = zzo(r0)
            long r0 = (long) r0
            zzya = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzn(r0)
            long r0 = (long) r0
            zzyb = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzo(r0)
            long r0 = (long) r0
            zzyc = r0
            java.lang.reflect.Field r0 = zzji()
            if (r0 == 0) goto L_0x00e8
            com.google.android.gms.internal.firebase_remote_config.zzkd$zzd r1 = zzxo
            if (r1 != 0) goto L_0x00e1
            goto L_0x00e8
        L_0x00e1:
            sun.misc.Unsafe r1 = r1.zzyi
            long r0 = r1.objectFieldOffset(r0)
            goto L_0x00ea
        L_0x00e8:
            r0 = -1
        L_0x00ea:
            zzyd = r0
            long r0 = zzxq
            r2 = 7
            long r0 = r0 & r2
            int r1 = (int) r0
            zzye = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x00fe
            r0 = 1
            goto L_0x00ff
        L_0x00fe:
            r0 = 0
        L_0x00ff:
            zzyf = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzkd.<clinit>():void");
    }
}
