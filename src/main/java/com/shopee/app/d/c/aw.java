package com.shopee.app.d.c;

import com.google.a.l;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.al;
import com.shopee.app.network.http.a.f;
import com.shopee.app.network.http.data.JsonDataResponse;
import com.shopee.app.react.modules.app.data.k;
import com.shopee.app.util.s;
import com.shopee.arcatch.data.common_bean.Country;
import d.d.b.j;
import f.m;
import io.b.b.b;
import io.b.i.a;

public final class aw extends ck {

    /* renamed from: c  reason: collision with root package name */
    private final a<Boolean> f16522c;

    /* renamed from: d  reason: collision with root package name */
    private final f f16523d;

    /* renamed from: e  reason: collision with root package name */
    private final UserInfo f16524e;

    /* renamed from: f  reason: collision with root package name */
    private final k f16525f;

    /* renamed from: g  reason: collision with root package name */
    private final s f16526g;
    private final al h;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetJkoWalletStatusInteractor";
    }

    public aw(f fVar, UserInfo userInfo, k kVar, s sVar, al alVar) {
        j.b(fVar, "jkoPayApi");
        j.b(userInfo, "userInfo");
        j.b(kVar, "rnConfigProvider");
        j.b(sVar, "featureToggleManager");
        j.b(alVar, "loginStore");
        this.f16523d = fVar;
        this.f16524e = userInfo;
        this.f16525f = kVar;
        this.f16526g = sVar;
        this.h = alVar;
        a<Boolean> j = a.j();
        j.a((Object) j, "BehaviorSubject.create<Boolean>()");
        this.f16522c = j;
    }

    public final b a(io.b.d.f<Boolean> fVar) {
        j.b(fVar, "consumer");
        a();
        b a2 = this.f16522c.a(io.b.a.b.a.a()).a(fVar);
        j.a((Object) a2, "subject.observeOn(Androi…ad()).subscribe(consumer)");
        return a2;
    }

    /* access modifiers changed from: protected */
    public void c() {
        boolean z = false;
        if (!this.f16525f.f() || this.f16524e.isCrossBorder() || (!j.a((Object) Country.COUNTRY_TW, (Object) "ID"))) {
            this.f16522c.a(false);
            return;
        }
        this.f16522c.a(this.h.B());
        try {
            m<JsonDataResponse> a2 = this.f16523d.a().a();
            JsonDataResponse e2 = a2.e();
            if (a2 != null && a2.d() && e2 != null) {
                l c2 = e2.getData().c("is_disabled");
                j.a((Object) c2, "body.data.get(\"is_disabled\")");
                if (!c2.h()) {
                    z = true;
                }
                this.h.f(z);
                this.f16522c.a(Boolean.valueOf(z));
            }
        } catch (Exception e3) {
            com.garena.android.appkit.d.a.a(e3);
        }
    }
}
