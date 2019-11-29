package com.shopee.app.util.datapoint.a;

import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.z;
import com.shopee.app.network.http.a.c;
import com.shopee.b.a.b;
import d.d.b.j;
import loan.data_point.ContentInfo;
import loan.data_point.DeviceHFInfo;

public final class a extends e {

    /* renamed from: a  reason: collision with root package name */
    private final z f26310a;

    public int b() {
        return 4;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(c cVar, aa aaVar, z zVar) {
        super(cVar, aaVar);
        j.b(cVar, "dataPointAPI");
        j.b(aaVar, "deviceStore");
        j.b(zVar, "dataPointStore");
        this.f26310a = zVar;
    }

    public ContentInfo a() {
        b c2 = e().c();
        ContentInfo build = new ContentInfo.Builder().status(1).deviceHF_info(new DeviceHFInfo.Builder().available_memory(Long.valueOf(c2.f())).available_storage(Long.valueOf(c2.e())).battery_percent(Float.valueOf(c2.b())).battery_temperature(Float.valueOf(c2.a())).brightness(Integer.valueOf(c2.g())).charging_source(Integer.valueOf(c2.d())).is_charging(Boolean.valueOf(c2.c())).client_timestamp(Integer.valueOf(f())).item_id(a(f())).build()).build();
        j.a((Object) build, "ContentInfo.Builder()\n  …\n                .build()");
        return build;
    }

    public void c() {
        if (i()) {
            UserInfo g2 = g();
            if (g2 != null && g2.isLoggedIn()) {
                if (((long) f()) - this.f26310a.a() >= ((long) 7200)) {
                    h();
                    return;
                }
                com.garena.android.appkit.d.a.b("POST_deviceInfo_TO_DataPoint%s", "DeviceInfo of HF is too frequently to report!");
            }
        }
    }

    public void d() {
        this.f26310a.a((long) f());
    }
}
