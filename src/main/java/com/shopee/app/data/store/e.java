package com.shopee.app.data.store;

import com.shopee.app.database.b;
import com.shopee.app.database.orm.a.c;
import com.shopee.app.database.orm.bean.DBActivityItem;
import java.util.List;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private c f17300a = b.f().o();

    public void a(List<DBActivityItem> list) {
        if (list != null && list.size() > 0) {
            this.f17300a.a(list);
        }
    }

    public List<DBActivityItem> b(List<Integer> list) {
        return this.f17300a.b(list);
    }

    public void a(int i) {
        this.f17300a.a((long) i);
    }
}
