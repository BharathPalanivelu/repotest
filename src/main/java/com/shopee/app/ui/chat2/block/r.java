package com.shopee.app.ui.chat2.block;

import com.garena.android.appkit.b.b;
import com.shopee.app.d.c.a;
import com.shopee.app.data.store.k;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.database.orm.bean.chatP2P.DBBlockUser;
import com.shopee.app.h.t;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.List;

public class r extends a {

    /* renamed from: c  reason: collision with root package name */
    private final k f20363c;

    /* access modifiers changed from: protected */
    public String d() {
        return "LoadBlockUserInteractor";
    }

    protected r(n nVar, k kVar) {
        super(nVar);
        this.f20363c = kVar;
    }

    /* access modifiers changed from: protected */
    public void c() {
        List<DBBlockUser> b2 = this.f20363c.b();
        ArrayList arrayList = new ArrayList();
        for (DBBlockUser next : b2) {
            UserBriefInfo a2 = t.a().a(next.a());
            if (a2 != null && next.b() && !a2.isUserDeleted()) {
                a2.setIsChatBlocked(next.b());
                arrayList.add(a2);
            }
        }
        if (arrayList.size() > 0) {
            UserBriefInfo userBriefInfo = new UserBriefInfo();
            userBriefInfo.setUserId(-1);
            arrayList.add(userBriefInfo);
        }
        b.a("BLOCKED_USER_LOAD", new com.garena.android.appkit.b.a(arrayList), b.a.NETWORK_BUS);
    }
}
