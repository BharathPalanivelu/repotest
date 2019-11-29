package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.Dao;
import com.shopee.app.database.orm.bean.DBReturnItem;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class z extends a<DBReturnItem, Long> {
    public z(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBReturnItem.class);
    }

    public void a(final List<DBReturnItem> list) {
        try {
            final Dao b2 = b();
            b2.callBatchTasks(new Callable<Object>() {
                public Object call() throws Exception {
                    for (DBReturnItem createOrUpdate : list) {
                        b2.createOrUpdate(createOrUpdate);
                    }
                    return null;
                }
            });
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public List<DBReturnItem> b(List<Long> list) {
        try {
            return b().queryBuilder().where().in("returnId", (Iterable<?>) list).query();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return new ArrayList();
        }
    }

    public DBReturnItem a(long j) {
        try {
            return (DBReturnItem) b().queryForId(Long.valueOf(j));
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public void b(long j) {
        try {
            b().deleteById(Long.valueOf(j));
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public DBReturnItem c(long j) {
        try {
            return (DBReturnItem) b().queryBuilder().where().eq("orderId", Long.valueOf(j)).queryForFirst();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }
}
