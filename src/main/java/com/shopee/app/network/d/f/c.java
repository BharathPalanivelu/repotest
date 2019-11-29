package com.shopee.app.network.d.f;

import com.shopee.app.network.a.b;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.CheckCaptcha;
import com.squareup.wire.Message;

public class c extends az implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f18272a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18273b;

    /* renamed from: c  reason: collision with root package name */
    private final String f18274c;

    public int b() {
        return 243;
    }

    public c(String str, String str2, String str3) {
        this.f18272a = str;
        this.f18273b = str2;
        this.f18274c = str3;
    }

    public Message q_() {
        return new CheckCaptcha.Builder().requestid(i().a()).email(this.f18272a).country("ID").captcha(this.f18273b).key(this.f18274c).provider("captcha.shopeemobile.com").type("alphanumeric").build();
    }
}
