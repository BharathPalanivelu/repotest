package com.shopee.app.network.d;

import android.util.Base64;
import com.beetalklib.network.d.f;
import com.shopee.app.util.ba;
import com.shopee.protocol.action.SetUserInfo;
import com.shopee.protocol.shop.DeviceExt;

public class bi extends az {

    /* renamed from: a  reason: collision with root package name */
    private String f18186a;

    /* renamed from: b  reason: collision with root package name */
    private String f18187b;

    /* renamed from: c  reason: collision with root package name */
    private String f18188c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f18189d;

    /* renamed from: e  reason: collision with root package name */
    private String f18190e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f18191f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f18192g;

    public void a(String str, String str2, byte[] bArr, String str3, boolean z, byte[] bArr2, String str4) {
        this.f18187b = str;
        this.f18186a = str4;
        this.f18188c = str2;
        this.f18189d = bArr;
        this.f18190e = str3;
        this.f18191f = z;
        this.f18192g = bArr2;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        SetUserInfo.Builder builder = new SetUserInfo.Builder();
        builder.requestid(i().a()).country("ID").deviceid(e.f.a(Base64.decode(this.f18187b, 0))).pn_token(e.f.a(this.f18188c)).machine_code("android_gpns").appversion(297).language(this.f18186a).ext(new DeviceExt.Builder().deviceid(e.f.a(Base64.decode(this.f18187b, 0))).device_fingerprint(e.f.a(this.f18189d)).user_agent(this.f18190e).is_rooted(Boolean.valueOf(ba.a())).fingerprint_before_temper(this.f18191f ? e.f.a(this.f18192g) : null).is_fingerprint_tempered(Boolean.valueOf(this.f18191f)).build());
        return new f(67, builder.build().toByteArray());
    }
}
