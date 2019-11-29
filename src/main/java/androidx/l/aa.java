package androidx.l;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class aa {

    /* renamed from: a  reason: collision with root package name */
    private static Method f2410a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2411b;

    static void a(ViewGroup viewGroup, boolean z) {
        a();
        Method method = f2410a;
        if (method != null) {
            try {
                method.invoke(viewGroup, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalAccessException e2) {
                Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", e2);
            } catch (InvocationTargetException e3) {
                Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", e3);
            }
        }
    }

    private static void a() {
        if (!f2411b) {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                f2410a = cls.getDeclaredMethod("suppressLayout", new Class[]{Boolean.TYPE});
                f2410a.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", e2);
            }
            f2411b = true;
        }
    }
}
