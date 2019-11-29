package com.shopee.app.react.modules.app.data;

import com.shopee.app.data.store.at;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.react.protocol.UnreadPurchasesResponse;
import com.shopee.app.web.WebRegister;

public class o implements h {

    /* renamed from: a  reason: collision with root package name */
    private at f18765a;

    public o(at atVar) {
        this.f18765a = atVar;
    }

    public boolean a(String str) {
        return "unreadPurchases".equals(str);
    }

    public String b(String str) {
        return WebRegister.GSON.b((Object) new UnreadPurchasesResponse(this.f18765a.a(new OrderKey(0, ((com.google.a.o) WebRegister.GSON.a(str, com.google.a.o.class)).c("tabType").g()))));
    }
}
