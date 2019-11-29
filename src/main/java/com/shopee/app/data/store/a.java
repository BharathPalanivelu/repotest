package com.shopee.app.data.store;

import com.shopee.app.database.orm.a.b;
import com.shopee.app.database.orm.bean.DBActionGroup;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private b f17160a = com.shopee.app.database.b.f().J();

    public void a(List<DBActionGroup> list) {
        if (list != null && list.size() > 0) {
            this.f17160a.a(list);
        }
    }

    public void a(long j) {
        this.f17160a.a(j);
    }

    public List<DBActionGroup> b(List<Long> list) {
        return this.f17160a.b(list);
    }
}
