package com.shopee.app.ui.chat2;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class x implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f20951a;

    /* renamed from: b  reason: collision with root package name */
    private final g f20952b = new g() {
        public void onEvent(a aVar) {
            x.this.f20951a.a((Pair) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f20953c = new g() {
        public void onEvent(a aVar) {
            x.this.f20951a.e();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f20954d = new g() {
        public void onEvent(a aVar) {
            x.this.f20951a.b(((Integer) aVar.data).intValue());
        }
    };

    public x(w wVar) {
        this.f20951a = wVar;
    }

    public void a() {
        b.a("CMD_SET_CHAT_QUICKREPLY_SUCCESS", (e) this.f20953c, b.a.NETWORK_BUS);
        b.a("CMD_SET_CHAT_QUICKREPLY_ERROR", (e) this.f20954d, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("CMD_SET_CHAT_QUICKREPLY_SUCCESS", this.f20953c, b.a.NETWORK_BUS);
        b.b("CMD_SET_CHAT_QUICKREPLY_ERROR", this.f20954d, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("CLICK", (e) this.f20952b, b.a.UI_BUS);
    }

    public void d() {
        b.b("CLICK", this.f20952b, b.a.UI_BUS);
    }
}
