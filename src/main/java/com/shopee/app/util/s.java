package com.shopee.app.util;

import android.text.TextUtils;
import com.google.a.c.a;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.ac;
import com.shopee.app.network.http.a.e;
import com.shopee.app.network.http.data.FeatureToggle;
import com.shopee.app.network.http.data.FeatureToggleResponse;
import com.shopee.app.util.k.i;
import com.shopee.app.web.WebRegister;
import io.b.d.f;
import java.util.List;

public class s {

    /* renamed from: a  reason: collision with root package name */
    private e f26499a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ac f26500b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<FeatureToggle> f26501c;

    /* renamed from: d  reason: collision with root package name */
    private UserInfo f26502d;

    public s(e eVar, ac acVar, UserInfo userInfo) {
        this.f26499a = eVar;
        this.f26500b = acVar;
        this.f26502d = userInfo;
        this.f26501c = (List) WebRegister.GSON.a(!TextUtils.isEmpty(this.f26500b.a()) ? this.f26500b.a() : "[]", new a<List<FeatureToggle>>() {
        }.getType());
        a();
    }

    public void a() {
        this.f26499a.a(Integer.valueOf(this.f26502d.getUserId())).b(io.b.h.a.b()).a(io.b.h.a.b()).a(new f<FeatureToggleResponse>() {
            /* renamed from: a */
            public void accept(FeatureToggleResponse featureToggleResponse) throws Exception {
                if (featureToggleResponse.isSuccess()) {
                    List<FeatureToggle> list = featureToggleResponse.data;
                    s.this.f26500b.a(WebRegister.GSON.b((Object) list));
                    List unused = s.this.f26501c = list;
                    WebRegister.notifyRNAppEvent("FeatureToggleUpdate", "");
                }
            }
        }, (f<? super Throwable>) bb.a());
    }

    public boolean a(String str) {
        if (!af.a(this.f26501c) && !TextUtils.isEmpty(str)) {
            for (FeatureToggle next : this.f26501c) {
                if (i.c(next.name, str)) {
                    return b.a(next.toggle);
                }
            }
        }
        return false;
    }

    public List<FeatureToggle> b() {
        return this.f26501c;
    }
}
