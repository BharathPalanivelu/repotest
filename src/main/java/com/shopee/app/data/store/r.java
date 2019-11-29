package com.shopee.app.data.store;

import com.shopee.app.database.b;
import com.shopee.app.database.orm.a.k;
import com.shopee.app.database.orm.bean.DBCheckoutItem;
import java.util.List;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private k f17326a = b.f().w();

    public void a(List<DBCheckoutItem> list) {
        if (!list.isEmpty()) {
            this.f17326a.a(list);
        }
    }

    public DBCheckoutItem a(long j) {
        return this.f17326a.a(j);
    }

    public void b(long j) {
        this.f17326a.b(j);
    }
}
