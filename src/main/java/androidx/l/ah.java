package androidx.l;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ah extends ag {

    /* renamed from: a  reason: collision with root package name */
    private static Method f2432a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2433b;

    ah() {
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        a();
        Method method = f2432a;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    private void a() {
        if (!f2433b) {
            Class<View> cls = View.class;
            try {
                f2432a = cls.getDeclaredMethod("setLeftTopRightBottom", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                f2432a.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi22", "Failed to retrieve setLeftTopRightBottom method", e2);
            }
            f2433b = true;
        }
    }
}
