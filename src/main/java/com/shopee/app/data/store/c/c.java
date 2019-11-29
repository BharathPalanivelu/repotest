package com.shopee.app.data.store.c;

import com.shopee.app.database.b;
import com.shopee.app.database.orm.a.v;
import com.shopee.app.database.orm.a.w;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.database.orm.bean.DBOrderItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class c {

    /* renamed from: a  reason: collision with root package name */
    v f17284a = b.f().r();

    /* renamed from: b  reason: collision with root package name */
    w f17285b = b.f().t();

    public void a(long j) {
        DBOrderDetail a2 = this.f17284a.a(Long.valueOf(j));
        if (a2 != null) {
            a2.a((Boolean) true);
            this.f17284a.a(a2);
        }
    }

    public DBOrderDetail b(long j) {
        return this.f17284a.a(Long.valueOf(j));
    }

    public void a(List<DBOrderDetail> list) {
        this.f17284a.a(list);
    }

    public void b(List<DBOrderItem> list) {
        this.f17285b.a(list);
    }

    public List<DBOrderItem> c(long j) {
        return this.f17285b.a(j);
    }

    public DBOrderItem a(long j, long j2, long j3) {
        return this.f17285b.a(j, j2, j3);
    }

    public void c(List<Long> list) {
        this.f17284a.b(list);
    }

    public void a(DBOrderDetail dBOrderDetail) {
        this.f17284a.a(dBOrderDetail);
    }

    public List<DBOrderDetail> d(List<Long> list) {
        List<DBOrderDetail> c2 = this.f17284a.c(list);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Long longValue : list) {
            linkedHashMap.put(Long.valueOf(longValue.longValue()), (Object) null);
        }
        for (DBOrderDetail next : c2) {
            linkedHashMap.put(Long.valueOf(next.a()), next);
        }
        return new ArrayList(linkedHashMap.values());
    }

    public HashMap<Long, DBOrderDetail> e(List<Long> list) {
        List<DBOrderDetail> c2 = this.f17284a.c(list);
        HashMap<Long, DBOrderDetail> hashMap = new HashMap<>();
        for (DBOrderDetail next : c2) {
            hashMap.put(Long.valueOf(next.a()), next);
        }
        return hashMap;
    }

    public List<DBOrderDetail> a(Long l) {
        return this.f17284a.b(l);
    }
}
