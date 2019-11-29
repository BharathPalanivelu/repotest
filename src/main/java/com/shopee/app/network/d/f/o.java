package com.shopee.app.network.d.f;

import android.text.TextUtils;
import android.util.Base64;
import com.beetalklib.network.d.f;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.ak;
import com.shopee.app.network.d.az;
import com.shopee.app.util.as;
import com.shopee.app.util.c;
import com.shopee.protocol.action.VcodeAppLogin;
import com.shopee.protocol.shop.DeviceExt;

public class o extends h {

    /* renamed from: a  reason: collision with root package name */
    private ak f18334a;

    /* renamed from: b  reason: collision with root package name */
    private String f18335b;

    /* renamed from: c  reason: collision with root package name */
    private String f18336c;

    /* renamed from: d  reason: collision with root package name */
    private String f18337d;

    /* renamed from: e  reason: collision with root package name */
    private String f18338e;

    /* renamed from: f  reason: collision with root package name */
    private String f18339f;

    /* renamed from: g  reason: collision with root package name */
    private String f18340g;
    private boolean h;
    private byte[] i;
    private String j;
    private String k;

    public void a(ak akVar, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        this.f18334a = akVar;
        this.f18335b = str;
        this.i = ar.f().e().deviceStore().e();
        this.j = c.a().c();
        this.f18339f = str2;
        this.f18338e = as.a(str2);
        this.f18340g = str3;
        this.k = str6;
        this.h = z;
        this.f18336c = str4;
        this.f18337d = str5;
        com.shopee.app.h.o.a().a((az) this);
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        VcodeAppLogin.Builder builder = new VcodeAppLogin.Builder();
        builder.requestid(i().a()).appversion(297).country("ID").deviceid(e.f.a(Base64.decode(this.f18335b, 0))).timestamp(Integer.valueOf((int) (System.currentTimeMillis() / 1000))).ext(new DeviceExt.Builder().deviceid(e.f.a(Base64.decode(this.f18335b, 0))).device_fingerprint(e.f.a(this.i)).user_agent(this.j).build()).is_user_login(Boolean.valueOf(this.h)).source("2201").app_version_name("2.46.06");
        ak akVar = this.f18334a;
        if (akVar == null || TextUtils.isEmpty((CharSequence) akVar.p().b(""))) {
            if (!TextUtils.isEmpty(this.f18338e)) {
                builder.phone(this.f18338e);
            } else {
                if (!TextUtils.isEmpty(this.f18337d)) {
                    builder.username(this.f18337d);
                }
                if (!TextUtils.isEmpty(this.f18336c)) {
                    builder.email(this.f18336c);
                }
            }
            if (!TextUtils.isEmpty(this.f18340g)) {
                builder.vcode(this.f18340g);
            }
        } else {
            builder.vcode_token((String) this.f18334a.p().b(""));
            if (!TextUtils.isEmpty(this.f18338e)) {
                builder.phone(this.f18338e);
            }
        }
        if (!TextUtils.isEmpty(this.k)) {
            builder.otp_seed(this.k);
        }
        return new f(171, builder.build().toByteArray());
    }

    public boolean b() {
        return this.h;
    }

    @Deprecated
    public void a(ak akVar, String str, boolean z) {
        this.f18334a = akVar;
        this.f18335b = str;
        this.f18338e = as.a((String) akVar.e().b(""));
        this.h = z;
        com.shopee.app.h.o.a().a((az) this);
        g();
    }

    public String c() {
        return TextUtils.isEmpty(this.f18339f) ? this.f18337d : this.f18339f;
    }
}
