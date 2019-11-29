package com.shopee.arcatch.b.c;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.arcatch.data.common_bean.Country;
import com.shopee.e.a.a;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f26680a = Pattern.compile("rgba\\((.*)\\)");

    /* renamed from: b  reason: collision with root package name */
    private static DecimalFormatSymbols f26681b = new DecimalFormatSymbols();

    /* renamed from: c  reason: collision with root package name */
    private static DecimalFormat f26682c = new DecimalFormat();

    /* renamed from: d  reason: collision with root package name */
    private static DecimalFormatSymbols f26683d = new DecimalFormatSymbols();

    /* renamed from: e  reason: collision with root package name */
    private static DecimalFormat f26684e = new DecimalFormat();

    /* renamed from: f  reason: collision with root package name */
    private static DecimalFormatSymbols f26685f = new DecimalFormatSymbols();

    /* renamed from: g  reason: collision with root package name */
    private static DecimalFormat f26686g = new DecimalFormat();

    private static int a(float f2, float f3, float f4, float f5) {
        return (((int) ((f2 * 255.0f) + 0.5f)) << 24) | (((int) (f3 + 0.5f)) << 16) | (((int) (f4 + 0.5f)) << 8) | ((int) (f5 + 0.5f));
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float a(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static String a(long j) {
        long j2 = j / 60000;
        long round = (long) Math.round(((float) (j % 60000)) / 1000.0f);
        String str = "";
        if (j2 < 10) {
            str = str + AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        String str2 = str + j2 + ":";
        if (round < 10) {
            str2 = str2 + AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        return str2 + round;
    }

    public static int c(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static Bitmap a(Bitmap bitmap, float f2) {
        Bitmap bitmap2;
        if (bitmap == null) {
            a.b("resizeBitmap fail target is null", new Object[0]);
            return null;
        } else if (bitmap.isRecycled()) {
            a.b("resizeBitmap fail target isRecycled", new Object[0]);
            return null;
        } else if (Float.compare(f2, 1.0f) == 0) {
            return bitmap;
        } else {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(f2, f2);
            try {
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
            } catch (Exception e2) {
                e2.printStackTrace();
                a.a(e2, "CommonUtils resizeBitmap failed", new Object[0]);
                bitmap2 = null;
            }
            if (bitmap2 != null) {
                return bitmap2;
            }
            a.b("resizedBitmap is null", new Object[0]);
            return null;
        }
    }

    static {
        f26681b.setGroupingSeparator('.');
        f26682c.setGroupingSize(3);
        f26682c.setGroupingUsed(true);
        f26682c.setMaximumFractionDigits(0);
        f26682c.setDecimalFormatSymbols(f26681b);
        f26683d.setGroupingSeparator(',');
        f26684e.setGroupingSize(3);
        f26684e.setGroupingUsed(true);
        f26684e.setMaximumFractionDigits(2);
        f26684e.setDecimalFormatSymbols(f26683d);
        f26685f.setGroupingSeparator(',');
        f26686g.setGroupingSize(3);
        f26686g.setGroupingUsed(true);
        f26686g.setMaximumFractionDigits(0);
        f26686g.setDecimalFormatSymbols(f26685f);
    }

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        Matcher matcher = f26680a.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            String[] split = matcher.group(1).split(",");
            if (split.length == 4) {
                float b2 = b(split[0]);
                float b3 = b(split[1]);
                float b4 = b(split[2]);
                float b5 = b(split[3]);
                if (!(Float.compare(b2, -1.0f) == 0 || Float.compare(b3, -1.0f) == 0 || Float.compare(b4, -1.0f) == 0 || Float.compare(b5, -1.0f) == 0)) {
                    return a((float) ((int) b5), b2, b3, b4);
                }
            }
        }
        return -1;
    }

    private static float b(String str) {
        float f2;
        String trim = str.trim();
        if (TextUtils.isEmpty(trim)) {
            return -1.0f;
        }
        try {
            f2 = Float.parseFloat(trim);
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            f2 = -1.0f;
        }
        if (Float.compare(f2, BitmapDescriptorFactory.HUE_RED) < 0 || Float.compare(f2, 255.0f) > 0) {
            return -1.0f;
        }
        return f2;
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 26) {
            activity.findViewById(16908290).setSystemUiVisibility(16);
            activity.getWindow().setNavigationBarColor(androidx.core.content.b.c(activity, 17170443));
        }
    }

    public static boolean a() {
        return Build.FINGERPRINT.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) || Build.FINGERPRINT.startsWith("unknown") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || (Build.BRAND.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) && Build.DEVICE.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE)) || "google_sdk".equals(Build.PRODUCT);
    }

    public static String a(float f2) {
        char c2;
        char c3;
        String d2 = com.shopee.sdk.b.a().a().a().d();
        if ("ID".equals(d2) || Country.COUNTRY_VN.equals(d2)) {
            return f26682c.format((long) ((int) f2));
        }
        if (Country.COUNTRY_SG.equals(d2) || Country.COUNTRY_MY.equals(d2)) {
            return f26686g.format((long) ((int) f2));
        }
        String format = f26684e.format((long) ((int) f2));
        String str = f2 + "";
        int indexOf = str.indexOf(46);
        if (indexOf < 0) {
            return format;
        }
        int length = str.length() - 1;
        if (indexOf == length) {
            return format;
        }
        int i = indexOf + 1;
        if (i == length) {
            c3 = str.charAt(length);
            c2 = '0';
        } else {
            c3 = str.charAt(i);
            c2 = str.charAt(indexOf + 2);
        }
        if (c2 != '0') {
            return format + '.' + c3 + c2;
        } else if (c3 == '0') {
            return format;
        } else {
            return format + '.' + c3;
        }
    }

    public static int b(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics == null) {
            return 0;
        }
        return displayMetrics.widthPixels;
    }

    public static int c(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics == null) {
            return 0;
        }
        return displayMetrics.heightPixels;
    }

    public static int d(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String e(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String str = packageInfo.versionName;
            int i = packageInfo.versionCode;
            return "versionName " + str + " versionCode " + i;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int f(Context context) {
        if (context != null) {
            Resources resources = context.getResources();
            if (resources != null) {
                return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
            }
        }
        return 0;
    }
}
