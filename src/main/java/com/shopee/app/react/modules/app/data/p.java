package com.shopee.app.react.modules.app.data;

import com.google.a.o;
import com.shopee.app.data.store.at;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.react.protocol.UnreadPurchasesResponse;
import com.shopee.app.util.af;
import com.shopee.app.web.WebRegister;
import java.util.Collections;
import java.util.List;

public class p implements i {

    /* renamed from: a  reason: collision with root package name */
    private at f18766a;

    public p(at atVar) {
        this.f18766a = atVar;
    }

    public boolean a(String str) {
        return "maskAsUnread".equals(str);
    }

    public String c(String str) {
        int g2 = ((o) WebRegister.GSON.a(str, o.class)).c("tabType").g();
        List<Long> a2 = this.f18766a.a(new OrderKey(0, g2));
        if (!af.a(a2)) {
            this.f18766a.a(new OrderKey(0, g2), (List<Long>) Collections.emptyList());
        }
        return WebRegister.GSON.b((Object) new UnreadPurchasesResponse(a2));
    }
}
