package com.bca.xco.widget.d.a.a.a;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class e extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private static final Method f4755a;

    /* renamed from: b  reason: collision with root package name */
    private IOException f4756b;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Exception unused) {
            method = null;
        }
        f4755a = method;
    }

    public e(IOException iOException) {
        super(iOException);
        this.f4756b = iOException;
    }

    public IOException a() {
        return this.f4756b;
    }

    public void a(IOException iOException) {
        a(iOException, this.f4756b);
        this.f4756b = iOException;
    }

    private void a(IOException iOException, IOException iOException2) {
        Method method = f4755a;
        if (method != null) {
            try {
                method.invoke(iOException, new Object[]{iOException2});
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
