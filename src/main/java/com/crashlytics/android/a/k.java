package com.crashlytics.android.a;

import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.Method;

public class k implements q {

    /* renamed from: a  reason: collision with root package name */
    private final Method f6341a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f6342b;

    public static q a(Context context) {
        Class b2 = b(context);
        if (b2 == null) {
            return null;
        }
        Object a2 = a(context, b2);
        if (a2 == null) {
            return null;
        }
        Method b3 = b(context, b2);
        if (b3 == null) {
            return null;
        }
        return new k(a2, b3);
    }

    private static Class b(Context context) {
        try {
            return context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement");
        } catch (Exception unused) {
            return null;
        }
    }

    private static Object a(Context context, Class cls) {
        try {
            return cls.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(cls, new Object[]{context});
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method b(Context context, Class cls) {
        try {
            return cls.getDeclaredMethod("logEventInternal", new Class[]{String.class, String.class, Bundle.class});
        } catch (Exception unused) {
            return null;
        }
    }

    public k(Object obj, Method method) {
        this.f6342b = obj;
        this.f6341a = method;
    }

    public void a(String str, Bundle bundle) {
        a("fab", str, bundle);
    }

    public void a(String str, String str2, Bundle bundle) {
        try {
            this.f6341a.invoke(this.f6342b, new Object[]{str, str2, bundle});
        } catch (Exception unused) {
        }
    }
}
