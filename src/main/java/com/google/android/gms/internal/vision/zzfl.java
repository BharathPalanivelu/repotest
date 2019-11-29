package com.google.android.gms.internal.vision;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzfl {
    private static final Logger logger = Logger.getLogger(zzfl.class.getName());
    private static final Class<?> zzgm = zzbj.zzar();
    private static final boolean zzhj = zzea();
    private static final Unsafe zznd = zzdz();
    private static final boolean zzpa = zzi(Long.TYPE);
    private static final boolean zzpb = zzi(Integer.TYPE);
    private static final zzd zzpc;
    private static final boolean zzpd = zzeb();
    private static final long zzpe = ((long) zzg(byte[].class));
    private static final long zzpf = ((long) zzg(boolean[].class));
    private static final long zzpg = ((long) zzh(boolean[].class));
    private static final long zzph = ((long) zzg(int[].class));
    private static final long zzpi = ((long) zzh(int[].class));
    private static final long zzpj = ((long) zzg(long[].class));
    private static final long zzpk = ((long) zzh(long[].class));
    private static final long zzpl = ((long) zzg(float[].class));
    private static final long zzpm = ((long) zzh(float[].class));
    private static final long zzpn = ((long) zzg(double[].class));
    private static final long zzpo = ((long) zzh(double[].class));
    private static final long zzpp = ((long) zzg(Object[].class));
    private static final long zzpq = ((long) zzh(Object[].class));
    private static final long zzpr = zza(zzec());
    private static final long zzps;
    /* access modifiers changed from: private */
    public static final boolean zzpt = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(Object obj, long j, double d2) {
            zza(obj, j, Double.doubleToLongBits(d2));
        }

        public final void zza(Object obj, long j, float f2) {
            zza(obj, j, Float.floatToIntBits(f2));
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzfl.zzpt) {
                zzfl.zzb(obj, j, z);
            } else {
                zzfl.zzc(obj, j, z);
            }
        }

        public final void zze(Object obj, long j, byte b2) {
            if (zzfl.zzpt) {
                zzfl.zza(obj, j, b2);
            } else {
                zzfl.zzb(obj, j, b2);
            }
        }

        public final boolean zzl(Object obj, long j) {
            return zzfl.zzpt ? zzfl.zzr(obj, j) : zzfl.zzs(obj, j);
        }

        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        public final byte zzx(Object obj, long j) {
            return zzfl.zzpt ? zzfl.zzp(obj, j) : zzfl.zzq(obj, j);
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(Object obj, long j, double d2) {
            zza(obj, j, Double.doubleToLongBits(d2));
        }

        public final void zza(Object obj, long j, float f2) {
            zza(obj, j, Float.floatToIntBits(f2));
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzfl.zzpt) {
                zzfl.zzb(obj, j, z);
            } else {
                zzfl.zzc(obj, j, z);
            }
        }

        public final void zze(Object obj, long j, byte b2) {
            if (zzfl.zzpt) {
                zzfl.zza(obj, j, b2);
            } else {
                zzfl.zzb(obj, j, b2);
            }
        }

        public final boolean zzl(Object obj, long j) {
            return zzfl.zzpt ? zzfl.zzr(obj, j) : zzfl.zzs(obj, j);
        }

        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        public final byte zzx(Object obj, long j) {
            return zzfl.zzpt ? zzfl.zzp(obj, j) : zzfl.zzq(obj, j);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(Object obj, long j, double d2) {
            this.zzpu.putDouble(obj, j, d2);
        }

        public final void zza(Object obj, long j, float f2) {
            this.zzpu.putFloat(obj, j, f2);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzpu.putBoolean(obj, j, z);
        }

        public final void zze(Object obj, long j, byte b2) {
            this.zzpu.putByte(obj, j, b2);
        }

        public final boolean zzl(Object obj, long j) {
            return this.zzpu.getBoolean(obj, j);
        }

        public final float zzm(Object obj, long j) {
            return this.zzpu.getFloat(obj, j);
        }

        public final double zzn(Object obj, long j) {
            return this.zzpu.getDouble(obj, j);
        }

        public final byte zzx(Object obj, long j) {
            return this.zzpu.getByte(obj, j);
        }
    }

    static abstract class zzd {
        Unsafe zzpu;

        zzd(Unsafe unsafe) {
            this.zzpu = unsafe;
        }

        public abstract void zza(Object obj, long j, double d2);

        public abstract void zza(Object obj, long j, float f2);

        public final void zza(Object obj, long j, int i) {
            this.zzpu.putInt(obj, j, i);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzpu.putLong(obj, j, j2);
        }

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zze(Object obj, long j, byte b2);

        public final int zzj(Object obj, long j) {
            return this.zzpu.getInt(obj, j);
        }

        public final long zzk(Object obj, long j) {
            return this.zzpu.getLong(obj, j);
        }

        public abstract boolean zzl(Object obj, long j);

        public abstract float zzm(Object obj, long j);

        public abstract double zzn(Object obj, long j);

        public abstract byte zzx(Object obj, long j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0105  */
    static {
        /*
            java.lang.Class<com.google.android.gms.internal.vision.zzfl> r0 = com.google.android.gms.internal.vision.zzfl.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            logger = r0
            sun.misc.Unsafe r0 = zzdz()
            zznd = r0
            java.lang.Class r0 = com.google.android.gms.internal.vision.zzbj.zzar()
            zzgm = r0
            java.lang.Class r0 = java.lang.Long.TYPE
            boolean r0 = zzi(r0)
            zzpa = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            boolean r0 = zzi(r0)
            zzpb = r0
            sun.misc.Unsafe r0 = zznd
            r1 = 0
            if (r0 != 0) goto L_0x002f
        L_0x002d:
            r0 = r1
            goto L_0x0054
        L_0x002f:
            boolean r0 = com.google.android.gms.internal.vision.zzbj.zzaq()
            if (r0 == 0) goto L_0x004d
            boolean r0 = zzpa
            if (r0 == 0) goto L_0x0041
            com.google.android.gms.internal.vision.zzfl$zzb r0 = new com.google.android.gms.internal.vision.zzfl$zzb
            sun.misc.Unsafe r2 = zznd
            r0.<init>(r2)
            goto L_0x0054
        L_0x0041:
            boolean r0 = zzpb
            if (r0 == 0) goto L_0x002d
            com.google.android.gms.internal.vision.zzfl$zza r0 = new com.google.android.gms.internal.vision.zzfl$zza
            sun.misc.Unsafe r2 = zznd
            r0.<init>(r2)
            goto L_0x0054
        L_0x004d:
            com.google.android.gms.internal.vision.zzfl$zzc r0 = new com.google.android.gms.internal.vision.zzfl$zzc
            sun.misc.Unsafe r2 = zznd
            r0.<init>(r2)
        L_0x0054:
            zzpc = r0
            boolean r0 = zzeb()
            zzpd = r0
            boolean r0 = zzea()
            zzhj = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = zzg(r0)
            long r2 = (long) r0
            zzpe = r2
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = zzg(r0)
            long r2 = (long) r0
            zzpf = r2
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = zzh(r0)
            long r2 = (long) r0
            zzpg = r2
            java.lang.Class<int[]> r0 = int[].class
            int r0 = zzg(r0)
            long r2 = (long) r0
            zzph = r2
            java.lang.Class<int[]> r0 = int[].class
            int r0 = zzh(r0)
            long r2 = (long) r0
            zzpi = r2
            java.lang.Class<long[]> r0 = long[].class
            int r0 = zzg(r0)
            long r2 = (long) r0
            zzpj = r2
            java.lang.Class<long[]> r0 = long[].class
            int r0 = zzh(r0)
            long r2 = (long) r0
            zzpk = r2
            java.lang.Class<float[]> r0 = float[].class
            int r0 = zzg(r0)
            long r2 = (long) r0
            zzpl = r2
            java.lang.Class<float[]> r0 = float[].class
            int r0 = zzh(r0)
            long r2 = (long) r0
            zzpm = r2
            java.lang.Class<double[]> r0 = double[].class
            int r0 = zzg(r0)
            long r2 = (long) r0
            zzpn = r2
            java.lang.Class<double[]> r0 = double[].class
            int r0 = zzh(r0)
            long r2 = (long) r0
            zzpo = r2
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzg(r0)
            long r2 = (long) r0
            zzpp = r2
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzh(r0)
            long r2 = (long) r0
            zzpq = r2
            java.lang.reflect.Field r0 = zzec()
            long r2 = zza(r0)
            zzpr = r2
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r2 = "value"
            java.lang.reflect.Field r0 = zzb(r0, r2)
            if (r0 == 0) goto L_0x00f4
            java.lang.Class r2 = r0.getType()
            java.lang.Class<char[]> r3 = char[].class
            if (r2 != r3) goto L_0x00f4
            goto L_0x00f5
        L_0x00f4:
            r0 = r1
        L_0x00f5:
            long r0 = zza(r0)
            zzps = r0
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x0105
            r0 = 1
            goto L_0x0106
        L_0x0105:
            r0 = 0
        L_0x0106:
            zzpt = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfl.<clinit>():void");
    }

    private zzfl() {
    }

    static byte zza(byte[] bArr, long j) {
        return zzpc.zzx(bArr, zzpe + j);
    }

    private static long zza(Field field) {
        if (field == null) {
            return -1;
        }
        zzd zzd2 = zzpc;
        if (zzd2 == null) {
            return -1;
        }
        return zzd2.zzpu.objectFieldOffset(field);
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b2) {
        long j2 = -4 & j;
        int i = ((((int) j) ^ -1) & 3) << 3;
        zza(obj, j2, ((255 & b2) << i) | (zzj(obj, j2) & ((255 << i) ^ -1)));
    }

    static void zza(Object obj, long j, double d2) {
        zzpc.zza(obj, j, d2);
    }

    static void zza(Object obj, long j, float f2) {
        zzpc.zza(obj, j, f2);
    }

    static void zza(Object obj, long j, int i) {
        zzpc.zza(obj, j, i);
    }

    static void zza(Object obj, long j, long j2) {
        zzpc.zza(obj, j, j2);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzpc.zzpu.putObject(obj, j, obj2);
    }

    static void zza(Object obj, long j, boolean z) {
        zzpc.zza(obj, j, z);
    }

    static void zza(byte[] bArr, long j, byte b2) {
        zzpc.zze(bArr, zzpe + j, b2);
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b2) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b2) << i) | (zzj(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    static boolean zzdx() {
        return zzhj;
    }

    static boolean zzdy() {
        return zzpd;
    }

    static Unsafe zzdz() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzfm());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzea() {
        Unsafe unsafe = zznd;
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
            if (zzbj.zzaq()) {
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

    private static boolean zzeb() {
        Unsafe unsafe = zznd;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (zzec() == null) {
                return false;
            }
            if (zzbj.zzaq()) {
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

    private static Field zzec() {
        if (zzbj.zzaq()) {
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

    private static int zzg(Class<?> cls) {
        if (zzhj) {
            return zzpc.zzpu.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzh(Class<?> cls) {
        if (zzhj) {
            return zzpc.zzpu.arrayIndexScale(cls);
        }
        return -1;
    }

    private static boolean zzi(Class<?> cls) {
        if (!zzbj.zzaq()) {
            return false;
        }
        try {
            Class<?> cls2 = zzgm;
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

    static int zzj(Object obj, long j) {
        return zzpc.zzj(obj, j);
    }

    static long zzk(Object obj, long j) {
        return zzpc.zzk(obj, j);
    }

    static boolean zzl(Object obj, long j) {
        return zzpc.zzl(obj, j);
    }

    static float zzm(Object obj, long j) {
        return zzpc.zzm(obj, j);
    }

    static double zzn(Object obj, long j) {
        return zzpc.zzn(obj, j);
    }

    static Object zzo(Object obj, long j) {
        return zzpc.zzpu.getObject(obj, j);
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
    public static boolean zzr(Object obj, long j) {
        return zzp(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }
}
