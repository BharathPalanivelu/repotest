package com.shopee.app.network.c;

import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.ak;
import com.shopee.app.data.store.v;
import com.shopee.app.h.o;
import com.shopee.app.network.d.ag;
import com.shopee.app.network.d.f.b;
import com.shopee.app.network.d.f.i;
import com.shopee.app.pushnotification.d;
import java.io.IOException;

public class m extends c {
    public int a() {
        return 235;
    }

    public void c(byte[] bArr, int i) throws IOException {
        com.shopee.app.util.g.a e2 = o.a().e("UpdateGcmIDNetworkConnectCallback");
        if (e2 != null) {
            e2.a();
            return;
        }
        if (new com.shopee.app.h.m().a()) {
            new b().a(ak.a(), ar.f().e().deviceStore().d(), false);
        } else {
            ar.f().e().connectedProcessor().a();
        }
        new ag().g();
        com.garena.android.appkit.b.b.a("TCP_CONNECTED", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final v f18040a;

        /* renamed from: b  reason: collision with root package name */
        private SettingConfigStore f18041b;

        /* renamed from: c  reason: collision with root package name */
        private final aa f18042c;

        /* renamed from: d  reason: collision with root package name */
        private final UserInfo f18043d;

        public a(v vVar, UserInfo userInfo, SettingConfigStore settingConfigStore, aa aaVar) {
            this.f18040a = vVar;
            this.f18043d = userInfo;
            this.f18041b = settingConfigStore;
            this.f18042c = aaVar;
        }

        public void a() {
            int e2 = this.f18040a.e();
            if (e2 != 0) {
                new i().a(this.f18042c.d(), this.f18040a.b(), e2, this.f18040a.c(), this.f18040a.d());
            }
            d.a(this.f18041b.getAllowGCM(), this.f18043d, this.f18042c);
        }
    }
}
