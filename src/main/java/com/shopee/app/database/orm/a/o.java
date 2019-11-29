package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.shopee.app.database.orm.bean.DBItemDetail;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class o extends a<DBItemDetail, Long> {
    public o(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBItemDetail.class);
    }

    public DBItemDetail a(long j) {
        try {
            return (DBItemDetail) b().queryForId(Long.valueOf(j));
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public void a(DBItemDetail dBItemDetail) {
        try {
            b().createOrUpdate(dBItemDetail);
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public void a(final List<DBItemDetail> list) {
        try {
            final Dao b2 = b();
            b2.callBatchTasks(new Callable<Object>() {
                public Object call() throws Exception {
                    for (DBItemDetail createOrUpdate : list) {
                        b2.createOrUpdate(createOrUpdate);
                    }
                    return null;
                }
            });
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public List<DBItemDetail> b(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.where().in("item_id", (Iterable<?>) list);
            return queryBuilder.query();
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return arrayList;
        }
    }

    public void b(long j) {
        try {
            b().deleteById(Long.valueOf(j));
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }
}
