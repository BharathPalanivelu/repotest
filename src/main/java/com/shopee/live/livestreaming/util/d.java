package com.shopee.live.livestreaming.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.shopee.shopeetracker.ShopeeTracker;
import java.util.regex.Pattern;

public class d {
    public static void a(Activity activity) {
        if (activity.getCurrentFocus() != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public static boolean a(String str) {
        return str == null || "".equals(str) || "null".equals(str);
    }

    public static boolean b(String str) {
        if (str == null || "".equals(str) || !Pattern.compile("[0-9]*").matcher(str).matches()) {
            return false;
        }
        return true;
    }

    @SuppressLint({"DefaultLocale"})
    public static String a(long j) {
        if (j < 60) {
            return String.format("00:00:%02d", new Object[]{Long.valueOf(j % 60)});
        } else if (j < ShopeeTracker.PERIOD_IN_SECS) {
            return String.format("00:%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
        } else {
            return String.format("%02d:%02d:%02d", new Object[]{Long.valueOf(j / ShopeeTracker.PERIOD_IN_SECS), Long.valueOf((j % ShopeeTracker.PERIOD_IN_SECS) / 60), Long.valueOf(j % 60)});
        }
    }

    /**
     * kalau width lebih besar dibandingkan height
     * @param context
     * @return
     */
    public static int a(Context context) {
        if (context == null) {
            return -1;
        }
        return w.a(context) > w.b(context) ? 1 : 0;
    }
}
