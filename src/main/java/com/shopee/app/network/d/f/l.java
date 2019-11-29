package com.shopee.app.network.d.f;

import android.util.Base64;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.RegisterDevice;
import com.shopee.protocol.shop.Device;
import e.f;

public class l extends az {

    /* renamed from: a  reason: collision with root package name */
    private String f18319a;

    /* renamed from: b  reason: collision with root package name */
    private f f18320b;

    /* renamed from: c  reason: collision with root package name */
    private String f18321c;

    public void a(String str, f fVar, String str2) {
        this.f18319a = str;
        this.f18320b = fVar;
        this.f18321c = str2;
        g();
    }

    /* access modifiers changed from: protected */
    public com.beetalklib.network.d.f a() {
        Device.Builder builder = new Device.Builder();
        builder.deviceid(f.a(Base64.decode(this.f18319a, 0))).pn_token(this.f18320b).appversion(297).country("ID").machine_code(this.f18321c);
        RegisterDevice.Builder builder2 = new RegisterDevice.Builder();
        builder2.requestid(i().a()).device(builder.build());
        return new com.beetalklib.network.d.f(158, builder2.build().toByteArray());
    }
}
