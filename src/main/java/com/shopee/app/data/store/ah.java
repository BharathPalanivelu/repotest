package com.shopee.app.data.store;

import com.shopee.app.database.b;
import com.shopee.app.database.orm.a.o;
import com.shopee.app.database.orm.a.p;
import com.shopee.app.database.orm.bean.DBItemDetail;
import com.shopee.app.database.orm.bean.DBItemSnapShot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ah {

    /* renamed from: a  reason: collision with root package name */
    private o f17176a = b.f().j();

    /* renamed from: b  reason: collision with root package name */
    private p f17177b = b.f().u();

    /* renamed from: c  reason: collision with root package name */
    private ai f17178c = ai.a();

    public void a(DBItemDetail dBItemDetail) {
        if (dBItemDetail != null) {
            this.f17176a.a(dBItemDetail);
        }
    }

    public void a(List<DBItemDetail> list) {
        if (list != null) {
            this.f17176a.a(list);
        }
    }

    public DBItemDetail a(long j) {
        return this.f17176a.a(j);
    }

    public HashMap<Long, DBItemDetail> b(List<Long> list) {
        List<DBItemDetail> b2 = this.f17176a.b(list);
        HashMap<Long, DBItemDetail> hashMap = new HashMap<>();
        for (DBItemDetail next : b2) {
            hashMap.put(Long.valueOf(next.a()), next);
        }
        return hashMap;
    }

    public void a(List<Long> list, int i) {
        if (i != -1) {
            this.f17178c.a(i, list);
        }
    }

    public void b(List<Long> list, int i) {
        if (i != -1) {
            List<Long> a2 = this.f17178c.a(i);
            for (Long longValue : list) {
                long longValue2 = longValue.longValue();
                if (!a2.contains(Long.valueOf(longValue2))) {
                    a2.add(Long.valueOf(longValue2));
                }
            }
            this.f17178c.a(i, a2);
        }
    }

    public void c(List<Long> list, int i) {
        if (i != -1) {
            List<Long> a2 = this.f17178c.a(i);
            a2.addAll(list);
            this.f17178c.a(i, a2);
        }
    }

    public List<DBItemDetail> c(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        List<DBItemDetail> b2 = this.f17176a.b(list);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Long longValue : list) {
            linkedHashMap.put(Long.valueOf(longValue.longValue()), (Object) null);
        }
        for (DBItemDetail next : b2) {
            linkedHashMap.put(Long.valueOf(next.a()), next);
        }
        for (DBItemDetail dBItemDetail : linkedHashMap.values()) {
            if (dBItemDetail != null) {
                arrayList.add(dBItemDetail);
            }
        }
        return arrayList;
    }

    public List<DBItemDetail> a(int i) {
        ArrayList arrayList = new ArrayList();
        List<Long> a2 = this.f17178c.a(i);
        List<DBItemDetail> b2 = this.f17176a.b(a2);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Long longValue : a2) {
            linkedHashMap.put(Long.valueOf(longValue.longValue()), (Object) null);
        }
        for (DBItemDetail next : b2) {
            linkedHashMap.put(Long.valueOf(next.a()), next);
        }
        for (DBItemDetail dBItemDetail : linkedHashMap.values()) {
            if (dBItemDetail != null) {
                arrayList.add(dBItemDetail);
            }
        }
        return arrayList;
    }

    public void b(long j) {
        this.f17176a.b(j);
    }

    public void a(DBItemSnapShot dBItemSnapShot) {
        this.f17177b.a(dBItemSnapShot);
    }

    public DBItemSnapShot c(long j) {
        return this.f17177b.a(j);
    }

    public List<DBItemSnapShot> d(List<Long> list) {
        return this.f17177b.a(list);
    }
}
