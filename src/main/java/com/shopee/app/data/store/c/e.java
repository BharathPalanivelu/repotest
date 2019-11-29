package com.shopee.app.data.store.c;

import com.shopee.app.database.b;
import com.shopee.app.database.orm.a.y;
import com.shopee.app.database.orm.a.z;
import com.shopee.app.database.orm.bean.DBRefund;
import com.shopee.app.database.orm.bean.DBReturnItem;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class e {

    /* renamed from: a  reason: collision with root package name */
    z f17292a = b.f().y();

    /* renamed from: b  reason: collision with root package name */
    y f17293b = b.f().B();

    public void a(List<DBReturnItem> list) {
        if (list != null && !list.isEmpty()) {
            this.f17292a.a(list);
            this.f17292a.d();
        }
    }

    public List<DBReturnItem> b(List<Long> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        List<DBReturnItem> b2 = this.f17292a.b(list);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Long longValue : list) {
            linkedHashMap.put(Long.valueOf(longValue.longValue()), (Object) null);
        }
        for (DBReturnItem next : b2) {
            linkedHashMap.put(Long.valueOf(next.b()), next);
        }
        return new ArrayList(linkedHashMap.values());
    }

    public DBReturnItem a(long j) {
        return this.f17292a.a(j);
    }

    public void b(long j) {
        this.f17292a.b(j);
    }

    public void c(List<DBRefund> list) {
        if (list != null && !list.isEmpty()) {
            this.f17293b.a(list);
        }
    }

    public List<DBRefund> c(long j) {
        return this.f17293b.a(j);
    }

    public DBReturnItem d(long j) {
        return this.f17292a.c(j);
    }
}
