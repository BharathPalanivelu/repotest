package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.Dao;
import com.shopee.app.database.orm.bean.DBRefund;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class y extends a<DBRefund, Long> {
    public y(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBRefund.class);
    }

    public void a(final List<DBRefund> list) {
        try {
            final Dao b2 = b();
            b2.callBatchTasks(new Callable<Object>() {
                public Object call() throws Exception {
                    for (DBRefund createOrUpdate : list) {
                        b2.createOrUpdate(createOrUpdate);
                    }
                    return null;
                }
            });
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public List<DBRefund> a(long j) {
        try {
            return b().queryForEq("orderId", Long.valueOf(j));
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return new ArrayList();
        }
    }
}
