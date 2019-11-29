package com.shopee.app.network.d.f;

import android.util.Base64;
import com.garena.android.appkit.tools.a.a;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.aa;
import com.shopee.app.network.a.b;
import com.shopee.app.network.d.az;
import com.shopee.app.util.c;
import com.shopee.protocol.action.LineLogin;
import com.shopee.protocol.ads.action.TrackingPlatformType;
import com.shopee.protocol.shop.DeviceExt;
import com.squareup.wire.Message;
import d.d.b.j;
import e.f;
import java.util.Arrays;

public final class g extends az implements b {

    /* renamed from: a  reason: collision with root package name */
    private String f18293a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f18294b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f18295c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f18296d = "";

    public int b() {
        return 249;
    }

    public final void a(String str) {
        this.f18293a = str;
    }

    public final void b(String str) {
        this.f18294b = str;
    }

    public final void c(String str) {
        this.f18295c = str;
    }

    public final void d(String str) {
        this.f18296d = str;
    }

    public Message q_() {
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        aa deviceStore = f2.e().deviceStore();
        j.a((Object) deviceStore, "ShopeeApplication.get().component.deviceStore()");
        String d2 = deviceStore.d();
        j.a((Object) d2, "ShopeeApplication.get().…nt.deviceStore().deviceId");
        ar f3 = ar.f();
        j.a((Object) f3, "ShopeeApplication.get()");
        aa deviceStore2 = f3.e().deviceStore();
        j.a((Object) deviceStore2, "ShopeeApplication.get().component.deviceStore()");
        byte[] e2 = deviceStore2.e();
        j.a((Object) e2, "ShopeeApplication.get().…eStore().fingerprintBytes");
        String c2 = c.a().c();
        LineLogin.Builder portrait = new LineLogin.Builder().requestid(i().a()).line_access_token(this.f18293a).username(this.f18294b).email(this.f18296d).portrait(this.f18295c);
        DeviceExt.Builder builder = new DeviceExt.Builder();
        byte[] decode = Base64.decode(d2, 0);
        LineLogin build = portrait.ext(builder.deviceid(f.a(Arrays.copyOf(decode, decode.length))).device_fingerprint(f.a(Arrays.copyOf(e2, e2.length))).user_agent(c2).build()).country("ID").timestamp(Integer.valueOf(a.a())).appversion(297).source("2201").platform(Integer.valueOf(TrackingPlatformType.ANDROID_APP.getValue())).app_version_name("2.46.06").build();
        j.a((Object) build, "LineLogin.Builder()\n    …\n                .build()");
        return build;
    }
}
