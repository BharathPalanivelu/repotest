package com.shopee.liveimsdk.custom.b;

import com.appsflyer.share.Constants;
import com.shopee.arcatch.data.common_bean.Country;
import com.shopee.arcatch.data.common_bean.ShopeeEnv;
import com.shopee.liveimsdk.d;

public class a {
    private static String b() {
        if (ShopeeEnv.ENV_TEST.equals(d.f29666b)) {
            return "test.";
        }
        if (ShopeeEnv.ENV_UAT.equals(d.f29666b)) {
            return "uat.";
        }
        if (ShopeeEnv.ENV_STAGING.equals(d.f29666b)) {
            return "staging.";
        }
        if ("live".equals(d.f29666b)) {
        }
        return "";
    }

    private static String c() {
        if (d.f29667c == null) {
            return "shopee.sg";
        }
        String str = d.f29667c;
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 2331) {
            if (hashCode != 2345) {
                if (hashCode != 2464) {
                    if (hashCode != 2476) {
                        if (hashCode != 2552) {
                            if (hashCode != 2644) {
                                if (hashCode != 2676) {
                                    if (hashCode != 2691) {
                                        if (hashCode == 2744 && str.equals(Country.COUNTRY_VN)) {
                                            c2 = 5;
                                        }
                                    } else if (str.equals(Country.COUNTRY_TW)) {
                                        c2 = 4;
                                    }
                                } else if (str.equals(Country.COUNTRY_TH)) {
                                    c2 = 3;
                                }
                            } else if (str.equals(Country.COUNTRY_SG)) {
                                c2 = 0;
                            }
                        } else if (str.equals(Country.COUNTRY_PH)) {
                            c2 = 6;
                        }
                    } else if (str.equals(Country.COUNTRY_MY)) {
                        c2 = 2;
                    }
                } else if (str.equals(Country.COUNTRY_MM)) {
                    c2 = 8;
                }
            } else if (str.equals(Country.COUNTRY_IR)) {
                c2 = 7;
            }
        } else if (str.equals("ID")) {
            c2 = 1;
        }
        switch (c2) {
            case 0:
                return "shopee.sg";
            case 1:
                return "shopee.co.id";
            case 2:
                return "shopee.com.my";
            case 3:
                return "shopee.co.th";
            case 4:
                return "shopee.tw";
            case 5:
                return "shopee.vn";
            case 6:
                return "shopee.ph";
            case 7:
                return "shopee.co.ir";
            case 8:
                return "shopee.com.mm";
            default:
                return "shopee.sg";
        }
    }

    public static String a() {
        String c2 = c();
        String b2 = b();
        return "https://chatroom-live." + b2 + c2 + Constants.URL_PATH_DELIMITER;
    }
}
