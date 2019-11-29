package com.crashlytics.android.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import io.a.a.a.a.b.p;

class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f6397a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6398b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6399c;

    /* renamed from: d  reason: collision with root package name */
    public final String f6400d;

    /* renamed from: e  reason: collision with root package name */
    public final String f6401e;

    /* renamed from: f  reason: collision with root package name */
    public final String f6402f;

    public static a a(Context context, p pVar, String str, String str2) throws PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        String i = pVar.i();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        return new a(str, str2, i, packageName, Integer.toString(packageInfo.versionCode), packageInfo.versionName == null ? "0.0" : packageInfo.versionName);
    }

    a(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f6397a = str;
        this.f6398b = str2;
        this.f6399c = str3;
        this.f6400d = str4;
        this.f6401e = str5;
        this.f6402f = str6;
    }
}
