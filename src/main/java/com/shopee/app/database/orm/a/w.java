package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.shopee.app.database.orm.bean.DBOrderItem;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class w extends a<DBOrderItem, Long> {
    public w(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBOrderItem.class);
    }

    public void a(final List<DBOrderItem> list) {
        try {
            final Dao b2 = b();
            b2.callBatchTasks(new Callable<Object>() {
                public Object call() throws Exception {
                    for (DBOrderItem createOrUpdate : list) {
                        b2.createOrUpdate(createOrUpdate);
                    }
                    return null;
                }
            });
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public List<DBOrderItem> a(long j) {
        ArrayList arrayList = new ArrayList();
        try {
            return b().queryForEq("orderId", Long.valueOf(j));
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return arrayList;
        }
    }

    public DBOrderItem a(long j, long j2, long j3) {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.where().eq("orderId", Long.valueOf(j)).and().eq("itemId", Long.valueOf(j2));
            if (j3 > 0) {
                queryBuilder.where().eq("orderId", Long.valueOf(j)).and().eq("itemId", Long.valueOf(j2)).and().eq("modelId", Long.valueOf(j3));
            } else {
                queryBuilder.where().eq("orderId", Long.valueOf(j)).and().eq("itemId", Long.valueOf(j2));
            }
            return (DBOrderItem) queryBuilder.queryForFirst();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }
}
