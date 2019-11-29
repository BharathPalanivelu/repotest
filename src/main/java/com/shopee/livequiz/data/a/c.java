package com.shopee.livequiz.data.a;

import com.shopee.arcatch.data.common_bean.Country;
import com.shopee.sdk.b;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f29816a = {"whatsapp", "facebookMessenger", "twitter"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f29817b = {"whatsapp", "facebookMessenger", "twitter", "lineChat", "facebookLink", "instagram"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f29818c = {"whatsapp", "lineChat", "facebookLink"};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f29819d = {"whatsapp", "lineChat", "facebookLink", "instagram", "facebookMessenger", "twitter"};

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f29820e = {"lineChat", "facebookMessenger", "twitter"};

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f29821f = {"lineChat", "facebookMessenger", "twitter", "facebookLink", "instagram", "whatsapp"};

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f29822g = {"facebookMessenger", "facebookLink", "whatsapp"};
    public static final String[] h = {"facebookMessenger", "facebookLink", "whatsapp", "lineChat", "instagram", "twitter"};
    public static final String[] i = {"lineChat", "facebookMessenger", "whatsapp"};
    public static final String[] j = {"lineChat", "facebookMessenger", "whatsapp", "facebookLink", "instagram"};
    public static final String[] k = {"facebookMessenger", "whatsapp", "facebookLink"};
    public static final String[] l = {"facebookMessenger", "whatsapp", "facebookLink", "instagram"};
    public static final String[] m = {"whatsapp", "facebookMessenger", "lineChat"};
    public static final String[] n = {"whatsapp", "facebookMessenger", "lineChat", "facebookLink", "instagram", "twitter"};

    public static String[] a() {
        String d2 = b.a().a().a().d();
        if (Country.COUNTRY_SG.equals(d2)) {
            return f29816a;
        }
        if ("ID".equals(d2)) {
            return f29818c;
        }
        if (Country.COUNTRY_MY.equals(d2)) {
            return m;
        }
        if (Country.COUNTRY_TW.equals(d2)) {
            return i;
        }
        if (Country.COUNTRY_TH.equals(d2)) {
            return f29820e;
        }
        if (Country.COUNTRY_VN.equals(d2)) {
            return k;
        }
        if (Country.COUNTRY_PH.equals(d2)) {
            return f29822g;
        }
        return f29816a;
    }

    public static String[] b() {
        String d2 = b.a().a().a().d();
        if (Country.COUNTRY_SG.equals(d2)) {
            return f29817b;
        }
        if ("ID".equals(d2)) {
            return f29819d;
        }
        if (Country.COUNTRY_MY.equals(d2)) {
            return n;
        }
        if (Country.COUNTRY_TW.equals(d2)) {
            return j;
        }
        if (Country.COUNTRY_TH.equals(d2)) {
            return f29821f;
        }
        if (Country.COUNTRY_VN.equals(d2)) {
            return l;
        }
        if (Country.COUNTRY_PH.equals(d2)) {
            return h;
        }
        return f29817b;
    }
}
