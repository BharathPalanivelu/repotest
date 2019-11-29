package com.shopee.app.database.orm.a;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.shopee.app.database.orm.bean.DBActionContent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class a extends com.garena.android.appkit.a.a.a<DBActionContent, Long> {
    public a(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBActionContent.class);
    }

    public DBActionContent a(long j) {
        try {
            return (DBActionContent) b().queryBuilder().where().eq("id", Long.valueOf(j)).queryForFirst();
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public void a(final List<DBActionContent> list) {
        if (list != null && list.size() > 0) {
            try {
                final Dao b2 = b();
                b2.callBatchTasks(new Callable<Object>() {
                    public Object call() throws Exception {
                        for (DBActionContent createOrUpdate : list) {
                            b2.createOrUpdate(createOrUpdate);
                        }
                        return null;
                    }
                });
            } catch (Exception e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }
    }

    public List<DBActionContent> b(List<Long> list) {
        if (list == null || list.size() <= 0) {
            return new ArrayList();
        }
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.orderBy("id", false).where().in("id", (Iterable<?>) list);
            return queryBuilder.query();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return new ArrayList();
        }
    }

    public void e() {
        try {
            b().deleteBuilder().delete();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public void b(long j) {
        try {
            b().deleteById(Long.valueOf(j));
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }
}
