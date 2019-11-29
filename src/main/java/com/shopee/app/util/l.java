package com.shopee.app.util;

import android.os.Build;
import com.beetalk.sdk.l;
import com.facebook.share.internal.ShareConstants;
import com.garena.android.appkit.tools.a.b;
import java.util.ArrayList;
import java.util.List;

public class l {
    public static final String A = ("android/" + Build.VERSION.SDK_INT + " device/" + Build.MANUFACTURER + Build.MODEL + " app/" + 297 + " country/" + "ID");
    public static final String B;

    /* renamed from: a  reason: collision with root package name */
    public static final String f7045a = (i.f7040c + "help_center/");

    /* renamed from: b  reason: collision with root package name */
    public static final String f7046b = (i.f7040c + "buyer/request_delete_account/");

    /* renamed from: c  reason: collision with root package name */
    public static final String f7047c = (f7045a + "answer/" + "3312/");

    /* renamed from: d  reason: collision with root package name */
    public static String f7048d;

    /* renamed from: e  reason: collision with root package name */
    public static String f7049e = (i.f7040c + "backend/CMS/blw.json");

    /* renamed from: f  reason: collision with root package name */
    public static String f7050f = (i.f7040c + "backend/CMS/seller_collection/");

    /* renamed from: g  reason: collision with root package name */
    public static String f7051g = (i.f7040c + "backend/CMS/hotwords.json");
    public static String h = (i.f7040c + "backend/CMS/hotwordsv2.json");
    public static String i = (i.f7040c + "backend/CMS/hot_hashtags.json");
    public static final String j = (i.f7041d + "communityrules/");
    public static final String k = (i.f7041d + "tips/");
    public static final String l = (i.f7041d + "terms");
    public static final String m = (i.f7041d + ShareConstants.WEB_DIALOG_PARAM_PRIVACY);
    public static final String n = ("seller" + i.f7042e);
    public static final String o = (i.f7040c + "contact-us");
    public static final int p = (b.a.q * 3);
    public static String q = (i.f7040c + "backend/CMS/app_theme/");
    public static String r = (i.f7040c + "ccms/shopee/conf_a/conf.json");
    public static String s = "http://203.116.180.99/crash/logs/";
    public static String t = "crash.shopeemobile.com";
    public static String u = "http://203.117.155.185/crash";
    public static String v = "test.crash.shopee.com";
    public static String w = "#EE4D2D";
    public static Integer x = 0;
    public static l.a y = l.a.PRODUCTION;
    public static List<String> z = new ArrayList();

    public interface a {

        /* renamed from: a  reason: collision with root package name */
        public static final String f7052a = (i.f7040c + "ccms/shopee_dev/conf_a/conf.json");
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(i.f7040c);
        sb.append("backend/CMS/banners.json");
        f7048d = sb.toString();
        z.add("Acerz220");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("userstats");
        sb2.append(i.f7042e);
        B = sb2.toString();
    }
}
