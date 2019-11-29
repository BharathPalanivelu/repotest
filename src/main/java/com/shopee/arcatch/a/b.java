package com.shopee.arcatch.a;

import com.facebook.appevents.UserDataStore;
import com.shopee.arcatch.c.c.a;
import com.shopee.arcatch.data.common_bean.Country;

public class b {
    public static String a() {
        if (a.f26749a) {
            return a.f26750b;
        }
        return com.shopee.sdk.b.a().a().a().c();
    }

    public static String b() {
        if (a.f26751c) {
            return a.f26752d;
        }
        String d2 = com.shopee.sdk.b.a().a().a().d();
        char c2 = 65535;
        int hashCode = d2.hashCode();
        if (hashCode != 2307) {
            if (hashCode != 2331) {
                if (hashCode != 2345) {
                    if (hashCode != 2464) {
                        if (hashCode != 2476) {
                            if (hashCode != 2552) {
                                if (hashCode != 2644) {
                                    if (hashCode != 2676) {
                                        if (hashCode != 2691) {
                                            if (hashCode == 2744 && d2.equals(Country.COUNTRY_VN)) {
                                                c2 = 5;
                                            }
                                        } else if (d2.equals(Country.COUNTRY_TW)) {
                                            c2 = 3;
                                        }
                                    } else if (d2.equals(Country.COUNTRY_TH)) {
                                        c2 = 4;
                                    }
                                } else if (d2.equals(Country.COUNTRY_SG)) {
                                    c2 = 0;
                                }
                            } else if (d2.equals(Country.COUNTRY_PH)) {
                                c2 = 6;
                            }
                        } else if (d2.equals(Country.COUNTRY_MY)) {
                            c2 = 2;
                        }
                    } else if (d2.equals(Country.COUNTRY_MM)) {
                        c2 = 7;
                    }
                } else if (d2.equals(Country.COUNTRY_IR)) {
                    c2 = 8;
                }
            } else if (d2.equals("ID")) {
                c2 = 1;
            }
        } else if (d2.equals(Country.COUNTRY_HK)) {
            c2 = 9;
        }
        switch (c2) {
            case 0:
                return "sg";
            case 1:
                return "co.id";
            case 2:
                return "com.my";
            case 3:
                return "tw";
            case 4:
                return "co.th";
            case 5:
                return "vn";
            case 6:
                return UserDataStore.PHONE;
            case 7:
                return "om.mm";
            case 8:
                return "co.ir";
            default:
                return "sg";
        }
    }
}
