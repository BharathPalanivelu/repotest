package com.shopee.live.livestreaming.util;

import com.appsflyer.share.Constants;
import com.garena.android.appkit.tools.b;
import com.shopee.arcatch.data.common_bean.Country;
import com.shopee.arcatch.data.common_bean.ShopeeEnv;
import com.shopee.live.livestreaming.c;

public class p {
    public static String a() {
        String a2 = x.a();
        if (Country.COUNTRY_SG.equals(a2)) {
            return b.e(c.g.live_streaming_base_url_domain_live_sg);
        }
        if ("ID".equals(a2)) {
            return b.e(c.g.live_streaming_base_url_domain_live_id);
        }
        if (Country.COUNTRY_MY.equals(a2)) {
            return b.e(c.g.live_streaming_base_url_domain_live_my);
        }
        if (Country.COUNTRY_TW.equals(a2)) {
            return b.e(c.g.live_streaming_base_url_domain_live_tw);
        }
        if (Country.COUNTRY_TH.equals(a2)) {
            return b.e(c.g.live_streaming_base_url_domain_live_th);
        }
        if (Country.COUNTRY_VN.equals(a2)) {
            return b.e(c.g.live_streaming_base_url_domain_live_vn);
        }
        if (Country.COUNTRY_PH.equals(a2)) {
            return b.e(c.g.live_streaming_base_url_domain_live_ph);
        }
        if (Country.COUNTRY_IR.equals(a2)) {
            return b.e(c.g.live_streaming_base_url_domain_live_ir);
        }
        if (Country.COUNTRY_MM.equals(a2)) {
            return b.e(c.g.live_streaming_base_url_domain_live_mm);
        }
        return b.e(c.g.live_streaming_base_url_domain_live_sg);
    }

    public static String b() {
        String a2 = a();
        String f2 = f();
        return "https://live." + f2 + a2 + Constants.URL_PATH_DELIMITER;
    }

    public static String c() {
        String a2 = x.a();
        if (Country.COUNTRY_SG.equals(a2)) {
            return b.e(c.g.live_streaming_base_url_meta_sg);
        }
        if ("ID".equals(a2)) {
            return b.e(c.g.live_streaming_base_url_meta_id);
        }
        if (Country.COUNTRY_MY.equals(a2)) {
            return b.e(c.g.live_streaming_base_url_meta_my);
        }
        if (Country.COUNTRY_TW.equals(a2)) {
            return b.e(c.g.live_streaming_base_url_meta_tw);
        }
        if (Country.COUNTRY_TH.equals(a2)) {
            return b.e(c.g.live_streaming_base_url_meta_th);
        }
        if (Country.COUNTRY_VN.equals(a2)) {
            return b.e(c.g.live_streaming_base_url_meta_vn);
        }
        if (Country.COUNTRY_PH.equals(a2)) {
            return b.e(c.g.live_streaming_base_url_meta_ph);
        }
        if (Country.COUNTRY_IR.equals(a2)) {
            return b.e(c.g.live_streaming_base_url_meta_ir);
        }
        if (Country.COUNTRY_MM.equals(a2)) {
            return b.e(c.g.live_streaming_base_url_meta_mm);
        }
        return b.e(c.g.live_streaming_base_url_meta_sg);
    }

    public static String a(String str) {
        if (d.a(str)) {
            return "";
        }
        return c() + str + "_tn";
    }

    public static String b(String str) {
        if (d.a(str)) {
            return "";
        }
        return c() + str;
    }

    public static String d() {
        String b2 = x.b();
        if (ShopeeEnv.ENV_TEST.equals(b2)) {
            return "https://deo.shopeemobile.com/shopee/shopee-toclivestream/download/test/1558682791";
        }
        if (ShopeeEnv.ENV_UAT.equals(b2)) {
            return "https://deo.shopeemobile.com/shopee/shopee-toclivestream/download/uat/1558682791";
        }
        if (!ShopeeEnv.ENV_STAGING.equals(b2) && "live".equals(b2)) {
            return "https://deo.shopeemobile.com/shopee/shopee-toclivestream/download/live/1558682791";
        }
        return "https://deo.shopeemobile.com/shopee/shopee-toclivestream/download/test/1558682791";
    }

    public static String e() {
        String b2 = x.b();
        if (ShopeeEnv.ENV_TEST.equals(b2)) {
            return "https://deo.shopeemobile.com/shopee/shopee-toclivestream/download/test/190617758798";
        }
        if (ShopeeEnv.ENV_UAT.equals(b2)) {
            return "https://deo.shopeemobile.com/shopee/shopee-toclivestream/download/uat/190617758798";
        }
        if (!ShopeeEnv.ENV_STAGING.equals(b2) && "live".equals(b2)) {
            return "https://deo.shopeemobile.com/shopee/shopee-toclivestream/download/live/190617758798";
        }
        return "https://deo.shopeemobile.com/shopee/shopee-toclivestream/download/test/190617758798";
    }

    public static String f() {
        String b2 = x.b();
        if (ShopeeEnv.ENV_TEST.equals(b2)) {
            return b.e(c.g.live_streaming_env_test);
        }
        if (ShopeeEnv.ENV_UAT.equals(b2)) {
            return b.e(c.g.live_streaming_env_uat);
        }
        if (ShopeeEnv.ENV_STAGING.equals(b2)) {
            return b.e(c.g.live_streaming_env_staging);
        }
        if ("live".equals(b2)) {
        }
        return "";
    }
}
