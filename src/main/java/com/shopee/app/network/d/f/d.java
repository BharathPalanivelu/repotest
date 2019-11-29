package com.shopee.app.network.d.f;

import android.util.Base64;
import com.beetalklib.network.d.f;
import com.shopee.app.application.ar;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.app.util.bd;
import com.shopee.app.util.c;
import com.shopee.protocol.action.Login;
import com.shopee.protocol.shop.DeviceExt;

public class d extends h {

    /* renamed from: a  reason: collision with root package name */
    private String f18275a;

    /* renamed from: b  reason: collision with root package name */
    private String f18276b;

    /* renamed from: c  reason: collision with root package name */
    private String f18277c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f18278d;

    /* renamed from: e  reason: collision with root package name */
    private String f18279e;

    public boolean b() {
        return true;
    }

    public void a(String str, String str2) {
        this.f18277c = ar.f().e().deviceStore().d();
        this.f18278d = ar.f().e().deviceStore().e();
        this.f18279e = c.a().c();
        this.f18275a = str;
        this.f18276b = bd.b(bd.a(str2).getBytes());
        o.a().a((az) this);
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        return new f(13, new Login.Builder().requestid(i().a()).country("ID").email(this.f18275a).password(this.f18276b).is_web(false).is_user_login(true).deviceid(e.f.a(Base64.decode(this.f18277c, 0))).appversion(297).timestamp(Integer.valueOf((int) (System.currentTimeMillis() / 1000))).otp_seed("seed_login").ext(new DeviceExt.Builder().deviceid(e.f.a(Base64.decode(this.f18277c, 0))).device_fingerprint(e.f.a(this.f18278d)).user_agent(this.f18279e).build()).source("2201").app_version_name("2.46.06").build().toByteArray());
    }

    public String c() {
        return this.f18275a;
    }
}
