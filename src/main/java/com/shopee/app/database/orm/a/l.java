package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public abstract class l<D> extends a<D, Long> {
    public l(com.garena.android.appkit.a.a aVar, Class<D> cls) {
        super(aVar, cls);
    }

    public D a(long j) {
        try {
            return b().queryForId(Long.valueOf(j));
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public void a(final List<D> list) {
        try {
            final Dao b2 = b();
            b2.callBatchTasks(new Callable<Object>() {
                public Object call() throws Exception {
                    for (Object createOrUpdate : list) {
                        b2.createOrUpdate(createOrUpdate);
                    }
                    return null;
                }
            });
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public List<D> b(long j) {
        ArrayList arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.where().eq("item_id", Long.valueOf(j));
            arrayList.addAll(queryBuilder.query());
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
        return arrayList;
    }

    public void c(long j) {
        try {
            DeleteBuilder deleteBuilder = b().deleteBuilder();
            deleteBuilder.where().eq("item_id", Long.valueOf(j));
            deleteBuilder.delete();
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }
}
