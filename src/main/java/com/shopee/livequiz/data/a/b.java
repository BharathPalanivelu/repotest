package com.shopee.livequiz.data.a;

import com.shopee.arcatch.data.common_bean.Country;
import com.shopee.livequiz.c;

public class b {
    public static String a() {
        String d2 = com.shopee.sdk.b.a().a().a().d();
        if (Country.COUNTRY_SG.equals(d2)) {
            return "https://cf.shopee.sg/file/";
        }
        if ("ID".equals(d2)) {
            return "https://cf.shopee.co.id/file/";
        }
        if (Country.COUNTRY_MY.equals(d2)) {
            return "https://cf.shopee.com.my/file/";
        }
        if (Country.COUNTRY_TW.equals(d2)) {
            return "https://cf.shopee.tw/file/";
        }
        if (Country.COUNTRY_TH.equals(d2)) {
            return "https://cf.shopee.co.th/file/";
        }
        if (Country.COUNTRY_VN.equals(d2)) {
            return "https://cf.shopee.vn/file/";
        }
        if (Country.COUNTRY_PH.equals(d2)) {
            return "https://cf.shopee.ph/file/";
        }
        if (Country.COUNTRY_IR.equals(d2)) {
            return "https://cf.shopee.co.ir/file/";
        }
        if (Country.COUNTRY_MM.equals(d2)) {
            return "https://cf.shopee.mm/file/";
        }
        return "https://cf.shopee.sg/file/";
    }

    public static String b() {
        return com.garena.android.appkit.tools.b.e(c.h.base_url_meta_bgm);
    }
}
