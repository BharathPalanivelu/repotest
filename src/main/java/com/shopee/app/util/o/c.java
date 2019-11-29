package com.shopee.app.util.o;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static float f26471a = -1.0f;

    /* renamed from: b  reason: collision with root package name */
    private static int f26472b = -1;

    /* renamed from: c  reason: collision with root package name */
    private static int f26473c;

    public static boolean a(Activity activity) {
        return a(activity, 1073741824);
    }

    @TargetApi(19)
    public static boolean a(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            activity.getWindow().setFlags(67108864, 67108864);
        } else if (Build.VERSION.SDK_INT < 21) {
            return false;
        } else {
            Window window = activity.getWindow();
            window.getDecorView().setSystemUiVisibility(1280);
            if (Build.VERSION.SDK_INT < 23 || !b()) {
                window.clearFlags(67108864);
                window.addFlags(RNCartPanelDataEntity.NULL_VALUE);
                window.setStatusBarColor(i);
            } else {
                window.clearFlags(67108864);
                window.addFlags(RNCartPanelDataEntity.NULL_VALUE);
                window.setStatusBarColor(0);
            }
        }
        return true;
    }

    public static boolean b(Activity activity) {
        if (activity == null || com.shopee.app.util.e.c.h()) {
            return false;
        }
        int i = f26473c;
        if (i != 0) {
            return b(activity, i);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            if (a() && b(activity.getWindow(), true)) {
                f26473c = 1;
                return true;
            } else if (c(activity.getWindow(), true)) {
                f26473c = 2;
                return true;
            } else if (Build.VERSION.SDK_INT >= 23) {
                a(activity.getWindow(), true);
                f26473c = 3;
                return true;
            }
        }
        return false;
    }

    private static boolean b(Activity activity, int i) {
        if (i == 1) {
            return b(activity.getWindow(), true);
        }
        if (i == 2) {
            return c(activity.getWindow(), true);
        }
        if (i == 3) {
            return a(activity.getWindow(), true);
        }
        return false;
    }

    public static boolean c(Activity activity) {
        if (activity == null) {
            return false;
        }
        int i = f26473c;
        if (i == 0) {
            return true;
        }
        if (i == 1) {
            return b(activity.getWindow(), false);
        }
        if (i == 2) {
            return c(activity.getWindow(), false);
        }
        if (i == 3) {
            return a(activity.getWindow(), false);
        }
        return true;
    }

    @TargetApi(23)
    private static int a(Window window, int i) {
        return a(window, a(window, a(window, a(window, a(window, a(window, i, 1024), 4), 2), 4096), 1024), 512);
    }

    private static int a(Window window, int i, int i2) {
        return (window.getDecorView().getSystemUiVisibility() & i2) == i2 ? i | i2 : i;
    }

    @TargetApi(23)
    private static boolean a(Window window, boolean z) {
        window.getDecorView().setSystemUiVisibility(a(window, z ? 8192 : 256));
        return true;
    }

    private static boolean b(Window window, boolean z) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
                if (z) {
                    method.invoke(window, new Object[]{Integer.valueOf(i), Integer.valueOf(i)});
                    return true;
                }
                method.invoke(window, new Object[]{0, Integer.valueOf(i)});
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static boolean a() {
        return com.shopee.app.util.e.c.b() || com.shopee.app.util.e.c.c() || com.shopee.app.util.e.c.d() || com.shopee.app.util.e.c.e();
    }

    private static boolean c(Window window, boolean z) {
        a(window, z);
        if (window != null) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i = declaredField.getInt((Object) null);
                int i2 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z ? i2 | i : (i ^ -1) & i2);
                window.setAttributes(attributes);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static boolean b() {
        return !com.shopee.app.util.e.c.g() && !com.shopee.app.util.e.c.h();
    }

    public static int a(Context context) {
        if (f26472b == -1) {
            b(context);
        }
        return f26472b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(android.content.Context r4) {
        /*
            r0 = 0
            java.lang.String r1 = "com.android.internal.R$dimen"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Throwable -> 0x0027 }
            java.lang.Object r2 = r1.newInstance()     // Catch:{ Throwable -> 0x0027 }
            boolean r3 = com.shopee.app.util.e.c.f()     // Catch:{ Throwable -> 0x0025 }
            if (r3 == 0) goto L_0x001c
            java.lang.String r3 = "status_bar_height_large"
            java.lang.reflect.Field r0 = r1.getField(r3)     // Catch:{ Throwable -> 0x0018 }
            goto L_0x001c
        L_0x0018:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ Throwable -> 0x0025 }
        L_0x001c:
            if (r0 != 0) goto L_0x002c
            java.lang.String r3 = "status_bar_height"
            java.lang.reflect.Field r0 = r1.getField(r3)     // Catch:{ Throwable -> 0x0025 }
            goto L_0x002c
        L_0x0025:
            r1 = move-exception
            goto L_0x0029
        L_0x0027:
            r1 = move-exception
            r2 = r0
        L_0x0029:
            r1.printStackTrace()
        L_0x002c:
            if (r0 == 0) goto L_0x004b
            if (r2 == 0) goto L_0x004b
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Throwable -> 0x0047 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0047 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Throwable -> 0x0047 }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ Throwable -> 0x0047 }
            int r4 = r4.getDimensionPixelSize(r0)     // Catch:{ Throwable -> 0x0047 }
            f26472b = r4     // Catch:{ Throwable -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r4 = move-exception
            r4.printStackTrace()
        L_0x004b:
            int r4 = f26472b
            if (r4 <= 0) goto L_0x005b
            com.garena.android.appkit.tools.c r0 = com.garena.android.appkit.tools.c.a()
            r1 = 50
            int r0 = r0.a((int) r1)
            if (r4 <= r0) goto L_0x007a
        L_0x005b:
            float r4 = f26471a
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x0070
            com.garena.android.appkit.tools.c r4 = com.garena.android.appkit.tools.c.a()
            r0 = 25
            int r4 = r4.a((int) r0)
            f26472b = r4
            goto L_0x007a
        L_0x0070:
            r0 = 1103626240(0x41c80000, float:25.0)
            float r4 = r4 * r0
            r0 = 1056964608(0x3f000000, float:0.5)
            float r4 = r4 + r0
            int r4 = (int) r4
            f26472b = r4
        L_0x007a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.util.o.c.b(android.content.Context):void");
    }
}
