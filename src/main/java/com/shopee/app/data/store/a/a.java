package com.shopee.app.data.store.a;

import com.shopee.app.database.b;
import com.shopee.app.database.orm.a.ab;
import com.shopee.app.database.orm.bean.DBTransaction;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private ab f17161a = b.f().x();

    public void a(List<DBTransaction> list) {
        if (!list.isEmpty()) {
            this.f17161a.a(list);
        }
    }

    public List<DBTransaction> a(int i) {
        return this.f17161a.a(i);
    }

    public void b(int i) {
        this.f17161a.b(i);
    }
}
