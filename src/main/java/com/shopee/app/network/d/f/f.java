package com.shopee.app.network.d.f;

import android.util.Base64;
import com.garena.android.appkit.tools.a.a;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.ak;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.app.util.c;
import com.shopee.protocol.action.FacebookLogin;
import com.shopee.protocol.ads.action.TrackingPlatformType;
import com.shopee.protocol.shop.DeviceExt;

public class f extends az {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f18286a;

    /* renamed from: b  reason: collision with root package name */
    private String f18287b;

    /* renamed from: c  reason: collision with root package name */
    private String f18288c;

    /* renamed from: d  reason: collision with root package name */
    private String f18289d;

    /* renamed from: e  reason: collision with root package name */
    private String f18290e;

    /* renamed from: f  reason: collision with root package name */
    private int f18291f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f18292g;
    private String h;

    public f() {
        this.f18292g = false;
        this.f18286a = true;
    }

    public void a(String str) {
        this.f18287b = str;
        if (str != null) {
            ak.a().o().a(str).v();
        }
        this.f18291f = a.a();
    }

    public f(String str, String str2) {
        this.f18292g = false;
        this.f18287b = str;
        this.f18286a = true;
        if (str != null) {
            ak.a().o().a(str).v();
        }
        this.f18288c = str2;
        this.f18291f = a.a();
    }

    public void b(String str) {
        this.f18289d = str;
    }

    public void c(String str) {
        this.f18290e = str;
    }

    /* access modifiers changed from: protected */
    public com.beetalklib.network.d.f a() {
        String d2 = ar.f().e().deviceStore().d();
        byte[] e2 = ar.f().e().deviceStore().e();
        String c2 = c.a().c();
        o.a().a((az) this);
        return new com.beetalklib.network.d.f(77, new FacebookLogin.Builder().fb_access_token(this.f18287b).requestid(i().a()).portrait(this.f18289d).shop_cover(this.f18290e).email(this.h).is_user_login(Boolean.valueOf(this.f18286a)).username(this.f18288c).deviceid(e.f.a(Base64.decode(ar.f().e().deviceStore().d(), 0))).ext(new DeviceExt.Builder().deviceid(e.f.a(Base64.decode(d2, 0))).device_fingerprint(e.f.a(e2)).user_agent(c2).build()).country("ID").timestamp(Integer.valueOf(this.f18291f)).appversion(297).source("2201").platform(Integer.valueOf(TrackingPlatformType.ANDROID_APP.getValue())).app_version_name("2.46.06").build().toByteArray());
    }

    public boolean b() {
        return this.f18286a;
    }

    public void d(String str) {
        this.h = str;
    }
}
