package com.shopee.app.g;

import android.text.ClipboardManager;
import com.appsflyer.share.Constants;
import com.garena.android.appkit.d.a;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.h.r;
import com.shopee.app.util.au;
import com.shopee.app.util.i;
import com.shopee.id.R;

public class m {

    /* renamed from: a  reason: collision with root package name */
    public static final String f17570a = b.e(R.string.tw_app_key);

    /* renamed from: b  reason: collision with root package name */
    public static final String f17571b = b.e(R.string.tw_secret);

    public static String a(String str, String str2, String str3, String str4, String str5, String str6) {
        if (str2 != null) {
            str = str.replace("{{product_name}}", str2);
        }
        if (str3 != null) {
            str = str.replace("{{shop_name}}", str3);
        }
        if (str4 != null) {
            str = str.replace("{{user_name}}", str4);
        }
        if (str5 != null) {
            str = str.replace("{{product_link}}", str5).replace("{{shop_link}}", str5);
        }
        if (str6 == null) {
            return str;
        }
        try {
            return str.replace("{{price}}", au.b(Long.valueOf(Long.parseLong(str6)).longValue()));
        } catch (NumberFormatException e2) {
            a.a(e2);
            return str.replace("{{price}}", str6);
        }
    }

    public static String a(long j, String str) {
        return i.f7041d + str + Constants.URL_PATH_DELIMITER + j;
    }

    public static void a(String str, String str2) {
        ((ClipboardManager) ar.a().getSystemService("clipboard")).setText(str);
        r.a().a(str2);
    }
}
