package com.shopee.app.data.store;

import com.garena.android.appkit.tools.a.a;
import com.shopee.app.database.b;
import com.shopee.app.database.orm.a.aa;
import com.shopee.app.database.orm.a.ad;
import com.shopee.app.database.orm.bean.DBShopInfo;
import com.shopee.app.database.orm.bean.DBUserInfo;
import java.util.List;

public class bh {

    /* renamed from: a  reason: collision with root package name */
    private ad f17275a = b.f().i();

    /* renamed from: b  reason: collision with root package name */
    private aa f17276b = b.f().s();

    public DBUserInfo a(int i) {
        DBUserInfo a2 = this.f17275a.a(i);
        if (a2 == null) {
            return null;
        }
        if (a.a() - a2.s() <= 86400) {
            return a2;
        }
        this.f17275a.a(a2);
        return null;
    }

    public void a(DBUserInfo dBUserInfo) {
        if (dBUserInfo != null) {
            this.f17275a.a(dBUserInfo);
        }
    }

    public void a(List<DBUserInfo> list) {
        if (list != null && !list.isEmpty()) {
            this.f17275a.a(list);
        }
    }

    public DBShopInfo b(int i) {
        return this.f17276b.a(i);
    }

    public void a(DBShopInfo dBShopInfo) {
        if (dBShopInfo != null) {
            this.f17276b.a(dBShopInfo);
        }
    }

    public boolean c(int i) {
        return i == ((Integer) ak.a().d().b(-1)).intValue();
    }
}
