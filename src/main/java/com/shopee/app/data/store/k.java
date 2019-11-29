package com.shopee.app.data.store;

import com.shopee.app.database.b;
import com.shopee.app.database.orm.a.f;
import com.shopee.app.database.orm.bean.chatP2P.DBBlockUser;
import com.shopee.app.util.af;
import java.util.List;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private f f17315a = b.f().E();

    k() {
    }

    public void a() {
        this.f17315a.e();
    }

    public List<DBBlockUser> b() {
        return this.f17315a.f();
    }

    public void a(List<DBBlockUser> list) {
        if (!af.a(list)) {
            this.f17315a.a(list);
        }
    }
}
