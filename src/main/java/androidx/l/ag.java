package androidx.l;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ag extends af {

    /* renamed from: a  reason: collision with root package name */
    private static Method f2428a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2429b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f2430c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f2431d;

    ag() {
    }

    public void a(View view, Matrix matrix) {
        a();
        Method method = f2428a;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{matrix});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    public void b(View view, Matrix matrix) {
        b();
        Method method = f2430c;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{matrix});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    private void a() {
        if (!f2429b) {
            try {
                f2428a = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[]{Matrix.class});
                f2428a.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", e2);
            }
            f2429b = true;
        }
    }

    private void b() {
        if (!f2431d) {
            try {
                f2430c = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[]{Matrix.class});
                f2430c.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", e2);
            }
            f2431d = true;
        }
    }
}
