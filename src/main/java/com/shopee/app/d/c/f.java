package com.shopee.app.d.c;

import com.shopee.app.application.ar;
import com.shopee.app.data.store.aq;
import com.shopee.app.util.n;
import java.util.List;

public class f extends a {
    /* access modifiers changed from: protected */
    public String b() {
        return "notification";
    }

    /* access modifiers changed from: protected */
    public String d() {
        return "ClearNotificationInteractor";
    }

    f(n nVar) {
        super(nVar);
    }

    /* access modifiers changed from: protected */
    public void c() {
        new aq(ar.f().getSharedPreferences("notification_list", 4)).a((List<String>) null);
    }
}
