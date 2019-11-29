package com.facebook.marketing.internal;

import android.os.Build;
import android.util.Log;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class MarketingUtils {
    private static final String TAG = "com.facebook.marketing.internal.MarketingUtils";

    public static boolean isEmulator() {
        return Build.FINGERPRINT.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) || Build.FINGERPRINT.startsWith("unknown") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || (Build.BRAND.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) && Build.DEVICE.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE)) || "google_sdk".equals(Build.PRODUCT);
    }

    public static double normalizePrice(String str) {
        try {
            return NumberFormat.getNumberInstance(Locale.getDefault()).parse(str.replaceAll("[^\\d,.+-]", "")).doubleValue();
        } catch (ParseException e2) {
            Log.e(TAG, "Error parsing price: ", e2);
            return 0.0d;
        }
    }
}
