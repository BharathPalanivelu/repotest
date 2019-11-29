package com.shopee.app.network.d.f;

import android.util.Base64;
import com.beetalklib.network.d.f;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.ak;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.app.util.c;
import com.shopee.protocol.action.VcodeAppLogin;
import com.shopee.protocol.shop.DeviceExt;

public class b extends h {

    /* renamed from: a  reason: collision with root package name */
    private ak f18267a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f18268b;

    /* renamed from: c  reason: collision with root package name */
    private String f18269c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f18270d;

    /* renamed from: e  reason: collision with root package name */
    private String f18271e;

    public boolean b() {
        return false;
    }

    public void a(ak akVar, String str, boolean z) {
        this.f18267a = akVar;
        this.f18269c = str;
        this.f18270d = ar.f().e().deviceStore().e();
        this.f18271e = c.a().c();
        this.f18268b = z;
        o.a().a((az) this);
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        VcodeAppLogin.Builder builder = new VcodeAppLogin.Builder();
        builder.requestid(i().a()).appversion(297).country("ID").deviceid(e.f.a(Base64.decode(this.f18269c, 0))).timestamp(Integer.valueOf((int) (System.currentTimeMillis() / 1000))).ext(new DeviceExt.Builder().deviceid(e.f.a(Base64.decode(this.f18269c, 0))).device_fingerprint(e.f.a(this.f18270d)).user_agent(this.f18271e).build()).is_user_login(Boolean.valueOf(this.f18268b)).phone((String) this.f18267a.e().b("")).username((String) this.f18267a.g().b("")).email((String) this.f18267a.j().b("")).vcode_token((String) this.f18267a.c().b("")).source("2201").app_version_name("2.46.06");
        return new f(171, builder.build().toByteArray());
    }
}
