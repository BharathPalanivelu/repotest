package com.shopee.app.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.garena.reactpush.b;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.application.ar;
import java.util.Arrays;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f26268a;

    /* renamed from: b  reason: collision with root package name */
    private static a[] f26269b = {new a("samsung", "GT-I9000"), new a("samsung", "GT-I9100"), new a("samsung", "GT-I9300"), new a("HTC", "HTC One X")};

    public static c a() {
        if (f26268a == null) {
            f26268a = new c();
        }
        return f26268a;
    }

    private c() {
    }

    public static boolean b() {
        if (TextUtils.isEmpty(Build.BRAND)) {
            return false;
        }
        if ((TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().contains("xiaomi")) && ((TextUtils.isEmpty(Build.MANUFACTURER) || !Build.MANUFACTURER.toLowerCase().contains("xiaomi")) && (TextUtils.isEmpty(Build.MODEL) || !Build.MODEL.toLowerCase().contains("mi")))) {
            return false;
        }
        return true;
    }

    public String c() {
        return "Brand/" + Build.BRAND.replaceAll(SQLBuilder.BLANK, "_").toLowerCase() + " Model/" + Build.MODEL.replaceAll(SQLBuilder.BLANK, "_").toLowerCase() + " OSVer/" + Build.VERSION.SDK_INT + " Manufacturer/" + Build.MANUFACTURER;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f26270a;

        /* renamed from: b  reason: collision with root package name */
        private String f26271b;

        public a(String str, String str2) {
            this.f26270a = str;
            this.f26271b = str2;
        }
    }

    public static boolean d() {
        return Runtime.getRuntime().availableProcessors() < 4;
    }

    public static boolean e() {
        return Arrays.asList(new String[]{"mdpi", "hdpi", "xhdpi"}).contains(b.a(ar.f().getResources().getDisplayMetrics().density));
    }

    public static boolean a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
        if ((Build.VERSION.SDK_INT >= 19 ? activityManager.isLowRamDevice() : true) || activityManager.getMemoryClass() < 160) {
            return true;
        }
        return false;
    }

    public static String b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return "120 Mb";
        }
        return Math.min(activityManager.getMemoryClass(), Integer.MAX_VALUE) + " Mb";
    }

    public static String f() {
        StringBuilder sb = new StringBuilder();
        if (Build.VERSION.SDK_INT >= 21) {
            for (String append : Build.SUPPORTED_ABIS) {
                sb.append(append);
                sb.append(",");
            }
        } else {
            sb = new StringBuilder(Build.CPU_ABI);
        }
        return sb.toString();
    }

    public static String g() {
        return "Device: " + Build.DEVICE + ", Model: " + Build.MODEL + ", Brand: " + Build.BRAND;
    }

    public static String c(Context context) {
        return context.getPackageManager().getInstallerPackageName(context.getPackageName());
    }

    public static boolean h() {
        try {
            if (Build.VERSION.SDK_INT < 21) {
                return "x86".equals(Build.CPU_ABI);
            }
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr != null) {
                String str = strArr[0];
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -806050265) {
                    if (hashCode == 117110) {
                        if (str.equals("x86")) {
                            c2 = 1;
                        }
                    }
                } else if (str.equals("x86_64")) {
                    c2 = 0;
                }
                if (c2 == 0 || c2 == 1) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public static boolean i() {
        try {
            if (Build.VERSION.SDK_INT >= 21 && Build.SUPPORTED_64_BIT_ABIS.length > 0) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return false;
        }
    }
}
