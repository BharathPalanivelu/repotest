package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.shopee.app.database.orm.bean.DBCategory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class g extends a<DBCategory, Integer> {
    public g(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBCategory.class);
    }

    public List<DBCategory> e() {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.orderBy("sort_weight", false).where().eq("status", 1);
            return queryBuilder.query();
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return new ArrayList();
        }
    }

    public void f() {
        try {
            b().deleteBuilder().delete();
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public void a(final List<DBCategory> list) {
        try {
            final Dao b2 = b();
            b2.callBatchTasks(new Callable<Object>() {
                public Object call() throws Exception {
                    for (DBCategory createOrUpdate : list) {
                        b2.createOrUpdate(createOrUpdate);
                    }
                    return null;
                }
            });
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public DBCategory a(int i) {
        try {
            return (DBCategory) b().queryForId(Integer.valueOf(i));
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public List<DBCategory> b(int i) {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.orderBy("sort_weight", false).where().eq("parent_id", Integer.valueOf(i)).and().eq("status", 1).query();
            return queryBuilder.query();
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return new ArrayList();
        }
    }
}
