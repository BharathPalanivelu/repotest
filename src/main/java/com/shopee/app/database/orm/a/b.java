package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.Dao;
import com.shopee.app.database.orm.bean.DBActionGroup;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class b extends a<DBActionGroup, Long> {
    public b(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBActionGroup.class);
    }

    public void a(final List<DBActionGroup> list) {
        try {
            final Dao b2 = b();
            b2.callBatchTasks(new Callable<Object>() {
                public Object call() throws Exception {
                    for (DBActionGroup createOrUpdate : list) {
                        b2.createOrUpdate(createOrUpdate);
                    }
                    return null;
                }
            });
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public List<DBActionGroup> b(List<Long> list) {
        try {
            return b().queryBuilder().where().in("id", (Iterable<?>) list).query();
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return new ArrayList();
        }
    }

    public void a(long j) {
        try {
            b().deleteById(Long.valueOf(j));
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }
}
