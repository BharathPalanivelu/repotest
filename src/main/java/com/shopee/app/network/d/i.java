package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.app.util.as;
import com.shopee.protocol.action.CheckVcode;

public class i extends az {

    /* renamed from: a  reason: collision with root package name */
    private final String f18413a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18414b;

    /* renamed from: c  reason: collision with root package name */
    private final String f18415c;

    /* renamed from: d  reason: collision with root package name */
    private final int f18416d;

    public i(String str, String str2, String str3, int i) {
        this.f18413a = str;
        this.f18414b = str2;
        this.f18415c = str3;
        this.f18416d = i;
        h();
    }

    /* access modifiers changed from: protected */
    public f a() {
        CheckVcode.Builder builder = new CheckVcode.Builder();
        builder.requestid(i().a()).phone(as.a(this.f18413a)).otp_seed(this.f18415c).operation(Integer.valueOf(this.f18416d)).vcode(this.f18414b);
        return new f(16, builder.build().toByteArray());
    }

    public String b() {
        return this.f18413a;
    }
}
