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

public class n extends h {

    /* renamed from: a  reason: collision with root package name */
    private String f18329a;

    /* renamed from: b  reason: collision with root package name */
    private String f18330b;

    /* renamed from: c  reason: collision with root package name */
    private String f18331c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f18332d;

    /* renamed from: e  reason: collision with root package name */
    private String f18333e;

    public boolean b() {
        return true;
    }

    public void a(String str, String str2) {
        this.f18331c = ar.f().e().deviceStore().d();
        this.f18332d = ar.f().e().deviceStore().e();
        this.f18333e = c.a().c();
        this.f18329a = str;
        this.f18330b = bd.b(bd.a(str2).getBytes());
        o.a().a((az) this);
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        return new f(13, new Login.Builder().requestid(i().a()).country("ID").username(this.f18329a).password(this.f18330b).is_web(false).deviceid(e.f.a(Base64.decode(this.f18331c, 0))).appversion(297).is_user_login(true).otp_seed("seed_login").timestamp(Integer.valueOf((int) (System.currentTimeMillis() / 1000))).ext(new DeviceExt.Builder().deviceid(e.f.a(Base64.decode(this.f18331c, 0))).device_fingerprint(e.f.a(this.f18332d)).user_agent(this.f18333e).build()).source("2201").app_version_name("2.46.06").build().toByteArray());
    }

    public String c() {
        return this.f18329a;
    }
}
