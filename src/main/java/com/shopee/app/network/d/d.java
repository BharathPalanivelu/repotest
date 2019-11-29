package com.shopee.app.network.d;

import android.text.TextUtils;
import com.shopee.app.network.a.b;
import com.shopee.app.util.as;
import com.shopee.protocol.action.BindAccount;
import com.squareup.wire.Message;

public class d extends az implements b {

    /* renamed from: a  reason: collision with root package name */
    private String f18238a;

    /* renamed from: b  reason: collision with root package name */
    private String f18239b;

    /* renamed from: c  reason: collision with root package name */
    private String f18240c;

    /* renamed from: d  reason: collision with root package name */
    private String f18241d;

    /* renamed from: e  reason: collision with root package name */
    private String f18242e;

    /* renamed from: f  reason: collision with root package name */
    private String f18243f;

    /* renamed from: g  reason: collision with root package name */
    private String f18244g;
    private String h;
    private String i;

    public int b() {
        return 92;
    }

    public void a(String str) {
        this.f18241d = str;
        g();
    }

    public void a(String str, String str2, String str3, String str4) {
        this.f18238a = str;
        this.f18239b = str2;
        this.f18240c = str3;
        this.i = str4;
        g();
    }

    public void b(String str) {
        this.f18243f = str;
        g();
    }

    public void c(String str) {
        this.h = str;
        g();
    }

    public Message q_() {
        BindAccount.Builder builder = new BindAccount.Builder();
        builder.requestid(i().a()).country("ID");
        if (!TextUtils.isEmpty(this.f18241d)) {
            builder.email(this.f18241d);
        }
        if (!TextUtils.isEmpty(this.f18242e)) {
            builder.password(this.f18242e);
        }
        if (!TextUtils.isEmpty(this.f18238a)) {
            String a2 = as.a(this.f18238a);
            if (!TextUtils.isEmpty(a2)) {
                builder.phone(a2);
            }
        }
        if (!TextUtils.isEmpty(this.f18239b)) {
            builder.vcode(this.f18239b);
        }
        if (!TextUtils.isEmpty(this.f18243f)) {
            builder.fb_access_token(this.f18243f);
        }
        if (!TextUtils.isEmpty(this.f18240c)) {
            builder.otp_token(this.f18240c);
        }
        if (!TextUtils.isEmpty(this.f18244g)) {
            builder.bk_access_token(this.f18244g);
        }
        if (!TextUtils.isEmpty(this.i)) {
            builder.otp_seed(this.i);
        }
        if (!TextUtils.isEmpty(this.h)) {
            builder.line_access_token(this.h);
        }
        return builder.build();
    }
}
