package com.shopee.app.ui.product.rating;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.ItemCommentInfo;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.ui.product.rating.b;
import java.util.List;

public final class f implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final e f24746a;

    /* renamed from: b  reason: collision with root package name */
    private final g f24747b = new g() {
        public void onEvent(a aVar) {
            f.this.f24746a.a((List<ItemCommentInfo>) (List) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f24748c = new g() {
        public void onEvent(a aVar) {
            f.this.f24746a.a((b.C0380b) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f24749d = new g() {
        public void onEvent(a aVar) {
            f.this.f24746a.b((List<UserData>) (List) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final com.garena.android.appkit.b.f f24750e = new com.garena.android.appkit.b.f() {
        public void a(a aVar) {
            f.this.f24746a.f();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f24751f = new g() {
        public void onEvent(a aVar) {
            f.this.f24746a.a(((Integer) aVar.data).intValue());
        }
    };

    public void c() {
    }

    public void d() {
    }

    public f(e eVar) {
        this.f24746a = eVar;
    }

    public void a() {
        com.garena.android.appkit.b.b.a("ITEM_IMAGE_RATING_SAVED", (e) this.f24747b, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("ITEM_IMAGE_RATING_LOAD", (e) this.f24748c, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("GET_USER_INFO_LOAD", (e) this.f24749d, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("ITEM_SNAPSHOT_LOAD", (e) this.f24750e, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("COMMENT_LIST_ERROR", (e) this.f24751f, b.a.NETWORK_BUS);
    }

    public void b() {
        com.garena.android.appkit.b.b.b("ITEM_IMAGE_RATING_SAVED", this.f24747b, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("ITEM_IMAGE_RATING_LOAD", this.f24748c, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("GET_USER_INFO_LOAD", this.f24749d, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("ITEM_SNAPSHOT_LOAD", this.f24750e, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("COMMENT_LIST_ERROR", this.f24751f, b.a.NETWORK_BUS);
    }
}
