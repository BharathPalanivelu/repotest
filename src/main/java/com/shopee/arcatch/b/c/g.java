package com.shopee.arcatch.b.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@TargetApi(19)
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f26692a = false;

    public static void a(Window window) {
        if (window != null) {
            f26692a = a(window, true);
        }
    }

    public static void a(View view) {
        if (view != null) {
            a(a(view.getContext()), view);
        }
    }

    public static void a(int i, View view) {
        if (f26692a && view != null) {
            if (view.getLayoutParams().height >= 0) {
                view.getLayoutParams().height += i;
            }
            view.setPadding(0, i, 0, 0);
            view.setLayoutParams(view.getLayoutParams());
        }
    }

    private static boolean a(Window window, boolean z) {
        if (Build.BRAND.equalsIgnoreCase("htc") && Build.MODEL.contains("M8w")) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 19 || !c(window, z)) {
            if (Build.VERSION.SDK_INT >= 19 && b(window, z)) {
                window.setFlags(67108864, 67108864);
                return true;
            } else if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
                window.addFlags(67108864);
                return true;
            } else if (Build.VERSION.SDK_INT < 21) {
                return false;
            } else {
                window.clearFlags(67108864);
                View decorView = window.getDecorView();
                if (decorView != null) {
                    if (Build.VERSION.SDK_INT < 23 || !z) {
                        decorView.setSystemUiVisibility(1280);
                    } else {
                        decorView.setSystemUiVisibility(9472);
                    }
                }
                window.addFlags(RNCartPanelDataEntity.NULL_VALUE);
                if (!z || (!Build.BRAND.equalsIgnoreCase("oppo") && !Build.BRAND.equalsIgnoreCase("vivo"))) {
                    window.setStatusBarColor(0);
                    return true;
                }
                window.setStatusBarColor(33554431);
                return true;
            }
        } else if (z) {
            window.setFlags(67108864, 67108864);
            window.addFlags(RNCartPanelDataEntity.NULL_VALUE);
            View decorView2 = window.getDecorView();
            if (decorView2 == null) {
                return true;
            }
            decorView2.setSystemUiVisibility(8192);
            return true;
        } else {
            window.setFlags(67108864, 67108864);
            View decorView3 = window.getDecorView();
            if (decorView3 == null) {
                return true;
            }
            decorView3.setSystemUiVisibility(decorView3.getSystemUiVisibility() & -8193);
            return true;
        }
    }

    private static boolean b(Window window, boolean z) {
        if (window == null) {
            return false;
        }
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
            return false;
        }
    }

    private static boolean c(Window window, boolean z) {
        if (window == null) {
            return false;
        }
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_TRANSPARENT").getInt(cls2);
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
            if (z) {
                int i3 = i2 | i;
                method.invoke(window, new Object[]{Integer.valueOf(i3), Integer.valueOf(i3)});
            } else {
                method.invoke(window, new Object[]{Integer.valueOf(i), Integer.valueOf(i2 | i)});
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int a(Context context) {
        int i;
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            i = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e2) {
            e2.printStackTrace();
            i = -1;
        }
        return i == -1 ? (int) TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics()) : i;
    }
}
