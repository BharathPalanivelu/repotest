package com.shopee.app.data.store;

import com.shopee.app.database.b;
import com.shopee.app.database.orm.a.u;
import com.shopee.app.database.orm.bean.chatP2P.DBOffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ar {

    /* renamed from: a  reason: collision with root package name */
    private u f17197a = b.f().D();

    ar() {
    }

    public List<DBOffer> a(List<Long> list) {
        List<DBOffer> a2 = this.f17197a.a(list);
        HashMap hashMap = new HashMap();
        for (DBOffer next : a2) {
            hashMap.put(Long.valueOf(next.a()), next);
        }
        ArrayList arrayList = new ArrayList();
        for (Long next2 : list) {
            if (hashMap.containsKey(next2)) {
                arrayList.add(hashMap.get(next2));
            }
        }
        return arrayList;
    }

    public List<DBOffer> a(long j) {
        return this.f17197a.b(j);
    }

    public void b(List<DBOffer> list) {
        this.f17197a.b(list);
    }

    public DBOffer b(long j) {
        return this.f17197a.a(j);
    }
}
