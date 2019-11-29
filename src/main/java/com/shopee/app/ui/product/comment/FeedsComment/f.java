package com.shopee.app.ui.product.comment.FeedsComment;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.FeedCommentInfo;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.ui.common.e;
import com.shopee.app.ui.product.comment.b;
import java.util.List;

public final class f implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final e f24439a;

    /* renamed from: b  reason: collision with root package name */
    private final g f24440b = new g() {
        public void onEvent(a aVar) {
            f.this.f24439a.a((Pair<String, e[]>) (Pair) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f24441c = new g() {
        public void onEvent(a aVar) {
            f.this.f24439a.c(((Integer) aVar.data).intValue());
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f24442d = new g() {
        public void onEvent(a aVar) {
            f.this.f24439a.a((b) aVar);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f24443e = new g() {
        public void onEvent(a aVar) {
            f.this.f24439a.b((Pair<String, Integer>) (Pair) aVar.data);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f24444f = new g() {
        public void onEvent(a aVar) {
            f.this.f24439a.d(((Integer) aVar.data).intValue());
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f24445g = new g() {
        public void onEvent(a aVar) {
            f.this.f24439a.e();
        }
    };
    private final g h = new g() {
        public void onEvent(a aVar) {
            f.this.f24439a.a((List<FeedCommentInfo>) (List) aVar.data);
        }
    };
    private final g i = new g() {
        public void onEvent(a aVar) {
            f.this.f24439a.f();
        }
    };
    private final g j = new g() {
        public void onEvent(a aVar) {
            f.this.f24439a.b((List<UserData>) (List) aVar.data);
        }
    };
    private final g k = new g() {
        public void onEvent(a aVar) {
            f.this.f24439a.g();
        }
    };
    private final g l = new g() {
        public void onEvent(a aVar) {
            f.this.f24439a.a((ItemDetail) aVar.data);
        }
    };
    private final g m = new g() {
        public void onEvent(a aVar) {
            f.this.f24439a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public f(e eVar) {
        this.f24439a = eVar;
    }

    public void a() {
        com.garena.android.appkit.b.b.a("FEED_COMMENT_ERROR", (com.garena.android.appkit.b.e) this.f24444f, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("FEED_COMMENT_SAVED", (com.garena.android.appkit.b.e) this.f24445g, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("FEED_COMMENT_LOCAL_LOAD", (com.garena.android.appkit.b.e) this.h, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("COMMENT_LIST_SAVED", (com.garena.android.appkit.b.e) this.i, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("GET_USER_INFO_LOAD", (com.garena.android.appkit.b.e) this.j, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("ADD_FEED_COMMENT_SUCCESS", (com.garena.android.appkit.b.e) this.k, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("ITEM_DETAIL_LOAD", (com.garena.android.appkit.b.e) this.l, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("ADD_FEED_COMMENT_FAIL", (com.garena.android.appkit.b.e) this.m, b.a.NETWORK_BUS);
    }

    public void b() {
        com.garena.android.appkit.b.b.b("FEED_COMMENT_ERROR", this.f24444f, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("FEED_COMMENT_SAVED", this.f24445g, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("FEED_COMMENT_LOCAL_LOAD", this.h, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("COMMENT_LIST_SAVED", this.i, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("GET_USER_INFO_LOAD", this.j, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("ADD_FEED_COMMENT_SUCCESS", this.k, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("ITEM_DETAIL_LOAD", this.l, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("ADD_FEED_COMMENT_FAIL", this.m, b.a.NETWORK_BUS);
    }

    public void c() {
        com.garena.android.appkit.b.b.a("SEND_TEXT_COMMENT", (com.garena.android.appkit.b.e) this.f24440b, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("MENTION_CLICKED", (com.garena.android.appkit.b.e) this.f24441c, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("ITEM_COMMENT_DELETE", (com.garena.android.appkit.b.e) this.f24442d, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("ITEM_COMMENT_REPLY", (com.garena.android.appkit.b.e) this.f24443e, b.a.UI_BUS);
    }

    public void d() {
        com.garena.android.appkit.b.b.b("SEND_TEXT_COMMENT", this.f24440b, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("MENTION_CLICKED", this.f24441c, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("ITEM_COMMENT_DELETE", this.f24442d, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("ITEM_COMMENT_REPLY", this.f24443e, b.a.UI_BUS);
    }
}
