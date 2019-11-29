package com.thoughtworks.xstream.converters.reflection;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class SunLimitedUnsafeReflectionProvider extends PureJavaReflectionProvider {
    protected static final Exception exception;
    protected static final Unsafe unsafe;

    /* access modifiers changed from: protected */
    public void validateFieldAccess(Field field) {
    }

    static {
        Unsafe unsafe2 = null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            Unsafe unsafe3 = (Unsafe) declaredField.get((Object) null);
            e = null;
            unsafe2 = unsafe3;
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e2) {
            e = e2;
        }
        exception = e;
        unsafe = unsafe2;
    }

    public SunLimitedUnsafeReflectionProvider() {
    }

    public SunLimitedUnsafeReflectionProvider(FieldDictionary fieldDictionary) {
        super(fieldDictionary);
    }

    public Object newInstance(Class cls) {
        if (exception == null) {
            try {
                return unsafe.allocateInstance(cls);
            } catch (SecurityException e2) {
                throw new ObjectAccessException("Cannot construct " + cls.getName(), e2);
            } catch (InstantiationException e3) {
                throw new ObjectAccessException("Cannot construct " + cls.getName(), e3);
            } catch (IllegalArgumentException e4) {
                throw new ObjectAccessException("Cannot construct " + cls.getName(), e4);
            }
        } else {
            throw new ObjectAccessException("Cannot construct " + cls.getName(), exception);
        }
    }

    private Object readResolve() {
        init();
        return this;
    }
}
