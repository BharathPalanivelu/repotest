package androidx.l;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class af extends ai {

    /* renamed from: a  reason: collision with root package name */
    private static Method f2424a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2425b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f2426c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f2427d;

    public void b(View view) {
    }

    public void c(View view) {
    }

    af() {
    }

    public void a(View view, float f2) {
        a();
        Method method = f2424a;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{Float.valueOf(f2)});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        } else {
            view.setAlpha(f2);
        }
    }

    public float a(View view) {
        b();
        Method method = f2426c;
        if (method != null) {
            try {
                return ((Float) method.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return super.a(view);
    }

    private void a() {
        if (!f2425b) {
            Class<View> cls = View.class;
            try {
                f2424a = cls.getDeclaredMethod("setTransitionAlpha", new Class[]{Float.TYPE});
                f2424a.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", e2);
            }
            f2425b = true;
        }
    }

    private void b() {
        if (!f2427d) {
            try {
                f2426c = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
                f2426c.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", e2);
            }
            f2427d = true;
        }
    }
}
