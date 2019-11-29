package com.shopee.app.network.d.f;

import android.util.Base64;
import com.beetalklib.network.d.f;
import com.shopee.app.application.ar;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.app.util.as;
import com.shopee.app.util.bd;
import com.shopee.app.util.c;
import com.shopee.protocol.action.Login;
import com.shopee.protocol.shop.DeviceExt;

public class j extends h {

    /* renamed from: a  reason: collision with root package name */
    private String f18307a;

    /* renamed from: b  reason: collision with root package name */
    private String f18308b;

    /* renamed from: c  reason: collision with root package name */
    private String f18309c;

    /* renamed from: d  reason: collision with root package name */
    private String f18310d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f18311e;

    /* renamed from: f  reason: collision with root package name */
    private String f18312f;

    public boolean b() {
        return true;
    }

    public void a(String str, String str2) {
        this.f18310d = ar.f().e().deviceStore().d();
        this.f18311e = ar.f().e().deviceStore().e();
        this.f18312f = c.a().c();
        this.f18308b = str;
        this.f18307a = as.a(str);
        this.f18309c = bd.b(bd.a(str2).getBytes());
        o.a().a((az) this);
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        return new f(13, new Login.Builder().requestid(i().a()).country("ID").phone(this.f18307a).password(this.f18309c).is_web(false).appversion(297).deviceid(e.f.a(Base64.decode(this.f18310d, 0))).is_user_login(true).otp_seed("seed_login").timestamp(Integer.valueOf((int) (System.currentTimeMillis() / 1000))).ext(new DeviceExt.Builder().deviceid(e.f.a(Base64.decode(this.f18310d, 0))).device_fingerprint(e.f.a(this.f18311e)).user_agent(this.f18312f).build()).source("2201").app_version_name("2.46.06").build().toByteArray());
    }

    public String c() {
        return this.f18308b;
    }
}
