package com.shopee.app.network.d.f;

import android.util.Base64;
import com.beetalklib.network.d.f;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.Logout;

public class i extends az {

    /* renamed from: a  reason: collision with root package name */
    private String f18302a;

    /* renamed from: b  reason: collision with root package name */
    private String f18303b;

    /* renamed from: c  reason: collision with root package name */
    private String f18304c;

    /* renamed from: d  reason: collision with root package name */
    private String f18305d;

    /* renamed from: e  reason: collision with root package name */
    private int f18306e;

    public void a(String str, String str2, int i, String str3, String str4) {
        this.f18302a = str;
        this.f18303b = str2;
        this.f18306e = i;
        this.f18304c = str3;
        this.f18305d = str4;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        Logout.Builder builder = new Logout.Builder();
        builder.requestid(i().a()).deviceid(e.f.a(Base64.decode(this.f18302a, 0))).passwd(this.f18303b).userid(Integer.valueOf(this.f18306e)).bk_access_token(this.f18305d).fb_access_token(this.f18304c);
        return new f(165, builder.build().toByteArray());
    }
}
