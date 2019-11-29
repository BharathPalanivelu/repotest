package com.beetalk.sdk.f;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.beetalk.sdk.e.a;
import com.beetalk.sdk.e.c;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f5422a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f5423b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f5424c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f5425d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f5426e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f5427f = "";

    public b(Context context) {
        a(context, (String) null);
    }

    private void a(Context context, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = "2.8.3";
        try {
            if (TextUtils.isEmpty(str7)) {
                str7 = "";
            }
            this.f5424c = str7;
            if (context == null || ((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0) {
                str2 = "";
            } else {
                str2 = " tablet";
            }
            if (TextUtils.isEmpty(Build.MODEL)) {
                str3 = "";
            } else {
                str3 = Build.MODEL + str2;
            }
            this.f5422a = str3;
            if (TextUtils.isEmpty(Build.VERSION.RELEASE)) {
                str4 = "Android";
            } else {
                str4 = "Android " + Build.VERSION.RELEASE;
            }
            this.f5423b = str4;
            if (TextUtils.isEmpty(c.b())) {
                str5 = "";
            } else {
                str5 = c.b();
            }
            this.f5425d = str5;
            if (TextUtils.isEmpty(c.a())) {
                str6 = "";
            } else {
                str6 = c.a();
            }
            this.f5426e = str6;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            this.f5427f = str;
        } catch (Exception e2) {
            a.a(e2);
        }
    }

    public String toString() {
        return String.format("%s/%s(%s;%s;%s;%s;%s)", new Object[]{"GarenaMSDK", this.f5424c, this.f5422a, this.f5423b, this.f5425d, this.f5426e, this.f5427f});
    }
}
