package com.shopee.app.ui.product.comment;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.aj;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.ui.common.e;
import java.util.List;

public final class l implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final k f24534a;

    /* renamed from: b  reason: collision with root package name */
    private final g f24535b = new g() {
        public void onEvent(a aVar) {
            l.this.f24534a.a((Pair<String, e[]>) (Pair) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f24536c = new g() {
        public void onEvent(a aVar) {
            l.this.f24534a.c(((Integer) aVar.data).intValue());
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f24537d = new g() {
        public void onEvent(a aVar) {
            l.this.f24534a.a((b) aVar);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f24538e = new g() {
        public void onEvent(a aVar) {
            l.this.f24534a.b((Pair<String, Integer>) (Pair) aVar.data);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f24539f = new g() {
        public void onEvent(a aVar) {
            l.this.f24534a.a((aj.b) aVar.data);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f24540g = new g() {
        public void onEvent(a aVar) {
            l.this.f24534a.e();
        }
    };
    private final g h = new g() {
        public void onEvent(a aVar) {
            l.this.f24534a.a((List<UserData>) (List) aVar.data);
        }
    };
    private final g i = new g() {
        public void onEvent(a aVar) {
            l.this.f24534a.f();
        }
    };
    private final g j = new g() {
        public void onEvent(a aVar) {
            l.this.f24534a.g();
        }
    };
    private final g k = new g() {
        public void onEvent(a aVar) {
            l.this.f24534a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };
    private final g l = new g() {
        public void onEvent(a aVar) {
            l.this.f24534a.a((ItemDetail) aVar.data);
        }
    };
    private final g m = new g() {
        public void onEvent(a aVar) {
            l.this.f24534a.b((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public l(k kVar) {
        this.f24534a = kVar;
    }

    public void a() {
        b.a("COMMENT_LIST_LOCAL_LOAD", (com.garena.android.appkit.b.e) this.f24539f, b.a.NETWORK_BUS);
        b.a("COMMENT_LIST_SAVED", (com.garena.android.appkit.b.e) this.f24540g, b.a.NETWORK_BUS);
        b.a("GET_USER_INFO_LOAD", (com.garena.android.appkit.b.e) this.h, b.a.NETWORK_BUS);
        b.a("ADD_ITEM_COMMENT_SUCCESS", (com.garena.android.appkit.b.e) this.i, b.a.NETWORK_BUS);
        b.a("DEL_ITEM_COMMENT_SUCCESS", (com.garena.android.appkit.b.e) this.j, b.a.NETWORK_BUS);
        b.a("DEL_ITEM_COMMENT_FAIL", (com.garena.android.appkit.b.e) this.k, b.a.NETWORK_BUS);
        b.a("ITEM_DETAIL_LOAD", (com.garena.android.appkit.b.e) this.l, b.a.NETWORK_BUS);
        b.a("ADD_ITEM_COMMENT_FAIL", (com.garena.android.appkit.b.e) this.m, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("COMMENT_LIST_LOCAL_LOAD", this.f24539f, b.a.NETWORK_BUS);
        b.b("COMMENT_LIST_SAVED", this.f24540g, b.a.NETWORK_BUS);
        b.b("GET_USER_INFO_LOAD", this.h, b.a.NETWORK_BUS);
        b.b("ADD_ITEM_COMMENT_SUCCESS", this.i, b.a.NETWORK_BUS);
        b.b("DEL_ITEM_COMMENT_SUCCESS", this.j, b.a.NETWORK_BUS);
        b.b("DEL_ITEM_COMMENT_FAIL", this.k, b.a.NETWORK_BUS);
        b.b("ITEM_DETAIL_LOAD", this.l, b.a.NETWORK_BUS);
        b.b("ADD_ITEM_COMMENT_FAIL", this.m, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("SEND_TEXT_COMMENT", (com.garena.android.appkit.b.e) this.f24535b, b.a.UI_BUS);
        b.a("MENTION_CLICKED", (com.garena.android.appkit.b.e) this.f24536c, b.a.UI_BUS);
        b.a("ITEM_COMMENT_DELETE", (com.garena.android.appkit.b.e) this.f24537d, b.a.UI_BUS);
        b.a("ITEM_COMMENT_REPLY", (com.garena.android.appkit.b.e) this.f24538e, b.a.UI_BUS);
    }

    public void d() {
        b.b("SEND_TEXT_COMMENT", this.f24535b, b.a.UI_BUS);
        b.b("MENTION_CLICKED", this.f24536c, b.a.UI_BUS);
        b.b("ITEM_COMMENT_DELETE", this.f24537d, b.a.UI_BUS);
        b.b("ITEM_COMMENT_REPLY", this.f24538e, b.a.UI_BUS);
    }
}
