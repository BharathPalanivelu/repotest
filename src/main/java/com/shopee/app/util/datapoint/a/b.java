package com.shopee.app.util.datapoint.a;

import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.z;
import com.shopee.app.network.http.a.c;
import com.shopee.b.c.a;
import d.d.b.j;
import java.util.ArrayList;
import java.util.Iterator;
import loan.data_point.AppInfo;
import loan.data_point.ContentInfo;
import loan.data_point.InstalledAppInfo;

public final class b extends e {

    /* renamed from: a  reason: collision with root package name */
    private final z f26311a;

    public int b() {
        return 7;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(c cVar, aa aaVar, z zVar) {
        super(cVar, aaVar);
        j.b(cVar, "dataPointAPI");
        j.b(aaVar, "deviceStore");
        j.b(zVar, "dataPointStore");
        this.f26311a = zVar;
    }

    public ContentInfo a() {
        com.shopee.b.c.b d2 = e().d();
        ArrayList arrayList = new ArrayList();
        Iterator<a> it = d2.a().iterator();
        while (it.hasNext()) {
            a next = it.next();
            arrayList.add(new AppInfo.Builder().app_id(next.b()).app_name(next.a()).first_installed_time(Integer.valueOf(next.c())).last_updated_time(Integer.valueOf(next.d())).build());
        }
        ContentInfo build = new ContentInfo.Builder().status(1).installed_info(new InstalledAppInfo.Builder().app_info(arrayList).client_timestamp(Integer.valueOf(f())).item_id(a(f())).build()).build();
        j.a((Object) build, "ContentInfo.Builder()\n  …\n                .build()");
        return build;
    }

    public void c() {
        if (i()) {
            UserInfo g2 = g();
            if (g2 != null && g2.isLoggedIn()) {
                if (((long) f()) - this.f26311a.d() >= ((long) 604800)) {
                    h();
                    return;
                }
                com.garena.android.appkit.d.a.b("POST_deviceInfo_TO_DataPoint%s", "DeviceInfo of Installed Apps is too frequently to report!");
            }
        }
    }

    public void d() {
        this.f26311a.d((long) f());
    }
}
