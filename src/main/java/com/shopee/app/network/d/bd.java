package com.shopee.app.network.d;

import android.text.TextUtils;
import com.shopee.app.network.a.b;
import com.shopee.app.util.as;
import com.shopee.protocol.action.ResetPassword;
import com.squareup.wire.Message;

public class bd extends az implements b {

    /* renamed from: a  reason: collision with root package name */
    private String f18171a;

    /* renamed from: b  reason: collision with root package name */
    private String f18172b;

    /* renamed from: c  reason: collision with root package name */
    private String f18173c;

    /* renamed from: d  reason: collision with root package name */
    private String f18174d;

    public int b() {
        return 14;
    }

    public void a(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str)) {
            str = as.a(str);
        }
        this.f18171a = str;
        this.f18172b = str2;
        this.f18173c = str3;
        this.f18174d = str4;
        g();
    }

    public Message q_() {
        ResetPassword.Builder builder = new ResetPassword.Builder();
        builder.requestid(i().a()).country("ID").kick_self(false).appversion(297).password(com.shopee.app.util.bd.b(com.shopee.app.util.bd.a(this.f18174d).getBytes()));
        if (!TextUtils.isEmpty(this.f18171a)) {
            builder.phone(this.f18171a);
        }
        if (!TextUtils.isEmpty(this.f18173c)) {
            builder.oldpass(com.shopee.app.util.bd.b(com.shopee.app.util.bd.a(this.f18173c).getBytes()));
        }
        if (!TextUtils.isEmpty(this.f18172b)) {
            builder.vcode(this.f18172b);
        }
        builder.otp_seed("seed_change_password");
        return builder.build();
    }
}
