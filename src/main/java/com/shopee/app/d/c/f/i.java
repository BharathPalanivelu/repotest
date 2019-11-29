package com.shopee.app.d.c.f;

import com.shopee.app.d.b.b;
import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.bg;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.database.orm.bean.DBUserBrief;
import com.shopee.app.database.orm.bean.chatP2P.DBChat;
import com.shopee.app.network.d.at;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class i extends com.shopee.app.d.c.a.a<a> {

    /* renamed from: d  reason: collision with root package name */
    private final av f16988d;

    /* renamed from: e  reason: collision with root package name */
    private final bg f16989e;

    protected i(n nVar, bg bgVar, av avVar) {
        super(nVar);
        this.f16989e = bgVar;
        this.f16988d = avVar;
    }

    public void a(boolean z) {
        b(new a(z));
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        List<DBChat> b2 = this.f16988d.b();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (DBChat next : b2) {
            if (next.h() > 0) {
                arrayList.add(Integer.valueOf(next.b()));
            }
        }
        HashMap<Integer, DBUserBrief> d2 = this.f16989e.d(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Integer num : arrayList) {
            if (!d2.containsKey(num)) {
                arrayList2.add(num);
            } else {
                UserData userData = new UserData();
                b.a(d2.get(num), userData);
                userData.setUserName(userData.getUserName().toLowerCase());
                arrayList3.add(userData);
            }
        }
        if (!af.a(arrayList2) && aVar.f16990a) {
            for (List a2 : af.a(arrayList2, 200)) {
                new at().a(a2);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        this.f16405a.a().ba.a(arrayList3).a();
    }

    public static class a extends a.C0253a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public boolean f16990a;

        public a(boolean z) {
            super("PrepareChatSearchDataInteractor" + z, "use_case8", 0, false);
            this.f16990a = z;
        }
    }
}
