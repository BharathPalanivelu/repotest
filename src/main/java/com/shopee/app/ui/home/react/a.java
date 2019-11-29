package com.shopee.app.ui.home.react;

import android.util.Pair;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class a implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ReactTabView f22708a;

    /* renamed from: b  reason: collision with root package name */
    private final g f22709b = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            a.this.f22708a.l();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f22710c = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            a.this.f22708a.m();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f22711d = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            a.this.f22708a.a((Pair<String, String>) (Pair) aVar.data);
        }
    };

    public a(ReactTabView reactTabView) {
        this.f22708a = reactTabView;
    }

    public void a() {
        b.a("REACT_ME_FEEDS_PAGE_UPDATE", (e) this.f22709b, b.a.NETWORK_BUS);
        b.a("REACT_PAGE_DID_MOUNT", (e) this.f22710c, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("REACT_ME_FEEDS_PAGE_UPDATE", this.f22709b, b.a.NETWORK_BUS);
        b.b("REACT_PAGE_DID_MOUNT", this.f22710c, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("MALL_TAB_REDIRECT_PARAM", (e) this.f22711d, b.a.UI_BUS);
    }

    public void d() {
        b.b("MALL_TAB_REDIRECT_PARAM", this.f22711d, b.a.UI_BUS);
    }
}
