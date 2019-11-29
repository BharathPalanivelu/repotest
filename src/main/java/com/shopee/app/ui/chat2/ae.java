package com.shopee.app.ui.chat2;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.ui.chat2.s;

public final class ae implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ad f20258a;

    /* renamed from: b  reason: collision with root package name */
    private final g f20259b = new g() {
        public void onEvent(a aVar) {
            ae.this.f20258a.a((s.a) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f20260c = new g() {
        public void onEvent(a aVar) {
            ae.this.f20258a.f();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f20261d = new g() {
        public void onEvent(a aVar) {
            ae.this.f20258a.g();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f20262e = new g() {
        public void onEvent(a aVar) {
            ae.this.f20258a.a(((Integer) aVar.data).intValue());
        }
    };

    public void c() {
    }

    public void d() {
    }

    public ae(ad adVar) {
        this.f20258a = adVar;
    }

    public void a() {
        b.a("GET_MESSAGE_SHORTCUTS", (e) this.f20259b, b.a.NETWORK_BUS);
        b.a("CMD_GET_CHAT_QUICKREPLY_SUCCESS", (e) this.f20260c, b.a.NETWORK_BUS);
        b.a("CMD_SET_CHAT_QUICKREPLY_SUCCESS", (e) this.f20261d, b.a.NETWORK_BUS);
        b.a("CMD_SET_CHAT_QUICKREPLY_ERROR", (e) this.f20262e, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("GET_MESSAGE_SHORTCUTS", this.f20259b, b.a.NETWORK_BUS);
        b.b("CMD_GET_CHAT_QUICKREPLY_SUCCESS", this.f20260c, b.a.NETWORK_BUS);
        b.b("CMD_SET_CHAT_QUICKREPLY_SUCCESS", this.f20261d, b.a.NETWORK_BUS);
        b.b("CMD_SET_CHAT_QUICKREPLY_ERROR", this.f20262e, b.a.NETWORK_BUS);
    }
}
