package com.google.a.b.b;

import com.google.a.m;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

final class c extends b {

    /* renamed from: a  reason: collision with root package name */
    private static Class f8828a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f8829b = b();

    /* renamed from: c  reason: collision with root package name */
    private final Field f8830c = c();

    c() {
    }

    public void a(AccessibleObject accessibleObject) {
        if (!b(accessibleObject)) {
            try {
                accessibleObject.setAccessible(true);
            } catch (SecurityException e2) {
                throw new m("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(AccessibleObject accessibleObject) {
        if (!(this.f8829b == null || this.f8830c == null)) {
            try {
                long longValue = ((Long) f8828a.getMethod("objectFieldOffset", new Class[]{Field.class}).invoke(this.f8829b, new Object[]{this.f8830c})).longValue();
                f8828a.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE}).invoke(this.f8829b, new Object[]{accessibleObject, Long.valueOf(longValue), true});
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static Object b() {
        try {
            f8828a = Class.forName("sun.misc.Unsafe");
            Field declaredField = f8828a.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get((Object) null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Field c() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }
}
