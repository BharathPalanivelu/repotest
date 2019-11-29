package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class v extends a<DBOrderDetail, Long> {
    public v(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBOrderDetail.class);
    }

    public void a(final List<DBOrderDetail> list) {
        if (list.size() > 0) {
            try {
                final Dao b2 = b();
                b2.callBatchTasks(new Callable<Object>() {
                    public Object call() throws Exception {
                        for (DBOrderDetail createOrUpdate : list) {
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

    public DBOrderDetail a(Long l) {
        try {
            return (DBOrderDetail) b().queryForId(l);
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public void a(DBOrderDetail dBOrderDetail) {
        try {
            b().createOrUpdate(dBOrderDetail);
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public void b(List<Long> list) {
        try {
            b().deleteIds(list);
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public List<DBOrderDetail> c(List<Long> list) {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.where().in("orderId", (Iterable<?>) list);
            return queryBuilder.query();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return new ArrayList();
        }
    }

    public List<DBOrderDetail> b(Long l) {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.where().eq("checkoutId", l).and().eq("status", 1);
            return queryBuilder.query();
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return new ArrayList();
        }
    }
}
