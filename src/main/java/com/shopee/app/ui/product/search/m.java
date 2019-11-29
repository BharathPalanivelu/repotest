package com.shopee.app.ui.product.search;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import java.util.List;

public final class m implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final l f24861a;

    /* renamed from: b  reason: collision with root package name */
    private final g f24862b = new g() {
        public void onEvent(a aVar) {
            m.this.f24861a.a((Pair<String, List<UserBriefInfo>>) (Pair) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public m(l lVar) {
        this.f24861a = lVar;
    }

    public void a() {
        b.a("SEARCH_USER_LOAD", (e) this.f24862b, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("SEARCH_USER_LOAD", this.f24862b, b.a.NETWORK_BUS);
    }
}
