package com.shopee.app.ui.home;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.store.theme.ActionBarTheme;
import com.shopee.app.data.viewmodel.MeCounter;

public final class j implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final i f22237a;

    /* renamed from: b  reason: collision with root package name */
    private final g f22238b = new g() {
        public void onEvent(a aVar) {
            j.this.f22237a.f();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f22239c = new g() {
        public void onEvent(a aVar) {
            j.this.f22237a.g();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f22240d = new g() {
        public void onEvent(a aVar) {
            j.this.f22237a.h();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f22241e = new g() {
        public void onEvent(a aVar) {
            j.this.f22237a.i();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f22242f = new g() {
        public void onEvent(a aVar) {
            j.this.f22237a.j();
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f22243g = new g() {
        public void onEvent(a aVar) {
            j.this.f22237a.k();
        }
    };
    private final g h = new g() {
        public void onEvent(a aVar) {
            j.this.f22237a.l();
        }
    };
    private final g i = new g() {
        public void onEvent(a aVar) {
            j.this.f22237a.a(((Boolean) aVar.data).booleanValue());
        }
    };
    private final g j = new g() {
        public void onEvent(a aVar) {
            j.this.f22237a.a(((Integer) aVar.data).intValue());
        }
    };
    private final g k = new g() {
        public void onEvent(a aVar) {
            j.this.f22237a.a((MeCounter) aVar.data);
        }
    };
    private final g l = new g() {
        public void onEvent(a aVar) {
            j.this.f22237a.m();
        }
    };
    private final g m = new g() {
        public void onEvent(a aVar) {
            j.this.f22237a.a((ActionBarTheme) aVar.data);
        }
    };

    public j(i iVar) {
        this.f22237a = iVar;
    }

    public void a() {
        b.a("APP_UPGRADE_XIAOMI_POPUP", (e) this.f22238b, b.a.NETWORK_BUS);
        b.a("CHAT_BADGE_LOAD", (e) this.j, b.a.NETWORK_BUS);
        b.a("CHAT_BADGE_UPDATE2", (e) this.j, b.a.NETWORK_BUS);
        b.a("ME_TAB_BADGE_UPDATE", (e) this.k, b.a.NETWORK_BUS);
        b.a("FEED_ON_NEW_RED_DOT", (e) this.l, b.a.NETWORK_BUS);
        b.a("ACTION_BAR_THEME_CHANGED", (e) this.m, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("APP_UPGRADE_XIAOMI_POPUP", this.f22238b, b.a.NETWORK_BUS);
        b.b("CHAT_BADGE_LOAD", this.j, b.a.NETWORK_BUS);
        b.b("CHAT_BADGE_UPDATE2", this.j, b.a.NETWORK_BUS);
        b.b("ME_TAB_BADGE_UPDATE", this.k, b.a.NETWORK_BUS);
        b.b("FEED_ON_NEW_RED_DOT", this.l, b.a.NETWORK_BUS);
        b.b("ACTION_BAR_THEME_CHANGED", this.m, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("ACTION_BAR_CART_PRIMARY", (e) this.f22239c, b.a.UI_BUS);
        b.a("ACTION_BAR_ACTION_BOX_PRIMARY", (e) this.f22240d, b.a.UI_BUS);
        b.a("ACTION_BAR_HOME_ACTION", (e) this.f22241e, b.a.UI_BUS);
        b.a("ME_TAB_SHOW", (e) this.f22242f, b.a.UI_BUS);
        b.a("DISMISS_TOOL_TIP_MALL", (e) this.f22243g, b.a.UI_BUS);
        b.a("DISMISS_TOOL_TIP_SELL_TAB", (e) this.h, b.a.UI_BUS);
        b.a("ME_TAB_FEED_TAB_SHOW", (e) this.i, b.a.UI_BUS);
    }

    public void d() {
        b.b("ACTION_BAR_CART_PRIMARY", this.f22239c, b.a.UI_BUS);
        b.b("ACTION_BAR_ACTION_BOX_PRIMARY", this.f22240d, b.a.UI_BUS);
        b.b("ACTION_BAR_HOME_ACTION", this.f22241e, b.a.UI_BUS);
        b.b("ME_TAB_SHOW", this.f22242f, b.a.UI_BUS);
        b.b("DISMISS_TOOL_TIP_MALL", this.f22243g, b.a.UI_BUS);
        b.b("DISMISS_TOOL_TIP_SELL_TAB", this.h, b.a.UI_BUS);
        b.b("ME_TAB_FEED_TAB_SHOW", this.i, b.a.UI_BUS);
    }
}
