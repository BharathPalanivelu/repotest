package com.shopee.app.data.store;

import com.shopee.app.database.b;
import com.shopee.app.database.orm.a.n;
import com.shopee.app.database.orm.bean.DBItemComment;
import java.util.List;

public class s {

    /* renamed from: a  reason: collision with root package name */
    private n f17327a = b.f().p();

    public void a(List<DBItemComment> list) {
        if (list != null) {
            this.f17327a.a(list);
        }
    }

    public List<DBItemComment> a(long j) {
        return this.f17327a.a(j);
    }

    public List<DBItemComment> b(long j) {
        return this.f17327a.b(j);
    }

    public void a(int i, long j, long j2) {
        this.f17327a.a(i, j, j2);
    }

    public void a(long j, List<DBItemComment> list, boolean z, int i) {
        if (list != null) {
            this.f17327a.a(j, list, z, i);
        }
    }
}
