package com.shopee.app.network.d.f;

import android.text.TextUtils;
import android.util.Base64;
import com.beetalklib.network.d.f;
import com.shopee.app.application.ar;
import com.shopee.app.network.d.az;
import com.shopee.app.util.as;
import com.shopee.app.util.bd;
import com.shopee.app.util.c;
import com.shopee.protocol.action.Register;
import com.shopee.protocol.ads.action.TrackingPlatformType;
import com.shopee.protocol.shop.DeviceExt;

public class k extends az {

    /* renamed from: a  reason: collision with root package name */
    private String f18313a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18314b;

    /* renamed from: c  reason: collision with root package name */
    private final String f18315c;

    /* renamed from: d  reason: collision with root package name */
    private final String f18316d;

    /* renamed from: e  reason: collision with root package name */
    private final String f18317e;

    /* renamed from: f  reason: collision with root package name */
    private final String f18318f;

    public k(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f18313a = as.a(str);
        this.f18314b = str2;
        this.f18315c = str3;
        this.f18316d = str4;
        this.f18317e = str5;
        this.f18318f = str6;
    }

    /* access modifiers changed from: protected */
    public f a() {
        Register.Builder builder = new Register.Builder();
        builder.requestid(i().a()).country("ID").password(bd.b(bd.a(this.f18314b).getBytes())).username(this.f18316d).otp_seed("seed_signup").phone(this.f18313a).ext(new DeviceExt.Builder().deviceid(e.f.a(Base64.decode(ar.f().e().deviceStore().d(), 0))).device_fingerprint(e.f.a(ar.f().e().deviceStore().e())).user_agent(c.a().c()).build()).vcode(this.f18315c).platform(Integer.valueOf(TrackingPlatformType.ANDROID_APP.getValue()));
        if (!TextUtils.isEmpty(this.f18317e)) {
            builder.portrait(this.f18317e);
        }
        if (!TextUtils.isEmpty(this.f18318f)) {
            builder.nickname(this.f18318f);
        }
        return new f(12, builder.build().toByteArray());
    }
}
