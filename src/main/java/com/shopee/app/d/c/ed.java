package com.shopee.app.d.c;

import com.garena.android.appkit.tools.a.a;
import com.shopee.app.data.store.j;
import com.shopee.app.data.viewmodel.BlackListData;
import com.shopee.app.h.a.e;
import com.shopee.app.util.l;
import com.shopee.app.util.n;
import com.shopee.app.web.WebRegister;
import org.json.JSONException;
import org.json.JSONObject;

public class ed extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final j f16906c;

    /* access modifiers changed from: protected */
    public String d() {
        return "SyncBlacklistDataInteractor";
    }

    protected ed(n nVar, j jVar) {
        super(nVar);
        this.f16906c = jVar;
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (a.a() - this.f16906c.b() > 3600) {
            com.shopee.app.h.a.a.a().a(l.f7049e, "blacklist_info", new e() {
                /* access modifiers changed from: protected */
                public void onJSonObject(JSONObject jSONObject) throws JSONException {
                    ed.this.f16906c.a((BlackListData) WebRegister.GSON.a(jSONObject.toString(), new com.google.a.c.a<BlackListData>() {
                    }.getType()));
                }
            });
        }
    }
}
