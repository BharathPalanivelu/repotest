package com.shopee.app.network.d.f;

import android.text.TextUtils;
import android.util.Base64;
import com.beetalklib.network.d.f;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.ak;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.app.util.c;
import com.shopee.protocol.action.Login;
import com.shopee.protocol.shop.DeviceExt;

public class h extends az {

    /* renamed from: a  reason: collision with root package name */
    private ak f18297a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f18298b;

    /* renamed from: c  reason: collision with root package name */
    private String f18299c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f18300d;

    /* renamed from: e  reason: collision with root package name */
    private String f18301e;

    public String c() {
        return "";
    }

    public void a(ak akVar, String str, boolean z) {
        this.f18297a = akVar;
        this.f18299c = str;
        this.f18300d = ar.f().e().deviceStore().e();
        this.f18301e = c.a().c();
        this.f18298b = z;
        o.a().a((az) this);
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        Login.Builder builder = new Login.Builder();
        builder.requestid(i().a()).is_user_login(Boolean.valueOf(this.f18298b)).deviceid(e.f.a(Base64.decode(this.f18299c, 0))).country("ID").is_web(false).appversion(297).timestamp(Integer.valueOf((int) (System.currentTimeMillis() / 1000))).ext(new DeviceExt.Builder().deviceid(e.f.a(Base64.decode(this.f18299c, 0))).device_fingerprint(e.f.a(this.f18300d)).user_agent(this.f18301e).build()).source("2201").app_version_name("2.46.06");
        ak akVar = this.f18297a;
        if (akVar == null || TextUtils.isEmpty((CharSequence) akVar.p().b(""))) {
            builder.phone((String) this.f18297a.e().b("")).username((String) this.f18297a.g().b("")).password((String) this.f18297a.h().b("")).email((String) this.f18297a.j().b(""));
        } else {
            builder.token((String) this.f18297a.c().b("")).password("");
        }
        return new f(13, builder.build().toByteArray());
    }

    public boolean b() {
        return this.f18298b;
    }
}
