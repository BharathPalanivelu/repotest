package com.shopee.app.data.store;

import com.shopee.app.database.b;
import com.shopee.app.database.orm.a.h;
import com.shopee.app.database.orm.bean.chatP2P.DBChat;
import java.util.ArrayList;
import java.util.List;

public class av {

    /* renamed from: a  reason: collision with root package name */
    private h f17202a = b.f().C();

    public List<DBChat> a() {
        return this.f17202a.e();
    }

    public void a(List<DBChat> list) {
        this.f17202a.a(list);
    }

    public DBChat a(long j) {
        return this.f17202a.b(j);
    }

    public void a(DBChat dBChat) {
        this.f17202a.a(dBChat);
    }

    public void a(Integer num) {
        if (num != null && num.intValue() > 0) {
            this.f17202a.a(num.intValue());
        }
    }

    public List<DBChat> b(long j) {
        return this.f17202a.a(j);
    }

    public DBChat a(int i) {
        return this.f17202a.b(i);
    }

    public List<DBChat> b() {
        List<DBChat> f2 = this.f17202a.f();
        return f2 == null ? new ArrayList() : f2;
    }

    public List<DBChat> a(List<Integer> list, long j) {
        List<DBChat> a2 = this.f17202a.a(list, j);
        return a2 == null ? new ArrayList() : a2;
    }
}
