package com.shopee.app.data.store;

import com.shopee.app.database.b;
import com.shopee.app.database.orm.a.s;
import com.shopee.app.database.orm.a.t;
import com.shopee.app.database.orm.bean.DBModel;
import com.shopee.app.database.orm.bean.DBModelSnapshot;
import java.util.List;

public class ao {

    /* renamed from: a  reason: collision with root package name */
    private s f17191a = b.f().k();

    /* renamed from: b  reason: collision with root package name */
    private t f17192b = b.f().l();

    public void a(List<DBModel> list) {
        if (list != null) {
            this.f17191a.a(list);
        }
    }

    public DBModel a(long j) {
        return (DBModel) this.f17191a.a(j);
    }

    public List<DBModel> b(long j) {
        return this.f17191a.b(j);
    }

    public void c(long j) {
        this.f17191a.c(j);
    }

    public void b(List<DBModelSnapshot> list) {
        if (list != null) {
            this.f17192b.a(list);
        }
    }

    public DBModelSnapshot d(long j) {
        return (DBModelSnapshot) this.f17192b.a(j);
    }

    public List<DBModelSnapshot> e(long j) {
        return this.f17192b.b(j);
    }
}
