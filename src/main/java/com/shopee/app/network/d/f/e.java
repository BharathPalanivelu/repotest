package com.shopee.app.network.d.f;

import android.text.TextUtils;
import android.util.Base64;
import com.beetalklib.network.d.f;
import com.shopee.app.application.ar;
import com.shopee.app.network.d.az;
import com.shopee.app.util.bd;
import com.shopee.app.util.c;
import com.shopee.protocol.action.Register;
import com.shopee.protocol.ads.action.TrackingPlatformType;
import com.shopee.protocol.shop.DeviceExt;

public class e extends az {

    /* renamed from: a  reason: collision with root package name */
    private final String f18280a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18281b;

    /* renamed from: c  reason: collision with root package name */
    private final String f18282c;

    /* renamed from: d  reason: collision with root package name */
    private final String f18283d;

    /* renamed from: e  reason: collision with root package name */
    private final String f18284e;

    /* renamed from: f  reason: collision with root package name */
    private String f18285f;

    public e(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f18280a = str2;
        this.f18281b = str3;
        this.f18282c = str4;
        this.f18283d = str5;
        this.f18285f = str;
        this.f18284e = str6;
    }

    /* access modifiers changed from: protected */
    public f a() {
        Register.Builder builder = new Register.Builder();
        builder.requestid(i().a()).password(bd.b(bd.a(this.f18280a).getBytes())).country("ID").captcha_token(this.f18284e).ext(new DeviceExt.Builder().deviceid(e.f.a(Base64.decode(ar.f().e().deviceStore().d(), 0))).device_fingerprint(e.f.a(ar.f().e().deviceStore().e())).user_agent(c.a().c()).build()).username(this.f18281b).platform(Integer.valueOf(TrackingPlatformType.ANDROID_APP.getValue()));
        if (!TextUtils.isEmpty(this.f18282c)) {
            builder.portrait(this.f18282c);
        }
        if (!TextUtils.isEmpty(this.f18283d)) {
            builder.nickname(this.f18283d);
        }
        if (!TextUtils.isEmpty(this.f18285f)) {
            builder.email(this.f18285f);
        }
        return new f(12, builder.build().toByteArray());
    }
}
