package com.shopee.app.data.store;

import com.shopee.app.database.b;
import com.shopee.app.database.orm.a.q;
import com.shopee.app.database.orm.bean.DBContactLocalInfo;
import java.util.List;

public class aj {

    /* renamed from: a  reason: collision with root package name */
    private q f17181a = b.f().h();

    public boolean a(DBContactLocalInfo dBContactLocalInfo) {
        if (dBContactLocalInfo != null) {
            return this.f17181a.a(dBContactLocalInfo);
        }
        return false;
    }

    public void a(List<DBContactLocalInfo> list) {
        if (list != null && !list.isEmpty()) {
            this.f17181a.a(list);
        }
    }
}
