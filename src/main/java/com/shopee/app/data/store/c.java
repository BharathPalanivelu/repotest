package com.shopee.app.data.store;

import com.shopee.app.database.b;
import com.shopee.app.database.orm.a.a;
import com.shopee.app.database.orm.bean.DBActionContent;
import java.util.List;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private a f17277a = b.f().v();

    public DBActionContent a(long j) {
        return this.f17277a.a(j);
    }

    public void a(List<DBActionContent> list) {
        this.f17277a.a(list);
    }

    public List<DBActionContent> b(List<Long> list) {
        return this.f17277a.b(list);
    }

    public void a() {
        this.f17277a.e();
    }

    public void b(long j) {
        this.f17277a.b(j);
    }
}
