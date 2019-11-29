package com.linecorp.linesdk.a.a.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.appsflyer.share.Constants;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.Locale;

final class e {

    /* renamed from: a  reason: collision with root package name */
    private final PackageInfo f15009a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15010b;

    /* renamed from: c  reason: collision with root package name */
    private String f15011c;

    e(Context context, String str) {
        this.f15009a = a(context);
        this.f15010b = str;
    }

    public final String a() {
        String str = this.f15011c;
        if (str != null) {
            return str;
        }
        PackageInfo packageInfo = this.f15009a;
        String str2 = "UNK";
        String str3 = packageInfo == null ? str2 : packageInfo.packageName;
        PackageInfo packageInfo2 = this.f15009a;
        if (packageInfo2 != null) {
            str2 = packageInfo2.versionName;
        }
        Locale locale = Locale.getDefault();
        this.f15011c = str3 + Constants.URL_PATH_DELIMITER + str2 + " ChannelSDK/" + this.f15010b + " (Linux; U; Android " + Build.VERSION.RELEASE + "; " + locale.getLanguage() + "-" + locale.getCountry() + "; " + Build.MODEL + " Build/" + Build.ID + SQLBuilder.PARENTHESES_RIGHT;
        return this.f15011c;
    }

    private static PackageInfo a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            throw null;
        }
    }
}
