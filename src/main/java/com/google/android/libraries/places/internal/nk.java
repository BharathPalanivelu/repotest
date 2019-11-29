package com.google.android.libraries.places.internal;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class nk {

    /* renamed from: a  reason: collision with root package name */
    public static final d f13026a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f13027b = c();

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f13028c = b();

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f13029d = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    /* renamed from: e  reason: collision with root package name */
    private static final Logger f13030e = Logger.getLogger(nk.class.getName());

    /* renamed from: f  reason: collision with root package name */
    private static final Unsafe f13031f = a();

    /* renamed from: g  reason: collision with root package name */
    private static final Class<?> f13032g = jz.f12859a;
    private static final boolean h = d(Long.TYPE);
    private static final boolean i = d(Integer.TYPE);
    private static final long j = ((long) b(byte[].class));
    private static final int k = ((int) (j & 7));

    private nk() {
    }

    static final class a extends d {
        a(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte a(Object obj, long j) {
            if (nk.f13029d) {
                return nk.g(obj, j);
            }
            return nk.h(obj, j);
        }

        public final void a(Object obj, long j, byte b2) {
            if (nk.f13029d) {
                nk.a(obj, j, b2);
            } else {
                nk.b(obj, j, b2);
            }
        }

        public final boolean b(Object obj, long j) {
            if (nk.f13029d) {
                return nk.i(obj, j);
            }
            return nk.j(obj, j);
        }

        public final void a(Object obj, long j, boolean z) {
            if (nk.f13029d) {
                nk.b(obj, j, z);
            } else {
                nk.c(obj, j, z);
            }
        }

        public final float c(Object obj, long j) {
            return Float.intBitsToFloat(e(obj, j));
        }

        public final void a(Object obj, long j, float f2) {
            a(obj, j, Float.floatToIntBits(f2));
        }

        public final double d(Object obj, long j) {
            return Double.longBitsToDouble(f(obj, j));
        }

        public final void a(Object obj, long j, double d2) {
            a(obj, j, Double.doubleToLongBits(d2));
        }
    }

    static final class b extends d {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte a(Object obj, long j) {
            if (nk.f13029d) {
                return nk.g(obj, j);
            }
            return nk.h(obj, j);
        }

        public final void a(Object obj, long j, byte b2) {
            if (nk.f13029d) {
                nk.a(obj, j, b2);
            } else {
                nk.b(obj, j, b2);
            }
        }

        public final boolean b(Object obj, long j) {
            if (nk.f13029d) {
                return nk.i(obj, j);
            }
            return nk.j(obj, j);
        }

        public final void a(Object obj, long j, boolean z) {
            if (nk.f13029d) {
                nk.b(obj, j, z);
            } else {
                nk.c(obj, j, z);
            }
        }

        public final float c(Object obj, long j) {
            return Float.intBitsToFloat(e(obj, j));
        }

        public final void a(Object obj, long j, float f2) {
            a(obj, j, Float.floatToIntBits(f2));
        }

        public final double d(Object obj, long j) {
            return Double.longBitsToDouble(f(obj, j));
        }

        public final void a(Object obj, long j, double d2) {
            a(obj, j, Double.doubleToLongBits(d2));
        }
    }

    static final class c extends d {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte a(Object obj, long j) {
            return this.f13033a.getByte(obj, j);
        }

        public final void a(Object obj, long j, byte b2) {
            this.f13033a.putByte(obj, j, b2);
        }

        public final boolean b(Object obj, long j) {
            return this.f13033a.getBoolean(obj, j);
        }

        public final void a(Object obj, long j, boolean z) {
            this.f13033a.putBoolean(obj, j, z);
        }

        public final float c(Object obj, long j) {
            return this.f13033a.getFloat(obj, j);
        }

        public final void a(Object obj, long j, float f2) {
            this.f13033a.putFloat(obj, j, f2);
        }

        public final double d(Object obj, long j) {
            return this.f13033a.getDouble(obj, j);
        }

        public final void a(Object obj, long j, double d2) {
            this.f13033a.putDouble(obj, j, d2);
        }
    }

    static <T> T a(Class<T> cls) {
        try {
            return f13031f.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    static abstract class d {

        /* renamed from: a  reason: collision with root package name */
        public Unsafe f13033a;

        d(Unsafe unsafe) {
            this.f13033a = unsafe;
        }

        public abstract byte a(Object obj, long j);

        public abstract void a(Object obj, long j, byte b2);

        public abstract void a(Object obj, long j, double d2);

        public abstract void a(Object obj, long j, float f2);

        public abstract void a(Object obj, long j, boolean z);

        public abstract boolean b(Object obj, long j);

        public abstract float c(Object obj, long j);

        public abstract double d(Object obj, long j);

        public final long a(Field field) {
            return this.f13033a.objectFieldOffset(field);
        }

        public final int e(Object obj, long j) {
            return this.f13033a.getInt(obj, j);
        }

        public final void a(Object obj, long j, int i) {
            this.f13033a.putInt(obj, j, i);
        }

        public final long f(Object obj, long j) {
            return this.f13033a.getLong(obj, j);
        }

        public final void a(Object obj, long j, long j2) {
            this.f13033a.putLong(obj, j, j2);
        }
    }

    private static int b(Class<?> cls) {
        if (f13028c) {
            return f13026a.f13033a.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int c(Class<?> cls) {
        if (f13028c) {
            return f13026a.f13033a.arrayIndexScale(cls);
        }
        return -1;
    }

    static int a(Object obj, long j2) {
        return f13026a.e(obj, j2);
    }

    static void a(Object obj, long j2, int i2) {
        f13026a.a(obj, j2, i2);
    }

    static long b(Object obj, long j2) {
        return f13026a.f(obj, j2);
    }

    static void a(Object obj, long j2, long j3) {
        f13026a.a(obj, j2, j3);
    }

    static boolean c(Object obj, long j2) {
        return f13026a.b(obj, j2);
    }

    static void a(Object obj, long j2, boolean z) {
        f13026a.a(obj, j2, z);
    }

    static float d(Object obj, long j2) {
        return f13026a.c(obj, j2);
    }

    static void a(Object obj, long j2, float f2) {
        f13026a.a(obj, j2, f2);
    }

    static double e(Object obj, long j2) {
        return f13026a.d(obj, j2);
    }

    static void a(Object obj, long j2, double d2) {
        f13026a.a(obj, j2, d2);
    }

    static Object f(Object obj, long j2) {
        return f13026a.f13033a.getObject(obj, j2);
    }

    static void a(Object obj, long j2, Object obj2) {
        f13026a.f13033a.putObject(obj, j2, obj2);
    }

    static byte a(byte[] bArr, long j2) {
        return f13026a.a(bArr, j + j2);
    }

    static void a(byte[] bArr, long j2, byte b2) {
        f13026a.a((Object) bArr, j + j2, b2);
    }

    static Unsafe a() {
        try {
            return (Unsafe) AccessController.doPrivileged(new nl());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean b() {
        Unsafe unsafe = f13031f;
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
            if (jz.a()) {
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
            Logger logger = f13030e;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean c() {
        Unsafe unsafe = f13031f;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (d() == null) {
                return false;
            }
            if (jz.a()) {
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
            Logger logger = f13030e;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean d(Class<?> cls) {
        if (!jz.a()) {
            return false;
        }
        try {
            Class<?> cls2 = f13032g;
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

    private static Field d() {
        if (jz.a()) {
            Field a2 = a((Class<?>) Buffer.class, "effectiveDirectAddress");
            if (a2 != null) {
                return a2;
            }
        }
        Field a3 = a((Class<?>) Buffer.class, "address");
        if (a3 == null || a3.getType() != Long.TYPE) {
            return null;
        }
        return a3;
    }

    static int a(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        if (i2 < 0 || i3 < 0 || i4 < 0 || i2 + i4 > bArr.length || i3 + i4 > bArr2.length) {
            throw new IndexOutOfBoundsException();
        }
        int i6 = 0;
        if (f13028c) {
            int i7 = (k + i2) & 7;
            while (i6 < i4 && (i7 & 7) != 0) {
                if (bArr[i2 + i6] != bArr2[i3 + i6]) {
                    return i6;
                }
                i6++;
                i7++;
            }
            int i8 = ((i4 - i6) & -8) + i6;
            while (i6 < i8) {
                long j2 = (long) i6;
                long b2 = b(bArr, j + ((long) i2) + j2);
                long b3 = b(bArr2, j + ((long) i3) + j2);
                if (b2 != b3) {
                    if (f13029d) {
                        i5 = Long.numberOfLeadingZeros(b2 ^ b3);
                    } else {
                        i5 = Long.numberOfTrailingZeros(b2 ^ b3);
                    }
                    return i6 + (i5 >> 3);
                }
                i6 += 8;
            }
        }
        while (i6 < i4) {
            if (bArr[i2 + i6] != bArr2[i3 + i6]) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    private static Field a(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static byte g(Object obj, long j2) {
        return (byte) (a(obj, -4 & j2) >>> ((int) (((j2 ^ -1) & 3) << 3)));
    }

    static byte h(Object obj, long j2) {
        return (byte) (a(obj, -4 & j2) >>> ((int) ((j2 & 3) << 3)));
    }

    static void a(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = ((((int) j2) ^ -1) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (a(obj, j3) & ((255 << i2) ^ -1)));
    }

    static void b(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = (((int) j2) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (a(obj, j3) & ((255 << i2) ^ -1)));
    }

    static boolean i(Object obj, long j2) {
        return g(obj, j2) != 0;
    }

    static boolean j(Object obj, long j2) {
        return h(obj, j2) != 0;
    }

    static void b(Object obj, long j2, boolean z) {
        a(obj, j2, z ? (byte) 1 : 0);
    }

    static void c(Object obj, long j2, boolean z) {
        b(obj, j2, z ? (byte) 1 : 0);
    }

    static {
        d dVar = null;
        if (f13031f != null) {
            if (!jz.a()) {
                dVar = new c(f13031f);
            } else if (h) {
                dVar = new b(f13031f);
            } else if (i) {
                dVar = new a(f13031f);
            }
        }
        f13026a = dVar;
        b(boolean[].class);
        c(boolean[].class);
        b(int[].class);
        c(int[].class);
        b(long[].class);
        c(long[].class);
        b(float[].class);
        c(float[].class);
        b(double[].class);
        c(double[].class);
        b(Object[].class);
        c(Object[].class);
        Field d2 = d();
        if (d2 != null) {
            d dVar2 = f13026a;
            if (dVar2 != null) {
                dVar2.a(d2);
            }
        }
    }
}
