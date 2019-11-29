package com.shopee.app.d.c;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.ap;
import com.shopee.app.data.store.bg;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.database.orm.bean.DBUserBrief;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.List;

public class ci extends a {

    /* renamed from: c  reason: collision with root package name */
    private final ap f16687c;

    /* renamed from: d  reason: collision with root package name */
    private final bg f16688d;

    /* access modifiers changed from: protected */
    public String d() {
        return "MyCustomerInteractor";
    }

    protected ci(n nVar, ap apVar, bg bgVar) {
        super(nVar);
        this.f16687c = apVar;
        this.f16688d = bgVar;
    }

    /* access modifiers changed from: protected */
    public void c() {
        List<DBUserBrief> b2 = this.f16688d.b(this.f16687c.c());
        ArrayList arrayList = new ArrayList();
        for (DBUserBrief a2 : b2) {
            UserBriefInfo userBriefInfo = new UserBriefInfo();
            b.a(a2, userBriefInfo);
            arrayList.add(userBriefInfo);
        }
        com.garena.android.appkit.b.b.a("MY_CUSTOMER_LOAD", new a(arrayList), b.a.NETWORK_BUS);
    }
}
