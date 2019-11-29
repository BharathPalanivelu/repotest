package com.shopee.app.d.c;

import com.garena.android.appkit.tools.a.a;
import com.shopee.app.data.store.h;
import com.shopee.app.data.viewmodel.BannerData;
import com.shopee.app.data.viewmodel.RecommendBannerData;
import com.shopee.app.util.ab;
import com.shopee.app.util.l;
import com.shopee.app.util.n;
import com.shopee.app.web.WebRegister;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class eb extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final h f16899c;

    /* access modifiers changed from: protected */
    public String d() {
        return "SyncBannerDataInteractor";
    }

    protected eb(n nVar, h hVar) {
        super(nVar);
        this.f16899c = hVar;
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (a.a() - this.f16899c.b() > 3600) {
            AnonymousClass1 r0 = new ab() {
                /* access modifiers changed from: protected */
                public void onJSONArray(JSONArray jSONArray) throws JSONException {
                    eb.this.f16899c.a((List) WebRegister.GSON.a(jSONArray.toString(), new com.google.a.c.a<List<BannerData>>() {
                    }.getType()));
                    eb.this.f16899c.c();
                    eb.this.f16402a.a("ACTION_BANNER_SAVED", new com.garena.android.appkit.b.a());
                }
            };
            AnonymousClass2 r1 = new ab() {
                /* access modifiers changed from: protected */
                public void onJSONArray(JSONArray jSONArray) throws JSONException {
                    eb.this.f16899c.b((List) WebRegister.GSON.a(jSONArray.toString(), new com.google.a.c.a<List<RecommendBannerData>>() {
                    }.getType()));
                    eb.this.f16899c.c();
                    eb.this.f16402a.a("RECOMMEND_BANNER_SAVED", new com.garena.android.appkit.b.a());
                }
            };
            com.shopee.app.h.a.a.a().a(l.f7048d, "activity_banner_info", r0);
            com.shopee.app.h.a.a.a().a(l.f7050f, "recommend_banner_info", r1);
        }
    }
}
