package com.shopee.feeds.feedlibrary.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.Locale;

public class p {
    public static boolean a(Context context, String str) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        if (packageManager == null) {
            return false;
        }
        for (PackageInfo packageInfo : packageManager.getInstalledPackages(0)) {
            if (str.equals(packageInfo.packageName.toLowerCase(Locale.ENGLISH))) {
                return true;
            }
        }
        return false;
    }
}
