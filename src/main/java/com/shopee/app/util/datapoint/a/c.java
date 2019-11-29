package com.shopee.app.util.datapoint.a;

import com.garena.android.appkit.d.a;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.z;
import com.shopee.app.util.bd;
import com.shopee.app.util.datapoint.b;
import d.d.b.j;
import loan.data_point.ContentInfo;
import loan.data_point.DeviceLFInfo;

public final class c extends e {

    /* renamed from: a  reason: collision with root package name */
    private com.shopee.b.a.c f26312a = e().a();

    /* renamed from: b  reason: collision with root package name */
    private final b f26313b = new b();

    /* renamed from: c  reason: collision with root package name */
    private String f26314c = "";

    /* renamed from: d  reason: collision with root package name */
    private final z f26315d;

    public int b() {
        return 5;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(com.shopee.app.network.http.a.c cVar, aa aaVar, z zVar) {
        super(cVar, aaVar);
        j.b(cVar, "dataPointAPI");
        j.b(aaVar, "deviceStore");
        j.b(zVar, "dataPointStore");
        this.f26315d = zVar;
    }

    public ContentInfo a() {
        ContentInfo build = new ContentInfo.Builder().status(1).deviceLF_info(new DeviceLFInfo.Builder().device_name(this.f26312a.f()).android_id(this.f26312a.i()).bluetooth_mac_address(this.f26312a.h()).brand(this.f26312a.e()).build_time(Integer.valueOf((int) this.f26312a.j())).hardware(this.f26312a.c()).mac_address(this.f26312a.g()).manufacturer(this.f26312a.a()).model(this.f26312a.b()).product(this.f26312a.d()).screen_height(Integer.valueOf(this.f26312a.n())).screen_width(Integer.valueOf(this.f26312a.m())).total_memory(Long.valueOf(this.f26312a.k())).total_storage(Long.valueOf(this.f26312a.l())).client_timestamp(Integer.valueOf(f())).item_id(a(f())).freefire_fingerprint(this.f26313b.b()).freefire_user_id(this.f26313b.c()).build()).build();
        j.a((Object) build, "ContentInfo.Builder()\n  …\n                .build()");
        return build;
    }

    public void a(boolean z) {
        this.f26312a = e().a();
        super.a(z);
    }

    public void c() {
        String a2 = bd.a(this.f26312a.o().toString());
        j.a((Object) a2, "SecurityHelper.md5(origi…Info.toJSON().toString())");
        this.f26314c = a2;
        if (j() || a(this.f26314c)) {
            h();
            return;
        }
        a.b("POST_deviceInfo_TO_DataPoint%s", "DeviceInfo of LF is too frequently to report!");
    }

    public void d() {
        this.f26315d.c((long) f());
        this.f26315d.b(this.f26314c);
    }

    private final boolean j() {
        return ((long) f()) - this.f26315d.c() >= ((long) 86400);
    }

    private final boolean a(String str) {
        if (i()) {
            UserInfo g2 = g();
            return g2 != null && g2.isLoggedIn() && (j.a((Object) str, (Object) this.f26315d.f()) ^ true);
        }
    }
}
