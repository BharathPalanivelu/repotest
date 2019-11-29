package com.airpay.paysdk.base.different;

import android.text.TextUtils;
import com.airpay.paysdk.c;
import com.shopee.arcatch.data.common_bean.Country;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Locale;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private b f3825a;

    /* renamed from: b  reason: collision with root package name */
    private String f3826b;

    /* renamed from: com.airpay.paysdk.base.different.a$a  reason: collision with other inner class name */
    private static final class C0071a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final a f3827a = new a();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object a(Object obj, Method method, Object[] objArr) throws Throwable {
        Class<?> returnType = method.getReturnType();
        return (returnType == String.class || returnType == Locale.class) ? null : 0;
    }

    public static a a() {
        return C0071a.f3827a;
    }

    private a() {
        this.f3825a = (b) Proxy.newProxyInstance(b.class.getClassLoader(), new Class[]{b.class}, $$Lambda$a$5DGeS6FP5NmbQBYSvCfSPZuwK9o.INSTANCE);
        this.f3826b = "en";
    }

    public a a(String str) {
        if (Country.COUNTRY_TH.equalsIgnoreCase(str)) {
            this.f3825a = c.a();
        } else if (Country.COUNTRY_VN.equalsIgnoreCase(str)) {
            this.f3825a = d.a();
        }
        return this;
    }

    public void b(String str) {
        this.f3826b = str;
    }

    public String b() {
        String b2 = this.f3825a.b();
        return TextUtils.isEmpty(b2) ? Country.COUNTRY_TH : b2;
    }

    public int c() {
        if ("th".equalsIgnoreCase(d())) {
            return c.d.payment_code_help_th;
        }
        if ("vi".equalsIgnoreCase(d())) {
            return c.d.payment_code_help_vn;
        }
        return c.d.payment_code_help_en;
    }

    public String d() {
        return this.f3826b;
    }

    public String e() {
        return this.f3825a.e();
    }

    public String f() {
        return this.f3825a.f();
    }

    public int g() {
        return this.f3825a.g();
    }

    public long h() {
        return this.f3825a.h();
    }

    public double i() {
        return this.f3825a.i();
    }

    public long j() {
        return this.f3825a.j();
    }

    public int k() {
        return this.f3825a.k();
    }

    public Locale l() {
        return this.f3825a.l();
    }
}
