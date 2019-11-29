package com.google.c;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

final class aw {

    /* renamed from: a  reason: collision with root package name */
    private static final Unsafe f13694a = d();

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f13695b = f();

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f13696c = e();

    /* renamed from: d  reason: collision with root package name */
    private static final long f13697d = ((long) g());

    /* renamed from: e  reason: collision with root package name */
    private static final long f13698e = a(a((Class<?>) Buffer.class, "address"));

    static boolean a() {
        return f13696c;
    }

    static boolean b() {
        return f13695b;
    }

    static long c() {
        return f13697d;
    }

    static byte a(byte[] bArr, long j) {
        return f13694a.getByte(bArr, j);
    }

    static void a(byte[] bArr, long j, byte b2) {
        f13694a.putByte(bArr, j, b2);
    }

    static long b(byte[] bArr, long j) {
        return f13694a.getLong(bArr, j);
    }

    private static Unsafe d() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() {
                /* renamed from: a */
                public Unsafe run() throws Exception {
                    Class<Unsafe> cls = Unsafe.class;
                    for (Field field : cls.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get((Object) null);
                        if (cls.isInstance(obj)) {
                            return cls.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean e() {
        Unsafe unsafe = f13694a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
                cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
                cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
                cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
                cls.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static boolean f() {
        Unsafe unsafe = f13694a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls.getMethod("getByte", new Class[]{Long.TYPE});
                cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
                cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
                cls.getMethod("getLong", new Class[]{Long.TYPE});
                cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static int g() {
        if (f13696c) {
            return f13694a.arrayBaseOffset(byte[].class);
        }
        return -1;
    }

    private static long a(Field field) {
        if (field != null) {
            Unsafe unsafe = f13694a;
            if (unsafe != null) {
                return unsafe.objectFieldOffset(field);
            }
        }
        return -1;
    }

    private static Field a(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }
}
