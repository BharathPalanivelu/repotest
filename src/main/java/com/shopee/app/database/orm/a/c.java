package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.shopee.app.database.orm.bean.DBActivityItem;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class c extends a<DBActivityItem, Long> {
    public c(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBActivityItem.class);
    }

    public void a(final List<DBActivityItem> list) {
        try {
            final Dao b2 = b();
            b2.callBatchTasks(new Callable<Object>() {
                public Object call() throws Exception {
                    for (DBActivityItem createOrUpdate : list) {
                        b2.createOrUpdate(createOrUpdate);
                    }
                    return null;
                }
            });
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public List<DBActivityItem> b(List<Integer> list) {
        try {
            return b().queryBuilder().orderBy("activityId", false).where().in("activityId", (Iterable<?>) list).query();
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return new ArrayList();
        }
    }

    public void a(long j) {
        try {
            DeleteBuilder deleteBuilder = b().deleteBuilder();
            deleteBuilder.where().eq("activityId", Long.valueOf(j));
            deleteBuilder.delete();
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }
}
