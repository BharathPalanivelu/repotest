package com.shopee.app.ui.product.add;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.da;
import com.shopee.app.data.viewmodel.VMItemAttribute;
import com.shopee.app.ui.product.attributes.u;
import com.shopee.app.upload.VideoState;
import java.util.List;

public final class f implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final e f24041a;

    /* renamed from: b  reason: collision with root package name */
    private final g f24042b = new g() {
        public void onEvent(a aVar) {
            f.this.f24041a.g();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f24043c = new g() {
        public void onEvent(a aVar) {
            f.this.f24041a.a(((Integer) aVar.data).intValue());
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f24044d = new g() {
        public void onEvent(a aVar) {
            f.this.f24041a.a((String) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f24045e = new g() {
        public void onEvent(a aVar) {
            f.this.f24041a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f24046f = new g() {
        public void onEvent(a aVar) {
            f.this.f24041a.b(((Integer) aVar.data).intValue());
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f24047g = new g() {
        public void onEvent(a aVar) {
            f.this.f24041a.a((af) aVar);
        }
    };
    private final g h = new g() {
        public void onEvent(a aVar) {
            f.this.f24041a.a((da.a) aVar.data);
        }
    };
    private final g i = new g() {
        public void onEvent(a aVar) {
            f.this.f24041a.h();
        }
    };
    private final g j = new g() {
        public void onEvent(a aVar) {
            f.this.f24041a.a((VideoState) aVar.data);
        }
    };
    private final g k = new g() {
        public void onEvent(a aVar) {
            f.this.f24041a.b((VideoState) aVar.data);
        }
    };
    private final g l = new g() {
        public void onEvent(a aVar) {
            f.this.f24041a.c((VideoState) aVar.data);
        }
    };
    private final g m = new g() {
        public void onEvent(a aVar) {
            f.this.f24041a.b((com.shopee.app.network.c.d.a) aVar.data);
        }
    };
    private final g n = new g() {
        public void onEvent(a aVar) {
            f.this.f24041a.c((List<VMItemAttribute>) (List) aVar.data);
        }
    };
    private final g o = new g() {
        public void onEvent(a aVar) {
            f.this.f24041a.a((u) aVar.data);
        }
    };
    private final g p = new g() {
        public void onEvent(a aVar) {
            f.this.f24041a.b((u) aVar.data);
        }
    };
    private final g q = new g() {
        public void onEvent(a aVar) {
            f.this.f24041a.c((u) aVar.data);
        }
    };
    private final g r = new g() {
        public void onEvent(a aVar) {
            f.this.f24041a.k();
        }
    };

    public void c() {
    }

    public void d() {
    }

    public f(e eVar) {
        this.f24041a = eVar;
    }

    public void a() {
        b.a("CMD_GET_SUBCATEGORY_SUCCESS", (e) this.f24042b, b.a.NETWORK_BUS);
        b.a("CMD_GET_ATTRIBUTE_MODEL_ERROR", (e) this.f24043c, b.a.NETWORK_BUS);
        b.a("CATEGORY_NAME_LOAD", (e) this.f24044d, b.a.NETWORK_BUS);
        b.a("ITEM_DELETE_ERROR", (e) this.f24045e, b.a.NETWORK_BUS);
        b.a("CMD_GET_ATTRIBUTE_MODEL_SUCCESS", (e) this.f24046f, b.a.NETWORK_BUS);
        b.a("CMD_MATCH_ATTRIBUTE_SUCCESS", (e) this.f24047g, b.a.NETWORK_BUS);
        b.a("ON_VIDEO_SELECTED", (e) this.h, b.a.NETWORK_BUS);
        b.a("ON_VIDEO_SELECTED_FAIL", (e) this.i, b.a.NETWORK_BUS);
        b.a("VIDEO_UPLOAD_PROGRESS", (e) this.j, b.a.NETWORK_BUS);
        b.a("VIDEO_TRIM_SUCCESS", (e) this.k, b.a.NETWORK_BUS);
        b.a("VIDEO_UPLOAD_SUCCESS", (e) this.l, b.a.NETWORK_BUS);
        b.a("ADD_ITEM_RESULT_ERROR", (e) this.m, b.a.NETWORK_BUS);
        b.a("ITEM_DETAIL_LOAD_FAIL", (e) this.m, b.a.NETWORK_BUS);
        b.a("ADD_ITEM_RESULT_INVALIDATE", (e) this.m, b.a.NETWORK_BUS);
        b.a("GET_LOCAL_ATTRIBUTES_SUCCESS", (e) this.n, b.a.NETWORK_BUS);
        b.a("ON_ATTRIBUTE_AUTO_SELECTED", (e) this.o, b.a.NETWORK_BUS);
        b.a("ON_ATTRIBUTE_SELF_DEFINED", (e) this.p, b.a.NETWORK_BUS);
        b.a("ON_ATTRIBUTE_SELECTED", (e) this.q, b.a.NETWORK_BUS);
        b.a("ON_NEW_LISTING_VALIDATOR_CONFIG", (e) this.r, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("CMD_GET_SUBCATEGORY_SUCCESS", this.f24042b, b.a.NETWORK_BUS);
        b.b("CMD_GET_ATTRIBUTE_MODEL_ERROR", this.f24043c, b.a.NETWORK_BUS);
        b.b("CATEGORY_NAME_LOAD", this.f24044d, b.a.NETWORK_BUS);
        b.b("ITEM_DELETE_ERROR", this.f24045e, b.a.NETWORK_BUS);
        b.b("CMD_GET_ATTRIBUTE_MODEL_SUCCESS", this.f24046f, b.a.NETWORK_BUS);
        b.b("CMD_MATCH_ATTRIBUTE_SUCCESS", this.f24047g, b.a.NETWORK_BUS);
        b.b("ON_VIDEO_SELECTED", this.h, b.a.NETWORK_BUS);
        b.b("ON_VIDEO_SELECTED_FAIL", this.i, b.a.NETWORK_BUS);
        b.b("VIDEO_UPLOAD_PROGRESS", this.j, b.a.NETWORK_BUS);
        b.b("VIDEO_TRIM_SUCCESS", this.k, b.a.NETWORK_BUS);
        b.b("VIDEO_UPLOAD_SUCCESS", this.l, b.a.NETWORK_BUS);
        b.b("ADD_ITEM_RESULT_ERROR", this.m, b.a.NETWORK_BUS);
        b.b("ITEM_DETAIL_LOAD_FAIL", this.m, b.a.NETWORK_BUS);
        b.b("ADD_ITEM_RESULT_INVALIDATE", this.m, b.a.NETWORK_BUS);
        b.b("GET_LOCAL_ATTRIBUTES_SUCCESS", this.n, b.a.NETWORK_BUS);
        b.b("ON_ATTRIBUTE_AUTO_SELECTED", this.o, b.a.NETWORK_BUS);
        b.b("ON_ATTRIBUTE_SELF_DEFINED", this.p, b.a.NETWORK_BUS);
        b.b("ON_ATTRIBUTE_SELECTED", this.q, b.a.NETWORK_BUS);
        b.b("ON_NEW_LISTING_VALIDATOR_CONFIG", this.r, b.a.NETWORK_BUS);
    }
}
