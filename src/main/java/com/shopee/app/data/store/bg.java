package com.shopee.app.data.store;

import com.garena.android.appkit.tools.a.a;
import com.shopee.app.database.b;
import com.shopee.app.database.orm.a.ac;
import com.shopee.app.database.orm.bean.DBUserBrief;
import com.shopee.app.util.af;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class bg {

    /* renamed from: a  reason: collision with root package name */
    ac f17274a = b.f().z();

    public void a(List<DBUserBrief> list) {
        if (!af.a(list)) {
            this.f17274a.a(list);
        }
    }

    public List<DBUserBrief> b(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        List<DBUserBrief> b2 = this.f17274a.b(list);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Integer put : list) {
            linkedHashMap.put(put, (Object) null);
        }
        for (DBUserBrief next : b2) {
            linkedHashMap.put(Integer.valueOf(next.a()), next);
        }
        return new ArrayList(linkedHashMap.values());
    }

    public boolean a(int i) {
        return this.f17274a.a(i) != null;
    }

    public DBUserBrief b(int i) {
        DBUserBrief a2 = this.f17274a.a(i);
        if (a2 != null) {
            return a2;
        }
        return DBUserBrief.b(i);
    }

    public HashMap<Integer, DBUserBrief> c(List<Integer> list) {
        List<DBUserBrief> b2 = this.f17274a.b(list);
        HashMap<Integer, DBUserBrief> hashMap = new HashMap<>();
        for (DBUserBrief next : b2) {
            if (a.a() - next.l() <= 3600) {
                hashMap.put(Integer.valueOf(next.a()), next);
            }
        }
        return hashMap;
    }

    public HashMap<Integer, DBUserBrief> d(List<Integer> list) {
        List<DBUserBrief> b2 = this.f17274a.b(list);
        HashMap<Integer, DBUserBrief> hashMap = new HashMap<>();
        for (DBUserBrief next : b2) {
            hashMap.put(Integer.valueOf(next.a()), next);
        }
        return hashMap;
    }
}
