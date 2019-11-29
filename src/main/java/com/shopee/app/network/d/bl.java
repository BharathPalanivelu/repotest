package com.shopee.app.network.d;

import android.util.Base64;
import com.beetalklib.network.d.f;
import com.shopee.app.util.ba;
import com.shopee.protocol.action.SetUserInfo;
import com.shopee.protocol.shop.DeviceExt;

public class bl extends az {

    /* renamed from: a  reason: collision with root package name */
    private String f18201a;

    /* renamed from: b  reason: collision with root package name */
    private String f18202b;

    /* renamed from: c  reason: collision with root package name */
    private String f18203c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f18204d;

    /* renamed from: e  reason: collision with root package name */
    private String f18205e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f18206f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f18207g;

    public void a(String str, String str2, byte[] bArr, String str3, boolean z, byte[] bArr2, String str4) {
        this.f18203c = str;
        this.f18201a = str2;
        this.f18204d = bArr;
        this.f18205e = str3;
        this.f18206f = z;
        this.f18207g = bArr2;
        this.f18202b = str4;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        SetUserInfo.Builder builder = new SetUserInfo.Builder();
        builder.requestid(i().a()).country("ID").deviceid(e.f.a(Base64.decode(this.f18203c, 0))).pn_token(e.f.a(this.f18202b)).machine_code("android_gcm").appversion(297).language(this.f18201a).ext(new DeviceExt.Builder().deviceid(e.f.a(Base64.decode(this.f18203c, 0))).device_fingerprint(e.f.a(this.f18204d)).user_agent(this.f18205e).is_rooted(Boolean.valueOf(ba.a())).fingerprint_before_temper(this.f18206f ? e.f.a(this.f18207g) : null).is_fingerprint_tempered(Boolean.valueOf(this.f18206f)).build());
        return new f(67, builder.build().toByteArray());
    }
}
