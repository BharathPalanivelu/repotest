package com.shopee.app.d.c.f;

import com.shopee.app.d.c.a;
import com.shopee.app.data.store.av;
import com.shopee.app.database.orm.bean.chatP2P.DBChat;
import com.shopee.app.network.d.ai;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.List;

public class k extends a {

    /* renamed from: c  reason: collision with root package name */
    private final av f16994c;

    /* access modifiers changed from: protected */
    public String d() {
        return "RequestOfferCountInteractor";
    }

    k(n nVar, av avVar) {
        super(nVar);
        this.f16994c = avVar;
    }

    /* access modifiers changed from: protected */
    public void c() {
        List<DBChat> a2 = this.f16994c.a();
        ArrayList arrayList = new ArrayList(a2.size());
        int i = 0;
        for (DBChat next : a2) {
            if (next.h() > 0) {
                i++;
                arrayList.add(Integer.valueOf(next.b()));
                if (i > 100) {
                    break;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            new ai().a(1, arrayList);
        }
    }
}
