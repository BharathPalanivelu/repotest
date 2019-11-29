package com.shopee.livequiz.data.a;

import com.appsflyer.share.Constants;
import com.shopee.arcatch.data.common_bean.Country;
import com.shopee.arcatch.data.common_bean.ShopeeEnv;
import com.shopee.livequiz.c;
import com.shopee.sdk.b;

public class a {
    private static String c() {
        String c2 = b.a().a().a().c();
        if (ShopeeEnv.ENV_TEST.equals(c2)) {
            return com.garena.android.appkit.tools.b.e(c.h.env_test);
        }
        if (ShopeeEnv.ENV_UAT.equals(c2)) {
            return com.garena.android.appkit.tools.b.e(c.h.env_uat);
        }
        if (ShopeeEnv.ENV_STAGING.equals(c2)) {
            return com.garena.android.appkit.tools.b.e(c.h.env_staging);
        }
        if ("live".equals(c2)) {
        }
        return "";
    }

    private static String d() {
        String d2 = b.a().a().a().d();
        if (Country.COUNTRY_SG.equals(d2)) {
            return com.garena.android.appkit.tools.b.e(c.h.base_url_domain_live_sg);
        }
        if ("ID".equals(d2)) {
            return com.garena.android.appkit.tools.b.e(c.h.base_url_domain_live_id);
        }
        if (Country.COUNTRY_MY.equals(d2)) {
            return com.garena.android.appkit.tools.b.e(c.h.base_url_domain_live_my);
        }
        if (Country.COUNTRY_TW.equals(d2)) {
            return com.garena.android.appkit.tools.b.e(c.h.base_url_domain_live_tw);
        }
        if (Country.COUNTRY_TH.equals(d2)) {
            return com.garena.android.appkit.tools.b.e(c.h.base_url_domain_live_th);
        }
        if (Country.COUNTRY_VN.equals(d2)) {
            return com.garena.android.appkit.tools.b.e(c.h.base_url_domain_live_vn);
        }
        if (Country.COUNTRY_PH.equals(d2)) {
            return com.garena.android.appkit.tools.b.e(c.h.base_url_domain_live_ph);
        }
        if (Country.COUNTRY_IR.equals(d2)) {
            return com.garena.android.appkit.tools.b.e(c.h.base_url_domain_live_ir);
        }
        if (Country.COUNTRY_MM.equals(d2)) {
            return com.garena.android.appkit.tools.b.e(c.h.base_url_domain_live_mm);
        }
        return com.garena.android.appkit.tools.b.e(c.h.base_url_domain_live_sg);
    }

    public static String a() {
        String d2 = d();
        String c2 = c();
        return "https://games." + c2 + d2 + Constants.URL_PATH_DELIMITER;
    }

    public static String b() {
        String d2 = d();
        String c2 = c();
        return "https://live." + c2 + d2 + Constants.URL_PATH_DELIMITER;
    }
}
