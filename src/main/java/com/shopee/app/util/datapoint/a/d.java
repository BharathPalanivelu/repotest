package com.shopee.app.util.datapoint.a;

import com.garena.android.appkit.d.a;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.z;
import com.shopee.app.network.http.a.c;
import com.shopee.app.util.bd;
import d.d.b.j;
import loan.data_point.ContentInfo;
import loan.data_point.DeviceMFInfo;

public final class d extends e {

    /* renamed from: a  reason: collision with root package name */
    private com.shopee.b.a.d f26316a = e().b();

    /* renamed from: b  reason: collision with root package name */
    private String f26317b = "";

    /* renamed from: c  reason: collision with root package name */
    private final z f26318c;

    public int b() {
        return 6;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(c cVar, aa aaVar, z zVar) {
        super(cVar, aaVar);
        j.b(cVar, "dataPointAPI");
        j.b(aaVar, "deviceStore");
        j.b(zVar, "dataPointStore");
        this.f26318c = zVar;
    }

    public ContentInfo a() {
        ContentInfo build = new ContentInfo.Builder().status(1).deviceMF_info(new DeviceMFInfo.Builder().carrier(this.f26316a.b()).boot_timestamp(Integer.valueOf((int) this.f26316a.a())).jailbreak(Boolean.valueOf(this.f26316a.d())).phone_number(this.f26316a.e()).timezone(this.f26316a.c()).client_timestamp(Integer.valueOf(f())).item_id(a(f())).build()).build();
        j.a((Object) build, "ContentInfo.Builder()\n  …\n                .build()");
        return build;
    }

    public void a(boolean z) {
        this.f26316a = e().b();
        super.a(z);
    }

    public void c() {
        String a2 = bd.a(this.f26316a.f().toString());
        j.a((Object) a2, "SecurityHelper.md5(origi…Info.toJSON().toString())");
        this.f26317b = a2;
        if (j() || a(this.f26317b)) {
            h();
            return;
        }
        a.b("POST_deviceInfo_TO_DataPoint%s", "DeviceInfo of MF is too frequently to report!");
    }

    public void d() {
        this.f26318c.b((long) f());
        this.f26318c.a(this.f26317b);
    }

    private final boolean j() {
        return ((long) f()) - this.f26318c.b() >= ((long) 86400);
    }

    private final boolean a(String str) {
        if (i()) {
            UserInfo g2 = g();
            return g2 != null && g2.isLoggedIn() && (j.a((Object) str, (Object) this.f26318c.e()) ^ true);
        }
    }
}
