package com.shopee.app.ui.actionbox2;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.bn;
import com.shopee.app.d.c.u;
import com.shopee.app.data.viewmodel.ActionContentInfo;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.data.viewmodel.ActivityItemInfo;
import com.shopee.app.data.viewmodel.MeCounter;
import java.util.List;

public final class e implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final d f19388a;

    /* renamed from: b  reason: collision with root package name */
    private final g f19389b = new g() {
        public void onEvent(a aVar) {
            e.this.f19388a.g();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f19390c = new g() {
        public void onEvent(a aVar) {
            e.this.f19388a.a((Pair<Long, Integer>) (Pair) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f19391d = new g() {
        public void onEvent(a aVar) {
            e.this.f19388a.b(((Long) aVar.data).longValue());
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f19392e = new g() {
        public void onEvent(a aVar) {
            e.this.f19388a.a((String) aVar.data);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f19393f = new g() {
        public void onEvent(a aVar) {
            e.this.f19388a.b(((Integer) aVar.data).intValue());
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f19394g = new g() {
        public void onEvent(a aVar) {
            e.this.f19388a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };
    private final g h = new g() {
        public void onEvent(a aVar) {
            e.this.f19388a.b((com.shopee.app.network.c.d.a) aVar.data);
        }
    };
    private final g i = new g() {
        public void onEvent(a aVar) {
            e.this.f19388a.h();
        }
    };
    private final g j = new g() {
        public void onEvent(a aVar) {
            e.this.f19388a.i();
        }
    };
    private final g k = new g() {
        public void onEvent(a aVar) {
            e.this.f19388a.a((ActionRequiredCounter) aVar.data);
        }
    };
    private final g l = new g() {
        public void onEvent(a aVar) {
            e.this.f19388a.a((ActivityCounter) aVar.data);
        }
    };
    private final g m = new g() {
        public void onEvent(a aVar) {
            e.this.f19388a.c(((Integer) aVar.data).intValue());
        }
    };
    private final g n = new g() {
        public void onEvent(a aVar) {
            e.this.f19388a.a((List<ActivityItemInfo>) (List) aVar.data);
        }
    };
    private final g o = new g() {
        public void onEvent(a aVar) {
            e.this.f19388a.b((String) aVar.data);
        }
    };
    private final g p = new g() {
        public void onEvent(a aVar) {
            e.this.f19388a.a((bn.b) aVar.data);
        }
    };
    private final g q = new g() {
        public void onEvent(a aVar) {
            e.this.f19388a.j();
        }
    };
    private final g r = new g() {
        public void onEvent(a aVar) {
            e.this.f19388a.c(((Long) aVar.data).longValue());
        }
    };
    private final g s = new g() {
        public void onEvent(a aVar) {
            e.this.f19388a.b((Pair<Long, Integer>) (Pair) aVar.data);
        }
    };
    private final g t = new g() {
        public void onEvent(a aVar) {
            e.this.f19388a.d(((Long) aVar.data).longValue());
        }
    };
    private final g u = new g() {
        public void onEvent(a aVar) {
            e.this.f19388a.c((Pair<List<ActionContentInfo>, u.a>) (Pair) aVar.data);
        }
    };
    private final g v = new g() {
        public void onEvent(a aVar) {
            e.this.f19388a.d((Pair<List<ActionContentInfo>, Long>) (Pair) aVar.data);
        }
    };
    private final g w = new g() {
        public void onEvent(a aVar) {
            e.this.f19388a.a((MeCounter) aVar.data);
        }
    };

    public e(d dVar) {
        this.f19388a = dVar;
    }

    public void a() {
        b.a("LOGIN_SUCCESS", (com.garena.android.appkit.b.e) this.f19389b, b.a.NETWORK_BUS);
        b.a("NEW_ACTION_ARRIVED", (com.garena.android.appkit.b.e) this.f19390c, b.a.NETWORK_BUS);
        b.a("ACTION_REMOVE_SUCCESS", (com.garena.android.appkit.b.e) this.f19391d, b.a.NETWORK_BUS);
        b.a("ACTIVITY_REMOVE_SUCCESS", (com.garena.android.appkit.b.e) this.f19392e, b.a.NETWORK_BUS);
        b.a("ACTIVITY_REMOVED_SUCCESS", (com.garena.android.appkit.b.e) this.f19393f, b.a.NETWORK_BUS);
        b.a("ACTIVITY_REMOVE_ERROR", (com.garena.android.appkit.b.e) this.f19394g, b.a.NETWORK_BUS);
        b.a("ACTION_REMOVE_ERROR", (com.garena.android.appkit.b.e) this.h, b.a.NETWORK_BUS);
        b.a("RARING_STATUS_CHANGE", (com.garena.android.appkit.b.e) this.i, b.a.NETWORK_BUS);
        b.a("ACTION_REQUIRED_BADGE_UPDATE", (com.garena.android.appkit.b.e) this.k, b.a.NETWORK_BUS);
        b.a("ACTIVITY_BADGE_UPDATE", (com.garena.android.appkit.b.e) this.l, b.a.NETWORK_BUS);
        b.a("ACTIVITY_LIST_SAVED", (com.garena.android.appkit.b.e) this.m, b.a.NETWORK_BUS);
        b.a("ACTIVITY_LIST_LOCAL_PROBE", (com.garena.android.appkit.b.e) this.n, b.a.NETWORK_BUS);
        b.a("GET_SHOP_UPDATES_NOTIFICATION_INFO", (com.garena.android.appkit.b.e) this.o, b.a.NETWORK_BUS);
        b.a("ACTION_PROBE_CONTENT_LOAD", (com.garena.android.appkit.b.e) this.p, b.a.NETWORK_BUS);
        b.a("ACTION_CONTENT_SAVE", (com.garena.android.appkit.b.e) this.q, b.a.NETWORK_BUS);
        b.a("ACTION_CHILD_CONTENT_SAVE", (com.garena.android.appkit.b.e) this.r, b.a.NETWORK_BUS);
        b.a("ACTION_LIST_LOAD", (com.garena.android.appkit.b.e) this.s, b.a.NETWORK_BUS);
        b.a("CHILD_ACTION_LIST_LOAD", (com.garena.android.appkit.b.e) this.t, b.a.NETWORK_BUS);
        b.a("ACTION_CONTENT_LOAD", (com.garena.android.appkit.b.e) this.u, b.a.NETWORK_BUS);
        b.a("CHILD_ACTION_CONTENT_LOAD", (com.garena.android.appkit.b.e) this.v, b.a.NETWORK_BUS);
        b.a("ME_TAB_BADGE_UPDATE", (com.garena.android.appkit.b.e) this.w, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("LOGIN_SUCCESS", this.f19389b, b.a.NETWORK_BUS);
        b.b("NEW_ACTION_ARRIVED", this.f19390c, b.a.NETWORK_BUS);
        b.b("ACTION_REMOVE_SUCCESS", this.f19391d, b.a.NETWORK_BUS);
        b.b("ACTIVITY_REMOVE_SUCCESS", this.f19392e, b.a.NETWORK_BUS);
        b.b("ACTIVITY_REMOVED_SUCCESS", this.f19393f, b.a.NETWORK_BUS);
        b.b("ACTIVITY_REMOVE_ERROR", this.f19394g, b.a.NETWORK_BUS);
        b.b("ACTION_REMOVE_ERROR", this.h, b.a.NETWORK_BUS);
        b.b("RARING_STATUS_CHANGE", this.i, b.a.NETWORK_BUS);
        b.b("ACTION_REQUIRED_BADGE_UPDATE", this.k, b.a.NETWORK_BUS);
        b.b("ACTIVITY_BADGE_UPDATE", this.l, b.a.NETWORK_BUS);
        b.b("ACTIVITY_LIST_SAVED", this.m, b.a.NETWORK_BUS);
        b.b("ACTIVITY_LIST_LOCAL_PROBE", this.n, b.a.NETWORK_BUS);
        b.b("GET_SHOP_UPDATES_NOTIFICATION_INFO", this.o, b.a.NETWORK_BUS);
        b.b("ACTION_PROBE_CONTENT_LOAD", this.p, b.a.NETWORK_BUS);
        b.b("ACTION_CONTENT_SAVE", this.q, b.a.NETWORK_BUS);
        b.b("ACTION_CHILD_CONTENT_SAVE", this.r, b.a.NETWORK_BUS);
        b.b("ACTION_LIST_LOAD", this.s, b.a.NETWORK_BUS);
        b.b("CHILD_ACTION_LIST_LOAD", this.t, b.a.NETWORK_BUS);
        b.b("ACTION_CONTENT_LOAD", this.u, b.a.NETWORK_BUS);
        b.b("CHILD_ACTION_CONTENT_LOAD", this.v, b.a.NETWORK_BUS);
        b.b("ME_TAB_BADGE_UPDATE", this.w, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("ON_ORDER_READ_ALL", (com.garena.android.appkit.b.e) this.j, b.a.UI_BUS);
    }

    public void d() {
        b.b("ON_ORDER_READ_ALL", this.j, b.a.UI_BUS);
    }
}
