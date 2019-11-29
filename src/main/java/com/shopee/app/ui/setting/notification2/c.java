package com.shopee.app.ui.setting.notification2;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.i.a;

public final class c implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b f25274a;

    /* renamed from: b  reason: collision with root package name */
    private final g f25275b = new g() {
        public void onEvent(a aVar) {
            c.this.f25274a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f25276c = new g() {
        public void onEvent(a aVar) {
            c.this.f25274a.a((a.C0257a) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public c(b bVar) {
        this.f25274a = bVar;
    }

    public void a() {
        b.a("SET_USER_INFO_ERROR", (e) this.f25275b, b.a.NETWORK_BUS);
        b.a("NOTIFICATION_SOUND_SETTING", (e) this.f25276c, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("SET_USER_INFO_ERROR", this.f25275b, b.a.NETWORK_BUS);
        b.b("NOTIFICATION_SOUND_SETTING", this.f25276c, b.a.NETWORK_BUS);
    }
}
