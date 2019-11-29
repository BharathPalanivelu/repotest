package com.shopee.feeds.feedlibrary.data.c;

import com.appsflyer.share.Constants;
import com.facebook.appevents.UserDataStore;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.shopee.arcatch.data.common_bean.Country;
import com.shopee.arcatch.data.common_bean.ShopeeEnv;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.feeds.feedlibrary.util.j;
import com.shopee.feeds.feedlibrary.util.k;
import com.shopee.feeds.feedlibrary.util.v;
import com.shopee.feeds.feedlibrary.util.y;
import com.shopee.sdk.modules.app.c.a;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.HttpUrl;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f27680a = c();

    /* renamed from: b  reason: collision with root package name */
    public static final String f27681b = (b() + "api/bizproxy");

    /* renamed from: c  reason: collision with root package name */
    public static final String f27682c = d();

    /* renamed from: d  reason: collision with root package name */
    public static final String f27683d = (f27681b + "/product/my_likes");

    /* renamed from: e  reason: collision with root package name */
    public static final String f27684e = (f27681b + "/product/recently_viewed");

    /* renamed from: f  reason: collision with root package name */
    public static final String f27685f = (f27681b + "/product/my_products");

    /* renamed from: g  reason: collision with root package name */
    public static final String f27686g = (f27681b + "/feed/image_text");
    public static final String h = (f27681b + "/feed/video");
    public static final String i = (f27681b + "/feed/buyer_review");
    public static final String j = (f27681b + "/feed/genid");
    public static final String k = (f27681b + "/hashtag/completion");
    public static final String l = (f27681b + "/user/search");
    public static final String m = (f27681b + "/product/items/v2");
    public static final String n = (f27681b + "/user/my_following");
    public static final String o = (f27681b + "/file/image");
    public static final String p = (f27681b + "/feed/video/uploadsign");
    public static final String q = (f27680a + "api/v2/user/login_status");
    public static final String r = (f27681b + "/product/shopitems");
    public static final String s = (f27680a + "api/v2/get_feature_toggles?");
    public static final String t = (f27681b + "/feed/precheck/image_text");
    public static final String u = (f27681b + "/feed/precheck/buyer_review");
    public static final String v = (f27681b + "/feed/precheck/video");
    public static final String w = (f27681b + "/voucher/list/v2");

    public static String a() {
        return r;
    }

    public static String b() {
        String g2 = g();
        String e2 = e();
        return "https://feeds." + e2 + g2 + Constants.URL_PATH_DELIMITER;
    }

    public static String c() {
        String g2 = g();
        String e2 = e();
        return "https://" + e2 + g2 + Constants.URL_PATH_DELIMITER;
    }

    public static String d() {
        String g2 = g();
        return "https://cf." + g2 + "/file/";
    }

    public static String e() {
        String c2 = c.f27687a == 0 ? ShopeeEnv.ENV_TEST : com.shopee.sdk.b.a().a().a().c();
        if (ShopeeEnv.ENV_TEST.equals(c2)) {
            return com.garena.android.appkit.tools.b.e(c.g.env_test);
        }
        if (ShopeeEnv.ENV_UAT.equals(c2)) {
            return com.garena.android.appkit.tools.b.e(c.g.env_uat);
        }
        if (ShopeeEnv.ENV_STAGING.equals(c2)) {
            return com.garena.android.appkit.tools.b.e(c.g.env_staging);
        }
        if ("live".equals(c2)) {
        }
        return "";
    }

    public static String f() {
        String str;
        if (c.f27687a == 0) {
            str = "en";
        } else {
            str = com.shopee.sdk.b.a().a().a().e();
        }
        h.b("", "language is " + str);
        return str;
    }

    public static String g() {
        String str;
        if (c.f27687a == 0) {
            str = "ID";
        } else {
            str = com.shopee.sdk.b.a().a().a().d();
        }
        if (Country.COUNTRY_SG.equals(str)) {
            return com.garena.android.appkit.tools.b.e(c.g.base_url_domain_live_sg);
        }
        if ("ID".equals(str)) {
            return com.garena.android.appkit.tools.b.e(c.g.base_url_domain_live_id);
        }
        if (Country.COUNTRY_MY.equals(str)) {
            return com.garena.android.appkit.tools.b.e(c.g.base_url_domain_live_my);
        }
        if (Country.COUNTRY_TW.equals(str)) {
            return com.garena.android.appkit.tools.b.e(c.g.base_url_domain_live_tw);
        }
        if (Country.COUNTRY_TH.equals(str)) {
            return com.garena.android.appkit.tools.b.e(c.g.base_url_domain_live_th);
        }
        if (Country.COUNTRY_VN.equals(str)) {
            return com.garena.android.appkit.tools.b.e(c.g.base_url_domain_live_vn);
        }
        if (Country.COUNTRY_PH.equals(str)) {
            return com.garena.android.appkit.tools.b.e(c.g.base_url_domain_live_ph);
        }
        if (Country.COUNTRY_IR.equals(str)) {
            return com.garena.android.appkit.tools.b.e(c.g.base_url_domain_live_ir);
        }
        if (Country.COUNTRY_MM.equals(str)) {
            return com.garena.android.appkit.tools.b.e(c.g.base_url_domain_live_mm);
        }
        return com.garena.android.appkit.tools.b.e(c.g.base_url_domain_live_sg);
    }

    public static void h() {
        if (androidx.core.content.b.b(com.shopee.feeds.feedlibrary.b.b().f27287b, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            if (c.f27687a == 0) {
                String h2 = k.h("test_cookie");
                if (!d.a(h2)) {
                    a(h2);
                }
            }
            if (c.f27687a != 1) {
                return;
            }
            if (com.garena.android.appkit.tools.b.e(c.g.env_test).equals(e()) || com.garena.android.appkit.tools.b.e(c.g.env_uat).equals(e())) {
                String c2 = c();
                a g2 = com.shopee.sdk.b.a().g();
                if (HttpUrl.parse(c2) != null) {
                    g2.a(c2, new com.shopee.sdk.f.b<List<Cookie>>() {
                        public void a(int i, String str) {
                        }

                        public void a(List<Cookie> list) {
                            if (list.size() > 0) {
                                for (int i = 0; i < list.size(); i++) {
                                    Cookie cookie = list.get(i);
                                    if (cookie.name().equals("SPC_EC")) {
                                        k.a("test_cookie", cookie.name() + SimpleComparison.EQUAL_TO_OPERATION + cookie.value().substring(1, cookie.value().length() - 1));
                                    }
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    public static void a(String str) {
        if (!d.a(str)) {
            String b2 = b();
            a g2 = com.shopee.sdk.b.a().g();
            HttpUrl parse = HttpUrl.parse(b2);
            if (parse != null) {
                g2.a(b2, Cookie.parse(parse, str), new com.shopee.sdk.f.b<Integer>() {
                    public void a(Integer num) {
                        com.garena.android.appkit.d.a.b("Net", num + "");
                    }

                    public void a(int i, String str) {
                        com.garena.android.appkit.d.a.a("Net", str);
                    }
                });
            }
        }
    }

    public static String b(String str) {
        if (d.a(str)) {
            return "http://xxxxxxx";
        }
        if (str.startsWith("http")) {
            return str;
        }
        return f27682c + str;
    }

    public static boolean i() {
        return j.a().q() == 5 || y.a();
    }

    public static String j() {
        String c2 = c.f27687a == 0 ? ShopeeEnv.ENV_TEST : com.shopee.sdk.b.a().a().a().c();
        String l2 = l();
        if (ShopeeEnv.ENV_TEST.equals(c2)) {
            return "https://deo.shopeemobile.com/shopee/shopee-feed-live-" + l2 + "/admin/upload/sticker/sticker_test.json";
        } else if (ShopeeEnv.ENV_UAT.equals(c2)) {
            return "https://deo.shopeemobile.com/shopee/shopee-feed-live-" + l2 + "/admin/upload/sticker/sticker_uat.json";
        } else if ("live".equals(c2)) {
            return "https://deo.shopeemobile.com/shopee/shopee-feed-live-" + l2 + "/admin/upload/sticker/sticker.json";
        } else {
            return "https://deo.shopeemobile.com/shopee/shopee-feed-live-" + l2 + "/admin/upload/sticker/sticker_test.json";
        }
    }

    public static String k() {
        String c2 = c.f27687a == 0 ? ShopeeEnv.ENV_TEST : com.shopee.sdk.b.a().a().a().c();
        if (ShopeeEnv.ENV_TEST.equals(c2)) {
            return "https://deo.shopeemobile.com/shopee/shopee-feed-live-id/biz/config/dynamic_compression_test.json";
        }
        if (ShopeeEnv.ENV_UAT.equals(c2)) {
            return "https://deo.shopeemobile.com/shopee/shopee-feed-live-id/biz/config/dynamic_compression_uat.json";
        }
        if ("live".equals(c2)) {
            return "https://deo.shopeemobile.com/shopee/shopee-feed-live-id/biz/config/dynamic_compression.json";
        }
        return "https://deo.shopeemobile.com/shopee/shopee-feed-live-id/biz/config/dynamic_compression_test.json";
    }

    public static String l() {
        String b2 = v.b();
        if (Country.COUNTRY_SG.equals(b2)) {
            return "sg";
        }
        if ("ID".equals(b2)) {
            return "id";
        }
        if (Country.COUNTRY_MY.equals(b2)) {
            return "my";
        }
        if (Country.COUNTRY_TW.equals(b2)) {
            return "tw";
        }
        if (Country.COUNTRY_TH.equals(b2)) {
            return "th";
        }
        if (Country.COUNTRY_VN.equals(b2)) {
            return "vn";
        }
        return Country.COUNTRY_PH.equals(b2) ? UserDataStore.PHONE : "";
    }
}
