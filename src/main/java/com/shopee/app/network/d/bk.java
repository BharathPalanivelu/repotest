package com.shopee.app.network.d;

import android.util.Base64;
import com.beetalklib.network.d.f;
import com.shopee.app.util.ba;
import com.shopee.protocol.action.SetUserInfo;
import com.shopee.protocol.shop.DeviceExt;

public class bk extends az {

    /* renamed from: a  reason: collision with root package name */
    private String f18195a;

    /* renamed from: b  reason: collision with root package name */
    private String f18196b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f18197c;

    /* renamed from: d  reason: collision with root package name */
    private String f18198d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f18199e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f18200f;

    public void a(String str, byte[] bArr, String str2, boolean z, byte[] bArr2, String str3) {
        this.f18196b = str;
        this.f18197c = bArr;
        this.f18198d = str2;
        this.f18195a = str3;
        this.f18199e = z;
        this.f18200f = bArr2;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        SetUserInfo.Builder builder = new SetUserInfo.Builder();
        builder.requestid(i().a()).country("ID").deviceid(e.f.a(Base64.decode(this.f18196b, 0))).appversion(297).ext(new DeviceExt.Builder().deviceid(e.f.a(Base64.decode(this.f18196b, 0))).device_fingerprint(e.f.a(this.f18197c)).user_agent(this.f18198d).is_rooted(Boolean.valueOf(ba.a())).fingerprint_before_temper(this.f18199e ? e.f.a(this.f18200f) : null).is_fingerprint_tempered(Boolean.valueOf(this.f18199e)).build()).language(this.f18195a);
        return new f(67, builder.build().toByteArray());
    }
}
