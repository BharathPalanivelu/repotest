package com.shopee.app.util.e;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f26342a = {"m9", "M9", "mx", "MX"};

    /* renamed from: b  reason: collision with root package name */
    private static String f26343b;

    /* renamed from: c  reason: collision with root package name */
    private static String f26344c;

    /* renamed from: d  reason: collision with root package name */
    private static String f26345d;

    /* renamed from: e  reason: collision with root package name */
    private static String f26346e;

    /* renamed from: f  reason: collision with root package name */
    private static String f26347f;

    /* renamed from: g  reason: collision with root package name */
    private static String f26348g;
    private static boolean h = false;
    private static boolean i = false;

    static {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            try {
                Properties properties = new Properties();
                properties.load(fileInputStream);
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
                f26343b = a(properties, declaredMethod, "ro.miui.ui.version.name");
                f26344c = a(properties, declaredMethod, "ro.build.display.id");
                f26345d = a(properties, declaredMethod, "ro.build.version.emui");
                f26346e = a(properties, declaredMethod, "ro.build.version.opporom");
                f26347f = a(properties, declaredMethod, "ro.vivo.os.version");
                f26348g = a(properties, declaredMethod, "ro.smartisan.version");
            } catch (Exception unused) {
            } catch (Throwable th2) {
                th = th2;
                a((Closeable) fileInputStream);
                throw th;
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            a((Closeable) fileInputStream);
            throw th;
        }
        a((Closeable) fileInputStream);
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean a() {
        return !TextUtils.isEmpty(f26344c) && f26344c.contains("flyme");
    }

    public static boolean b() {
        return "v5".equals(f26343b);
    }

    public static boolean c() {
        return "v6".equals(f26343b);
    }

    public static boolean d() {
        return "v7".equals(f26343b);
    }

    public static boolean e() {
        return "v8".equals(f26343b);
    }

    public static boolean f() {
        return a(f26342a) || a();
    }

    public static boolean g() {
        String str = Build.MODEL;
        return str != null && str.toLowerCase().contains("zuk z1");
    }

    public static boolean h() {
        String str = Build.MODEL;
        return str != null && str.toLowerCase().contains("zte c2016");
    }

    private static boolean a(String[] strArr) {
        String str = Build.BOARD;
        if (str == null) {
            return false;
        }
        for (String equals : strArr) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    private static String a(Properties properties, Method method, String str) {
        String property = properties.getProperty(str);
        if (property == null) {
            try {
                property = (String) method.invoke((Object) null, new Object[]{str});
            } catch (Exception unused) {
            }
        }
        return property != null ? property.toLowerCase() : property;
    }
}
