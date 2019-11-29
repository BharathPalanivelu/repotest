package com.shopee.app.react.modules.app.data;

import com.google.a.o;
import com.shopee.app.network.http.data.FeatureToggle;
import com.shopee.app.util.af;
import com.shopee.app.util.s;
import java.util.List;

public class j implements h {

    /* renamed from: a  reason: collision with root package name */
    private s f18755a;

    public j(s sVar) {
        this.f18755a = sVar;
    }

    public boolean a(String str) {
        return "featureToggle".equals(str);
    }

    public String b(String str) {
        o oVar = new o();
        List<FeatureToggle> b2 = this.f18755a.b();
        if (af.a(b2)) {
            return oVar.toString();
        }
        for (FeatureToggle next : b2) {
            oVar.a(next.name, next.toggle);
        }
        return oVar.toString();
    }
}
