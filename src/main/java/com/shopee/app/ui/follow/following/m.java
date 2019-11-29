package com.shopee.app.ui.follow.following;

import com.shopee.app.d.b.b;
import com.shopee.app.d.c.a;
import com.shopee.app.data.store.ah;
import com.shopee.app.database.orm.bean.DBItemDetail;
import com.shopee.app.h.o;
import com.shopee.app.network.d.ad;
import com.shopee.app.network.d.az;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.RecUser;
import com.shopee.protocol.action.ResponseRecUsers;
import java.util.ArrayList;
import java.util.List;

public class m extends a {

    /* renamed from: c  reason: collision with root package name */
    private String f21656c;

    /* renamed from: d  reason: collision with root package name */
    private final ah f21657d;

    /* access modifiers changed from: protected */
    public String d() {
        return "ProcessRecommendListInteractor";
    }

    public m(n nVar, ah ahVar) {
        super(nVar);
        this.f21657d = ahVar;
    }

    public void a(String str) {
        this.f21656c = str;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        az f2 = o.a().f(this.f21656c);
        if (f2 != null) {
            ResponseRecUsers b2 = ((ad) f2).b();
            ArrayList arrayList = new ArrayList();
            if (!af.a(b2.users)) {
                for (RecUser next : b2.users) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Long longValue : next.itemid_list) {
                        DBItemDetail a2 = this.f21657d.a(longValue.longValue());
                        if (a2 != null) {
                            k kVar = new k();
                            b.a(kVar, a2);
                            arrayList2.add(kVar);
                        }
                    }
                    t tVar = new t();
                    tVar.f(2);
                    b.a(tVar, next);
                    tVar.a((List<k>) arrayList2);
                    if (!tVar.g()) {
                        arrayList.add(tVar);
                    }
                }
            }
            this.f16402a.a("GET_REC_FRIEND_LIST", new com.garena.android.appkit.b.a(arrayList));
        }
    }
}
