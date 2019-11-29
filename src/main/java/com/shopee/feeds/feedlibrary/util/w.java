package com.shopee.feeds.feedlibrary.util;

import android.content.Context;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.SimpleAdapter;
import com.facebook.appevents.AppEventsConstants;
import com.shopee.feeds.feedlibrary.b;

public class w {

    /* renamed from: a  reason: collision with root package name */
    public static final SimpleAdapter.ViewBinder f28393a = new SimpleAdapter.ViewBinder() {
        public boolean setViewValue(View view, Object obj, String str) {
            if (!(view instanceof CheckedTextView)) {
                return false;
            }
            ((CheckedTextView) view).setText(str);
            return true;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static String f28394b = "UI_UTILS";

    /* renamed from: c  reason: collision with root package name */
    private static CharacterStyle f28395c = new ForegroundColorSpan(-16776961);

    /* renamed from: d  reason: collision with root package name */
    private static boolean f28396d = false;

    public static int a(Context context, int i) {
        return (int) ((((float) i) / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int b(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static String a(String str) {
        if (d.a(str) || str.length() != 9) {
            return str;
        }
        return "#" + str.substring(3, 9) + str.substring(1, 3);
    }

    public static String a(int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = (16711680 & i) >> 16;
        int i3 = (65280 & i) >> 8;
        int i4 = i & 255;
        try {
            sb.append("#");
            sb.append(b(i2));
            sb.append(b(i3));
            sb.append(b(i4));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return sb.toString();
    }

    public static String b(int i) {
        StringBuilder sb = new StringBuilder(8);
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        if (i == 0) {
            return "00";
        }
        while (i != 0) {
            sb.append(cArr[i % 16]);
            i /= 16;
        }
        String sb2 = sb.reverse().toString();
        if (sb2.length() != 1) {
            return sb2;
        }
        return AppEventsConstants.EVENT_PARAM_VALUE_NO + sb2;
    }

    public static int c(int i) {
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), i == -2 ? 0 : 1073741824);
    }

    public static float a(float f2) {
        try {
            return (f2 * 375.0f) / ((float) a(b.b().c(), a(b.b().c())));
        } catch (Exception e2) {
            e2.printStackTrace();
            return f2;
        }
    }
}
