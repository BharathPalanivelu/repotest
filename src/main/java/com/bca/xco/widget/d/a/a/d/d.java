package com.bca.xco.widget.d.a.a.d;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f4853a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4854b;

    /* renamed from: c  reason: collision with root package name */
    private final Class[] f4855c;

    public d(Class<?> cls, String str, Class... clsArr) {
        this.f4853a = cls;
        this.f4854b = str;
        this.f4855c = clsArr;
    }

    public boolean a(T t) {
        return a(t.getClass()) != null;
    }

    public Object a(T t, Object... objArr) {
        Method a2 = a(t.getClass());
        if (a2 == null) {
            return null;
        }
        try {
            return a2.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public Object b(T t, Object... objArr) {
        try {
            return a(t, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object c(T t, Object... objArr) {
        Method a2 = a(t.getClass());
        if (a2 != null) {
            try {
                return a2.invoke(t, objArr);
            } catch (IllegalAccessException e2) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a2);
                assertionError.initCause(e2);
                throw assertionError;
            }
        } else {
            throw new AssertionError("Method " + this.f4854b + " not supported for object " + t);
        }
    }

    public Object d(T t, Object... objArr) {
        try {
            return c(t, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    private Method a(Class<?> cls) {
        String str = this.f4854b;
        if (str == null) {
            return null;
        }
        Method a2 = a(cls, str, this.f4855c);
        if (a2 != null) {
            Class<?> cls2 = this.f4853a;
            if (cls2 != null && !cls2.isAssignableFrom(a2.getReturnType())) {
                return null;
            }
        }
        return a2;
    }

    private static Method a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) != 0) {
                    return method;
                }
            } catch (NoSuchMethodException unused) {
                return method;
            }
        } catch (NoSuchMethodException unused2) {
        }
        return null;
    }
}
