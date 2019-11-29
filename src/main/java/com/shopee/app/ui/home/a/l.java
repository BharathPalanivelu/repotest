package com.shopee.app.ui.home.a;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.data.viewmodel.ActivityItemInfo;
import java.util.List;

public final class l implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final k f22066a;

    /* renamed from: b  reason: collision with root package name */
    private final g f22067b = new g() {
        public void onEvent(a aVar) {
            l.this.f22066a.a((Pair<Integer, List<ActivityItemInfo>>) (Pair) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f22068c = new g() {
        public void onEvent(a aVar) {
            l.this.f22066a.b(((Integer) aVar.data).intValue());
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f22069d = new g() {
        public void onEvent(a aVar) {
            l.this.f22066a.a((ActivityCounter) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f22070e = new g() {
        public void onEvent(a aVar) {
            l.this.f22066a.c(((Integer) aVar.data).intValue());
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f22071f = new g() {
        public void onEvent(a aVar) {
            l.this.f22066a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f22072g = new g() {
        public void onEvent(a aVar) {
            l.this.f22066a.b((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public l(k kVar) {
        this.f22066a = kVar;
    }

    public void a() {
        b.a("ACTIVITY_LIST_LOCAL_LOAD", (e) this.f22067b, b.a.NETWORK_BUS);
        b.a("ACTIVITY_LIST_SAVED", (e) this.f22068c, b.a.NETWORK_BUS);
        b.a("ACTIVITY_BADGE_UPDATE", (e) this.f22069d, b.a.NETWORK_BUS);
        b.a("ACTIVITY_REMOVED_SUCCESS", (e) this.f22070e, b.a.NETWORK_BUS);
        b.a("ACTIVITY_REMOVE_ERROR", (e) this.f22071f, b.a.NETWORK_BUS);
        b.a("FOLLOW_ERROR", (e) this.f22072g, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("ACTIVITY_LIST_LOCAL_LOAD", this.f22067b, b.a.NETWORK_BUS);
        b.b("ACTIVITY_LIST_SAVED", this.f22068c, b.a.NETWORK_BUS);
        b.b("ACTIVITY_BADGE_UPDATE", this.f22069d, b.a.NETWORK_BUS);
        b.b("ACTIVITY_REMOVED_SUCCESS", this.f22070e, b.a.NETWORK_BUS);
        b.b("ACTIVITY_REMOVE_ERROR", this.f22071f, b.a.NETWORK_BUS);
        b.b("FOLLOW_ERROR", this.f22072g, b.a.NETWORK_BUS);
    }
}
