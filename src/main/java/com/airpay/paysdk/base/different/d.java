package com.airpay.paysdk.base.different;

import com.airpay.paysdk.c;
import com.path.android.jobqueue.JobManager;
import com.shopee.arcatch.data.common_bean.Country;
import java.util.Locale;

public class d implements b {
    public String b() {
        return Country.COUNTRY_VN;
    }

    public String e() {
        return "19006906";
    }

    public String f() {
        return "VND";
    }

    public int g() {
        return 1000000;
    }

    public long h() {
        return 1;
    }

    public double i() {
        return 1000000.0d;
    }

    public long j() {
        return JobManager.NS_PER_MS;
    }

    public static b a() {
        return new d();
    }

    public int k() {
        return c.d.icon_payment_cash_page_vn;
    }

    public Locale l() {
        return new Locale("vi", b());
    }
}
