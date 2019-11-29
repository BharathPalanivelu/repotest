package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.g.d;
import androidx.core.g.w;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static Method f1914a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1915b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f1916c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f1917d;

    public static void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 19) {
            popupWindow.showAsDropDown(view, i, i2, i3);
            return;
        }
        if ((d.a(i3, w.g(view)) & 7) == 5) {
            i -= popupWindow.getWidth() - view.getWidth();
        }
        popupWindow.showAsDropDown(view, i, i2);
    }

    public static void a(PopupWindow popupWindow, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setOverlapAnchor(z);
        } else if (Build.VERSION.SDK_INT >= 21) {
            if (!f1917d) {
                try {
                    f1916c = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    f1916c.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e2);
                }
                f1917d = true;
            }
            Field field = f1916c;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e3) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e3);
                }
            }
        }
    }

    public static void a(PopupWindow popupWindow, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i);
            return;
        }
        if (!f1915b) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                f1914a = cls.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                f1914a.setAccessible(true);
            } catch (Exception unused) {
            }
            f1915b = true;
        }
        Method method = f1914a;
        if (method != null) {
            try {
                method.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
            } catch (Exception unused2) {
            }
        }
    }
}
