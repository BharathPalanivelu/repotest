package com.shopee.app.ui.shopassistant.shopProfile;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class e implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final d f25496a;

    /* renamed from: b  reason: collision with root package name */
    private final g f25497b = new g() {
        public void onEvent(a aVar) {
            e.this.f25496a.a((String) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f25498c = new g() {
        public void onEvent(a aVar) {
            e.this.f25496a.b((String) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f25499d = new g() {
        public void onEvent(a aVar) {
            e.this.f25496a.c((String) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f25500e = new g() {
        public void onEvent(a aVar) {
            e.this.f25496a.d((String) aVar.data);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f25501f = new g() {
        public void onEvent(a aVar) {
            e.this.f25496a.f();
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f25502g = new g() {
        public void onEvent(a aVar) {
            e.this.f25496a.e((String) aVar.data);
        }
    };
    private final g h = new g() {
        public void onEvent(a aVar) {
            e.this.f25496a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };
    private final g i = new g() {
        public void onEvent(a aVar) {
            e.this.f25496a.b((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public e(d dVar) {
        this.f25496a = dVar;
    }

    public void a() {
        b.a("GET_YOUTUBE_INFO_ERROR", (com.garena.android.appkit.b.e) this.f25497b, b.a.NETWORK_BUS);
        b.a("YOUTUBE_VIDEO_ADDED", (com.garena.android.appkit.b.e) this.f25498c, b.a.NETWORK_BUS);
        b.a("AVATAR_SELECTED", (com.garena.android.appkit.b.e) this.f25500e, b.a.NETWORK_BUS);
        b.a("AVATAR_SELECTED_FAIL", (com.garena.android.appkit.b.e) this.f25501f, b.a.NETWORK_BUS);
        b.a("COVER_SELECTED_FAIL", (com.garena.android.appkit.b.e) this.f25501f, b.a.NETWORK_BUS);
        b.a("COVER_SELECTED", (com.garena.android.appkit.b.e) this.f25502g, b.a.NETWORK_BUS);
        b.a("SET_USER_INFO_ERROR", (com.garena.android.appkit.b.e) this.h, b.a.NETWORK_BUS);
        b.a("UPDATE_SHOP_INFO_ERROR", (com.garena.android.appkit.b.e) this.i, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("GET_YOUTUBE_INFO_ERROR", this.f25497b, b.a.NETWORK_BUS);
        b.b("YOUTUBE_VIDEO_ADDED", this.f25498c, b.a.NETWORK_BUS);
        b.b("AVATAR_SELECTED", this.f25500e, b.a.NETWORK_BUS);
        b.b("AVATAR_SELECTED_FAIL", this.f25501f, b.a.NETWORK_BUS);
        b.b("COVER_SELECTED_FAIL", this.f25501f, b.a.NETWORK_BUS);
        b.b("COVER_SELECTED", this.f25502g, b.a.NETWORK_BUS);
        b.b("SET_USER_INFO_ERROR", this.h, b.a.NETWORK_BUS);
        b.b("UPDATE_SHOP_INFO_ERROR", this.i, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("GET_YOUTUBE_URL", (com.garena.android.appkit.b.e) this.f25499d, b.a.UI_BUS);
    }

    public void d() {
        b.b("GET_YOUTUBE_URL", this.f25499d, b.a.UI_BUS);
    }
}
