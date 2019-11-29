package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.Dao;
import com.shopee.app.database.orm.bean.DBUserBrief;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ac extends a<DBUserBrief, Integer> {
    public ac(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBUserBrief.class);
    }

    public DBUserBrief a(int i) {
        try {
            return (DBUserBrief) b().queryForId(Integer.valueOf(i));
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public void a(final List<DBUserBrief> list) {
        try {
            final Dao b2 = b();
            b2.callBatchTasks(new Callable<Object>() {
                public Object call() throws Exception {
                    for (DBUserBrief createOrUpdate : list) {
                        b2.createOrUpdate(createOrUpdate);
                    }
                    return null;
                }
            });
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public List<DBUserBrief> b(List<Integer> list) {
        ArrayList arrayList = new ArrayList();
        try {
            return b().queryBuilder().where().in("userId", (Iterable<?>) list).query();
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return arrayList;
        }
    }
}
