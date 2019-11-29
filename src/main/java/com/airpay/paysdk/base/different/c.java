package com.airpay.paysdk.base.different;

import com.airpay.paysdk.c;
import com.shopee.arcatch.data.common_bean.Country;
import java.util.Locale;

public class c implements b {
    public String b() {
        return Country.COUNTRY_TH;
    }

    public String e() {
        return "021189170";
    }

    public String f() {
        return "THB";
    }

    public int g() {
        return 10000;
    }

    public long h() {
        return 100;
    }

    public double i() {
        return 10000.0d;
    }

    public long j() {
        return 10000;
    }

    public static b a() {
        return new c();
    }

    public int k() {
        return c.d.icon_payment_cash_page_th;
    }

    public Locale l() {
        return new Locale("th", b());
    }
}
