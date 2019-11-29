package com.google.android.gms.internal.icing;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzgi {
    private static final Logger logger = Logger.getLogger(zzgi.class.getName());
    private static final Class<?> zzfs = zzcg.zzaf();
    private static final boolean zzgj = zzdr();
    private static final Unsafe zzmj = zzdq();
    private static final boolean zzob = zzj(Long.TYPE);
    private static final boolean zzoc = zzj(Integer.TYPE);
    private static final zzd zzod;
    private static final boolean zzoe = zzds();
    private static final long zzof = ((long) zzh(byte[].class));
    private static final long zzog = ((long) zzh(boolean[].class));
    private static final long zzoh = ((long) zzi(boolean[].class));
    private static final long zzoi = ((long) zzh(int[].class));
    private static final long zzoj = ((long) zzi(int[].class));
    private static final long zzok = ((long) zzh(long[].class));
    private static final long zzol = ((long) zzi(long[].class));
    private static final long zzom = ((long) zzh(float[].class));
    private static final long zzon = ((long) zzi(float[].class));
    private static final long zzoo = ((long) zzh(double[].class));
    private static final long zzop = ((long) zzi(double[].class));
    private static final long zzoq = ((long) zzh(Object[].class));
    private static final long zzor = ((long) zzi(Object[].class));
    private static final long zzos;
    private static final int zzot = ((int) (zzof & 7));
    static final boolean zzou = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);

    private zzgi() {
    }

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzx(Object obj, long j) {
            if (zzgi.zzou) {
                return zzgi.zzp(obj, j);
            }
            return zzgi.zzq(obj, j);
        }

        public final void zze(Object obj, long j, byte b2) {
            if (zzgi.zzou) {
                zzgi.zza(obj, j, b2);
            } else {
                zzgi.zzb(obj, j, b2);
            }
        }

        public final boolean zzl(Object obj, long j) {
            if (zzgi.zzou) {
                return zzgi.zzr(obj, j);
            }
            return zzgi.zzs(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzgi.zzou) {
                zzgi.zzb(obj, j, z);
            } else {
                zzgi.zzc(obj, j, z);
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

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzx(Object obj, long j) {
            return this.zzox.getByte(obj, j);
        }

        public final void zze(Object obj, long j, byte b2) {
            this.zzox.putByte(obj, j, b2);
        }

        public final boolean zzl(Object obj, long j) {
            return this.zzox.getBoolean(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzox.putBoolean(obj, j, z);
        }

        public final float zzm(Object obj, long j) {
            return this.zzox.getFloat(obj, j);
        }

        public final void zza(Object obj, long j, float f2) {
            this.zzox.putFloat(obj, j, f2);
        }

        public final double zzn(Object obj, long j) {
            return this.zzox.getDouble(obj, j);
        }

        public final void zza(Object obj, long j, double d2) {
            this.zzox.putDouble(obj, j, d2);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzx(Object obj, long j) {
            if (zzgi.zzou) {
                return zzgi.zzp(obj, j);
            }
            return zzgi.zzq(obj, j);
        }

        public final void zze(Object obj, long j, byte b2) {
            if (zzgi.zzou) {
                zzgi.zza(obj, j, b2);
            } else {
                zzgi.zzb(obj, j, b2);
            }
        }

        public final boolean zzl(Object obj, long j) {
            if (zzgi.zzou) {
                return zzgi.zzr(obj, j);
            }
            return zzgi.zzs(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzgi.zzou) {
                zzgi.zzb(obj, j, z);
            } else {
                zzgi.zzc(obj, j, z);
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

    static boolean zzdo() {
        return zzgj;
    }

    static abstract class zzd {
        Unsafe zzox;

        zzd(Unsafe unsafe) {
            this.zzox = unsafe;
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
            return this.zzox.getInt(obj, j);
        }

        public final void zza(Object obj, long j, int i) {
            this.zzox.putInt(obj, j, i);
        }

        public final long zzk(Object obj, long j) {
            return this.zzox.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzox.putLong(obj, j, j2);
        }
    }

    static boolean zzdp() {
        return zzoe;
    }

    static <T> T zzg(Class<T> cls) {
        try {
            return zzmj.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int zzh(Class<?> cls) {
        if (zzgj) {
            return zzod.zzox.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzi(Class<?> cls) {
        if (zzgj) {
            return zzod.zzox.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzj(Object obj, long j) {
        return zzod.zzj(obj, j);
    }

    static void zza(Object obj, long j, int i) {
        zzod.zza(obj, j, i);
    }

    static long zzk(Object obj, long j) {
        return zzod.zzk(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzod.zza(obj, j, j2);
    }

    static boolean zzl(Object obj, long j) {
        return zzod.zzl(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzod.zza(obj, j, z);
    }

    static float zzm(Object obj, long j) {
        return zzod.zzm(obj, j);
    }

    static void zza(Object obj, long j, float f2) {
        zzod.zza(obj, j, f2);
    }

    static double zzn(Object obj, long j) {
        return zzod.zzn(obj, j);
    }

    static void zza(Object obj, long j, double d2) {
        zzod.zza(obj, j, d2);
    }

    static Object zzo(Object obj, long j) {
        return zzod.zzox.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzod.zzox.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzod.zzx(bArr, zzof + j);
    }

    static void zza(byte[] bArr, long j, byte b2) {
        zzod.zze(bArr, zzof + j, b2);
    }

    static Unsafe zzdq() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzgk());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzdr() {
        Unsafe unsafe = zzmj;
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
            if (zzcg.zzae()) {
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

    private static boolean zzds() {
        Unsafe unsafe = zzmj;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (zzdt() == null) {
                return false;
            }
            if (zzcg.zzae()) {
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
        if (!zzcg.zzae()) {
            return false;
        }
        try {
            Class<?> cls2 = zzfs;
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

    private static Field zzdt() {
        if (zzcg.zzae()) {
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
            java.lang.Class<com.google.android.gms.internal.icing.zzgi> r0 = com.google.android.gms.internal.icing.zzgi.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            logger = r0
            sun.misc.Unsafe r0 = zzdq()
            zzmj = r0
            java.lang.Class r0 = com.google.android.gms.internal.icing.zzcg.zzaf()
            zzfs = r0
            java.lang.Class r0 = java.lang.Long.TYPE
            boolean r0 = zzj(r0)
            zzob = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            boolean r0 = zzj(r0)
            zzoc = r0
            sun.misc.Unsafe r0 = zzmj
            r1 = 0
            if (r0 != 0) goto L_0x002e
            goto L_0x0053
        L_0x002e:
            boolean r0 = com.google.android.gms.internal.icing.zzcg.zzae()
            if (r0 == 0) goto L_0x004c
            boolean r0 = zzob
            if (r0 == 0) goto L_0x0040
            com.google.android.gms.internal.icing.zzgi$zzc r1 = new com.google.android.gms.internal.icing.zzgi$zzc
            sun.misc.Unsafe r0 = zzmj
            r1.<init>(r0)
            goto L_0x0053
        L_0x0040:
            boolean r0 = zzoc
            if (r0 == 0) goto L_0x0053
            com.google.android.gms.internal.icing.zzgi$zza r1 = new com.google.android.gms.internal.icing.zzgi$zza
            sun.misc.Unsafe r0 = zzmj
            r1.<init>(r0)
            goto L_0x0053
        L_0x004c:
            com.google.android.gms.internal.icing.zzgi$zzb r1 = new com.google.android.gms.internal.icing.zzgi$zzb
            sun.misc.Unsafe r0 = zzmj
            r1.<init>(r0)
        L_0x0053:
            zzod = r1
            boolean r0 = zzds()
            zzoe = r0
            boolean r0 = zzdr()
            zzgj = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzof = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzog = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzoh = r0
            java.lang.Class<int[]> r0 = int[].class
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzoi = r0
            java.lang.Class<int[]> r0 = int[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzoj = r0
            java.lang.Class<long[]> r0 = long[].class
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzok = r0
            java.lang.Class<long[]> r0 = long[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzol = r0
            java.lang.Class<float[]> r0 = float[].class
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzom = r0
            java.lang.Class<float[]> r0 = float[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzon = r0
            java.lang.Class<double[]> r0 = double[].class
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzoo = r0
            java.lang.Class<double[]> r0 = double[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzop = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzoq = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzor = r0
            java.lang.reflect.Field r0 = zzdt()
            if (r0 == 0) goto L_0x00e8
            com.google.android.gms.internal.icing.zzgi$zzd r1 = zzod
            if (r1 != 0) goto L_0x00e1
            goto L_0x00e8
        L_0x00e1:
            sun.misc.Unsafe r1 = r1.zzox
            long r0 = r1.objectFieldOffset(r0)
            goto L_0x00ea
        L_0x00e8:
            r0 = -1
        L_0x00ea:
            zzos = r0
            long r0 = zzof
            r2 = 7
            long r0 = r0 & r2
            int r1 = (int) r0
            zzot = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x00fe
            r0 = 1
            goto L_0x00ff
        L_0x00fe:
            r0 = 0
        L_0x00ff:
            zzou = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.icing.zzgi.<clinit>():void");
    }
}
